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
		url:"<%=path%>/cacheSystem/servMainInfo/getListInservMainList.do",
		title:"",iconCls:"icon-save",pagination:"true",
		pagePosition:"bottom",pageNumber:1,pageSize:10,pageList:[10,20],striped:"true",fitColumns:"true",nowrap:"true",singleSelect:"true",
		rownumbers:"true",border:"true",idField:"id",height:400,
		columns:[ [
			{title:"服务名称",field:"serviceName",width:"10%",align:"center"},
			{title:"服务路径",field:"serviceUrl",width:"10%",align:"center"},
			{title:"服务图片路径",field:"servicePicUrl",width:"24%",align:"center"},
			{title:"服务状态",field:"serviceStatus",width:"8%",align:"center",
				formatter:function(value,rowData,rowIndex) {
					var retrunValue ="";
					if(value == "1"){
						retrunValue = "草稿";
					}else if(value == "2"){
						retrunValue = "待审核";
					}else if(value == "3"){
						retrunValue = "待上架";
					}else if(value == "4"){
						retrunValue = "已上架";
					}else if(value == "5"){
						retrunValue = "已下架";
					}
					return retrunValue;
				}
			},
			{title:"服务类型·",field:"serviceType",width:"8%",align:"center",
				formatter:function(value, rowData,rowIndex) {
					var retrunValue ="";
					if(value == "1"){
						retrunValue = "免费服务";
					}else if(value == "2"){
						retrunValue = "付费服务";
					}
					return retrunValue;
				}
			},
			{title:"服务栏目",field:"serviceCategory",width:"10%",align:"center",
				formatter:function(value, rowData,rowIndex) {
					var retrunValue ="";
					if(value == "1"){
						retrunValue = "咨询";
					}else if(value == "2"){
						retrunValue = "就医服务";
					}else if(value == "3"){
						retrunValue = "健康管理";
					}else if(value == "4"){
						retrunValue = "推广员服务";
					}
					return retrunValue;
				}
			},
			{title:"服务登录要求·",field:"isNeedLogin",width:"10%",align:"center",
				formatter:function(value, rowData,rowIndex) {
					var retrunValue ="";
					if(value == "1"){
						retrunValue = "需要登录";
					}else if(value == "0"){
						retrunValue = "无需登录";
					}
					return retrunValue;
				}
			},
			{title:"服务用户信息要求·",field:"isNeedPersonal",width:"10%",align:"center",
				formatter:function(value, rowData,rowIndex) {
					var retrunValue ="";
					if(value == "1"){
						retrunValue = "需要进行实名认证";
					}else if(value == "0"){
						retrunValue = "无需进行实名认证";
					}
					return retrunValue;
				}
			},
			{title:"操作",field:"serviceId",width:"9%",align:"center",
				formatter:function(value, rowData,rowIndex) {
					var htmlDelete = "<a href='javascript:void(0)' onclick='deleteCache(\""+value+"\")'>删除</a>";
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
	window.top.showWaitingDiv();
	$.ajax({
		type:"post",
		data:{},
		url:"<%=path%>/cacheSystem/servMainInfo/toFlushServMainCache.do",
		success:function(data) {
			window.top.closeWaitingDiv();
			$('#datagrid').datagrid('load',{});
			
		}
	})
}

var deleteCache = function(serviceId){
	$.ajax({
		type:"post",
		data:{"serviceId":serviceId},
		url:"<%=path%>/cacheSystem/servMainInfo/toDeleteOneServMainCache.do",
		success:function(data) {
			$('#datagrid').datagrid('load',{});
		}
	})
}
</script>
<meta charset="utf-8">
<title>服务缓存管理</title>
</head>
<body>
<div id="div" class="biaodan-content" >
	<div style="border:1px solid #ccccce;margin-bottom:10px;" >
	<div class="biaodan-content-nav" onclick="openOrOff(this)"><span class="nav-span-left" >列表及功能区</span></div>
	<div class="biaodan-content-List">
	<table style="width: 100%;margin-bottom:10px;">
		<tr>
			<td style="font-size: 12px;width: 30%;text-align:center;" colspan="2">
				<a href="javascript:void(0)" style="float:right;margin-right:10px;" class="standard-button" onclick="flushCache()">刷新缓存</a>
				<a href="javascript:void(0)" style="float:right;margin-right:10px;" class="standard-button" onclick="flushList()">刷新列表</a>
			</td>
		</tr>
	</table>
	<table id="datagrid" style="height: 100%;"></table>
	</div>
	</div>
</div>
</body>
</html>