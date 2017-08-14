package com.keller.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.keller.model.CarInfor;
import com.keller.model.SaleOrder;
import com.keller.service.ICarInforService;
import com.keller.service.ISaleOrderService;

import net.sf.json.JSONArray;

/**
 * @author keller
 * @date 创建时间：2017年4月27日下午12:12:31
 * @version 1.0
 */
@Controller
@RequestMapping("/SaleOrderController")
public class SaleOrderController {
	ISaleOrderService saleOrderService;
	ICarInforService carInforService;

	public ICarInforService getCarInforService() {
		return carInforService;
	}
	@Autowired
	public void setCarInforService(ICarInforService carInforService) {
		this.carInforService = carInforService;
	}
	public ISaleOrderService getSaleOrderService() {
		return saleOrderService;
	}
	@Autowired
	public void setSaleOrderService(ISaleOrderService saleOrderService) {
		this.saleOrderService = saleOrderService;
	}
	
	
	@RequestMapping("selectOrder")
	public void selectOrder(
			@RequestParam(value = "uid", defaultValue = "0") Integer uid,
			@RequestParam(value = "cid", defaultValue = "0") Integer cid,
			@RequestParam(value = "start", defaultValue = "0") Integer start,
			@RequestParam(value = "limit", defaultValue = "5") Integer limit, 
			HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		SaleOrder record = new SaleOrder();
		record.setLimit(limit);
		record.setStart(start);
		record.setcId(cid);
		record.setuId(uid);
		List<SaleOrder> listid = saleOrderService.selectByUid(record);
		List<CarInfor> carinfors =new ArrayList<>();
		for(SaleOrder saleOrder :listid){
			CarInfor carInfor =carInforService.selectCarByPrimeKey(saleOrder.getcId());
			carinfors.add(carInfor);
		}
		
		if (carinfors.size() != 0) {
			JSONArray carlist = new JSONArray();
			carlist.addAll(carinfors);
			out.println(carlist.toString());
		} else {
			out.println("no");
		}
		
	}
	

}
