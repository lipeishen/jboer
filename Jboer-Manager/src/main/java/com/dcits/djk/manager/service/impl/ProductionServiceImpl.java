package com.dcits.djk.manager.service.impl;

import java.util.Date;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

import com.dcits.djk.manager.service.ProductionService;
import com.dcits.djk.manager.single.model.BhProductionMainInfoExample;
@Service("productionService")
public class ProductionServiceImpl implements ProductionService {

	
	
	public int getCountCommodityListByCaseOnPage(String proname,String protype,Date createtime,String isself,String resouce,Date invlidtime,String issale){
		
		BhProductionMainInfoExample example =new BhProductionMainInfoExample();
		BhProductionMainInfoExample.Criteria criteria =new BhProductionMainInfoExample().createCriteria();
		
		if (!"".equals(proname)&&proname!=null) {
			proname="%"+proname+"%";
			criteria.andProductionNameLike(proname);
			
		}
		if ("0".equals(protype)) {
			criteria.andProductionTypeEqualTo("0");
		}else if ("1".equals(protype)) {
			criteria.andProductionTypeEqualTo("1");
		}else if ("2".equals(protype)) {
			criteria.andProductionTypeEqualTo("2");
		}else if ("3".equals(protype)) {
			criteria.andProductionTypeEqualTo("3");
		}else if ("4".equals(protype)) {
			criteria.andProductionTypeEqualTo("4");
		}
		if (createtime!=null) {
			criteria.andProductionCreateTimeEqualTo(createtime);
		}
		if ("0".equals(isself)) {
			criteria.andProductionIsselfEqualTo("0");
		}else if ("1".equals(isself)) {
			criteria.andProductionIsselfEqualTo("1");
		}
		
	}
	
	public List<ConcurrentHashMap<String, String>> getCommodityListByCaseOnPage(String proname,String protype,Date createtime,String isself,String resouce,Date invlidtime,String issale,int rows,int page);

}
