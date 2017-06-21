package com.molyo.intergrationjannie.service;

import com.molyo.intergrationjannie.model.User;

/**
 * Created by hongchong on 2017-04-06.
 */
public interface IUserService {
    public User getUserById(Long userId);
    public User findByUsername(String username);
}
