package com.keller.dao;

import com.keller.model.Role;

public interface RoleMapper {
    int deleteByPrimaryKey(Integer rId);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer rId);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
}