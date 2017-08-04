package com.molyo.intergrationjannie.dao;

import com.molyo.intergrationjannie.model.UserModel;


public interface IUserDao extends SuperDao<UserModel>{

//    Long deleteByPrimaryKey(Long id);
//
//    Long insert(User record);
//
//    Long insertSelective(User record);
//
//    User selectByPrimaryKey(Long id);
//
     public abstract UserModel findByUsername(String username);
//
//    Long updateByPrimaryKeySelective(User record);
//
//    Long updateByPrimaryKey(User record);


}