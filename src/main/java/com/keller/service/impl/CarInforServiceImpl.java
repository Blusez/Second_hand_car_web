package com.keller.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.keller.dao.CarInforMapper;
import com.keller.model.Car;
import com.keller.model.CarInfor;
import com.keller.service.ICarInforService;

/**
 * @author keller
 * @date 创建时间：2017年4月23日下午3:30:35
 * @version 1.0
 */
@Service("CarInforServiceImpl")
public class CarInforServiceImpl implements ICarInforService {
	CarInforMapper carInforMapper;
	
	public CarInforMapper getCarInforMapper() {
		return carInforMapper;
	}
	@Autowired
	public void setCarInforMapper(CarInforMapper carInforMapper) {
		this.carInforMapper = carInforMapper;
	}

	@Override
	public Car selectCarByT() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public CarInfor selectCarByPrimeKey(Integer cId) {
		// TODO Auto-generated method stub
		return carInforMapper.selectByPrimaryKey(cId);
	}

	@Override
	public Car selectCarByUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CarInfor> selectCarByLimt(CarInfor record) {
		// TODO Auto-generated method stub
		return carInforMapper.selectByLimit(record);
	}
	@Override
	public int updateCarStatusById(CarInfor record) {
		// TODO Auto-generated method stub
		return carInforMapper.updateByPrimaryKeySelective(record);
	}
	@Override
	public int InsertCar(CarInfor record) {
		// TODO Auto-generated method stub
		return carInforMapper.insertSelective(record);
	}
	@Override
	public int selectAllCount() {
		// TODO Auto-generated method stub
		return carInforMapper.selectAllCount();
	}
	@Override
	public List<CarInfor> adminselectByLimit(CarInfor record) {
		// TODO Auto-generated method stub
		return carInforMapper.adminselectByLimit(record);
	}

}
