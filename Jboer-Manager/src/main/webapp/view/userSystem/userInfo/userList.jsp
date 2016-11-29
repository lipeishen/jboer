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
	var modularId = $("#modularId").val();
	$("#datagrid").datagrid({
		method:"post",
		url:"<%=path%>/userSystem/userInfo/getListInUserList.do?modularId="+ modularId,
		onLoadSuccess: function (data) {  
            if (data.total == 0) {  
                //添加一个新数据行，第一列的值为你需要的提示信息，然后将其他列合并到第一列来，注意修改colspan参数为你columns配置的总列数  
                $(this).datagrid('appendRow', { name: '<div style="text-align:center;color:red">没有相关记录！</div>' }).datagrid('mergeCells', { index: 0, field: 'name', colspan: 8 })  
                //隐藏分页导航条，这个需要熟悉datagrid的html结构，直接用jquery操作DOM对象，easyui datagrid没有提供相关方法隐藏导航条  
                $(this).closest('div.datagrid-wrap').find('div.datagrid-pager').hide();  
            }  
            //如果通过调用reload方法重新加载数据有数据时显示出分页导航容器  
            else $(this).closest('div.datagrid-wrap').find('div.datagrid-pager').show();  
        },
		title:"",iconCls:"icon-save",pagination:"true",
		pagePosition:"bottom",pageNumber:1,pageSize:10,pageList:[10,20],striped:"true",fitColumns:"true",nowrap:"true",singleSelect:"true",
		rownumbers:"true",border:"true",idField:"id",height:400,
		columns:[ [
			{title:"用户名称",field:"name",width:"10%",align:"center"},
			{title:"登录名称",field:"login_name",width:"10%",align:"center"},
			{title:"员工编号",field:"staff_num",width:"10%",align:"center"},
			{title:"邮箱",field:"email",width:"15%",align:"center"},
			{title:"固定电话",field:"phone",width:"10%",align:"center"},
			{title:"手机号",field:"mobile_phone",width:"15%",align:"center"},
			{title:"描述",field:"comments",width:"15%",align:"center"},
			{title:"操作",field:"id",width:"14%",align:"center",
				formatter:function(value, rowData,rowIndex) {
					var userId = "\""+rowData.user_id+"\"";
					var htmlEdit = "<a href='javascript:void(0)' onclick='editUser("+userId+")'>编辑</a>";
					var htmlDelete = "<a href='javascript:void(0)' onclick='deleteUser("+userId+")'>删除</a>";
					var htmlRepass = "<a href='javascript:void(0)' onclick='repassUser("+userId+")'>重置密码</a>";
					return htmlEdit + "&nbsp" + htmlDelete + "&nbsp" + htmlRepass;
				}
			} 
		] ]
	});
});

var clearAll = function(){
	$('input[name="serch_name"]').val("");
	$('input[name="serch_loginName"]').val("");
	$('input[name="serch_staffNum"]').val("");
	$('#serch_orgId').combobox('setValue', '');
}

var queryUserList = function(){
	var orgIds = $('#serch_orgId').combobox('getValues');
	var orgIdss = "";
	for(var i = 0;i < orgIds.length;i++){
		var orgId = orgIds[i];
		if(i == 0){
			orgIdss = orgId;
		}else{
			orgIdss = orgIdss + "," + orgId;
		}
	}
	$('#datagrid').datagrid('load',{  
		orgIds:orgIdss,
		name:$('input[name="serch_name"]').val(),
		loginName:$('input[name="serch_loginName"]').val(),
		staffNum:$('input[name="serch_staffNum"]').val()
	});
}

function deleteUser(userId){
	if(userId != ""){ 
		$.messager.confirm("系统提示","您确定要删除这条记录吗?",function(r){
			if(r){
				$.post('<%=path%>/userSystem/userInfo/deleteUser.do?userId='+userId,function(result){
					if(result.success){
						$.messager.alert("系统提示","已成功删除这条记录!");
						$("#datagrid").datagrid("reload");
					}else{
						$.messager.alert("系统提示",result.errorMsg);
					}
				},'json');
			}
		});
	}
}

