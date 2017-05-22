package com.molyo.intergrationjannie.dao;

import com.molyo.intergrationjannie.model.User;

public interface IUserDao {
    Long deleteByPrimaryKey(Long id);

    Long insert(User record);

    Long insertSelective(User record);

    User selectByPrimaryKey(Long id);

    User findByUsername(String username);

    Long updateByPrimaryKeySelective(User record);

    Long updateByPrimaryKey(User record);
}