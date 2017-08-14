package com.keller.dao;

import com.keller.model.CarModel;

public interface CarModelMapper {
    int deleteByPrimaryKey(Integer mId);

    int insert(CarModel record);

    int insertSelective(CarModel record);

    CarModel selectByPrimaryKey(Integer mId);

    int updateByPrimaryKeySelective(CarModel record);

    int updateByPrimaryKey(CarModel record);
}