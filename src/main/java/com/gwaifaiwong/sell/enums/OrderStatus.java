package com.gwaifaiwong.sell.enums;

import lombok.Getter;

/**
 * Create by gwaifaiwong on 2020/6/22.
 */
@Getter
public enum OrderStatus {
    NEW(0, "新订单"),
    FINISH(1, "完结"),
    CANCEL(2, "已取消"),
    ;
    private Integer code;

    private String message;

    OrderStatus(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
