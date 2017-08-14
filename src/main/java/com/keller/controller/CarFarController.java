package com.keller.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.keller.model.CarFav;
import com.keller.model.CarInfor;
import com.keller.model.SaleOrder;
import com.keller.service.ICarFavService;
import com.keller.service.ICarInforService;

import net.sf.json.JSONArray;

/**
 * @author keller
 * @date 创建时间：2017年4月27日下午2:11:03
 * @version 1.0
 */
@Controller
@RequestMapping("/CarFarController")
public class CarFarController {
	private ICarFavService carFavService;
	private ICarInforService carInforService;
	
	public ICarInforService getCarInforService() {
		return carInforService;
	}
	@Autowired
	public void setCarInforService(ICarInforService carInforService) {
		this.carInforService = carInforService;
	}
	public ICarFavService getCarFavService() {
		return carFavService;
	}
	@Autowired
	public void setCarFavService(ICarFavService carFavService) {
		this.carFavService = carFavService;
	}
	
	@RequestMapping("selectFav")
	public void selectFav(
			@RequestParam(value = "uid", defaultValue = "0") Integer uid,
			@RequestParam(value = "cid", defaultValue = "0") Integer cid,
			@RequestParam(value = "start", defaultValue = "0") Integer start,
			@RequestParam(value = "limit", defaultValue = "5") Integer limit, 
			HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		CarFav carFav =new CarFav();
		carFav.setLimit(limit);
		carFav.setStart(start);
		carFav.setcId(cid);
		carFav.setuId(uid);
		List<CarFav> listid = carFavService.selectCar(carFav);
		List<CarInfor> carinfors =new ArrayList<>();
		for(CarFav saleOrder :listid){
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
	/**
	 * 判断是否收藏
	 * @param uid
	 * @param cid
	 * @param start
	 * @param limit
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("orFav")
	public void orFav(
			@RequestParam(value = "uid", defaultValue = "0") Integer uid,
			@RequestParam(value = "cid", defaultValue = "0") Integer cid,
			@RequestParam(value = "start", defaultValue = "0") Integer start,
			@RequestParam(value = "limit", defaultValue = "5") Integer limit, 
			HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		CarFav carFav =new CarFav();
		carFav.setLimit(limit);
		carFav.setStart(start);
		carFav.setcId(cid);
		carFav.setuId(uid);
		List<CarFav> listid = carFavService.selectCar(carFav);
		//判断是否被收藏
		boolean flag = false;
		for(CarFav saleOrder :listid){
			if (cid == saleOrder.getcId()) {
				flag =true;
			}
		}
		
		if (flag) {
//			JSONArray carlist = new JSONArray();
//			carlist.addAll(carinfors);
			out.println("yes");
		} else {
			out.println("no");
		}
		
	}
	/**
	 * 添加收藏
	 * @param uid
	 * @param cid
	 * @param start
	 * @param limit
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("addAnddelfav")
	public void addAnddelfav(
			@RequestParam(value = "uid", defaultValue = "0") Integer uid,
			@RequestParam(value = "cid", defaultValue = "0") Integer cid,
			@RequestParam(value = "opera", defaultValue = "insert") String opera,
			@RequestParam(value = "start", defaultValue = "0") Integer start,
			@RequestParam(value = "limit", defaultValue = "5") Integer limit, 
			HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		CarFav carFav =new CarFav();
		carFav.setLimit(limit);
		carFav.setStart(start);
		carFav.setcId(cid);
		carFav.setuId(uid);
		List<CarFav> listid = carFavService.selectCar(carFav);
		//判断是否被收藏
		boolean flag = false;
		for(CarFav saleOrder :listid){
			if (cid == saleOrder.getcId()) {
				carFav=saleOrder;
				flag =true;
			}
		}
		
		if (flag) {
//			JSONArray carlist = new JSONArray();
//			carlist.addAll(carinfors);
			carFavService.deleteFav(carFav);
			out.println("no");
		} else {
			carFavService.insertFav(carFav);
			out.println("yes");
		}
		
	}
	
	
	
	
}
