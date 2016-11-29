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
	$('#noticeStatus').combobox('setValue', '');
	$("#datagrid").datagrid({
		method:"post",
		url:"<%=path%>/monitor/serviceMonitor/getserviceMonitorList.do",
		title:"",iconCls:"icon-save",pagination:"true",
		pagePosition:"bottom",pageNumber:1,pageSize:10,pageList:[10,20],striped:"true",fitColumns:"true",nowrap:"true",singleSelect:"true",
		rownumbers:"true",border:"true",idField:"id",height:400,
		columns:[ [
			{title:"服务名称",field:"serviceName",width:"40%",align:"center"},
			{title:"服务地址",field:"serviceUrl",width:"40%",align:"center"},
			{title:"操作",field:"id",width:"20%",align:"center",
				formatter:function(value, rowData,rowIndex) {
					var htmlEdit = "<a href='javascript:void(0)' onclick='editMonitor(\""+rowData.serviceNodeId+"\")'>编辑</a>";
					var htmlDelete = "<a href='javascript:void(0)' onclick='deleteMonitor(\""+rowData.serviceNodeId+"\")'>删除</a>";
					return htmlEdit + "&nbsp" + htmlDelete;
				}
			} 
		] ]
	});
});

var clearAll = function(){
	$('input[name="service_name"]').val("");
}

var queryMonitorList = function(){
	var servicename=$.trim($("#service_name").val());
	$('#datagrid').datagrid('load',{  
		serviceName:servicename
		
	});
}

function editMonitor(serviceNodeId){
	if(serviceNodeId != ""){ 
		$('#fm').form('clear');
		$("#dlg").dialog({top : "10px",});
		$("#dlg").dialog('open').dialog('setTitle','编辑服务');
		$.post('<%=path%>/monitor/editServiceMonitor.do?serviceId=' + serviceNodeId,
					function(result) {
						if (result.success) {
							$('#fm').form('load', result.data);
						} else {
							$.messager.alert("系统提示", result.errorMsg);
						}
					}, 'json');
		}
	}
function deleteMonitor(serviceNodeId){
	if(serviceNodeId != ""){ 
		$.messager.confirm("系统提示","您确定要删除这条记录吗?",function(r){
			if(r){
				$.post('<%=path%>/monitor/deleteServiceMonitor.do?serviceId='+serviceNodeId,
				function(result){
					if(result.errorMsg){
						$.messager.alert("系统提示",result.errorMsg);
						return;
					}else if(result.code=="01"){
						$.messager.show({
						title:'系统提示',
						msg:result.msg,
						timeout:2000,
						showType:'show'
					});
						$("#datagrid").datagrid("reload");
					}else{
						$.messager.alert("系统提示",result.msg);
					}
				},'json');
			}
		});
	}
}

function newMonitor(){
	$("#dlg").dialog('open').dialog('setTitle','新增服务');
	$('#fm').form('clear');
}

function saveMonitor(){
	$('#fm').form('submit',{
		url:"<%=path%>/monitor/saveService.do",
		onSubmit:function(){
			var valid=$(this).form('validate');
			if(valid==false){
				return false;
			}
			var serviceName=$("#servname_id").val();
			var serviceUrl=$("#servurl_id").val();
			var seviceId=$("#serviceNodeId").val();
			if(serviceName==""){
				$.messager.alert("系统提示","服务名称不能为空！");
				return false;
			}
			if(serviceUrl==""){
				$.messager.alert("系统提示","服务地址不能为空！");
				return false;
			}
			var bol=false;
				$.ajax({
		            type: "post",
		            url: "<%=path%>/monitor/searchRepeatService.do",
		            data: {serviceName: serviceName,serviceNodeId:seviceId},
		            dataType: "json",
		            async:false,
		            success: function (data) {
		            	if(data.total=="0"){
		            		bol= true;
						}else{
							alert("不能输入重复服务名称")
							bol= false;
						}
		            },
		            error: function (xhr, type) {
		            	alert("查询后台数据错误")
		            }
		        });
			
			return  bol;
		},
		success:function(result){
			var result=eval('('+result+')');
			if(result.errorMsg){
				$.messager.alert("系统提示",result.errorMsg);
				return;
			}else if(result.msg){
			   	$.messager.alert("系统提示","保存成功");
				$('#dlg').dialog('close');
				queryMonitorList();
			}else{
				$.messager.alert("系统提示","保存失败！");
				return;
			}
		},
		error:function(result){
			$.messager.alert("系统提示","保存失败");
		}
	});
	}
