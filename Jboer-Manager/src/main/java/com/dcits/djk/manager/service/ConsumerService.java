package com.dcits.djk.manager.service;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public interface ConsumerService {
	
	 public int getCountConsumerListByCaseOnPage(String surname,String name,String mobphone);
	
	 public List<ConcurrentHashMap<String, String>> getConsumerListByCaseOnPage(String surname,String name,String mobphone,int rows, int page);

}
