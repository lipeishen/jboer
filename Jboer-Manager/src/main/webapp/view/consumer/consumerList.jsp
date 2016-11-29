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
td {height: 30px;color: #505052;padding-left：10px;}
td {height: 40px;}
input {height: 30px;width: 70%;background: #ededef;border: 1px solid #cbcbcd;color: #666;line-height: 28px;font-size: 14px;}
select {height: 30px;width: 70%;background: #ededef;border: 1px solid #cbcbcd;color: #666;font-size: 14px;}
img {vertical-align: middle;}
.table td{
    padding-top: 8px;
    padding-bottom: 4px;
	line-height:20px;
	
}
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
		url:"<%=path%>/consumer/getConsumerList.do",
		title:"",iconCls:"icon-save",pagination:"true",
		pagePosition:"bottom",pageNumber:1,pageSize:10,pageList:[10,20],striped:"true",fitColumns:"true",nowrap:"true",singleSelect:"true",
		rownumbers:"true",border:"true",idField:"id",height:400,
		columns:[ [
			{title:"客户姓",field:"surname",width:"10%",align:"center"},
			{title:"客户名",field:"name",width:"10%",align:"center"},
			{title:"性别",field:"sex",width:"10%",align:"center"},
			{title:"手机号码",field:"mobile_phone",width:"10%",align:"center"},
			{title:"省",field:"province_name",width:"10%",align:"center"},
			{title:"市",field:"city_name",width:"10%",align:"center"},
			{title:"县",field:"country_name",width:"10%",align:"center"},
			{title:"地址",field:"addr_detail",width:"30%",align:"center"}
		] ]
	});
});

var clearAll = function(){
	$('input[name="surname"]').val("");
	$('input[name="name"]').val("");
	$('input[name="mobile_phone"]').val("");
}

var queryConsumerList = function(){
	var surname=$.trim($("#surname").val());
	var name=$.trim($("#name").val());
	var mobilePhone=$.trim($("#mobilePhone").val());
	$('#datagrid').datagrid('load',{  
		surname: surname,
		name : name,
		mobphone : mobilePhone
	});
}


</script>
<meta charset="utf-8">
<title>客户信息管理</title>
</head>
<body>
	<div id="div" class="biaodan-content" >
		<div style="border:1px solid #ccccce;margin-bottom:10px;" >
			<div class="biaodan-content-nav" onclick="openOrOff(this)"><span class="nav-span-left" >客户信息查询区</span></div>
			<div class="biaodan-content-List">
				<table style="width: 100%;margin-bottom:10px;">
					<tr>
						<td style="font-size: 12px;width: 30%;text-align:center;">
							<span style="height:30px;vertical-align:middle;font-weight:bold;width:40%;text-align:right">客户姓:</span> 
							<input id="surname" name="surname" style="width: 45%;" />
						</td>
						<td style="font-size: 12px;width: 30%;text-align:center;">
							<span style="height:30px;vertical-align:middle;font-weight:bold;width:40%;text-align:right">客户名:</span> 
							<input id="name" name="name" style="width: 45%;" />
						</td>
						<td style="font-size: 12px;width: 30%;text-align:center;">
							<span style="height:30px;vertical-align:middle;font-weight:bold;width:40%;text-align:right">手机号码:</span> 
							<input id="mobilePhone" name="mobile_phone" style="width: 45%;" />
						</td>
					</tr>
					<tr>
						<td style="font-size: 12px;width: 70%;height:80px;text-align:center;" colspan="3">
							<a href="javascript:void(0)"  style="text-align:center;" class="standard-button" id="select" onclick="queryConsumerList()" >查询</a>
							<a href="javascript:void(0)"  style="text-align:center;" class="standard-button" id="select" onclick="clearAll()" >重置</a>
						</td>
					</tr>
				</table>
			</div>
		</div>	
	<div style="border:1px solid #ccccce;margin-bottom:10px;" >
	   <div class="biaodan-content-nav" onclick="openOrOff(this)"><span class="nav-span-left" >功能及列表区</span></div>
	   <div class="biaodan-content-List">
		<table id="datagrid" style="height: 100%;"></table>
		</div>
		</div>
	</div>
</body>
</html>