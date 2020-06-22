package com.gwaifaiwong.sell.dataobject;

import com.gwaifaiwong.sell.enums.OrderStatus;
import com.gwaifaiwong.sell.enums.PayStatusEnum;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Create by gwaifaiwong on 2020/6/22.
 */
@Entity
@Data
@DynamicUpdate
public class OrderMaster {
    /**订单id*/
    @Id
    private String orderId;

    private String buyerName;

    private String buyerPhone;

    private String buyerAddress;

    private String buyerOpenid;

    private BigDecimal orderAmount;

    private Integer orderStatus = OrderStatus.NEW.getCode();

    private Integer payStatus = PayStatusEnum.WAIT.getCode();

    private Date createTime;

    private Date updateTime;

}
