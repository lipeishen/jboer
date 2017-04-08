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
.calendar-dtable td{height:14px;padding-left：0px;}
.calendar-dtable th{height:14px;padding-left：0px;}
.datebox-button td{height:14px;padding-left：0px;}
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
		url:"<%=path%>/production/commodity/getProductionList.do",
		title:"",iconCls:"icon-save",pagination:"true",
		pagePosition:"bottom",pageNumber:1,pageSize:10,pageList:[10,20],striped:"true",fitColumns:"true",nowrap:true,singleSelect:"true",
		rownumbers:true,border:true,idField:"id",height:435,
		columns:[ [
 			{title:"商品名称",field:"production_name",width:"15%",align:"center"},
			{title:"商品类型",field:"production_type",width:"15%",align:"center",
				formatter:function(value, rowData,rowIndex) {
					var retrunValue ="";
					if(value == "0"){
						retrunValue = "蔬菜类";
					}else if(value == "1"){
						retrunValue = "水果类";
					}else if(value == "2"){
						retrunValue = "肉类";
					}else if(value == "3"){
						retrunValue = "奶制品";
					}else if(value == "4"){
						retrunValue = "蛋类";
					}
					return retrunValue;
				}},
			{title:"剩余库存",field:"production_stock_remain",width:"10%",align:"center"},
			{title:"是否自有",field:"production_isself",width:"10%",align:"center",
				formatter:function(value, rowData,rowIndex) {
					var retrunValue ="";
					if(value == "1"){
						retrunValue = "是";
					}else if(value == "0"){
						retrunValue = "否";
					}
					return retrunValue;
				}},
			{title:"商品价格",field:"production_price",width:"10%",align:"center"},
			{title:"是否促销",field:"production_issale",width:"10%",align:"center",
				formatter:function(value, rowData,rowIndex) {
					var retrunValue ="";
					if(value == "1"){
						retrunValue = "是";
					}else if(value == "0"){
						retrunValue = "否";
					}
					return retrunValue;
				}},
			{title:"商品来源",field:"production_source",width:"15%",align:"center",
				formatter:function(value, rowData,rowIndex) {
					var retrunValue ="";
					if(value == "1"){
						retrunValue = "彩虹";
					}else{
						retrunValue = "其他供应商";
					}
					return retrunValue;
				}},
			{title:"操作",field:"productionId",width:"15%",align:"center",
			} 
		] ]
	});
});
var queryproductList = function(){
	var productionName=$('#production_name').val();
	var productionType=$('#production_type').val();
	var productionIsself=$('#production_isself').val();
	var productionIssale=$('#production_issale').val();
	var productionSource=$('#production_source').val();
	$('#datagrid').datagrid('load',{
		proname :productionName,
		protype:productionType,
		isself:productionIsself,
		resouce:productionSource,
		issale:productionIssale
		
	});
}

