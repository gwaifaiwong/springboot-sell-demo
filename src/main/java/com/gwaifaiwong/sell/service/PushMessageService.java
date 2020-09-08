package com.gwaifaiwong.sell.service;

import com.gwaifaiwong.sell.dto.OrderDTO;

/**
 * Create by
 *
 * @author gwaifaiwong
 * @date 2020/9/8
 */
public interface PushMessageService {

    /**
     * 订单状态变更消息
     * @param orderDTO
     */
    void orderStatus(OrderDTO orderDTO);
}
