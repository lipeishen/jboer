package com.dcits.djk.manager.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitterReturnValueHandler;

import com.dcits.djk.core.util.BeanUtil;
import com.dcits.djk.core.util.StringUtil;
import com.dcits.djk.manager.service.ProductionService;
import com.dcits.djk.manager.single.mapper.BhProductionMainInfoMapper;
import com.dcits.djk.manager.single.model.BhProductionMainInfo;
import com.dcits.djk.manager.single.model.BhProductionMainInfoExample;
@Service("productionService")
public class ProductionServiceImpl implements ProductionService {

	@Autowired 
	private BhProductionMainInfoMapper bhProductionMainInfoMapper;
	
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
		
		if (!"".equals(StringUtil.getNullStr(resouce))) {
			criteria.andProductionSourceEqualTo(resouce);
		}
		
		if (invlidtime!=null) {
			criteria.andProductionInvalidTimeEqualTo(invlidtime);
		}
		if (!"".equals(StringUtil.getNullStr(issale))) {
			if ("0".equals(issale)) {
				criteria.andProductionIssaleEqualTo(issale);
			}else if ("1".equals(issale)) {
				criteria.andProductionIssaleEqualTo(issale);
			}
		}
		
		int num=bhProductionMainInfoMapper.countByExample(example);
		
		return num;
		
	}
	
	public List<ConcurrentHashMap<String, String>> getCommodityListByCaseOnPage(String proname,String protype,Date createtime,String isself,String resouce,Date invlidtime,String issale,int rows,int page){
		
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
		
		if (!"".equals(StringUtil.getNullStr(resouce))) {
			criteria.andProductionSourceEqualTo(resouce);
		}
		
		if (invlidtime!=null) {
			criteria.andProductionInvalidTimeEqualTo(invlidtime);
		}
		if (!"".equals(StringUtil.getNullStr(issale))) {
			if ("0".equals(issale)) {
				criteria.andProductionIssaleEqualTo(issale);
			}else if ("1".equals(issale)) {
				criteria.andProductionIssaleEqualTo(issale);
			}
		}
		
		List<BhProductionMainInfo> pList=new ArrayList<BhProductionMainInfo>();
		
		List<BhProductionMainInfo> maps=bhProductionMainInfoMapper.selectByExample(example);
		
		if(maps != null && maps.size() > 0){
			if(maps.size() < rows){
				pList = maps;
			}else{
				if(rows * page < maps.size()){
					for(int i = (page-1)*rows;i < page*rows;i++){
						BhProductionMainInfo proinfo = maps.get(i);
						pList.add(proinfo);
					}
				}else{
					if(maps.size()%rows > 0){
						page = maps.size()/rows + 1;
					}else{
						page = maps.size()/rows;
					}
					for(int i = (page-1)*rows;i < maps.size();i++){
						BhProductionMainInfo proinfo = maps.get(i);
						pList.add(proinfo);
					}
				}
			}
		}
		
		List<ConcurrentHashMap<String, String>> listmap=new ArrayList<ConcurrentHashMap<String, String>>();
		ConcurrentHashMap<String, String> map=new ConcurrentHashMap<>();
		for (BhProductionMainInfo bhProductionMainInfo : pList) {
			map=(ConcurrentHashMap<String, String>) BeanUtil.transBean2Map(bhProductionMainInfo);
			if (map!=null) {
				listmap.add(map);
			}
		}
		
		return listmap;
	}

}
