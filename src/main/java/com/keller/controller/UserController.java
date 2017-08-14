package com.keller.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.keller.model.LoginLog;
import com.keller.model.User;
import com.keller.service.ILoginLogService;
import com.keller.service.IUserService;

import net.sf.json.JSONObject;

/**
 * @author keller
 * @date 创建时间：2017年4月19日下午5:27:01
 * @version 1.0
 */
@Controller
@RequestMapping("/UserController")
public class UserController {
	private IUserService userService;
	private ILoginLogService loginlogService;
	private LoginLog loginlog;
	
	HttpSession session;
	

	
	
	public ILoginLogService getLoginlogService() {
		return loginlogService;
	}
	@Autowired
	public void setLoginlogService(ILoginLogService loginlogService) {
		this.loginlogService = loginlogService;
	}
	public IUserService getUserService() {
		return userService;
	}
	@Autowired
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	@RequestMapping("/login")
	public void login(HttpServletRequest request, HttpServletResponse response)
			throws Exception{
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		PrintWriter out = response.getWriter();
		Integer identype = 1;
		if (null != request.getParameter("identype")) {
			identype = Integer.parseInt(request.getParameter("identype"));
		}
		HttpSession session = request.getSession();
		User user = new User();
		user.setuName(name);
		user.setuPasswd(pwd);
		user.setrId(identype);
		//用户登陆
		if (identype == 1) {
			User retUser = userService.login(user);
			JSONObject user1 = new JSONObject();
			if (retUser != null) {
				user1.put("uid", retUser.getuId());
				user1.put("name", retUser.getuName());
				user1.put("pwd", retUser.getuPasswd());
				loginlog = new LoginLog();
				loginlog.setFaccount(name);
				loginlog.setFlogintime(new Date());
				//登陆log表，登陆之后自动赋值
				loginlogService.loginlog(loginlog);
				user1.put("logid", loginlog.getFid());
				session.setAttribute("uid", retUser.getuId());
				session.setAttribute("logid", loginlog.getFid());
			}else{
				user1.put("uid", "");
				user1.put("name","");
				user1.put("pwd", "");
				user1.put("logid", "");
			}
			out.print(user1.toString());
			//管理员登陆
		}else {
			JSONObject json1 = new JSONObject();
			User retUser = userService.login(user);
			if (retUser != null) {
				session.setAttribute("user", retUser.getuName());
				json1.put("result", "success");
			} else {
				json1.put("result", "fail");
			}
			
			out.print(json1.toString());
		}
		

	}

	@RequestMapping("/register")
	public void register(String name, String pwd, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		PrintWriter out = response.getWriter();
		JSONObject json1 = new JSONObject();
		User user = new User();
		user.setuName(name);
		user.setuPasswd(pwd);
		if(userService.selectByName(user) != null){
			json1.put("result", "samepeople");
		}else{
			int flag = userService.register(user);
			if (flag != -1) {
				json1.put("result", "success");
			} else {
				json1.put("result", "fail");
			}
		}
		out.print(json1.toString());

	}
	
	
	@RequestMapping("adminselectByLimt")
	public String adminselectByLimt(
			@RequestParam(value = "start", defaultValue = "0") Integer start,
			@RequestParam(value = "limit", defaultValue = "8") Integer limit, 
			@RequestParam(value = "rid", defaultValue = "1") Integer rid, 
			HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		session = request.getSession();
		List<User> users ;
		User user = new User();
		user.setStart(start);
		user.setLimit(limit);
		user.setrId(rid);
		users = userService.adminselectBylimit(user);
		int count = userService.selectCount(user);
		
		session.setAttribute("users", users);
		session.setAttribute("count", count);
		return "showUser";
		
		
	}
	@RequestMapping("adminExit")
	public void adminExit(
			HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<script>top.window.location.href='/Second_hand_car/login.jsp';</script>");
		request.getSession().invalidate();
	}
	
	
	
}
