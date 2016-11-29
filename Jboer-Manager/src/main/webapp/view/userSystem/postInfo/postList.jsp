<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE HTML>
<html>
<head>
<link href="<%=path%>/static/css/base.css" rel="stylesheet" />
<link href="<%=path%>/static/js/jquery-easyui-1/themes/icon.css"
	rel="stylesheet" />
<link
	href="<%=path%>/static/js/jquery-easyui-1/themes/default/easyui.css"
	rel="stylesheet" />

<script type="text/javascript"
	src="<%=path%>/static/js/jquery-2.2.0.min.js"></script>
<script type="text/javascript"
	src="<%=path%>/static/js/jquery-easyui-1/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="<%=path%>/static/js/jquery-easyui-1/locale/easyui-lang-zh_CN.js"></script>
<style>
* {
	font-family: '微软雅黑';
	font-size: 14px;
	margin: 0;
	padding: 0;
}

td {
	height: 30px;
	color: #505052;
	padding-left：10px;
}

td {
	height: 40px;
}

input {
	height: 30px;
	width: 70%;
	background: #ededef;
	border: 1px solid #cbcbcd;
	color: #666;
	line-height: 28px;
	font-size: 14px;
}

select {
	height: 30px;
	width: 70%;
	background: #ededef;
	border: 1px solid #cbcbcd;
	color: #666;
	font-size: 14px;
}

img {
	vertical-align: middle;
}

.btn {
	border-image: none;
	border-radius: 4px;
	border-style: solid;
	border-width: 1px;
	box-shadow: 0 1px 0 rgba(255, 255, 255, 0.2) inset, 0 1px 2px
		rgba(0, 0, 0, 0.05);
	cursor: pointer;
	display: inline-block;
	font-size: 14px;
	line-height: 20px;
	margin-bottom: 0;
	padding: 4px 12px;
	text-align: center;
	vertical-align: middle;
}

.btn-success {
	background-color: #5bb75b;
	background-image: linear-gradient(to bottom, #62c462, #51a351);
	background-repeat: repeat-x;
	border-color: rgba(0, 0, 0, 0.1) rgba(0, 0, 0, 0.1) rgba(0, 0, 0, 0.25);
	color: #ffffff;
	text-shadow: 0 -1px 0 rgba(0, 0, 0, 0.25);
}

.btn-primary {
	background-color: #006dcc;
	background-image: linear-gradient(to bottom, #0088cc, #0044cc);
	background-repeat: repeat-x;
	border-color: rgba(0, 0, 0, 0.1) rgba(0, 0, 0, 0.1) rgba(0, 0, 0, 0.25);
	color: #ffffff;
	text-shadow: 0 -1px 0 rgba(0, 0, 0, 0.25);
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
		url:"<%=path%>/userSystem/postInfo/getListInPostList.do",
		title:"",iconCls:"icon-save",pagination:"true",
		pagePosition:"bottom",pageNumber:1,pageSize:10,pageList:[10,20],striped:"true",fitColumns:"true",nowrap:"true",singleSelect:"true",
		rownumbers:"true",border:"true",idField:"id",height:400,
		columns:[ [
			{title:"岗位名称",field:"postName",width:"40%",align:"center"},
			{title:"描述",field:"comments",width:"40%",align:"center"},
			{title:"操作",field:"id",width:"20%",align:"center",
				formatter:function(value, rowData,rowIndex) {
					var htmlEdit = "<a href='javascript:void(0)' onclick='editPost(\""+rowData.postId+"\")'>编辑</a>";
					var htmlDelete = "<a href='javascript:void(0)' onclick='deletePost(\""+rowData.postId+"\")'>删除</a>";
					return htmlEdit + "&nbsp" + htmlDelete;
				}
			} 
		] ]
	});
});

var clearAll = function(){
	$('input[name="post_name"]').val("");
}

var queryPostList = function(){
	var postname=$.trim($("#post_name").val());
	$('#datagrid').datagrid('load',{  
		postName:postname
		
	});
}