function newUser(){
	var modularId = $("#modularId").val();
	window.location.href="<%=path%>/userSystem/userInfo/toUserAddOrEdit.do?modularId="+ modularId;
}


function editUser(userId){
	if(userId != ""){ 
		var modularId = $("#modularId").val();
		window.location.href="<%=path%>/userSystem/userInfo/toUserAddOrEdit.do?userId="+userId+"&modularId="+ modularId;
	}else{
		$.messager.alert("系统提示","请选择需要编辑的用户！");
	}
}

function repassUser(userId){
	if(userId){
		$.messager.confirm("系统提示","您确定要重置该用户的密码吗",function(r){
			if(r){
				$.post('<%=path%>/user/repass.do?userId='+userId,function(result){
					if(result.success){
						$.messager.alert("系统提示","密码重置成功 重置后密码为:pass123");
						$("#datagrid").datagrid("reload");
					}else{
						$.messager.alert("系统提示",result.errorMsg);
					}
				},'json');
			}
		});
	}else{
		$.messager.alert("系统提示","请选择需要重置密码的用户!");
	}
}
</script>
<meta charset="utf-8">
<title>用户信息管理</title>
</head>
<body>
<div id="div" class="biaodan-content"  style="width:99%;">
	<div style="border:1px solid #ccccce;margin-bottom:10px;" >
	<div class="biaodan-content-nav" onclick="openOrOff(this)"><span class="nav-span-left" >用户信息管理查询区</span></div>
	<div class=" biaodan-content-List">
	<table style="width: 100%;margin-bottom:10px;">
		<tr>
			<td style="font-size: 12px;width: 30%;text-align:center;">
				<span style="height:30px;vertical-align:middle;font-weight:bold;width:40%;text-align:right">用户名称:</span> 
				<input id="serch_name" name="serch_name" style="width: 50%;" />
			</td>
			<td style="font-size: 12px;width: 30%;text-align:center;">
				<span style="height:30px;vertical-align:middle;font-weight:bold;width:40%;text-align:right">登录名称:</span> 
				<input id="serch_loginName" name="serch_loginName" style="width: 50%;" />
			</td>
			<td style="font-size: 12px;width: 30%;text-align:center;">
				<span style="height:30px;vertical-align:middle;font-weight:bold;width:40%;text-align:right">员工编号:</span> 
				<input id="serch_staffNum" name="serch_staffNum" style="width: 50%;" />
			</td>
		</tr>
		<tr>
			<td  style="font-size: 12px;width: 30%;text-align:center;">
				<span style="height:30px;vertical-align:middle;font-weight:bold;width:50%;text-align:left">组织机构:</span> 
				<input id="serch_orgId" class="easyui-combobox" name="serch_orgId" data-options="valueField:'org_id',textField:'org_name',url:'<%=path%>/userSystem/common/getOrgs.do?modularId=${modularId}'"  multiple style="width: 50%;height: 30px"/> 
			</td>
			
		</tr>
		<tr>
		<td style="font-size: 12px;width: 70%;height:80px;text-align:center;" colspan="3">
				<a href="javascript:void(0)" class="standard-button" onclick="queryUserList()">查询</a>
				<a href="javascript:void(0)" class="standard-button" onclick="clearAll()">重置</a>
			</td>
		</tr>
	</table>
	</div>
	</div>
	<div style="border:1px solid #ccccce;margin-bottom:10px;" >
	<div class="biaodan-content-nav" onclick="openOrOff(this)"><span class="nav-span-left" >功能及列表区</span></div>
	<div class=" biaodan-content-List">
	<table style="width: 100%;margin-bottom:10px;">
		<tr>
			<td style="font-size: 12px;width: 70%;text-align:center;">
				<a href="javascript:void(0)" style="float:right;margin-right:10px;" class="standard-button" onclick="newUser()">新增用户</a>
			</td>
		</tr>
	</table>
	<table id="datagrid" style="height: 100%;"></table>
	<input type="hidden" name="modularId" id="modularId" value="${modularId}" />
</div>
</div>
</div>
</body>
</html>