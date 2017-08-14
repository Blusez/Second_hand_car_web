package com.keller.service;

import java.util.List;

import com.keller.model.User;

/**
 * @author keller
 * @date 创建时间：2017年4月19日下午5:37:15
 * @version 1.0
 */
public interface IUserService {
	/**
	 * 登陆
	 * @return
	 */
	public User login(User user);
	
	/**
	 * 注册
	 * @param user
	 * @return
	 */
	public int register(User user);
	
	/**
	 * 
	 * @param user
	 * @return
	 */
	public User selectByName(User user);
	
	
	public List<User> adminselectBylimit(User user);
	


	int selectCount(User record);
}
