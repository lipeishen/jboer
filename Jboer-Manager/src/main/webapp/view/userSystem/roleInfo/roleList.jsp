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
// 	var modularId = $("#modularId").val();
	$("#datagrid").datagrid({
		method:"post",
		url:"<%=path%>/userSystem/roleInfo/getListInRoleList.do",
		title:"",iconCls:"icon-save",pagination:"true",
		pagePosition:"bottom",pageNumber:1,pageSize:10,pageList:[10,20],striped:"true",fitColumns:"true",nowrap:"true",singleSelect:"true",
		rownumbers:"true",border:"true",idField:"id",height:400,
		columns:[ [
			{title:"角色名称",field:"roleName",width:"30%",align:"center"},
			{title:"描述",field:"comments",width:"40%",align:"center"},
			{title:"操作",field:"roleId",width:"28%",align:"center",
				formatter:function(value, rowData,rowIndex) {
					var id = "\""+rowData.roleId+"\"";
					var htmlEdit = "<a href='javascript:void(0)' onclick='toEditRole("+id+")'>编辑</a>";
					var htmlDelete = "<a href='javascript:void(0)' onclick='deleteRole("+id+")'>删除</a>";
					return htmlEdit + "&nbsp" + htmlDelete;
				}
			} 
		] ]
	});
});


var deleteRole = function(id){
	$.messager.confirm('系统提示', '你确定要删除选中角色吗？', function(r){
		if(r){
			$.ajax({
				 url:"<%=path%>/userSystem/roleInfo/deleteRoleInfo.do",    //请求的url地址
				 dataType:"json",   //返回格式为json
				 async:false,//请求是否异步，默认为异步，这也是ajax重要特性
				 data:{"id":id},    //参数值
				 type:"GET",   //请求方式
			     success:function(data){
			    	 if(data.code == '01'){
			    		 $.messager.alert('系统提示',data.msg,'info');
				    	 $("#datagrid").datagrid("reload");
			    	 }else{
			    		 $.messager.alert('系统提示',data.msg,'warning');
			    	 }
			     },
			     error:function(){
			        //请求出错处理
			     }
			});
		}
	});
}

var toEditRole = function(id){
	window.location.href="<%=path%>/userSystem/roleInfo/toRoleAddOrEdit.do?id="+id+"";
}

var resetRole = function(){
	$("#roleName").val("");
}

var queryRoleList = function(){
	$('#datagrid').datagrid('load',{  
		roleName:$('input[name="roleName"]').val(),
	});
}

var addRole = function(){
	window.location.href="<%=path%>/userSystem/roleInfo/toRoleAddOrEdit.do";
}
</script>
<meta charset="utf-8">
<title>角色信息管理</title>
</head>
<body>
<div id="div" style="width:99%;" class="biaodan-content" >
	<div style="border:1px solid #ccccce;margin-bottom:10px;" >
	<div class="biaodan-content-nav" onclick="openOrOff(this)"><span class="nav-span-left" >角色信息管理查询区</span></div>
	<div class="biaodan-content-List">
	<table style="width: 100%;margin-bottom:10px;">
		<tr>
			<td style="font-size: 12px;width:30%;text-align:center;">
				<span style="height:30px;vertical-align:middle;font-weight:bold;width:40%;text-align:right">角色名称:</span> 
				<input id="roleName" name="roleName" style="width: 50%;" />
			</td>
			<td></td>
			<td></td>
		</tr>
		<tr>
		 <td style="font-size: 12px;width: 30%;text-align:center;" colspan="3">
				<a href="javascript:void(0)" class="standard-button" onclick="queryRoleList()">查询</a>
				<a href="javascript:void(0)" class="standard-button" onclick="resetRole()">重置</a>
			</td>
		</tr>
	</table>
	</div>
	</div>
	<div style="border:1px solid #ccccce;margin-bottom:10px;" >
	<div class="biaodan-content-nav" onclick="openOrOff(this)"><span class="nav-span-left" >功能及列表区</span></div>
	<div class="biaodan-content-List">
	<table style="width: 100%;margin-bottom:10px;">
		<tr>
			<td style="font-size: 12px;width: 70%;text-align:center;">
				<a href="javascript:void(0)" style="float:right;margin-right:10px;" class="standard-button" onclick="addRole()">新增角色</a>
			</td>
		</tr>
	</table>
	<table id="datagrid" style="height: 100%;"></table>
	</div>
	</div>
</div>
</body>
</html>