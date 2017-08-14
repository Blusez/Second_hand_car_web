package com.keller.dao;

import java.util.List;

import com.keller.model.CarScanHis;

public interface CarScanHisMapper {
    int deleteByPrimaryKey(Integer sId);

    int insert(CarScanHis record);

    int insertSelective(CarScanHis record);

    CarScanHis selectByPrimaryKey(Integer sId);

    int updateByPrimaryKeySelective(CarScanHis record);

    int updateByPrimaryKey(CarScanHis record);

	List<CarScanHis> selectByuId(CarScanHis carScanHis);

	List<CarScanHis> selectByWhatlike(CarScanHis carScanHis);
}