package com.gwaifaiwong.sell.enums;

import lombok.Getter;

/**
 * Create by gwaifaiwong on 2020/6/23.
 */
@Getter
public enum ResultEnum {
    PRODUCT_NOT_EXIT(10, "商品不存在"),

    PRODUCT_STOCK_ERROR(11, "商品库存不正确"),
    ;

    private Integer code;

    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
