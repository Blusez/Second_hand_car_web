package com.keller.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.keller.dao.UserMapper;
import com.keller.model.User;
import com.keller.service.IUserService;


/**
 * @author keller
 * @date 创建时间：2017年4月20日上午12:22:22
 * @version 1.0
 */
@Service("userService")
public class UserServiceImpl implements IUserService {
	private UserMapper userMapper;
	
	public UserMapper getUserMapper() {
		return userMapper;
	}
	@Autowired
	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		
		return userMapper.selectByLogin(user);
	}

	@Override
	public int register(User user) {
		// TODO Auto-generated method stub
		return userMapper.insertSelective(user);
	}
	
	@Override
	public User selectByName(User user){
		
		return userMapper.selectByName(user);
		
	}
	@Override
	public List<User> adminselectBylimit(User user) {
		// TODO Auto-generated method stub
		return userMapper.adminselectBylimit(user);
	}
	@Override
	public int selectCount(User record) {
		// TODO Auto-generated method stub
		return userMapper.selectCount(record);
	}

}
