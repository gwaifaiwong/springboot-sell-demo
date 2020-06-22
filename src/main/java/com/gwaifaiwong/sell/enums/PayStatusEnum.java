package com.gwaifaiwong.sell.enums;

import lombok.Getter;

/**
 * Create by gwaifaiwong on 2020/6/22.
 */
@Getter
public enum PayStatusEnum {

    WAIT(0, "等待支付"),
    SUCCESS(1, "支付成功"),
    ;

    PayStatusEnum(Integer code) {
        this.code = code;
    }

    private Integer code;

    private String message;

    PayStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