function deletePost(postId){
	if(postId != ""){ 
		$.messager.confirm("系统提示","您确定要删除这条记录吗?",function(r){
			if(r){
				$.post('<%=path%>/userSystem/postInfo/deletePost.do?postId='+postId,
				function(result){
					if(result.code=="01"){
						$.messager.show({
						title:'系统提示',
						msg:result.msg,
						timeout:3000,
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

function newPost(){
	$("#dlg").dialog('open').dialog('setTitle','新增岗位');
	$('#fm').form('clear');
}

var addPost=function(){
	window.location.href="<%=path%>/userSystem/postInfo/toPostAddOrEdit.do";
}
var editPost = function(postId){
	window.location.href="<%=path%>/userSystem/postInfo/toPostAddOrEdit.do?id="+postId+"";
}

function savePost(){
	$('#fm').form('submit',{
		url:"<%=path%>/userSystem/postInfo/postSave.do",
			onSubmit : function() {
				return true;
			},
			success : function(result) {
				var result = eval('(' + result + ')');
				if (result.errorMsg) {
					$.messager.alert("系统提示", result.errorMsg);
					return;
				} else {
					//$.messager.alert("系统提示","保存成功");
					$.messager.show({
						title : '系统提示',
						msg : '保存成功',
						timeout : 3000,
						showType : 'show'
					});
					$('#dlg').dialog('close');
					$("#datagrid").datagrid("reload");
				}
			},
			error : function(result) {
				$.messager.alert("系统提示", "保存失败");
			}
		});
	}
</script>
<meta charset="utf-8">
<title>岗位信息管理</title>
</head>
<body>
	<div id="div" style="width: 99%;" class="biaodan-content" >
	<div style="border:1px solid #ccccce;margin-bottom:10px;" >
	<div class="biaodan-content-nav" onclick="openOrOff(this)"><span class="nav-span-left" >岗位信息管理查询区</span></div>
	<div class="biaodan-content-List">
		<table style="width: 100%; margin-bottom: 10px;">
			<tr>
				<td style="font-size: 12px; width: 30%; text-align: center;">
					<span style="height: 30px; vertical-align: middle; font-weight: bold; width: 40%; text-align: right">岗位名称:</span>
					<input id="post_name" name="post_name" style="width: 50%;" />
				</td>
				<td></td>
			    <td></td>
			</tr>
			<tr>
			 <td style="font-size: 12px;width: 70%;text-align:center;" colspan="3">
				<a href="javascript:void(0)" class="standard-button" onclick="queryPostList()">查询</a>
				<a href="javascript:void(0)" class="standard-button" onclick="clearAll()">重置</a>
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
				<a href="javascript:void(0)" style="float:right;margin-right:10px;" class="standard-button" onclick="addPost()">新增岗位</a>
			</td>
		</tr>
	</table>
		<table id="datagrid" style="height: 100%;"></table>
		</div>
		</div>
		<div id="dlg" class="easyui-dialog"
			style="width: 600px; padding: 10px 8px" closed="true"
			buttons="#dlg-buttons">
			<form id="fm" method="post">
				<table cellspacing="10px;">
					<tr>
						<td style="font-size: 12px; width: 30%; text-align: center;">
							<span
							style="height: 30px; vertical-align: middle; font-weight: bold; width: 40%; text-align: right">岗位名称:</span>
							<input id="postname_id" name="postname" class="abc input-default"
							data-options="required:true" />
						</td>
					</tr>
					<tr>
						<td>描述:</td>
						<td><input type="text" name="comments" id="comments"
							class="easyui-validatebox" style="width: 200px;"></td>
					</tr>
				</table>
			</form>
		</div>
		<div id="dlg-buttons">
			<a href="javascript:void(0)" class="easyui-linkbutton"
				iconCls="icon-ok" onclick="savePost()">保存</a> <a
				href="javascript:void(0)" class="easyui-linkbutton"
				iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">关闭</a>
		</div>
	</div>
</body>
</html>