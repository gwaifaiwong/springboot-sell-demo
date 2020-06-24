package com.gwaifaiwong.sell.utils;

import java.util.Random;

/**
 * Create by gwaifaiwong on 2020/6/23.
 */
public class KeyUtil {

    /**
     * 生成唯一的主键
     * 格式：时间+6位随机数
     * synchronized：防止多线程
     */
    public static synchronized String genUniqueKey() {
        Random random = new Random();
        Integer number = random.nextInt(900000) + 100000;
        return System.currentTimeMillis() + String.valueOf(number);
    }
}
