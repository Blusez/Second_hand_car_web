package com.keller.dao;

import com.keller.model.LoginLog;

public interface LoginLogMapper {
    int deleteByPrimaryKey(Integer fid);

    int insert(LoginLog record);

    int insertSelective(LoginLog record);

    LoginLog selectByPrimaryKey(Integer fid);

    int updateByPrimaryKeySelective(LoginLog record);

    int updateByPrimaryKey(LoginLog record);
}