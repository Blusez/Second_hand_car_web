package com.keller.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.keller.model.CarFav;
import com.keller.model.CarInfor;
import com.keller.model.CarScanHis;
import com.keller.service.ICarInforService;
import com.keller.service.ICarScanHisService;

import net.sf.json.JSONArray;

/**
 * @author keller
 * @date 创建时间：2017年4月27日下午8:43:41
 * @version 1.0
 */
@Controller
@RequestMapping("/CarSanHisController")
public class CarSanHisController {
	ICarScanHisService carScanHisService;
	ICarInforService carInforService;

	public ICarInforService getCarInforService() {
		return carInforService;
	}
	@Autowired
	public void setCarInforService(ICarInforService carInforService) {
		this.carInforService = carInforService;
	}
	public ICarScanHisService getCarScanHisService() {
		return carScanHisService;
	}
	@Autowired
	public void setCarScanHisService(ICarScanHisService carScanHisService) {
		this.carScanHisService = carScanHisService;
	}
	
	@RequestMapping("selectByLimt")
	public void selectByLimt(@RequestParam(value = "uid", defaultValue = "0") Integer uid,
			@RequestParam(value = "cid", defaultValue = "0") Integer cid,
			@RequestParam(value = "start", defaultValue = "0") Integer start,
			@RequestParam(value = "limit", defaultValue = "5") Integer limit, 
			HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		CarScanHis carScanHis =new CarScanHis();
		carScanHis.setuId(uid);
		List<CarScanHis> list;
		list=carScanHisService.selectByuId(carScanHis);
		
		List<CarInfor> carinfors =new ArrayList<>();
		for(CarScanHis saleOrder :list){
			CarInfor carInfor =carInforService.selectCarByPrimeKey(saleOrder.getcId());
			if (carInfor != null) {
				carinfors.add(carInfor);
			}
		}
		
		if (carinfors.size() != 0) {
			JSONArray carlist = new JSONArray();
			carlist.addAll(carinfors);
			out.println(carlist.toString());
		} else {
			out.println("no");
		}
	}
	
	@RequestMapping("addhis")
	public void addhis(
			@RequestParam(value = "uid", defaultValue = "0") Integer uid,
			@RequestParam(value = "cid", defaultValue = "0") Integer cid,
			@RequestParam(value = "opera", defaultValue = "insert") String opera,
			@RequestParam(value = "start", defaultValue = "0") Integer start,
			@RequestParam(value = "limit", defaultValue = "5") Integer limit, 
			HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		CarScanHis carFav =new CarScanHis();
		carFav.setStart(start);
		carFav.setcId(cid);
		carFav.setuId(uid);
		carFav.setLimit(limit);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
		java.util.Date date=new java.util.Date();  
		String str=sdf.format(date); 
		carFav.setTime(str);
		carScanHisService.insert(carFav);
	}
	/**
	 * 猜你喜欢
	 * select t.c_id,count(*) as count
from t_car_scan_his t group by t.c_id having count>1 ORDER BY count  desc  LIMIT 0,4
	 * @param uid
	 * @param cid
	 * @param start
	 * @param limit
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("whatYourLike")
	public void whatYourLike(@RequestParam(value = "uid", defaultValue = "0") Integer uid,
			@RequestParam(value = "cid", defaultValue = "0") Integer cid,
			@RequestParam(value = "start", defaultValue = "0") Integer start,
			@RequestParam(value = "limit", defaultValue = "5") Integer limit, 
			HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		CarScanHis carScanHis =new CarScanHis();
		carScanHis.setuId(uid);
		List<CarScanHis> list;
		List<CarInfor> carinfors =new ArrayList<>();
		if(start == 0){
			list=carScanHisService.selectByWhatlike(carScanHis);
			for(CarScanHis saleOrder :list){
				CarInfor carInfor =carInforService.selectCarByPrimeKey(saleOrder.getcId());
				if (carInfor != null) {
					carinfors.add(carInfor);
				}
			}
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
