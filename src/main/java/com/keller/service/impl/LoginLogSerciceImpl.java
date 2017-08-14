package com.keller.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.support.logging.Log;
import com.keller.dao.LoginLogMapper;
import com.keller.model.LoginLog;
import com.keller.service.ILoginLogService;

/**
 * @author keller
 * @date 创建时间：2017年4月21日下午5:47:32
 * @version 1.0
 */
@Service("loginLogSerciceImpl")
public class LoginLogSerciceImpl implements ILoginLogService {
	private LoginLogMapper loginLogMapper;
	
	public LoginLogMapper getLoginLogMapper() {
		return loginLogMapper;
	}
	@Autowired
	public void setLoginLogMapper(LoginLogMapper loginLogMapper) {
		this.loginLogMapper = loginLogMapper;
	}

	@Override
	public int loginlog(LoginLog LoginLog) {
		// TODO Auto-generated method stub
		return loginLogMapper.insertSelective(LoginLog);
//		loginLogMapper.selectByPrimaryKey(1);
	}

}
