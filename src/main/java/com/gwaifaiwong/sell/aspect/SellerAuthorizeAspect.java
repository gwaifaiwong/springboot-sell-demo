package com.gwaifaiwong.sell.aspect;

import com.gwaifaiwong.sell.constant.CookieConstant;
import com.gwaifaiwong.sell.constant.RedisConstant;
import com.gwaifaiwong.sell.exception.SellerAuthorzeExpection;
import com.gwaifaiwong.sell.utils.CookieUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * Create by
 *
 * @author gwaifaiwong
 * @date 2020/9/8
 */
@Aspect
@Component
@Slf4j
public class SellerAuthorizeAspect {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Pointcut("execution(public * com.gwaifaiwong.sell.controller.Seller*.*(..))" +
            "&& !execution(public * com.gwaifaiwong.sell.controller.SellerUserController.*(..))")
    public void verify() {

    }

    @Before("verify()")
    public void doVerify() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        //查询cookie
        Cookie cookie = CookieUtil.get(request, CookieConstant.TOKEN);
        if (cookie == null) {
            log.warn("【登录校验】Cookie查不到token");
            throw new SellerAuthorzeExpection();
        }

        //去redis里查
        String tokenValue = redisTemplate.opsForValue().get(String.format(RedisConstant.TOKEN_PREFIX, cookie.getValue()));
        if (StringUtils.isEmpty(tokenValue)) {
            log.warn("【登录校验】Redis查不到token");
            throw new SellerAuthorzeExpection();
        }
    }
}
