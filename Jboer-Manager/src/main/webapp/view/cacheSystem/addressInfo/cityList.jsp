﻿<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE HTML>
<html>
<head>
<link href="<%=path%>/static/css/base.css" rel="stylesheet" />
<link href="<%=path%>/static/js/jquery-easyui-1/themes/icon.css" rel="stylesheet" />
<link href="<%=path%>/static/js/jquery-easyui-1/themes/default/easyui.css" rel="stylesheet" />

<script type="text/javascript" src="<%=path%>/static/js/jquery-2.2.0.min.js"></script>
<script type="text/javascript" src="<%=path%>/static/js/jquery-easyui-1/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=path%>/static/js/jquery-easyui-1/locale/easyui-lang-zh_CN.js"></script>
<style>
* {font-family: '微软雅黑';font-size: 14px;margin: 0;padding: 0;}
td {height: 30px;color: #505052;padding-left：10px;}
td {height: 40px;}
input {height: 30px;width: 70%;background: #ededef;border: 1px solid #cbcbcd;color: #666;line-height: 28px;font-size: 14px;}
select {height: 30px;width: 70%;background: #ededef;border: 1px solid #cbcbcd;color: #666;font-size: 14px;}
img {vertical-align: middle;}
</style>
<script type="text/javascript">
var openOrOff = function(obj){
	if($(obj).attr("class") == "biaodan-content-nav-active"){
		$(obj).removeClass("biaodan-content-nav-active").addClass('biaodan-content-nav');
		$(obj).next().show(100);
	}else{
		$(obj).removeClass("biaodan-content-nav").addClass('biaodan-content-nav-active');
		$(obj).next().hide(100);
	}
}

$(document).ready(function(){
	$.ajaxSetup({
		//关闭AJAX相应的缓存
		cache:false
	});
	$("#datagrid").datagrid({
		method:"post",
		url:"<%=path%>/cacheSystem/city/getListInCityList.do",
		title:"",iconCls:"icon-save",pagination:"true",
		pagePosition:"bottom",pageNumber:1,pageSize:10,pageList:[10,20],striped:"true",fitColumns:"true",nowrap:"true",singleSelect:"true",
		rownumbers:"true",border:"true",idField:"id",height:400,
		columns:[[
			{title:"市编码",field:"city_code",width:"45%",align:"center"},
			{title:"市名称",field:"city_name",width:"53%",align:"center"}
		]]
	});
});

var refreshCityCache = function(){
	$("#datagrid").datagrid({
		method:"post",
		url:"<%=path%>/cacheSystem/city/refreshCityCache.do",
		title:"",iconCls:"icon-save",pagination:"true",
		pagePosition:"bottom",pageNumber:1,pageSize:10,pageList:[10,20],striped:"true",fitColumns:"true",nowrap:"true",singleSelect:"true",
		rownumbers:"true",border:"true",idField:"id",height:400,
		columns:[[
			{title:"市编码",field:"city_code",width:"45%",align:"center"},
			{title:"市名称",field:"city_name",width:"53%",align:"center"}
		]]
	});
}
</script>
<meta charset="utf-8">
<title>市缓存管理</title>
</head>
<body>
<div id="div" class="biaodan-content" >
	<div style="border:1px solid #ccccce;margin-bottom:10px;" >
	<div class="biaodan-content-nav" onclick="openOrOff(this)"><span class="nav-span-left" >列表及功能区</span></div>
	<div class="biaodan-content-List">
	<table style="width: 100%;margin-bottom:10px;">
		<tr>
			<td style="font-size: 12px;width: 30%;text-align:center;" colspan="2">
				<a href="javascript:void(0)" style="float:right;margin-right:10px;" class="standard-button" onclick="refreshCityCache()">刷新缓存</a>
			</td>
		</tr>
	</table>
	<table id="datagrid" style="height: 100%;"></table>
	</div>
	</div>
</div>
</body>
</html>