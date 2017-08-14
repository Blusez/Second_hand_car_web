package com.keller.service;

import java.util.List;

import com.keller.model.CarFav;

/**
 * @author keller
 * @date 创建时间：2017年4月27日下午1:48:20
 * @version 1.0
 */
public interface ICarFavService {
	/**
	 * 查出所有的收藏汽车
	 * @param uid
	 * @return
	 */
	List<CarFav> selectCar(CarFav carFav);
	/**
	 * 增加收藏汽车
	 * @param carFav
	 */
	void insertFav(CarFav carFav);
	/**
	 * 删除收藏
	 * @param carFav
	 * @return
	 */
	int deleteFav(CarFav carFav);

}
