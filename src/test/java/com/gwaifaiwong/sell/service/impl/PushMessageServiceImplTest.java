package com.gwaifaiwong.sell.service.impl;

import com.gwaifaiwong.sell.dto.OrderDTO;
import com.gwaifaiwong.sell.service.OrderService;
import com.gwaifaiwong.sell.service.PushMessageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Create by
 *
 * @author gwaifaiwong
 * @date 2020/9/8
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PushMessageServiceImplTest {

    @Autowired
    private PushMessageService pushMessageService;

    @Autowired
    private OrderService orderService;

    @Test
    public void orderStatus() throws Exception {
        OrderDTO orderDTO = orderService.findOne("");
        pushMessageService.orderStatus(orderDTO);
    }

}