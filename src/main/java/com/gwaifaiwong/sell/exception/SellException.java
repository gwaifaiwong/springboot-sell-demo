package com.gwaifaiwong.sell.exception;

import com.gwaifaiwong.sell.enums.ResultEnum;
import lombok.Getter;

/**
 * Create by gwaifaiwong on 2020/6/23.
 */
@Getter
public class SellException extends RuntimeException {
    private Integer code;


    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());

        this.code = resultEnum.getCode();
    }

    public SellException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}
