package com.keller.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.keller.dao.CarScanHisMapper;
import com.keller.model.CarScanHis;
import com.keller.service.ICarScanHisService;

/**
 * @author keller
 * @date 创建时间：2017年4月27日下午8:35:35
 * @version 1.0
 */
@Service("CarScanHisServicelmpl")
public class CarScanHisServicelmpl implements ICarScanHisService {
	CarScanHisMapper carScanHisMapper;

	public CarScanHisMapper getCarScanHisMapper() {
		return carScanHisMapper;
	}
	@Autowired
	public void setCarScanHisMapper(CarScanHisMapper carScanHisMapper) {
		this.carScanHisMapper = carScanHisMapper;
	}

	@Override
	public List<CarScanHis> selectByuId(CarScanHis carScanHis) {
		// TODO Auto-generated method stub
		return carScanHisMapper.selectByuId(carScanHis);
	}

	@Override
	public void insert(CarScanHis carScanHis) {
		// TODO Auto-generated method stub
		carScanHisMapper.insertSelective(carScanHis);

	}
	@Override
	public List<CarScanHis> selectByWhatlike(CarScanHis carScanHis) {
		// TODO Auto-generated method stub
		return carScanHisMapper.selectByWhatlike(carScanHis);
	}

}
