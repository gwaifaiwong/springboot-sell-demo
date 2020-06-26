package com.gwaifaiwong.sell.enums;

import lombok.Getter;

/**
 * Create by gwaifaiwong on 2020/6/23.
 */
@Getter
public enum ResultEnum {
    PRODUCT_NOT_EXIT(10, "商品不存在"),

    PRODUCT_STOCK_ERROR(11, "商品库存不正确"),

    ORDER_NOT_EXIT(12, "订单不存在"),

    ORDERDETAIL_NOT_EXIT(13, "订单详情不存在"),

    ORDER_STATUS_ERROR(14, "订单状态异常"),

    ORDER_UPDATE_FAIL(15, "订单更新失败"),

    ORDER_DETIAL_EMPTY(16, "订单详情为空"),

    ORDER_PAY_STATUS_ERROR(17, "订单支付状态不正确"),
    ;

    private Integer code;

    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
