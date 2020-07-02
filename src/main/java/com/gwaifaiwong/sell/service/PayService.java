package com.gwaifaiwong.sell.service;

import com.gwaifaiwong.sell.dto.OrderDTO;

/**
 * Create by
 *
 * @author gwaifaiwong
 * @date 2020/6/30
 */
public interface PayService {
    void create(OrderDTO orderDTO);
}
