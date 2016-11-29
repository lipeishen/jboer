package com.dcits.djk.manager.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dcits.djk.manager.service.ConsumerService;

import net.sf.json.JSONObject;
@Controller
@RequestMapping("/consumer")
public class ConsumerController {
	private Logger logger = Logger.getLogger(ConsumerController.class);
	@Resource(name="consumerService")
	private ConsumerService consumerService;
	
	@RequestMapping("/toconsumer")
	public String toConsumerList(HttpServletRequest request){
		
		return "/consumer/consumerList";
	}
	
	@RequestMapping("/getConsumerList")
	@ResponseBody
	public String getConsumerList(HttpServletRequest request,String surname,String name,String mobphone, int rows ,int page){
		ConcurrentMap<String, Object> returnMap = new ConcurrentHashMap<String, Object>();
		int allRows = consumerService.getCountConsumerListByCaseOnPage(surname, name, mobphone);
		List<ConcurrentHashMap<String, String>> consumerList = consumerService.getConsumerListByCaseOnPage(surname, name, mobphone, rows, page);
		if(consumerList == null ){
			consumerList = new ArrayList<ConcurrentHashMap<String,String>>();
		}
		returnMap.put("total", allRows);
		returnMap.put("rows", consumerList);
		JSONObject jo = JSONObject.fromObject(returnMap);
		return jo.toString();
		
		
	}

}
