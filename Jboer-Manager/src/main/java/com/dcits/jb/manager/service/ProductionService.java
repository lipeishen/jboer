package com.dcits.jb.manager.service;

import java.util.HashMap;
import java.util.List;

public interface ProductionService {
	
	public int getCountCommodityListByCaseOnPage(String proname,String protype,String isself,String resouce,String issale);
	
	public List<HashMap<String, Object>> getCommodityListByCaseOnPage(String proname,String protype,String isself,String resouce,String issale,int rows,int page);
	
	public String updateProductInfo(HashMap<String, String> productMap,String loginname);

}
