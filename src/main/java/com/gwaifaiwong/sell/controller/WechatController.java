package com.gwaifaiwong.sell.controller;

import lombok.extern.slf4j.Slf4j;

import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create by
 *
 * @author gwaifaiwong
 * @date 2020/6/29
 */
@RestController
@RequestMapping("wechat")
@Slf4j
public class WechatController {

    @Autowired
    private WxMpService wxMpService;

    @GetMapping("authorize")
    public void authorize(@RequestParam("returnUrl") String returnUrl) {
        WxMpService wxMpService = new WxMpServiceImpl();
        //1. 配置
        //2.调用方法
        wxMpService.oauth2buildAuthorizationUrl(null)
    }

    @GetMapping("userInfo")
    public void userInfo(){

    }
}
