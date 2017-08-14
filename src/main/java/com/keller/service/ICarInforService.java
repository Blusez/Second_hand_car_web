package com.keller.service;

import java.util.List;

import com.keller.model.Car;
import com.keller.model.CarInfor;

/**
 * @author keller
 * @date 创建时间：2017年4月22日下午9:33:50
 * @version 1.0
 */
public interface ICarInforService {
	/**
	 * 根据条件进行筛选
	 */
	public Car selectCarByT();
	
	public Car selectCarByUser();
	public List<CarInfor> selectCarByLimt(CarInfor record);
	public List<CarInfor> adminselectByLimit(CarInfor record);
	/**
	 * C_status:0:审核中   1：上架  2：下架 3：销售中 4：付款成功 5：订单取消
	 * 购买汽车，设置C_status为3
	 */
	public int updateCarStatusById(CarInfor record);
	public int InsertCar(CarInfor record);
	
	int selectAllCount();

	CarInfor selectCarByPrimeKey(Integer cId);

}
