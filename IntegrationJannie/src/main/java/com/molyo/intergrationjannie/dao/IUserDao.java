package com.molyo.intergrationjannie.dao;

import com.molyo.intergrationjannie.model.User;


public interface IUserDao extends SuperDao<User>{

//    Long deleteByPrimaryKey(Long id);
//
//    Long insert(User record);
//
//    Long insertSelective(User record);
//
//    User selectByPrimaryKey(Long id);
//
     public abstract User findByUsername(String username);
//
//    Long updateByPrimaryKeySelective(User record);
//
//    Long updateByPrimaryKey(User record);


}