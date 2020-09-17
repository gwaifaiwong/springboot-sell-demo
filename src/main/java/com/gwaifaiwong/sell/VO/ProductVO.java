package com.gwaifaiwong.sell.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 商品（包含类目）
 * Create by gwaifaiwong on 2020/6/21.
 */
@Data
public class ProductVO implements Serializable {

    private static final long serialVersionUID = -4167054183124233126L;
    @JsonProperty("name")
    private String categoryName;

    @JsonProperty("type")
    private Integer categoryType;

    @JsonProperty("food")
    private List<ProductInfoVO> productInfoVOList;
}
