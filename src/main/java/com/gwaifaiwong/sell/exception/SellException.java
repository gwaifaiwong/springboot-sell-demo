package com.gwaifaiwong.sell.exception;

import com.gwaifaiwong.sell.enums.ResultEnum;

/**
 * Create by gwaifaiwong on 2020/6/23.
 */
public class SellException extends RuntimeException {
    private Integer code;


    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());

        this.code = resultEnum.getCode();
    }
}
