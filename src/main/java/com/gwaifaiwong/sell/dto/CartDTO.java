package com.gwaifaiwong.sell.dto;

import lombok.Data;

/**
 * Create by gwaifaiwong on 2020/6/24.
 */
@Data
public class CartDTO {
    /**
     * 商品Id
     */
    private String productId;

    /**
     * 数量
     */
    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
