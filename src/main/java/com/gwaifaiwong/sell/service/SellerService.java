package com.gwaifaiwong.sell.service;

import com.gwaifaiwong.sell.dataobject.SellerInfo;

/**
 * Create by
 *
 * @author gwaifaiwong
 * @date 2020/8/27
 */
public interface SellerService {
    SellerInfo findSellerInfoByOpenid(String openid);
}
