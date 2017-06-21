package com.molyo.intergrationjannie.controller;

import com.molyo.intergrationjannie.model.User;
import com.molyo.intergrationjannie.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by hongchong on 2017-05-26.
 */
@Controller
@RequestMapping("/user")
public class UserController extends SuperController{
    private static Logger logger = LoggerFactory.getLogger(UserController.class);
    @Resource
    private IUserService userService;

    @RequestMapping("/showUser")
    public String toIndex(HttpServletRequest request, Model model){
        long userId = Integer.parseInt(request.getParameter("id"));
        User user = userService.getUserById(userId);
        model.addAttribute("user", user);
        return "showUser";
    }

    @RequestMapping("/userlist")
    public String userList(HttpServletRequest request, Model model){
        return "userlist";
    }

    @RequestMapping("/add")
    public String add(User user, HttpServletRequest request, Model model){
        logger.info("" + user.getUsername() + "," + user.getPassword()+ "," + user.getOrganizationId() + "," + user.getRoleIdsStr() + "," + user.getSalt());
        return "userlist";
    }
}
