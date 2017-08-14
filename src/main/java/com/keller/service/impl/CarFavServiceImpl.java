package com.keller.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.keller.dao.CarFavMapper;
import com.keller.model.CarFav;
import com.keller.service.ICarFavService;

/**
 * @author keller
 * @date 创建时间：2017年4月27日下午1:59:25
 * @version 1.0
 */
@Service("CarFavServiceImpl")
public class CarFavServiceImpl implements ICarFavService {
	CarFavMapper CarFavMapper;
	

	public CarFavMapper getCarFavMapper() {
		return CarFavMapper;
	}
	@Autowired
	public void setCarFavMapper(CarFavMapper carFavMapper) {
		CarFavMapper = carFavMapper;
	}

	@Override
	public List<CarFav> selectCar(CarFav carFav) {
		// TODO Auto-generated method stub
		return CarFavMapper.selectByuId(carFav);
	}

	@Override
	public void insertFav(CarFav carFav) {
		// TODO Auto-generated method stub
		CarFavMapper.insertSelective(carFav);

	}

	@Override
	public int deleteFav(CarFav carFav) {
		// TODO Auto-generated method stub
		return CarFavMapper.deleteByPrimaryKey(carFav.getfId());
	}

}
