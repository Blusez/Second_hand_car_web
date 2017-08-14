package com.keller.service;

import java.util.List;

import com.keller.model.CarInfor;
import com.keller.model.SaleOrder;

/**
 * @author keller
 * @date 创建时间：2017年4月27日上午11:51:56
 * @version 1.0
 */
public interface ISaleOrderService {
	/**
	 * 插入购买信息
	 * @param saleOrder
	 */
	public void insertcord(SaleOrder saleOrder);
	/**
	 * 购买商品状态
	 * @param saleOrder
	 * @return
	 */
	public int updatecordStutas(SaleOrder saleOrder);
	
	List<SaleOrder> selectByUid(SaleOrder saleOrder);

}
