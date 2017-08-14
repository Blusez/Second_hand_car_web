package com.keller.dao;

import java.util.List;

import com.keller.model.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer uId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer uId);
    
    User selectByLogin(User record);
    
    User selectByName(User record);
    List<User> adminselectBylimit(User record);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    int selectCount(User record);
}