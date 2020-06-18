package com.gwaifaiwong.sell.dao;

import com.gwaifaiwong.sell.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryDaoTest {

    @Autowired
    private ProductCategoryDao productCategoryDao;

    @Test
    public void findOneTest(){
        ProductCategory productCategory = productCategoryDao.findById(1).orElse(null);
        System.out.println(productCategory.toString());
    }
    @Test
    public void updateTest(){
        ProductCategory productCategory = productCategoryDao.findById(2).orElse(null);
        productCategory.setCategoryType(3);
        productCategoryDao.save(productCategory);
    }
    @Test
    public void saveTest(){
        ProductCategory productCategory = new ProductCategory("男生最爱",4);
        ProductCategory result = productCategoryDao.save(productCategory);
        Assert.assertNotNull(result);
//        Assert.assertNotEquals(null,result);
    }
    @Test
    public void findByCategoryTypeIn(){
        List<Integer> list = Arrays.asList(2,3,4);
        List<ProductCategory> result = productCategoryDao.findByCategoryTypeIn(list);

        Assert.assertNotEquals(0,result.size());
    }
}