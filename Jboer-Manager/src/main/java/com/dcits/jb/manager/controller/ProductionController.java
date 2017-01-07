package com.dcits.jb.manager.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dcits.jb.manager.service.ProductionService;

import net.sf.json.JSONObject;
@RequestMapping("/production")
@Controller
public class ProductionController {
	
	private Logger logger = Logger.getLogger(ProductionController.class);
	@Resource(name="productionService")
	private ProductionService productionService;
	
	@RequestMapping("/commodity/tocommodityList")
	public String toCommodityList(HttpServletRequest request,String modularId) {
		
		request.setAttribute("modularId", modularId);
		
		return "/production/commodity/commodityList";
		
	}
	
	@RequestMapping("/commodity/getProductionList")
	@ResponseBody
	public String getProductionList(HttpServletRequest request,String proname,String protype,Date createtime,String isself,String resouce,Date invlidtime,String issale, int rows ,int page){
		ConcurrentMap<String, Object> returnMap = new ConcurrentHashMap<String, Object>();
		int allRows = productionService.getCountCommodityListByCaseOnPage(proname, protype,createtime, isself, resouce, invlidtime, issale);
		List<ConcurrentHashMap<String, String>> productionList = productionService.getCommodityListByCaseOnPage(proname, protype, createtime, isself, resouce, invlidtime, issale, rows, page);
		if(productionList == null ){
			productionList = new ArrayList<ConcurrentHashMap<String,String>>();
		}
		returnMap.put("total", allRows);
		returnMap.put("rows", productionList);
		JSONObject jo = JSONObject.fromObject(returnMap);
		return jo.toString();
	}
	
	

}
