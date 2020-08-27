package com.gwaifaiwong.sell.dao;

import com.gwaifaiwong.sell.dataobject.SellerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Create by
 *
 * @author gwaifaiwong
 * @date 2020/8/27
 */
public interface SellerInfoDao extends JpaRepository<SellerInfo, String> {
    SellerInfo findByOpenid(String openid);
}
