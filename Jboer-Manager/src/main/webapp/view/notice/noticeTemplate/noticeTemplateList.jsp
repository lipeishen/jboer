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
		url:"<%=path%>/notice/noticeTemplate/getNoticeTemplateList.do",
		title:"",iconCls:"icon-save",pagination:"true",
		pagePosition:"bottom",pageNumber:1,pageSize:10,pageList:[10,20],striped:"true",fitColumns:"true",nowrap:"true",singleSelect:"true",
		rownumbers:"true",border:"true",idField:"id",height:400,
		columns:[ [
			{title:"通知模板编码",field:"noticeTempCode",width:"40%",align:"center"},
			{title:"通知模板内容",field:"noticeTempContent",width:"40%",align:"center"},
			{title:"操作",field:"operation",width:"19%",align:"center",
				formatter:function(value, rowData,rowIndex) {
					var noticeTempCode = "\""+rowData.noticeTempCode+"\"";
					var noticeTempContent = "\""+rowData.noticeTempContent+"\"";
					var editNoticeTemplate = "<a href='javascript:void(0)' onclick='editNoticeTemplate("+noticeTempCode+")'>编辑</a>"; 
					var delNoticeTemplate = "<a href='javascript:void(0)' onclick='delNoticeTemplate("+noticeTempCode+")'>删除</a>"; 
					return editNoticeTemplate+"&nbsp;"+delNoticeTemplate;
				}
			} 
		] ]
	});
});

var clearAll = function(){
	$('input[name="tempContent"]').val("");
}

var queryNoticeTemplateList = function(){
	var tempContent=$.trim($("#tempContent").val());
	$('#datagrid').datagrid('load',{  
		tempContent:tempContent
		
	});
}

//编辑
function editNoticeTemplate(noticeTempCode){
	if(noticeTempCode != ""){ 
		$("#dlg").dialog({top : "10px",});
		$("#dlg").dialog('open').dialog('setTitle','编辑模板');
		$.post('<%=path%>/notice/noticeTemplate/editNoticeTemplate.do?noticeTempCode=' + noticeTempCode,
			function(result) {
				if (result.success) {
					$("#notice_temp_code").val(result.data.noticeTempCode);
					$("#notice_temp_content").val(result.data.noticeTempContent);
					$("#notice_temp_code").attr("readonly","readonly");
				} else {
					$.messager.alert("系统提示", result.errorMsg);
				}
			}, 'json');
	}
}

//删除模板
function delNoticeTemplate(noticeTempCode){
	if(noticeTempCode != ""){ 
		$.messager.confirm("系统提示","您确定要删除这条记录吗?",function(r){
			if(r){
				$.post('<%=path%>/notice/noticeTemplate/delNoticeTemplate.do?noticeTempCode='+noticeTempCode,function(result){
					if(result.success){
						$.messager.alert("系统提示","操作成功！");
						queryNoticeTemplateList();
					}else{
						$.messager.alert("系统提示",result.errorMsg);
					}
				},'json');
			}
		});
	}
}

function newNoticeTemplate(){
	$("#dlg").dialog('open').dialog('setTitle','新增通知模板');
	$('#fm').form('clear');
}

//新增模板
function saveNoticeTemplate(e){
	var noticeTempCode=$("#notice_temp_code").val();
	var noticeTempContent=$("#notice_temp_content").val();
	if(noticeTempCode==""){
		$.messager.alert("系统提示","模板编码不能为空！");
		return false;
	}
	if (!/(?=^.{6,32}$)(?=.*[0-9])(?=.*[a-zA-Z])(?!.*\s)[0-9a-zA-Z_]*$/
			.test(noticeTempCode)){
		$.messager.alert("系统提示","模板编码由6-32位字母、数字和下划线组成！");
		return false;
	}
	if(noticeTempCode.length>32){
		$.messager.alert("系统提示","模板编码不能超过32个字符！");
		return false;
	}
	if(noticeTempContent==""){
		$.messager.alert("系统提示","模板内容不能为空！");
		return false;
	}
	if(noticeTempContent.length>500){
		$.messager.alert("系统提示","模板内容不能超过500个字符！");
		return false;
	}
	$.ajax({
		 url:"<%=path%>/notice/noticeTemplate/saveNoticeTemplate.do", 
		 dataType:"json",
		 async:false,
		 data:{
			 "noticeTempCode":noticeTempCode,
			 "noticeTempContent":noticeTempContent
		 },
		 type:"POST",
	     success:function(data){
	    	 if(data.errorMsg){
					$.messager.alert("系统提示",data.errorMsg);
					return;
				}else{
					$.messager.alert("系统提示","保存成功!");
					$('#dlg').dialog('close');
					queryNoticeTemplateList();
				}
	     },
	     error:function(){
			$('#saveButton').attr("onclick","saveExamDuration(this)");
			$.messager.alert("系统提示","保存失败");
	     }
	});		
}
</script>
<meta charset="utf-8">
<title>模板管理</title>
</head>
<body>
	<div id="div" class="biaodan-content" >
		<div style="border:1px solid #ccccce;margin-bottom:10px;" >
			<div class="biaodan-content-nav" onclick="openOrOff(this)"><span class="nav-span-left" >模板查询区</span></div>
			<div class="biaodan-content-List">
				<table style="width: 100%;margin-bottom:10px;">
					<tr>
						<td style="font-size: 12px;width: 30%;text-align:center;">
							<span style="height:30px;vertical-align:middle;font-weight:bold;width:40%;text-align:right">模板内容:</span> 
							<input id=tempContent name="tempContent" style="width: 45%;" />
						</td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td style="font-size: 12px;width: 70%;height:80px;text-align:center;" colspan="3">
							<a href="javascript:void(0)"  style="text-align:center;" class="standard-button" id="select" onclick="queryNoticeTemplateList()" >查询</a>
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
				<a href="javascript:void(0)" style="float:right;margin-right:10px;" class="standard-button" onclick="newNoticeTemplate()">新增模板</a>
			</td>
		</tr>
	</table>
		<table id="datagrid" style="height: 100%;"></table>
		</div>
		</div>
		<div id="dlg" class="easyui-dialog" style="width: 600px; padding: 10px 8px" closed="true" buttons="#dlg-buttons">
			<form id="fm" method="post">
				<table cellspacing="10px;">
					<tr>
						<td>模板编码:</td>
						<td><input type="text" name="notice_temp_code" id="notice_temp_code"  class="easyui-validatebox" 
						data-options="required:true,validType:['length[0,32]']" style="width: 400px;"></td>
					</tr>
					<tr>
						<td>模板内容:</td>
						<td>
							<textarea rows="5" cols="2" name="notice_temp_content" id="notice_temp_content" style="width: 400px;" 
							class="easyui-validatebox" data-options="required:true,validType:['length[0,500]']"></textarea>
						</td>
					</tr>
				</table>
			</form>
		</div>
		<div id="dlg-buttons">
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveNoticeTemplate(this)">保存</a> 
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">关闭</a>
		</div>
	</div>
</body>
</html>