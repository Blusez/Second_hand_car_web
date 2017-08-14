package com.keller.dao;

import java.util.List;

import com.keller.model.CarFav;

public interface CarFavMapper {
    int deleteByPrimaryKey(Integer fId);

    int insert(CarFav record);

    int insertSelective(CarFav record);

    CarFav selectByPrimaryKey(Integer fId);

    int updateByPrimaryKeySelective(CarFav record);

    int updateByPrimaryKey(CarFav record);

	List<CarFav> selectByuId(CarFav carFav);
}