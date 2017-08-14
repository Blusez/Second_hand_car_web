package com.keller.dao;

import java.util.List;

import com.keller.model.SaleOrder;

public interface SaleOrderMapper {
    int deleteByPrimaryKey(Integer sId);

    int insert(SaleOrder record);

    int insertSelective(SaleOrder record);

    SaleOrder selectByPrimaryKey(Integer sId);

    int updateByPrimaryKeySelective(SaleOrder record);

    int updateByPrimaryKey(SaleOrder record);

	List<SaleOrder> selectByUid(SaleOrder saleOrder);
}