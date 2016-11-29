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
		url:"<%=path%>/authManage/userFeedback/getFeedbackList.do",
		title:"",iconCls:"icon-save",pagination:"true",
		pagePosition:"bottom",pageNumber:1,pageSize:10,pageList:[10,20],striped:"true",fitColumns:"true",nowrap:true,singleSelect:"true",
		rownumbers:true,border:true,idField:"id",height:400,
		columns:[ [
			{title:"用户姓名",field:"userName",width:"14%",align:"center"},
			{title:"客服姓名",field:"servUserName",width:"14%",align:"center"},
			{title:"用户反馈信息",field:"feedbackUserContent",width:"14%",align:"center",
				formatter:function(value, rowData,rowIndex) {
					return "<span title='" + value + "'>" + value + "</span>";
				}
			},
			{title:"客服回复信息",field:"feedbackServContent",width:"14%",align:"center",
				formatter:function(value, rowData,rowIndex) {
					return "<span title='" + value + "'>" + value + "</span>";
				}
			},
			{title:"反馈时间",field:"feedbackTime",width:"14%",align:"center",
				formatter:function(value, rowData,rowIndex) {
					var date = rowData.feedbackTime;
					if(date != null){
						var time = new Date(date.time);
						var year = time.getFullYear();
						var month = time.getMonth()+1;
						if(month < 10){
							month="0"+month;
						}
						var date = time.getDate();
						if(date < 10){
							date="0"+date;
						}
						var hours = time.getHours();
						var min = time.getMinutes();
						var sec = time.getSeconds();
	 					var d = year+"-"+month+"-"+date+" "+hours+":"+min+":"+sec;
						return d;
					}else{
						return "";
					}
 				
				}
			},
			{title:"反馈状态",field:"feedbackStatus",width:"14%",align:"center",
				formatter:function(value, rowData,rowIndex) {
					var feedbackStatus = rowData.feedbackStatus;
					if(feedbackStatus == 1){
						return "提出问题";
					}else if(feedbackStatus == 2){
						return "反馈完成";
					}else{
						return "反馈无效";
					}
				}
			},
			{title:"操作",field:"areaId",width:"14%",align:"center",
				formatter:function(value, rowData,rowIndex) {
					var id = "\""+rowData.feedbackId+"\"";
					var feedbackStatus = "\""+rowData.feedbackStatus+"\"";
					var htmlEdit = "<a href='javascript:void(0)' onclick='openReply("+id+","+feedbackStatus+")'>回复</a>";
					var htmlDelete = "<a href='javascript:void(0)' onclick='setToInvalid("+id+","+feedbackStatus+")'>置为无效</a>";
					return htmlEdit + "&nbsp" + htmlDelete;
				}
			} 
		] ]
	});
});


var setToInvalid = function(id,feedbackStatus){
	if(feedbackStatus == "1"){
		$.messager.confirm('系统提示', '你确定要将此反馈信息置为无效吗？', function(r){
			if(r){
				$.ajax({
					 url:"<%=path%>/authManage/userFeedback/setToInvalid.do",    //请求的url地址
					 dataType:"json",   //返回格式为json
					 async:false,//请求是否异步，默认为异步，这也是ajax重要特性
					 data:{"feedbackId":id},    //参数值
					 type:"GET",   //请求方式
				     success:function(data){
				    	 if(data.success){
				    		 $.messager.alert('系统提示','设置成功','info');
					    	 $("#datagrid").datagrid("reload");
				    	 }else{
				    		 $.messager.alert('系统提示',data.errorMsg,'warning');
				    	 }
				     },
				     error:function(){
				        //请求出错处理
				     }
				});
			}
		});
	}else if(feedbackStatus == "2"){
		$.messager.alert("系统提示","此信息已被回复,不可置为无效");
	}else{
		$.messager.alert("系统提示","此信息已被置为无效");
	}
}

var openReply = function(id,feedbackStatus){
	if(feedbackStatus == "1"){
		if(id){
			$('#fm').form('clear');
			$("#dlg").dialog('open').dialog('setTitle','回复信息');
			$("#feedbackId").val(id);
		}
	}else if(feedbackStatus == "2"){
		$.messager.alert("系统提示","此信息已被回复");
	}else{
		$.messager.alert("系统提示","此信息已被置为无效");
		
	}	
}

var query = function(){
	$('#datagrid').datagrid('load',{
		serv_user_name:$("#serv_user_name").val(),
		startTime:$('#startTime').combo('getText'),
		endTime:$('#endTime').combo('getText'),
		feedback_status:$("#feedback_status").combobox("getValue")
	});
}

