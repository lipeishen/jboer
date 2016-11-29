package com.dcits.djk.manager.service;

import java.util.Date;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public interface ProductionService {
	
	public int getCountCommodityListByCaseOnPage(String proname,String protype,Date createtime,String isself,String resouce,Date invlidtime,String issale);
	
	public List<ConcurrentHashMap<String, String>> getCommodityListByCaseOnPage(String proname,String protype,Date createtime,String isself,String resouce,Date invlidtime,String issale,int rows,int page);

}
