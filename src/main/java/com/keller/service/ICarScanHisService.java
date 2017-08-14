package com.keller.service;

import java.util.List;

import com.keller.model.CarScanHis;

/**
 * @author keller
 * @date 创建时间：2017年4月27日下午8:32:16
 * @version 1.0
 */
public interface ICarScanHisService {
	
	List<CarScanHis> selectByuId(CarScanHis carScanHis);
	List<CarScanHis> selectByWhatlike(CarScanHis carScanHis);

	void insert(CarScanHis carScanHis);
}
