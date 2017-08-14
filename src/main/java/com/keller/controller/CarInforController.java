package com.keller.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.DiskFileUpload;
import org.apache.commons.fileupload.FileItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.keller.model.CarInfor;
import com.keller.model.SaleOrder;
import com.keller.service.ICarInforService;
import com.keller.service.ICarScanHisService;
import com.keller.service.ISaleOrderService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import utils.PageUtil;

/**
 * @author keller
 * @date 创建时间：2017年4月19日下午5:27:01
 * @version 1.0
 */
@Controller
@RequestMapping("/CarInforController")
public class CarInforController {
	ICarInforService carInforService;
	ISaleOrderService saleOrderService;
	ICarScanHisService carScanHisService;
	
	
	

	public ICarScanHisService getCarScanHisService() {
		return carScanHisService;
	}
	@Autowired
	public void setCarScanHisService(ICarScanHisService carScanHisService) {
		this.carScanHisService = carScanHisService;
	}
	public ISaleOrderService getSaleOrderService() {
		return saleOrderService;
	}
	@Autowired
	public void setSaleOrderService(ISaleOrderService saleOrderService) {
		this.saleOrderService = saleOrderService;
	}

	public ICarInforService getCarInforService() {
		return carInforService;
	}

	@Autowired
	public void setCarInforService(ICarInforService carInforService) {
		this.carInforService = carInforService;
	}

	@RequestMapping("selectByLimt")
	public void selectByLimt(@RequestParam(value = "order_dauft", defaultValue = "dauft") String order_dauft,
			@RequestParam(value = "order_price", defaultValue = "dauft") String order_price,
			@RequestParam(value = "order_brand", defaultValue = "dauft") String order_brand,
			@RequestParam(value = "key", defaultValue = "dauft") String key,
			@RequestParam(value = "start", defaultValue = "0") Integer start,
			@RequestParam(value = "limit", defaultValue = "5") Integer limit, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		CarInfor record = new CarInfor();
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		record.setStart(start);
		record.setLimit(limit);
		List<CarInfor> list;

		
//		order_dauft  =new String(order_dauft.getBytes("iso-8859-1"),"utf-8");
//		order_price  =new String(order_price.getBytes("iso-8859-1"),"utf-8");
//		order_brand  =new String(order_brand.getBytes("iso-8859-1"),"utf-8");
//		key  =new String(key.getBytes("iso-8859-1"),"utf-8");
		if (order_dauft.equals("dauft")) {
		} else if (order_dauft.equals("价格最低")) {
			record.setOrder_daufu("CAST(TRIM('万' FROM c_price) AS  decimal(9,2))");
		} else if (order_dauft.equals("价格最高")) {
			record.setOrder_daufu("CAST(TRIM('万' FROM c_price) AS  decimal(9,2)) desc");
		} else if (order_dauft.equals("里程最短")) {
			record.setOrder_daufu("CAST(TRIM('万' FROM c_distance) AS  decimal(9,2))");
		}
		if (order_price.equals("dauft")) {
		} else if (order_price.equals("5万以内")) {
			record.setOrder_price("CAST(TRIM('万' FROM c_price) AS  decimal(9,2)) <5");
		} else if (order_price.equals("5万~10万")) {
			record.setOrder_price("CAST(TRIM('万' FROM c_price) AS  decimal(9,2)) BETWEEN 5 and 10");
		} else if (order_price.equals("10万~20万")) {
			record.setOrder_price("CAST(TRIM('万' FROM c_price) AS  decimal(9,2)) BETWEEN 10 and 20");
		} else if (order_price.equals("20万以上")) {
			record.setOrder_price("CAST(TRIM('万' FROM c_price) AS  decimal(9,2)) >20");
		}
		if (!order_brand.equals("dauft")&&!order_brand.equals("品牌")) {
			record.setOrder_brand("c_name like '%"+order_brand+"%'");
		} 
		if (!key.equals("dauft")) {
			record.setKey("c_name like '%"
					+key+"%'  or b_id like '%"
					+key+"%' or m_id like '%"
					+key+"%' or c_city like '%"
					+key+"%' or c_price like '%"
					+key+"%' or c_distance like '%"
					+key+"%'");
		} 
		int count = carInforService.selectAllCount();
		list = carInforService.selectCarByLimt(record);
		for (CarInfor cc:list) {
			cc.setCount(count);
		}
		// System.out.println(list.get(0).getcDes().toString());
		// list
		if (list.size() != 0) {
			JSONArray carlist = new JSONArray();
			carlist.addAll(list);
			out.println(carlist.toString());
		} else {
			out.println("no");
		}
		
	}
	
	
	
