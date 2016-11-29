package com.dcits.djk.manager.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.xml.parsers.ParserConfigurationException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.xml.sax.SAXException;
@SuppressWarnings("unchecked")
public class XmlParseUtil {
	public static void main(String[] args) throws ParserConfigurationException,
			SAXException, IOException {
		String xml1 = "<?xml version='1.0' encoding='UTF-8'?> "
				+"<ROOT>"
         		+ "<CLINIC>"
         		+ "<CLINIC_DATE> 2016-03-31 10:35:00</CLINIC_DATE>"
         		+ "<CLINIC_ORG>江门江华家庭医生诊所</CLINIC_ORG>"
         		+ "<CLINIC_DEP>全科</CLINIC_DEP>"
         		+ "<DOCTOR_NAME>张辉明</DOCTOR_NAME>"
         		+ "<DIAGNOSIS>骨质疏松症</DIAGNOSIS>"
         		+ "<DOCTOR></DOCTOR>"
	         		+ "<ITEM>"
	         		+ "<NAME>碳酸钙3咀嚼片</NAME>"
	         		+ "<FREQUENCY>1次/天</FREQUENCY>"
	         		+ "</ITEM>"
	         		+ "<ITEM>"
	         		+ "<NAME>金钙尔奇</NAME>"
	         		+ "<FREQUENCY> 3次/天</FREQUENCY>"
	         		+ "</ITEM>"
         		+ "</CLINIC>"
         		+ "<CLINIC>"
         		+ "<CLINIC_DATE> 2016-03-31 10:35:00</CLINIC_DATE>"
         		+ "<CLINIC_ORG>江门江华家庭医生诊所</CLINIC_ORG>"
         		+ "<CLINIC_DEP>全科</CLINIC_DEP>"
         		+ "<DOCTOR_NAME>张辉明</DOCTOR_NAME>"
         		+ " <DIAGNOSIS>骨质疏松症</DIAGNOSIS>"
         		+ " <DOCTOR></DOCTOR>"
	         		+ " <ITEM>"
	         		+ "<NAME>碳酸钙3咀嚼片</NAME>"
	         		+ "<FREQUENCY> 1次/天</FREQUENCY>"
	         		+ " </ITEM>"
	         		+ " <ITEM>"
	         		+ "<NAME>金钙尔奇</NAME>"
	         		+ "<FREQUENCY> 3次/天</FREQUENCY>"
	         		+ "</ITEM>"
         		+ "</CLINIC>"
         		+ "</ROOT>";
		Set<Map<String,String>> list = XmlParseUtil.parseToMap(xml1);
		for(Map<String,String> map : list){
			Iterator<String> iter = map.keySet().iterator();
			String key;
			String value;
			while (iter.hasNext()) {
			    key = iter.next();
			    System.out.println(key);
			    value = (String) map.get(key);
			    System.out.println(value);
			}
		}
		
	}

	public static void getNodes(Element node) {
		// 递归遍历当前节点所有的子节点
		List<Element> listElement = node.elements();// 所有一级子节点的list
		for (Element e : listElement) {// 遍历所有一级子节点
			XmlParseUtil.getNodes(e);// 递归
		}
		System.out.println("当前节点名称：" + node.getName());// 当前节点名称
		System.out.println("当前节点的内容：" + node.getTextTrim());// 当前节点名称
	}
	
	
	/**
	 * 
	 * @param xml
	 * @return
	 */
	public static Set<Map<String,String>> parseToMap(String xml){
		Document doc = null;
		Set<Map<String,String>> list = new HashSet<Map<String,String>>();
		try {
			doc = DocumentHelper.parseText(xml);
			Element rootElement = doc.getRootElement();
			List<Element> listElement = rootElement.elements();
			for (Element element : listElement) {
				List<Element> elements = element.elements();
				Map<String,String> map = new HashMap<String,String>();
				for (Element elem : elements) {
					map.put(elem.getName(), elem.getText());
				}
				list.add(map);
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
}
