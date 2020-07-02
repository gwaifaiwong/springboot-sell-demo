package com.gwaifaiwong.sell.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Create by
 *
 * @author gwaifaiwong
 * @date 2020/7/2
 */
public class JsonUtil {
    public static String toJson(Object object) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();
        return gson.toJson(object);
    }
}
