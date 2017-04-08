<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="com.dcits.jb.manager.env.FileuploadEnv" %>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE HTML>
<html>
<head>
<title>商品信息导入管理</title>
<link href="<%=path%>/static/css/base.css" rel="stylesheet" />
<link href="<%=path%>/static/js/jquery-easyui-1/themes/icon.css" rel="stylesheet" />
<link href="<%=path%>/static/js/jquery-easyui-1/themes/default/easyui.css" rel="stylesheet" />
<script type="text/javascript" src="<%=path%>/static/js/jquery-2.2.0.min.js"></script>
<script type="text/javascript" src="<%=path%>/static/js/jquery-easyui-1/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=path%>/static/js/jquery-easyui-1/locale/easyui-lang-zh_CN.js"></script>

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
var downloadModel = function(){
		window.location.href = "<%=path%>/production/commodity/downloadExcel.do";
}

var changeUploadFile = function(path){
	var lastPath = path.substring(path.lastIndexOf("\\") + 1);
	var name = lastPath.substring(0, lastPath.indexOf("."));
	var style = lastPath.substring(lastPath.indexOf("."));
	if (style !=".xls") {
		$("#uploadExcel").hide();
	}else{
		$("#uploadExcel").show();
	}
}
var toProductList=function(){
	window.location.href = "<%=path%>/production/commodity/tocommodityList.do?modularId=${modularId}";
}
var submitFile = function(){
	$("#uploadExcel").hide();
	window.top.showWaitingDiv();
	$('#uploadForm').submit();
}

var addStringToTextArea = function(str){
	$("#recordStr").text(str+"\n");
}
</script>
</head>

<body onload="">
<div style="width:100%;margin:0 auto;">
	<div class="biaodan-content">
		<div id="bcfi" class="biaodan-content-nav" onclick="openOrOff(this)"><span class="nav-span-left">下载商品导入模板</span></div>
		<div id="bcfi1" class="biaodan-content-content">
		<form id="downloadForm" method="post">
			<table style="width:99%;border:0;cellspacing:3">
			<tr >
				<td colspan="4" style="width:50%;text-align:center;">
					<a href="javascript:void(0)" class="standard-button" onclick="downloadModel()">下载模板</a>
				</td>
			</tr>
		</table>
		</form>
		</div>
	</div>
</div>
<div style="width:100%;margin:0 auto;">
	<div class="biaodan-content">
		<div id="bcfi" class="biaodan-content-nav" onclick="openOrOff(this)"><span class="nav-span-left">上传商品信息数据</span></div>
		<div id="bcfi1" class="biaodan-content-content">
		<form id="uploadForm" method="post">
		<table style="width:99%;border:0;cellspacing:3">
			<tr>
				<th align="right" width="15%">上传Excel：</th>
				<td width="35%">
					<input type="file" name="uploadFile" id="uploadFile" onchange="changeUploadFile(this.value)">
				</td>
				<td colspan="2" style="width:50%;text-align:center;">
					<a href="javascript:void(0)" class="standard-button" id="uploadExcel" onclick="submitFile()" >上传</a>
				</td>
			</tr>
			<tr>
				<th align="left" width="100%" colspan="4">上传记录：</th>
			</tr>
			<tr>
				<td width="100%" colspan="4">
					<textarea id="recordStr" style="width:100%;height:400px;" readonly="readonly"></textarea>
				</td>
			</tr>
		</table>
		</form>
		</div>
	</div>
</div>
<p style="text-align: center;">
			<br /> <a href="javascript:void(0)" id="backid"
				class="standard-button" onclick="toProductList()">返回列表</a>
		</p>
</body>
<script type="text/javascript">
$("#uploadExcel").hide();
$('#uploadForm').submit(function (e) {
    e.preventDefault();
    $.ajax({
        url: "<%=path%>/production/commodity/uploadExcel.do",
        type: 'POST',
        dataType:"json",
        data: new FormData(this),
        processData: false,
        contentType: false
    }).done(function (data){
    	window.top.closeWaitingDiv();
    	var jsondata = data;
		if(jsondata.state == 'ok'){
			$("#uploadFile").val("")
			addStringToTextArea(jsondata.msg);
		}else{
			$("#uploadFile").val("")
			addStringToTextArea("上传失败！");
		}
		$("#uploadExcel").show();
    }).fail(function (data){
    	$("#uploadFile").val("")
    	window.top.closeWaitingDiv();
    	addStringToTextArea("上传失败！");
    });
});
</script>
</html>