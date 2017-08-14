package com.keller.dao;

import com.keller.model.CarBrand;

public interface CarBrandMapper {
    int deleteByPrimaryKey(Integer bId);

    int insert(CarBrand record);

    int insertSelective(CarBrand record);

    CarBrand selectByPrimaryKey(Integer bId);

    int updateByPrimaryKeySelective(CarBrand record);

    int updateByPrimaryKey(CarBrand record);
}