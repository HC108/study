package com.molyo.intergrationjannie.controller;


import com.molyo.intergrationjannie.model.User;
import com.molyo.intergrationjannie.service.IUserService;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


/**
 * <p>
 * 账户相关操作
 * </p>
 * 
 * @author hc
 * @Date 2017-03-30
 */
@RequiresRoles("admin")
@Controller
@RequestMapping("/account")
public class AccountController{

	//锁定用户标记
	private static final String LOCKSCREEN_USER_FLAG = "LockscreenUserFlag";

	@Resource
	private IUserService userService;

	@RequestMapping("/showUser")
	public String toIndex(HttpServletRequest request,Model model){
		long userId = Integer.parseInt(request.getParameter("id"));
		User user = this.userService.getUserById(userId);
		model.addAttribute("user", user);
		return "showUser";
	}

	/**
	 * 登录
	 */
	@RequestMapping(value ="/login", method = RequestMethod.GET)
	public String login(Model model) {

		return "/login";
	}

	/**
	 * 列表页
	 */
	@RequestMapping(value ="/list", method = RequestMethod.GET)
	public ModelAndView list(ModelAndView modelAndView) {
		modelAndView.setViewName("userList");
		return modelAndView;
	}

}
