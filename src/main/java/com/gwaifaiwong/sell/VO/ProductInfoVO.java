package com.gwaifaiwong.sell.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 商品详情
 * Create by gwaifaiwong on 2020/6/21.
 */

@Data
public class ProductInfoVO implements Serializable {

    private static final long serialVersionUID = 903395248417526083L;
    @JsonProperty("id")
    private String productId;
    @JsonProperty("name")
    private String productName;
    @JsonProperty("price")
    private BigDecimal productPrice;
    @JsonProperty("description")
    private String productDescription;
    @JsonProperty("icon")
    private String productIcon;
}
