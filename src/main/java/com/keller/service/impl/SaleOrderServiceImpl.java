package com.keller.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.keller.dao.SaleOrderMapper;
import com.keller.model.CarInfor;
import com.keller.model.SaleOrder;
import com.keller.service.ISaleOrderService;

/**
 * @author keller
 * @date 创建时间：2017年4月27日上午11:54:51
 * @version 1.0
 */
@Service("SaleOrderServiceImpl")
public class SaleOrderServiceImpl implements ISaleOrderService {
	SaleOrderMapper saleOrderMapper;
	
	
	public SaleOrderMapper getSaleOrderMapper() {
		return saleOrderMapper;
	}
	@Autowired
	public void setSaleOrderMapper(SaleOrderMapper saleOrderMapper) {
		this.saleOrderMapper = saleOrderMapper;
	}

	@Override
	public void insertcord(SaleOrder saleOrder) {
		// TODO Auto-generated method stub
		saleOrderMapper.insertSelective(saleOrder);

	}

	@Override
	public int updatecordStutas(SaleOrder saleOrder) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public List<SaleOrder> selectByUid(SaleOrder saleOrder) {
		// TODO Auto-generated method stub
		return saleOrderMapper.selectByUid(saleOrder);
	}

}
