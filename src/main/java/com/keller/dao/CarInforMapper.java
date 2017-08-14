package com.keller.dao;

import java.util.List;

import com.keller.model.CarInfor;

public interface CarInforMapper {
    int deleteByPrimaryKey(Integer cId);

    int insert(CarInfor record);

    int insertSelective(CarInfor record);

    CarInfor selectByPrimaryKey(Integer cId);

    int updateByPrimaryKeySelective(CarInfor record);

    int updateByPrimaryKey(CarInfor record);
    int selectAllCount();

	List<CarInfor> selectByLimit(CarInfor record);
	List<CarInfor> adminselectByLimit(CarInfor record);
	
}