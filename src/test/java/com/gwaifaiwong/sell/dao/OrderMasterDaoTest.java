package com.gwaifaiwong.sell.dao;

import com.gwaifaiwong.sell.dataobject.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

/**
 * Create by gwaifaiwong on 2020/6/22.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterDaoTest {
    @Autowired
    private OrderMasterDao orderMasterDao;

    private final String OPENID = "10110";

    @Test
    public void saveTest(){
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("123457");
        orderMaster.setBuyerName("师兄");
        orderMaster.setBuyerPhone("123456789012");
        orderMaster.setBuyerAddress("我家");
        orderMaster.setBuyerOpenid("10110");
        orderMaster.setOrderAmount(new BigDecimal("2.5"));

        OrderMaster result = orderMasterDao.save(orderMaster);
        Assert.assertNotNull(result);

    }
    @Test
    public void findByBuyerOpenid(){
        PageRequest request = PageRequest.of(0,3);

        Page<OrderMaster> result = orderMasterDao.findByBuyerOpenid(OPENID, request);

        System.out.println(result.getTotalElements());

    }

}