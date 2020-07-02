package com.gwaifaiwong.sell.service.impl;

import com.gwaifaiwong.sell.dto.OrderDTO;
import com.gwaifaiwong.sell.service.OrderService;
import com.gwaifaiwong.sell.service.PayService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Create by
 *
 * @author gwaifaiwong
 * @date 2020/7/2
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class PayServiceImplTest {
    @Autowired
    private PayService payService;

    @Autowired
    private OrderService orderService;

    @Test
    public void create() throws Exception {
        OrderDTO orderDTO = orderService.findOne("1593222920403335428");
        payService.create(orderDTO);
    }


}