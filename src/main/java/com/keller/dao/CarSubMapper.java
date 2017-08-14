package com.keller.dao;

import com.keller.model.CarSub;

public interface CarSubMapper {
    int deleteByPrimaryKey(Integer sId);

    int insert(CarSub record);

    int insertSelective(CarSub record);

    CarSub selectByPrimaryKey(Integer sId);

    int updateByPrimaryKeySelective(CarSub record);

    int updateByPrimaryKey(CarSub record);
}