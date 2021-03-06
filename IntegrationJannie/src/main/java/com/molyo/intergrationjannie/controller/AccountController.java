package com.molyo.intergrationjannie.controller;


import com.molyo.intergrationjannie.model.UserModel;
import com.molyo.intergrationjannie.service.IUserService;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresRoles;

import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Set;


/**
 * <p>
 * 账户相关操作
 * </p>
 * 
 * @author hc
 * @Date 2017-03-30
 */
//@RequiresRoles("admin")
@Controller
//@RequestMapping("/account")
public class AccountController{

	private static Logger logger = LoggerFactory.getLogger(AccountController.class);
	//锁定用户标记
	private static final String LOCKSCREEN_USER_FLAG = "LockscreenUserFlag";

	@Resource
	private IUserService userService;

	@RequestMapping("/")
	public String index(Model model) {
		logger.info("log into index");
//		Set<String> permissions = userService.findPermissions(loginUser.getUsername());
//		List<Resource> menus = resourceService.findMenus(permissions);
//		model.addAttribute("menus", menus);
		return "index";
	}

	@RequestMapping(value ="/", method = RequestMethod.POST)
	public String postIndex(Model model) {
		logger.info("log into postIndex");
//		Set<String> permissions = userService.findPermissions(loginUser.getUsername());
//		List<Resource> menus = resourceService.findMenus(permissions);
//		model.addAttribute("menus", menus);
		return "index";
	}

	@RequestMapping("/showUser")
	public String toIndex(HttpServletRequest request,Model model){
		long userId = Integer.parseInt(request.getParameter("id"));
		UserModel user = this.userService.getUserById(userId);
		model.addAttribute("user", user);
		return "showUser";
	}

	/**
	 * 登录
	 */
	@RequestMapping(value ="/toLogin", method = RequestMethod.GET)
	public String toLogin(HttpServletRequest request,ModelAndView modelAndView) {
		logger.info("jannie my little girl");
		return "login";
	}
	/**
	 * 登录
	 */
//	@RequestMapping(value ="/login",method = RequestMethod.POST)
	@RequestMapping(value ="/login")
	public String login(HttpServletRequest request,ModelAndView modelAndView) {
        Object username = SecurityUtils.getSubject().getPrincipal();
		logger.info("principal is : " +  username);
		String errorClassName = (String)request.getAttribute("shiroLoginFailure");
		logger.info("errorClassName is :" + errorClassName);
		if(UnknownAccountException.class.getName().equals(errorClassName)) {
			request.setAttribute("error", "用户名/密码错误");
			logger.info("用户名/密码错误");
		} else if(IncorrectCredentialsException.class.getName().equals(errorClassName)) {
			request.setAttribute("error", "用户名/密码错误");
			logger.info("用户名/密码错误");
		} else if(errorClassName != null) {
			request.setAttribute("error", "未知错误：" + errorClassName);
			logger.info("未知错误：");
		}

		//request.getRequestDispatcher("/WEB-INF/jsp/formfilterlogin.jsp").forward(req, resp);
		String password = request.getParameter("password");
		logger.info("username is:" + username + ",password is:" + password);
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
