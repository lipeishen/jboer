package com.dcits.djk.manager.service.impl;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dcits.djk.manager.service.ConsumerService;
import com.dcits.djk.manager.union.mapper.ConsumerMapper;
@Service("consumerService")
public class ConsumerServiceImpl implements ConsumerService{
	private Logger logger = Logger.getLogger(ConsumerServiceImpl.class);
	
	@Autowired
	private ConsumerMapper consumerMapper;
	
	@Override
	 public int getCountConsumerListByCaseOnPage(String surname,String name,String mobphone){
		
		if(surname != null && !"".equals(surname)){
			surname = "%"+surname+"%";
		}
		
		if(name != null && !"".equals(name)){
			name = "%"+name+"%";
		}
		if(mobphone != null && !"".equals(mobphone)){
			mobphone = "%"+mobphone+"%";
		}
		
		logger.debug("==============================================service countsql start");
		int allrows = consumerMapper.getCountConsumerListByCaseOnPage(surname, name, mobphone);
		logger.debug("==============================================service countsql end");
		
		return allrows;
		
	}
	@Override	
	 public List<ConcurrentHashMap<String, String>> getConsumerListByCaseOnPage(String surname,String name,String mobphone,int rows, int page){
		
		if(surname != null && !"".equals(surname)){
			surname = "%"+surname+"%";
		}
		
		if(name != null && !"".equals(name)){
			name = "%"+name+"%";
		}
		if(mobphone != null && !"".equals(mobphone)){
			mobphone = "%"+mobphone+"%";
		}
		
		//rows 每页显示的记录数， page 当前页数 
				//1 0 (1-1)*rows
		page = (page-1)*rows;
		logger.debug("==============================================service sql start");
		List<ConcurrentHashMap<String, String>> consumerList=consumerMapper.getConsumerListByCaseOnPage(surname, name, mobphone, rows, page);
		logger.debug("==============================================service sql end");
		return consumerList;
		
	}


}
