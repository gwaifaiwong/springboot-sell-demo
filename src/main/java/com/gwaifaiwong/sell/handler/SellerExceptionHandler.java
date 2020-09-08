package com.gwaifaiwong.sell.handler;

import com.gwaifaiwong.sell.config.ProjectUrlConfig;
import com.gwaifaiwong.sell.exception.SellerAuthorzeExpection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * Create by
 *
 * @author gwaifaiwong
 * @date 2020/9/8
 */
@ControllerAdvice
public class SellerExceptionHandler {
    @Autowired
    private ProjectUrlConfig projectUrlConfig;

    //拦截登录异常
    @ExceptionHandler(value = SellerAuthorzeExpection.class)
    public ModelAndView handlerAuthorizeException(){
        return new ModelAndView("redirect:"
//        .concat(projectUrlConfig.getWechatMpAuthorize())
//        .concat("/sell/wechat/qrAuthorize")
//        .concat("?returnUrl=")
//        .concat(projectUrlConfig.getSell())
        .concat("/sell/seller/login"));
    }
}
