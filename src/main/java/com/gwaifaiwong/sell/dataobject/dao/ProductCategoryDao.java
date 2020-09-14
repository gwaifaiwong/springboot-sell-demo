package com.gwaifaiwong.sell.dataobject.dao;

import com.gwaifaiwong.sell.dataobject.mapper.ProductCategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 * Create by
 *
 * @author gwaifaiwong
 * @date 2020/9/14
 */
public class ProductCategoryDao {
    @Autowired
    ProductCategoryMapper mapper;

    public int insertByMap(Map<String, Object> map) {
        return mapper.insertByMap(map);
    }
}