	@RequestMapping("updateStatusByid")
	public void updateStatusByid(@RequestParam(value = "status", defaultValue = "1") Integer status,
			@RequestParam(value = "", defaultValue = "0") Integer id, 
			@RequestParam(value = "uid", defaultValue = "0") String uid, 
			HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		CarInfor record = new CarInfor();
		record.setcId(id);
		record.setcStatus(status);
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		int flag = carInforService.updateCarStatusById(record);
		// System.out.println(list.get(0).getcDes().toString());
		// list
		if (flag > 0) {
			if (!uid.equals("0")) {
				//保存到购车记录
				SaleOrder saleOrder =new SaleOrder();
				saleOrder.setcId(id);
				saleOrder.setuId(Integer.parseInt(uid));
				saleOrder.setStatus(status+"");
				saleOrderService.insertcord(saleOrder);
			}
			
			JSONObject rusult = new JSONObject();
			rusult.put("result", "success");
			out.println(rusult.toString());
		} else {

			out.println("no");
		}
	}
	
	@RequestMapping("insertCarinf")
	public void insertCarinf(@RequestParam(value = "status", defaultValue = "1") Integer status,
			@RequestParam(value = "id", defaultValue = "0") Integer id, 
			@RequestParam(value = "uid", defaultValue = "0") String uid, 
			@RequestParam(value = "name", defaultValue = "0") String name1, 
			@RequestParam(value = "city", defaultValue = "0") String city, 
			@RequestParam(value = "sptime", defaultValue = "0") String sptime, 
			@RequestParam(value = "distance", defaultValue = "0") String distance, 
			@RequestParam(value = "price", defaultValue = "0") String price, 
			HttpServletRequest request,
			HttpServletResponse response)  {
		CarInfor record = new CarInfor();
		record.setcName(name1);
		record.setcCity(city);
		record.setcLicensrtime(sptime);
		record.setcDistance(distance);
		record.setcPrice(price);
		record.setcStatus(4);
		String destDirName = request.getSession().getServletContext().getRealPath("/") ;
        createDir(destDirName+ "temp");
        createDir(destDirName+ "Image");
		//接收文件
		String temp = request.getSession().getServletContext().getRealPath("/") + "temp"; // 临时目录
		System.out.println("temp=" + temp);
		String loadpath = request.getSession().getServletContext().getRealPath("/") + "Image"; // 上传文件存放目录
		System.out.println("loadpath=" + loadpath);
		DiskFileUpload fu = new DiskFileUpload();
		fu.setSizeMax(30* 1024 * 1024); // 设置允许用户上传文件大小,单位:字节
		fu.setSizeThreshold(4096); // 设置最多只允许在内存中存储的数据,单位:字节
		fu.setRepositoryPath(temp); // 设置一旦文件大小超过getSizeThreshold()的值时数据存放在硬盘的目录

		// 开始读取上传信息
		int index = 0;
		List fileItems = null;

		try {
			fileItems = fu.parseRequest(request);
			System.out.println("fileItems=" + fileItems);
		} catch (Exception e) {
			e.printStackTrace();
		}

		Iterator iter = fileItems.iterator(); // 依次处理每个上传的文件
		while (iter.hasNext()) {
			FileItem item = (FileItem) iter.next();// 忽略其他不是文件域的所有表单信息
			if (!item.isFormField()) {
				String name = item.getName();// 获取上传文件名,包括路径
				name = name.substring(name.lastIndexOf("\\") + 1);// 从全路径中提取文件名
				long size = item.getSize();
				if ((name == null || name.equals("")) && size == 0)
					continue;
				int point = name.indexOf(".");
				name = (new Date()).getTime() + name.substring(point, name.length());
				index++;
				File fNew = new File(loadpath, name);
				try {
					item.write(fNew);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				record.setpUrl("http://112.74.193.234:8080/Second_hand_car/"+"/Image/"+name);
				System.out.println(record.getpUrl());
			} else// 取出不是文件域的所有表单信息
			{
				String fieldvalue = item.getString();
				// 如果包含中文应写为：(转为UTF-8编码)
				// String fieldvalue = new
				// String(item.getString().getBytes(),"UTF-8");
			}
		}
		int flag=carInforService.InsertCar(record);
//		String text1 = "11";
//		response.sendRedirect("result.jsp?text1=" + text1);
		
//
//		ObjectInputStream ois = null;
//		try {
//			PrintWriter out = response.getWriter();
////        	System.out.println(request.getInputStream().toString());
////            ois = new ObjectInputStream(request.getInputStream()); 
////            record = (CarInfor) ois.readObject();  
////			out.print("success");
////			out.print(record.toString());
//            out.flush();  
//            out.close();  
//        } catch (Exception e) {  
//            e.printStackTrace();  
//        } finally {  
//            ois.close();  
//        }
	}
	/**
	 * C_status: 0：默认上架中  1. 销售中  2.卖出成功  3.订单取消  4.审核  5.下架
	 * @param start
	 * @param limit
	 * @param cStatus
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	
	@RequestMapping("adminselectByLimt")
	public String adminselectByLimt(
			@RequestParam(value = "start", defaultValue = "0") Integer start,
			@RequestParam(value = "limit", defaultValue = "5") Integer limit, 
			@RequestParam(value = "cStatus", defaultValue = "0") Integer cStatus, 
			HttpServletRequest request,
			HttpServletResponse response)  {
		int totalCount =carInforService.selectAllCount();
		PageUtil pageUtil = new PageUtil();
		pageUtil.setTotalCount(totalCount);
		pageUtil.setPageSize(limit);
		pageUtil.setCurrentPage(start);
		
		CarInfor carInfor =new CarInfor();
		carInfor.setLimit(limit);
		carInfor.setStart(pageUtil.getCurrentStart());
		carInfor.setcStatus(cStatus);
		List<CarInfor> carInfors = carInforService.adminselectByLimit(carInfor);
		
		
		request.setAttribute("carInfors", carInfors);
		request.setAttribute("pageUtil", pageUtil);
		if (cStatus==4) {
		   return "showCar2";
		}else{
			
			return "showCar";
		}
	}
	@RequestMapping("adminselectByLimt1")
	public String adminselectByLimt1(
			@RequestParam(value = "start", defaultValue = "0") Integer start,
			@RequestParam(value = "limit", defaultValue = "5") Integer limit, 
			@RequestParam(value = "cStatus", defaultValue = "0") Integer cStatus, 
			HttpServletRequest request,
			HttpServletResponse response) {
		int totalCount =carInforService.selectAllCount();
		PageUtil pageUtil = new PageUtil();
		pageUtil.setTotalCount(totalCount);
		pageUtil.setPageSize(limit);
		pageUtil.setCurrentPage(start);
		
		CarInfor carInfor =new CarInfor();
		carInfor.setLimit(limit);
		carInfor.setStart(pageUtil.getCurrentStart());
		carInfor.setcStatus(cStatus);
		List<CarInfor> carInfors = carInforService.adminselectByLimit(carInfor);
		request.setAttribute("carInfors", carInfors);
		request.setAttribute("pageUtil", pageUtil);
		return "showCar1";
	}
	
	
	 public  boolean createDir(String destDirName) {  
	        File dir = new File(destDirName);  
	        if (dir.exists()) {  
	            System.out.println("创建目录" + destDirName + "失败，目标目录已经存在");  
	            return false;  
	        }  
	        if (!destDirName.endsWith(File.separator)) {  
	            destDirName = destDirName + File.separator;  
	        }  
	        //创建目录  
	        if (dir.mkdirs()) {  
	            System.out.println("创建目录" + destDirName + "成功！");  
	            return true;  
	        } else {  
	            System.out.println("创建目录" + destDirName + "失败！");  
	            return false;  
	        }  
	    } 
}
