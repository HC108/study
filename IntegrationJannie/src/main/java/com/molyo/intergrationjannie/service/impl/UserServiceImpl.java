package com.molyo.intergrationjannie.service.impl;

import javax.annotation.Resource;

import com.molyo.intergrationjannie.dao.IUserDao;
import com.molyo.intergrationjannie.model.UserModel;
import com.molyo.intergrationjannie.service.IUserService;
import org.springframework.stereotype.Service;

/**
 * Created by hongchong on 2017-04-06.
 */
@Service("userService")
public class UserServiceImpl implements IUserService{
    @Resource
    private IUserDao userDao;
    @Override
    public UserModel getUserById(Long userId) {
        // TODO Auto-generated method stub
        return this.userDao.selectByPrimaryKey(userId, new UserModel());
    }
    @Override
    public UserModel findByUsername(String username) {
        return this.userDao.findByUsername(username);
    }
}