</script>
<meta charset="utf-8">
<title>通知管理</title>
</head>
<body>
	<div id="div" class="biaodan-content" >
		<div style="border:1px solid #ccccce;margin-bottom:10px;" >
			<div class="biaodan-content-nav" onclick="openOrOff(this)"><span class="nav-span-left" >文章拟稿查询区</span></div>
			<div class="biaodan-content-List">
				<table style="width: 100%;margin-bottom:10px;">
					<tr>
						<td style="font-size: 12px;width: 30%;text-align:center;">
							<span style="height:30px;vertical-align:middle;font-weight:bold;width:40%;text-align:right">通知来源:</span> 
							<input id="noticeSource" name="noticeSource" style="width: 45%;" />
						</td>
						<td style="font-size: 12px;width: 30%;text-align:center;">
							<span style="height:30px;vertical-align:middle;font-weight:bold;width:40%;text-align:right">通知状态:</span> 
								<select class="easyui-combobox" name="noticeStatus" id="noticeStatus" data-options="editable:false"  style="width: 50%;height:35px" panelHeight="auto">
									<option value="0">未读取</option>
									<option value="1">已读取</option>
								</select>
						</td>
						<td></td>
					</tr>
					<tr>
						<td style="font-size: 12px;width: 70%;height:80px;text-align:center;" colspan="3">
							<a href="javascript:void(0)"  style="text-align:center;" class="standard-button" id="select" onclick="queryMonitorList()" >查询</a>
							<a href="javascript:void(0)"  style="text-align:center;" class="standard-button" id="select" onclick="clearAll()" >重置</a>
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
				<a href="javascript:void(0)" style="float:right;margin-right:10px;" class="standard-button" onclick="newMonitor()">新增通知</a>
			</td>
		</tr>
	</table>
		<table id="datagrid" style="height: 100%;"></table>
		</div>
		</div>
		<div id="dlg" class="easyui-dialog" style="width: 600px; padding: 10px 8px" closed="true" buttons="#dlg-buttons">
			<form id="fm" method="post">
				<input type="hidden" name="serviceNodeId" id="serviceNodeId">
				<table cellspacing="10px;">
					<tr>
						<td style="font-size: 12px; width: 30%; text-align: center;">
							<span style="height: 30px; vertical-align: middle; font-weight: bold; width: 40%; text-align: right">通知类型:</span>
							<select class="easyui-combobox" name="notice_type" id="notice_type" data-options="editable:false"  style="width: 50%;height:35px" panelHeight="auto">
								<option value="1">系统类</option>
								<option value="2">服务类</option>
								<option value="3">其他</option>
							</select>
						</td>
					</tr>
					<tr>
						<td style="font-size: 12px; width: 30%; text-align: center;">
							<span style="height: 30px; vertical-align: middle; font-weight: bold; width: 40%; text-align: right">通知来源:</span>
							<input id="notice_source" name="notice_source" data-options="required:true" maxlength="200" style="width: 50%;"/>
						</td>
					</tr>
					<tr>
						<td style="font-size: 12px; width: 30%; text-align: center;">
							<span style="height: 30px; vertical-align: middle; font-weight: bold; width: 40%; text-align: right">通知目标:</span>
							<input id="notice_target" name="notice_target" data-options="required:true" maxlength="200" style="width: 50%;"/>
						</td>
					</tr>
					<tr>
						<td style="font-size: 12px; width: 30%; text-align: center;">
							<span style="height: 30px; vertical-align: middle; font-weight: bold; width: 40%; text-align: right">通知内容:</span>
							<textarea rows="6" cols="" id="notice_content" name="notice_content" class="easyui-validatebox" style="width: 50%;"
								data-options="validType:['length[0,1000]']"></textarea>
						</td>
					</tr>
				</table>
			</form>
		</div>
		<div id="dlg-buttons">
			<a href="javascript:void(0)" class="easyui-linkbutton"
				iconCls="icon-ok" onclick="saveMonitor()">保存</a> <a
				href="javascript:void(0)" class="easyui-linkbutton"
				iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">关闭</a>
		</div>
	</div>
</body>
</html>