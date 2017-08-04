package com.molyo.intergrationjannie.service;

import com.molyo.intergrationjannie.model.UserModel;

/**
 * Created by hongchong on 2017-04-06.
 */
public interface IUserService {
    public UserModel getUserById(Long userId);
    public UserModel findByUsername(String username);
}
