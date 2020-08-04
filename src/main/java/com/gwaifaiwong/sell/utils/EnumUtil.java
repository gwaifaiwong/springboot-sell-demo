package com.gwaifaiwong.sell.utils;

import com.gwaifaiwong.sell.enums.CodeEnum;

/**
 * Create by
 *
 * @author gwaifaiwong
 * @date 2020/8/4
 */
public class EnumUtil {
    public static  <T extends CodeEnum> T getByCode(Integer code, Class<T> enumClass) {
        for (T each : enumClass.getEnumConstants()) {
            if (code.equals(each.getCode())) {
                return each;
            }
        }
        return null;
    }
}
