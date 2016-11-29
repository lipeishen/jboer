<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
td {height: 30px;color: #505052;}
td {height: 40px;}
input {height: 30px;width: 70%;background: #ededef;border: 1px solid #cbcbcd;color: #666;line-height: 28px;font-size: 14px;}
select {height: 30px;width: 70%;background: #ededef;border: 1px solid #cbcbcd;color: #666;font-size: 14px;}
img {vertical-align: middle;}
</style>
<script type="text/javascript">
$(document).ready(function(){
	$.ajaxSetup({
		//关闭AJAX相应的缓存
		cache:false
	});
	$("#datagrid").datagrid({
		method:"post",
		url:"<%=path%>/cacheSystem/routerInfo/getListInRouterList.do",
		title:"",iconCls:"icon-save",pagination:"true",
		pagePosition:"bottom",pageNumber:1,pageSize:10,pageList:[10,20],striped:"true",fitColumns:"true",nowrap:"true",singleSelect:"true",
		rownumbers:"true",border:"true",idField:"id",height:400,
		columns:[ [
			{title:"服务名称",field:"serviceName",width:"15%",align:"center"},
			{title:"服务ip",field:"serviceIp",width:"30%",align:"center"},
			{title:"服务端口",field:"servicePort",width:"15%",align:"center"},
			{title:"服务上下文",field:"serviceContext",width:"30%",align:"center"},
			{title:"操作",field:" ",width:"9%",align:"center",
				formatter:function(value, rowData,rowIndex) {
					var htmlDelete = "<a href='javascript:void(0)' onclick='deleteCache(\""+rowData.serviceName+"\")'>删除</a>";
					return htmlDelete;
				}
			} 
		] ]
	});
});

var flushList = function(){
	$('#datagrid').datagrid('load',{});
}

var flushCache = function(){
	$.ajax({
		type:"post",
		data:{},
		url:"<%=path%>/cacheSystem/routerInfo/toFlustRouterCache.do",
		success:function(data) {
			$('#datagrid').datagrid('load',{});
		}
	})
}

var deleteCache = function(serviceName){
	//alert(serviceName);
	$.ajax({
		type:"post",
		data:{"serviceName":serviceName},
		url:"<%=path%>/cacheSystem/routerInfo/toDeleteOneRouterCache.do",
		success:function(data) {
			$('#datagrid').datagrid('load',{});
		}
	})
}
</script>
<meta charset="utf-8">
<title>路由缓存管理</title>
</head>
<body>
<div id="div" style="width:99%;">
	<div style="heigh:40px;line-height:40px;font-size:20px;font-weight:bold;text-align:center;margin-bottom:20px;">路由缓存管理</div>
	<table style="width: 100%;margin-bottom:10px;">
		<tr>
			<td style="font-size: 12px;width: 70%;text-align:right;">
				<input type="button" value ="刷新列表" id="select" onclick="flushList()" style="border:0;width: 100px;height: 30px;background-color: #1763b0;color: white;font-weight:bold;cursor: pointer;">
				<input type="button" value ="刷新缓存" id="select" onclick="flushCache()" style="border:0;width: 100px;height: 30px;background-color: #1763b0;color: white;font-weight:bold;cursor: pointer;">
			</td>
		</tr>
	</table>
	<table id="datagrid" style="height: 100%;"></table>
</div>
</body>
</html>