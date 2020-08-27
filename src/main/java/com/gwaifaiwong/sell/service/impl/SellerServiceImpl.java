package com.gwaifaiwong.sell.service.impl;

import com.gwaifaiwong.sell.dao.SellerInfoDao;
import com.gwaifaiwong.sell.dataobject.SellerInfo;
import com.gwaifaiwong.sell.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Create by
 *
 * @author gwaifaiwong
 * @date 2020/8/27
 */
@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    private SellerInfoDao sellerInfoDao;

    @Override
    public SellerInfo findSellerInfoByOpenid(String openid) {
        return sellerInfoDao.findByOpenid(openid);
    }
}
