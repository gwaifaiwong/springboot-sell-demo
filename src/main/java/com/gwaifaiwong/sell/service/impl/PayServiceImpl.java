package com.gwaifaiwong.sell.service.impl;

import com.gwaifaiwong.sell.dto.OrderDTO;
import com.gwaifaiwong.sell.enums.ResultEnum;
import com.gwaifaiwong.sell.exception.SellException;
import com.gwaifaiwong.sell.service.OrderService;
import com.gwaifaiwong.sell.service.PayService;
import com.gwaifaiwong.sell.utils.JsonUtil;
import com.gwaifaiwong.sell.utils.MathUtil;
import com.lly835.bestpay.enums.BestPayTypeEnum;
import com.lly835.bestpay.model.PayRequest;
import com.lly835.bestpay.model.PayResponse;
import com.lly835.bestpay.service.impl.BestPayServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Create by
 *
 * @author gwaifaiwong
 * @date 2020/6/30
 */
@Service
@Slf4j
public class PayServiceImpl implements PayService {

    private static final String ORDER_NAME = "微信点餐订单";

    @Autowired
    private BestPayServiceImpl bestPayService;

    @Autowired
    private OrderService orderService;

    @Override
    public PayResponse create(OrderDTO orderDTO) {
        PayRequest payRequest = new PayRequest();
        payRequest.setOpenid(orderDTO.getOrderId());
        payRequest.setOrderAmount(orderDTO.getOrderAmount().doubleValue());
        payRequest.setOrderId(orderDTO.getOrderId());
        payRequest.setOrderName(ORDER_NAME);
        payRequest.setPayTypeEnum(BestPayTypeEnum.WXPAY_H5);
        log.info("【微信支付】 request={}", JsonUtil.toJson(payRequest));

        PayResponse payResponse = bestPayService.pay(payRequest);
        log.info("【微信支付】 response={}", JsonUtil.toJson(payResponse));
        return payResponse;
    }

    @Override
    public PayResponse notify(String notifyData) {
        //1. 验证签名
        //2. 支付的状态
        //3. 支付金额
        //4. 支付人（下单人==支付人）

        PayResponse payResponse = bestPayService.asyncNotify(notifyData);
        log.info("【微信支付】异步通知，payResponse={}", JsonUtil.toJson(payResponse));

        //查询订单
        OrderDTO orderDTO = orderService.findOne(payResponse.getOrderId());
        //判断订单是否存在
        if (orderDTO == null) {
            log.error("【微信支付】异步通知，订单不存在，orderId={}", payResponse.getOrderId());
            throw new SellException(ResultEnum.ORDER_NOT_EXIT);
        }
        //判断金额是否一致
        if (!MathUtil.equals(payResponse.getOrderAmount(),orderDTO.getOrderAmount().doubleValue())) {
            log.error("【微信支付】异步通知，订单金额不一致，orderId={},微信通知金额={}，系统金额={}",
                    payResponse.getOrderId(),
                    payResponse.getOrderAmount(),
                    orderDTO.getOrderAmount());
            throw new SellException(ResultEnum.WXPAY_NOTIFY_MONEY_VERIFY_ERROR);
        }
        //修改订单的支付状态
        orderService.paid(orderDTO);
        return payResponse;
    }
}