var clearAll = function(){
	$("#serv_user_name").val("");
	$('#startTime').combo('setText','');
	$('#endTime').combo('setText','');
	$("#feedback_status").combobox("setValue",'');
}
function reply(){
	$('#fm').form('submit',{
		url:"<%=path%>/authManage/userFeedback/reply.do",
		onSubmit:function(){
			return $(this).form('validate');
		},
		success:function(result){
			var result=eval('('+result+')');
			if(result.errorMsg){
				$.messager.alert("系统提示",result.errorMsg);
				return;
			}else{
			    $.messager.alert({title:'系统提示',msg:'回复成功'}); 
				$('#dlg').dialog('close');
				$("#datagrid").datagrid("reload");
			}
		},
		error:function(result){
			$.messager.alert("系统提示","保存失败");
		}
	});
}
function myformatter(date) {

	var y = date.getFullYear();

	var m = date.getMonth() + 1;

	var d = date.getDate();

	return y + '-' + (m < 10 ? ('0' + m) : m) + '-'

	+ (d < 10 ? ('0' + d) : d);

	}

	function myparser(s) {

	if (!s)

	return new Date();

	var ss = (s.split('-'));

	var y = parseInt(ss[0], 10);

	var m = parseInt(ss[1], 10);

	var d = parseInt(ss[2], 10);

	if (!isNaN(y) && !isNaN(m) && !isNaN(d)) {

	return new Date(y, m - 1, d);

	} else {

	return new Date();

	}

	}
</script>
<meta charset="utf-8">
<title>用户反馈管理</title>
</head>
<body>
<div  id="div" class="biaodan-content">
	<div style="border:1px solid #ccccce;margin-bottom:10px;" >
		<div class="biaodan-content-nav" onclick="openOrOff(this)"><span class="nav-span-left" >用户反馈管理</span></div>
			<div class="biaodan-content-List" style="heigh:40px;line-height:40px;font-size:20px;font-weight:bold;text-align:center;margin-bottom:20px;">
			<table style="width: 100%;margin-bottom:10px;">
				<tr>
					<td style="font-size: 12px;width:30%;text-align:center;">
						<span style="height:30px;vertical-align:middle;font-weight:bold;width:40%;text-align:right">客服姓名:</span> 
						<input id="serv_user_name" class="abc input-default" name="serv_user_name" style="width: 249px;height:35px" />
					</td>
					<td style="font-size: 12px;width:30%;text-align:center;">
						<span style="height:30px;vertical-align:middle;font-weight:bold;width:40%;text-align:right">反馈时间起:</span> 
						<input id="startTime" class="abc input-default easyui-datebox" data-options="formatter:myformatter,parser:myparser" style="width: 249px;height:35px" />
					</td>
					<td style="font-size: 12px;width:30%;text-align:center;">
						<span style="height:30px;vertical-align:middle;font-weight:bold;width:40%;text-align:right">反馈时间止:</span> 
						<input id="endTime" class="abc input-default easyui-datebox" data-options="formatter:myformatter,parser:myparser" style="width: 249px;height:35px" />
					</td>
				</tr>
				<tr>
					<td style="font-size: 12px;width:30%;text-align:center;">
						<span style="height:30px;vertical-align:middle;font-weight:bold;width:40%;text-align:right">反馈状态:</span> 
						<select id="feedback_status" name="feedback_status" style="width: 250px;height:35px" class="easyui-combobox" data-options="editable:false" panelHeight="100px">
							<option value="">--请选择--</option>
							<option value="1">提出问题</option>
							<option value="2">反馈完成</option>
							<option value="3">反馈无效</option>
						</select>
					</td>
				</tr>
				<tr>
				   <td style="font-size: 12px;width: 30%;text-align:center;" colspan="4">
						<a href="javascript:void(0)" class="standard-button" onclick="query()">查询</a>
						<a href="javascript:void(0)" class="standard-button" onclick="clearAll()">重置</a>
					</td>
				</tr>
			</table>
		</div>
	</div>
	<div style="border:1px solid #ccccce;">
		<div class="biaodan-content-nav" onclick="openOrOff(this)"><span class="nav-span-left">功能及列表区</span></div>
		<div class="biaodan-content-List">
			<table id="datagrid" style="height: 100%;"></table>
			<div id="dlg" class="easyui-dialog" style="width: 400px; padding: 10px 8px" closed="true" buttons="#dlg-buttons">
				<form action="" id="fm">
					<table cellspacing="10px;">
							<tr>
								<td>
									<input name="feedbackId" type="hidden" id="feedbackId" value="">
								   <textarea rows="3" cols="39" maxlength="200" name="feedbackServContent" id="feedbackServContent" required="true" class="easyui-validatebox"></textarea>
								</td>
							</tr>
					</table>
				</form>
				<div id="dlg-buttons">
					<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="reply()">确定</a> <a
						href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel"
						onclick="javascript:$('#dlg').dialog('close')">关闭</a>
				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>