var clearAll = function(){
	$('#production_name').val("");
	$('#production_type').val("");
	$('#production_isself').val("");
	$('#production_issale').val("");
	$('#production_source').val("");
}
var toImportProduct=function(){
	window.location.href="<%=path%>/production/commodity/toProductImport.do?modularId=${modularId}";
}
var editDurationRecord = function(durationRecordId,center_name,examination_date,duration_name,duration_cur_capacity){
	window.location.href="<%=path%>/examManage/examSchedule/toEditDurationRecord.do?durationRecordId="+durationRecordId+"&center_name="+center_name+"&examination_date="+examination_date+"&duration_name="+duration_name+"&duration_cur_capacity="+duration_cur_capacity+"&modularId=${modularId}";
}
</script>
<meta charset="utf-8">
<title>销售商品信息管理</title>
</head>
<body>
  <div  id="div" class="biaodan-content">
	<div style="border:1px solid #ccccce;margin-bottom:10px;" >
	<div class="biaodan-content-nav" onclick="openOrOff(this)"><span class="nav-span-left" >商品信息查询区</span></div>
	<div class="biaodan-content-List" style="heigh:40px;line-height:40px;font-size:20px;font-weight:bold;text-align:center;margin-bottom:20px;">
		<table style="width: 100%;margin-bottom:10px;">
		<tr>
			<td style="font-size: 12px;width:30%;text-align:center;">
				<span style="height:30px;vertical-align:middle;font-weight:bold;width:40%;text-align:right">商品名称:</span> 
				<input id="production_name" class="abc input-default" name="productionName" style="width: 50%;height:30px"/ panelHeight="auto">
			</td>
			<td style="font-size: 12px;width: 30%;text-align:center;">
				<span style="height:30px;vertical-align:middle;font-weight:bold;width:40%;text-align:right">商品类型:</span> 
				<select class="easyui-select" name="productionType" id="production_type"  style="width: 50%;height:35px;background:#fff ">
						<option value="">未选择</option>
						<option value="0">水果类</option>
						<option value="1">蔬菜类 </option>
						<option value="2">奶制品</option>
						<option value="3">生鲜类</option>
						<option value="4">肉类</option>
				</select>
			</td>
			<td style="font-size: 12px;width: 30%;text-align:center;">
				<span style="height:30px;vertical-align:middle;font-weight:bold;width:40%;text-align:right">是否自有:</span> 
				<select class="easyui-select" name="productionIsself" id="production_isself"  style="width: 50%;height:35px;background:#fff ">
						<option value="">未选择</option>
						<option value="0">否</option>
						<option value="1">是 </option>
				</select>
			</td>
		</tr>
		<tr>
		<td style="font-size: 12px;width: 30%;text-align:center;">
				<span style="height:30px;vertical-align:middle;font-weight:bold;width:40%;text-align:right">商品来源:</span> 
				<select class="easyui-select" name="productionSource" id="production_source"  style="width: 50%;height:35px;background:#fff ">
						<option value="">未选择</option>
						<option value="1">供应商</option>
						<option value="0">自有</option>
				</select>
			</td>
		<!--  <td style="font-size: 12px;width:30%;text-align:center" class="date">
				<span style="height:30px;vertical-align:middle;font-weight:bold;width:40%;text-align:right">生产日期:</span> 
				<input id="production_createTime"  style="width: 50%;height:33px"  name="productionCreateTime" type="text" data-options="required:false,showSeconds:false,editable:false" class="easyui-datebox" panelHeight="auto"></input>
			</td>
			<td style="font-size: 12px;width:30%;text-align:center" class="date">
				<span style="height:30px;vertical-align:middle;font-weight:bold;width:40%;text-align:right">失效日期:</span> 
				<input id="production_invalidTime"  style="width: 50%;height:33px"  name="productionInvalidTime" type="text" data-options="required:false,showSeconds:false,editable:false" class="easyui-datebox" panelHeight="auto"></input>
			</td> -->
			<td style="font-size: 12px;width: 30%;text-align:center;">
				<span style="height:30px;vertical-align:middle;font-weight:bold;width:40%;text-align:right">是否促销:</span> 
				<select class="easyui-select" name="productionIssale" id="production_issale"  style="width: 50%;height:35px;background:#fff ">
						<option value="">未选择</option>
						<option value="0">否</option>
						<option value="1">是 </option>
				</select>
			</td>
			
		</tr>
		<tr>
				<td style="font-size: 12px;width: 30%;text-align:center;" colspan="3">
				<a href="javascript:void(0)" class="standard-button" onclick="queryproductList()">查询</a>
				<a href="javascript:void(0)" class="standard-button" onclick="clearAll()">重置</a>
				
			</td>
		</tr>
	</table>
 	</div>
 	</div>
	<div style="border:1px solid #ccccce;">
	<div class="biaodan-content-nav" onclick="openOrOff(this)"><span class="nav-span-left">功能及列表区</span></div>
	<div class="biaodan-content-List">
		<table style="width: 100%;margin-bottom:10px;">
			<tr>
				<td style="font-size: 12px;width: 30%;text-align:right;" colspan="2">
					<a href="javascript:void(0)"   class="standard-button"  onclick="toImportProduct()" >批量导入商品</a>
				</td>
			</tr>
		</table>
	<table id="datagrid" style="height: 100%;"></table>
	</div>
	</div>
</div>
</body>
</html>