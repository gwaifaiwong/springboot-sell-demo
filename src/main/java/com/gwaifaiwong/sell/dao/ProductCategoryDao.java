package com.gwaifaiwong.sell.dao;

import com.gwaifaiwong.sell.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductCategoryDao extends JpaRepository<ProductCategory,Integer> {
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
