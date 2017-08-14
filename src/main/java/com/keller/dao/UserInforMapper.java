package com.keller.dao;

import com.keller.model.UserInfor;

public interface UserInforMapper {
    int deleteByPrimaryKey(Integer uId);

    int insert(UserInfor record);

    int insertSelective(UserInfor record);

    UserInfor selectByPrimaryKey(Integer uId);

    int updateByPrimaryKeySelective(UserInfor record);

    int updateByPrimaryKey(UserInfor record);
}