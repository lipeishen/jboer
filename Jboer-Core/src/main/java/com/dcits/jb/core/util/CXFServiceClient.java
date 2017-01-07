package com.dcits.jb.core.util;

import javax.xml.namespace.QName;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

public class CXFServiceClient {
/*	static String serviceUrl;
	static String nameSpace;
	 static{
		 serviceUrl=PropertyUtil.getPropertyManager("CxfServiceClient").getProperty("serviceUrl");
		 nameSpace=PropertyUtil.getPropertyManager("CxfServiceClient").getProperty("nameSpace");
	 }*/
	 //接口调用
	public static Object getMethInfo(String xmlStr,String method,String serviceUrl,String nameSpace) throws Exception {
		JaxWsDynamicClientFactory jcf = JaxWsDynamicClientFactory.newInstance();
		Client client = jcf.createClient(serviceUrl);
		 QName name=new QName(nameSpace,method);
		Object[] objArray = client.invoke(name, xmlStr);
		System.out.println(objArray[0]);
		return objArray[0];
	} 
}
