package com.gwaifaiwong.sell.dao;

import com.gwaifaiwong.sell.dataobject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Create by gwaifaiwong on 2020/6/22.
 */
public interface OrderDetialDao extends JpaRepository<OrderDetail, String> {
    List<OrderDetail> findByOrderId(String orderId);
}
