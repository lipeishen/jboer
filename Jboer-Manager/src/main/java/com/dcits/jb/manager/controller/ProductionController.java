package com.dcits.jb.manager.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.dcits.jb.manager.service.ProductionService;
import com.dcits.jb.manager.single.model.BhSysUserLoginInfo;
import com.dcits.jb.manager.util.ExcelUtil;
import com.dcits.jb.manager.util.SessionUtil;

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
	
	@RequestMapping(value="/commodity/getProductionList",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
	@ResponseBody
	public String getProductionList(HttpServletRequest request,String proname,String protype,String isself,String resouce,String issale, int rows ,int page){
		Map<String, Object> returnMap = new HashMap<String, Object>();
		int allRows = productionService.getCountCommodityListByCaseOnPage(proname, protype,isself, resouce, issale);
		List<HashMap<String, Object>> productionList = productionService.getCommodityListByCaseOnPage(proname, protype,  isself, resouce,  issale, rows, page);
		if(productionList == null ){
			productionList = new ArrayList<HashMap<String,Object>>();
		}
		returnMap.put("total", allRows);
		returnMap.put("rows", productionList);
		JSONObject jo = JSONObject.fromObject(returnMap);
		return jo.toString();
	}
	
	//跳转商品导入页面
	@RequestMapping("/commodity/toProductImport")
	public String toImportSchedule(HttpServletRequest request, Model model, String modularId) {
		return "/production/commodity/commodityImport";
	}
	
	
	/**
	 * 下载商品信息excel模板
	 *
	 * @author lips
	 * @param request
	 * @param response
	 */
	@RequestMapping("/commodity/downloadExcel")
	public void downloadExcel(HttpServletRequest request, HttpServletResponse response) {
		try {
			String fileName = "commodity.xls";
			response.setContentType("application/vnd.ms-excel");
			response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
			response.addHeader("Cache-Control", "no-cache");
			String[] chineseTitleList = { "产品名称", "产品类型", "产品价格", "是否自有产品", "产品来源","是否促销" };
			String[] englishTitleList = { "productionName", "productionType", "productionPrice", "productionIsself","productionSource","productionIssale" };
			Integer[] widths = { 12000, 10000, 6000, 5000, 6000,5000 };
			List<HashMap<String, String>> recordList = new ArrayList<HashMap<String, String>>();
			/*
			 * HashMap<String,String> valueMap = new HashMap<String,String>();
			 * valueMap.put("productionName","示例:苹果");
			 * valueMap.put("productionType","示例:1");
			 * valueMap.put("productionPrice","示例:5.00");
			 * valueMap.put("productionIsself","示例:0");
			 * valueMap.put("productionSource","示例:1");
			 * valueMap.put("productionIssale","示例:1");
			 * recordList.add(valueMap);
			 */
			String sbf = "示例(勿删): 所有输入字段都是必填项，产品类型有如下几类 只需输入类型代码即可(0,蔬菜类1,水果类2,肉类3,奶制品4，蛋类)，产品价格的格式只能是数字类型(保留两位小数 5.00 单位是元)；是否自有产品只需输入编码即可(1是0否)；产品来源是表示产品来至于哪个供应商，只需输入供应商编码即可(1,彩虹)；是否促销输入编码0表示不促销，1表示促销(0否1是)";
			Map<String, String> map = new HashMap<String, String>();
			map.put("length", "6");
			map.put("sbf", sbf);
			String sheetTitle = "商品信息模板";
			OutputStream ouputStream = response.getOutputStream();
			ExcelUtil.getExcelStreamByHssfNotify(chineseTitleList, englishTitleList, widths, recordList, map,
					sheetTitle, ouputStream);
			ouputStream.flush();
			ouputStream.close();
		} catch (Exception e) {
			logger.error(e,e);
		}
	}
	
	/**
	 * 上传excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping("/commodity/uploadExcel")
	@ResponseBody
	public String uploadExcel(HttpServletRequest request, HttpServletResponse response) {
		Map<String, String> result = new HashMap<String, String>();
		StringBuffer sb = new StringBuffer();
		StringBuffer sberror = new StringBuffer();
		InputStream inputStream = null;
		BhSysUserLoginInfo sysUserLoginInfo=null;
		String loginname="admin";
		Object obj = request.getSession(true).getAttribute("session_user");
		if(obj != null && obj instanceof BhSysUserLoginInfo){
			sysUserLoginInfo= (BhSysUserLoginInfo) obj;
			loginname=sysUserLoginInfo.getLoginName();
		}
		try {
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
			Iterator<String> iter = multiRequest.getFileNames();
			int update = 0;
			int insert = 0;
			int error = 0;
			int all = 0;
			while (iter.hasNext()) {
				try {
					// 取得上传文件
					MultipartFile file = multiRequest.getFile(iter.next());
					inputStream = file.getInputStream();
					String[] titleList = {"productionName", "productionType", "productionPrice", "productionIsself","productionSource","productionIssale" };
					List<Map<String, String>> recordList = ExcelUtil.getExcelInfoListByHssf(inputStream, titleList, 0, 2,0);
					if (recordList != null && recordList.size() > 0) {
						all = recordList.size();
						for (int i = 0; i < recordList.size(); i++) {
							HashMap<String, String> productMap = (HashMap<String, String>) recordList.get(i);
							String returnMsg = productionService.updateProductInfo(productMap,loginname);
							if ("insert".equals(returnMsg)) {
								insert++;
							} else if ("update".equals(returnMsg)) {
								update++;
							} else {
								error++;
								sberror.append("\n第" + (i + 1) + "行数据存储的错误。错误原因:"+returnMsg);
							}
						}
					}
				} catch (Exception e) {
					logger.error(e,e);
				}finally {
					try {
						if (inputStream != null) {
							inputStream.close();
						}
					} catch (IOException e) {
						logger.error(e,e);
					}
				}
				
			}
			sb.append("导入数据完成！");
			sb.append("\n共计" + all + "条数据，插入" + insert + "条数据，更新" + update + "条数据，错误" + error + "条数据。");
			sb.append(sberror.toString());
			result.put("state", "ok");
			result.put("msg", sb.toString());
		} catch (Exception e) {
			logger.error(e,e);
			result.put("state", "fail");
			result.put("msg", "");
		}
		JSONObject jo = JSONObject.fromObject(result);
		return jo.toString();
	}

}
