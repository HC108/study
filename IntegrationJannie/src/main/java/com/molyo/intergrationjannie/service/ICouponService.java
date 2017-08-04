package com.molyo.intergrationjannie.service;

import com.molyo.intergrationjannie.model.CouponModel;

/**
 * Created by hongchong on 2017-04-06.
 */
public interface ICouponService {
    public CouponModel selectByIp(String ip);

    public CouponModel findUnused();

    Long updateByPrimaryKey(CouponModel record);
}
