package com.gwaifaiwong.sell.service;

import com.gwaifaiwong.sell.dto.OrderDTO;

/**
 * Create by
 *
 * @author gwaifaiwong
 * @date 2020/6/27
 */

public interface BuyerService {

    /**
     * 查询一个订单
     */

    OrderDTO findOrderOne(String openid, String orderId);

    /**
     * 取消订单
     */
    OrderDTO cancelOrder(String openid, String orderId);

}
