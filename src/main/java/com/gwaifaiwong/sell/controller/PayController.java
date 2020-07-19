package com.gwaifaiwong.sell.controller;

import com.gwaifaiwong.sell.dto.OrderDTO;
import com.gwaifaiwong.sell.enums.ResultEnum;
import com.gwaifaiwong.sell.exception.SellException;
import com.gwaifaiwong.sell.service.OrderService;
import com.gwaifaiwong.sell.service.PayService;
import com.lly835.bestpay.model.PayResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * Create by
 *
 * @author gwaifaiwong
 * @date 2020/6/30
 */
@Controller
@RequestMapping("/pay")
public class PayController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private PayService payService;

    @GetMapping("/create")
    public ModelAndView create(@RequestParam("orderId")String orderId,
                               @RequestParam("returnUrl")String returnUrl,
                               Map<String,Object> map){
        //查询订单
        OrderDTO orderDTO = orderService.findOne(orderId);
        if (orderDTO == null) {
            throw new SellException(ResultEnum.ORDER_NOT_EXIT);
        }
        //发起支付
        PayResponse payResponse = payService.create(orderDTO);
        map.put("payResponse", payResponse);
        return  new ModelAndView("pay/create",map);
    }
}
