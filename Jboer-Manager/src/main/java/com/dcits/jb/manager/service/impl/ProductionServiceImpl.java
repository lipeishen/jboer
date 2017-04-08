package com.dcits.jb.manager.service.impl;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dcits.jb.core.util.BeanUtil;
import com.dcits.jb.core.util.StringUtil;
import com.dcits.jb.core.util.UuidUtil;
import com.dcits.jb.manager.service.ProductionService;
import com.dcits.jb.manager.single.mapper.BhProductionMainInfoMapper;
import com.dcits.jb.manager.single.model.BhProductionMainInfo;
import com.dcits.jb.manager.single.model.BhProductionMainInfoExample;
import com.dcits.jb.manager.union.mapper.ProductMapper;
import com.dcits.jb.manager.util.RandomUtil;

@Service("productionService")
public class ProductionServiceImpl implements ProductionService {

	@Autowired 
	private BhProductionMainInfoMapper bhProductionMainInfoMapper;
	@Autowired
	private ProductMapper productMapper;
	
	public int getCountCommodityListByCaseOnPage(String proname,String protype,String isself,String resouce,String issale){
		
		if (!"".equals(StringUtil.getNullStr(proname))) {
			proname="%"+proname+"%";
		}
		int num=productMapper.getCountProListByConQuery(proname, protype, isself, resouce, issale);
		
		return num;
		
	}
	
	public List<HashMap<String, Object>> getCommodityListByCaseOnPage(String proname,String protype,String isself,String resouce,String issale,int rows,int page){
		List<HashMap<String, Object>> listmap=null;
		//rows 每页显示的记录数， page 当前页数 
		//1 0 (1-1)*rows
		page = (page-1)*rows;
		listmap=productMapper.getProListByConQuery(proname, protype, isself, resouce, issale, rows, page);
		return listmap;
	}
	
	@Override
	public String updateProductInfo(HashMap<String, String> productMap,String loginname) {
		String productionName = StringUtil.getNullStr(productMap.get("productionName"));
		String productionType = StringUtil.getNullStr(productMap.get("productionType"));
		String productionPrice = StringUtil.getNullStr(productMap.get("productionPrice"));
		String productionIsself = StringUtil.getNullStr(productMap.get("productionIsself"));
		String productionSource = StringUtil.getNullStr(productMap.get("productionSource"));
		String productionIssale = StringUtil.getNullStr(productMap.get("productionIssale"));
		StringBuffer sb=new StringBuffer();
		double price = 0.00;
		//校验excel 数据的合法性
		if("".equals(StringUtil.getNullStr(productionName))){
			sb.append("产品名称为空，");
		}
		if ("".equals(StringUtil.getNullStr(productionType))) {
			sb.append("产品类型为空，");
		}else{
			if (!"0".equals(productionType)&&!"1".equals(productionType)&&!"2".equals(productionType)
					&&!"3".equals(productionType)&&!"4".equals(productionType)) {
				sb.append("产品类型编码不正确，");
			}
		}
		if("".equals(StringUtil.getNullStr(productionPrice))){
			sb.append("产品价格为空");
		}else{
			//采用正则表达式的方式来判断一个字符串是否为数字，这种方式判断面比较全
			//可以判断正负、整数小数
			try {
				DecimalFormat df = new DecimalFormat("#.##");
				 price = Double.parseDouble(df.format(Double.parseDouble(productionPrice)));
			} catch (Exception e) {
				e.printStackTrace();
				sb.append("产品价格不合法");
			}
		}
		if ("".equals(StringUtil.getNullStr(productionIsself))) {
			sb.append("产品是否自有为空，");
		}else{
			if (!"0".equals(productionIsself)&&!"1".equals(productionIsself)) {
				sb.append("产品是否自有编码不正确，");
			}
		}	
		if ("".equals(StringUtil.getNullStr(productionIssale))) {
			sb.append("产品是否促销为空，");
		}else{
			if (!"0".equals(productionIssale)&&!"1".equals(productionIssale)) {
				sb.append("产品是否促销编码不正确，");
			}
		}	
		if("".equals(StringUtil.getNullStr(productionSource))){
			sb.append("产品来源为空，");
		}
		 String messg=sb.toString();
		if (sb.length()>0) {
		   messg=messg.substring(0, messg.length()-1);
		   return messg;
		}
			//根据类型和名称判定是同一种商品，如果是同一种商品，就更新库存，否则增加新的商品
			try{
				    BhProductionMainInfo product=null;
					BhProductionMainInfoExample example =new BhProductionMainInfoExample();
					example.createCriteria().andProductionTypeEqualTo(productionType).andProductionNameEqualTo(productionName);
					List<BhProductionMainInfo>  listmap = bhProductionMainInfoMapper.selectByExample(example);
					if(listmap!=null&&listmap.size() > 0){
						//更新记录
						product=listmap.get(0);
						if (product!=null) {
							long total = getStockTotal(productionName,productionType)+1;
							product.setProductionStockRemain(total);
							int i=bhProductionMainInfoMapper.updateByPrimaryKeySelective(product);
							if (i>0) {
								return "update";
							}
						}
				}else {
					//插入一条新的记录
					BhProductionMainInfo productup=new BhProductionMainInfo();
					productup.setProductionId(UuidUtil.get32Uuid());
					productup.setImportPerson(loginname);
					productup.setProductionType(productionType);
					productup.setImportTime(new Date());
					productup.setProductionIssale(productionIssale);
					productup.setProductionIsself(productionIsself);
					productup.setProductionName(productionName);
					productup.setProductionPrice(price);
					productup.setProductionSource(productionSource);
					productup.setProductionStockRemain((long) 1);
					//获取当前库存
					long total=getStockTotal(productionName, productionType)+1;
					productup.setProductionStockRemain(total);
					productup.setProductionIsvalid("1");
					productup.setProductionCode(RandomUtil.getProCode(16));
					int i=bhProductionMainInfoMapper.insertSelective(productup);
					if (i>0) {
						return "insert";
					}
					
			}
			}catch(Exception e){
				e.printStackTrace();
				return "error";
			}
			return "";
			
		}
	
	//获取当前库存
	public long getStockTotal(String proname,String protype){
		BhProductionMainInfoExample example = new  BhProductionMainInfoExample();
		example.createCriteria().andProductionNameEqualTo(proname).andProductionTypeEqualTo(protype);
		long num=bhProductionMainInfoMapper.countByExample(example);
		return num;
	}
	
	}


