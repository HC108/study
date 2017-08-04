package com.molyo.intergrationjannie.service.impl;

import com.molyo.intergrationjannie.dao.ICouponDao;
import com.molyo.intergrationjannie.model.CouponModel;
import com.molyo.intergrationjannie.service.ICouponService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by hongchong on 2017-04-06.
 */
@Service("couponService")
public class CouponServiceImpl implements ICouponService {
    @Resource
    private ICouponDao couponDao;

    @Override
    public CouponModel selectByIp(String ip) {
        return this.couponDao.selectByIp(ip);
    }

    @Override
    public CouponModel findUnused(){
        return this.couponDao.findUnused();
    }

    @Override
    public Long updateByPrimaryKey(CouponModel record){
        return this.couponDao.updateByPrimaryKey(record);
    }

}
