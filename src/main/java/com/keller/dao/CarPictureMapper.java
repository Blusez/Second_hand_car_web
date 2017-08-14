package com.keller.dao;

import com.keller.model.CarPicture;

public interface CarPictureMapper {
    int deleteByPrimaryKey(Integer pId);

    int insert(CarPicture record);

    int insertSelective(CarPicture record);

    CarPicture selectByPrimaryKey(Integer pId);

    int updateByPrimaryKeySelective(CarPicture record);

    int updateByPrimaryKey(CarPicture record);
}