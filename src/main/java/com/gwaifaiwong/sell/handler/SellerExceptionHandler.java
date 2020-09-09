package com.gwaifaiwong.sell.handler;

import com.gwaifaiwong.sell.VO.ResultVO;
import com.gwaifaiwong.sell.config.ProjectUrlConfig;
import com.gwaifaiwong.sell.exception.SellException;
import com.gwaifaiwong.sell.exception.SellerAuthorzeExpection;
import com.gwaifaiwong.sell.utils.ResultVoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
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
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ModelAndView handlerAuthorizeException() {
        return new ModelAndView("redirect:"
//        .concat(projectUrlConfig.getWechatMpAuthorize())
//        .concat("/sell/wechat/qrAuthorize")
//        .concat("?returnUrl=")
//        .concat(projectUrlConfig.getSell())
                .concat("/sell/seller/login"));
    }

    /**
     * 捕获SellException异常
     * @param e
     * @return
     */
    @ExceptionHandler(value = SellException.class)
    @ResponseBody
    public ResultVO handlerSellerException(SellException e){
        return ResultVoUtil.error(e.getCode(), e.getMessage());
    }
}
