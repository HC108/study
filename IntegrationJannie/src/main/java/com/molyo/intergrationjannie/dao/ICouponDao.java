package com.molyo.intergrationjannie.dao;

import com.molyo.intergrationjannie.model.CouponModel;


public interface ICouponDao extends SuperDao<CouponModel>{

//    Long deleteByPrimaryKey(Long id);
//
//      public int insert(Coupon record);
//
//    Long insertSelective(User record);
//
      public CouponModel selectByIp(String ip);
//
      public CouponModel findUnused();
//
//    Long updateByPrimaryKeySelective(User record);
//
      Long updateByPrimaryKey(CouponModel record);


}