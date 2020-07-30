package com.gwaifaiwong.sell.service;

import com.gwaifaiwong.sell.dto.OrderDTO;
import com.lly835.bestpay.model.PayResponse;
import com.lly835.bestpay.model.RefundResponse;

/**
 * Create by
 *
 * @author gwaifaiwong
 * @date 2020/6/30
 */
public interface PayService {
    PayResponse create(OrderDTO orderDTO);

    PayResponse notify(String notifyData);

    RefundResponse refund(OrderDTO orderDTO);
}
