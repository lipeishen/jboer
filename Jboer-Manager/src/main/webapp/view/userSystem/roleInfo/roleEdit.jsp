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
	line-height:20ppx;
	
}
.definewidth{
	width:96%;
	margin:auto;		
}
.m10{
	margin-top:10px;
}
.m20{
	padding-top:20px;
}
.tableleft{
	text-align:left;
	padding-left:5px;
	background-color:#f5f5f5;
}
.table-bordered {
	border: 1px solid #dddddd;
	border-collapse: separate;
	*border-collapse: collapse;
	border-left: 0;
  	-webkit-border-radius: 4px;
    -moz-border-radius: 4px;
    border-radius: 4px;
}
.table-hover tbody tr:hover > td{
  background-color: #f5f5f5;
}
.bg {
  display:none;
  position:fixed;
  width:100%;
  height:100%;
  background:#CCCCFF;
  z-index:20;
  top:0;
  left:0;
  opacity:0.5;
}
.content{
  display:none;
  width:100px;
  height:15px;
  position:fixed;
  top:50%;
  margin-top:-150px;
  background:#fff;
  z-index:30;
  left:50%;
  margin-left:-25px;
  margin-top:auto;
}
</style>
<script type="text/javascript">
	$(document).ready(function(){
		$.ajaxSetup({
			//关闭AJAX相应的缓存
			cache:false
		});
		var rid = $("#roleId").val();
		if(rid == ''){
			$('#tt2').tree({
		        url: '<%=path%>/userSystem/roleInfo/easyUitree.do',
		        checkbox:true,
		        onBeforeLoad:function(){
		        	$('.bg').fadeIn(200);
                	$('.content').fadeIn(400);
		        },
		        loadFilter: function(data){
		    		if (data.d){
		    			return data.d;
		    		} else {
		    			return data;
		    		}
		        },
		        onLoadSuccess: function(node,data){
		        	 $('.bg').fadeOut(800);
	            	 $('.content').fadeOut(800);
		        }
		    });
		}else{
			$('#tt2').tree({
		        url: '<%=path%>/userSystem/roleInfo/easyUitree.do',
		        checkbox:true,
		        loadFilter: function(data){
		    		if (data.d){
		    			return data.d;
		    		} else {
		    			return data;
		    		}
		        },
		        onBeforeLoad:function(){
		        	$('.bg').fadeIn(200);
                	$('.content').fadeIn(400);
		        },
		        onLoadSuccess: function(node,data){
		        	$.ajax({
						 url:"<%=path%>/userSystem/roleInfo/getHaveModulars.do",    //请求的url地址
						 dataType:"json",   //返回格式为json
						 async:false,//请求是否异步，默认为异步，这也是ajax重要特性
						 data:{"roleId":rid},    //参数值
						 type:"POST",   //请求方式
					     success:function(data){
					    	 var le = data.length;
					    	 for(var i = 0; i < le; i++){
					    		 var n = $("#tt2").tree('find',data[i]);
			                      if(n){
			                          $("#tt2").tree('check',n.target);
			                      }
					    	 }
					     },
					     error:function(){
					        //请求出错处理
					        alert("请求异常");
					     }
					});
		        	$('.bg').fadeOut(800);
	            	$('.content').fadeOut(800);
		        }
		    });
		}
	});
	
	var saveOrEditRoleInfo = function(button){
		var rid = $("#roleId").val();
		var nodes = $('#tt2').tree('getChecked');
		var lth = nodes.length;
		var idsArray =  new Array();
		if(lth > 0){
			for(var i = 0; i < lth; i++){
				idsArray.push(nodes[i].id);
			}
		}
		var roleName = $("#roleName").val();
		var comments = $("#comments").val();
		if(roleName == ''){
			$.messager.alert("系统提示","角色名不能为空","warning");
			return false;
		}
		if(roleName.length > 25){
			$.messager.alert("系统提示","角色名称过长","warning");
			return false;
		}
		if(comments.length > 100){
			$.messager.alert("系统提示","描述过长","warning");
			return false;
		}
		if(idsArray.length == 0){
			$.messager.alert("系统提示","请选择角色拥有的权限","warning");
			return false;
		}
		if(rid == ''){
			//新增角色
			$.ajax({
				 url:"<%=path%>/userSystem/roleInfo/saveRoleInfo.do",    //请求的url地址
				 dataType:"json",   //返回格式为json
				 async:false,//请求是否异步，默认为异步，这也是ajax重要特性
				 data:{"roleName":roleName,"comments":comments,"idsArray":idsArray},    //参数值
				 type:"POST",   //请求方式
			     success:function(data){
			    	 if(data.code == '01'){
			    		 //请求成功时处理
				    	 window.location.href = "<%=path%>/userSystem/roleInfo/toRoleList.do";
			    	 }else{
			    		 $.messager.alert("系统提示",data.msg,"warning");
			    	 }
			     },
			     error:function(){
			        //请求出错处理
			     }
			});
		}else{
			//编辑角色
			$.ajax({
				 url:"<%=path%>/userSystem/roleInfo/editRoleInfo.do",    //请求的url地址
				 dataType:"json",   //返回格式为json
				 async:false,//请求是否异步，默认为异步，这也是ajax重要特性
				 data:{"roleId":rid, "roleName":roleName,"comments":comments,"idsArray":idsArray},    //参数值
				 type:"POST",   //请求方式
			     success:function(data){
			    	 if(data.code == '01'){
			    		 //请求成功时处理
				    	 window.location.href = "<%=path%>/userSystem/roleInfo/toRoleList.do";
			    	 }else{
			    		 $.messager.alert("系统提示",data.msg);
			    	 }
			     },
			     error:function(){
			        //请求出错处理
			     }
			});
		}
		
	}
	
	var toRoleList = function() {
		window.location.href = "<%=path%>/userSystem/roleInfo/toRoleList.do";
	}
</script>
<meta charset="utf-8">
<title>角色信息管理</title>
</head>
<body>
<div class="bg"></div>
<div class="content">
	<h1>数据加载中...</h1>
</div>
<form action="index.html" method="post" class="definewidth m20">
    <table class="table table-bordered table-hover definewidth m10">
        <tr>
            <td width="10%" class="tableleft">角色名称</td>
            <td><input type="text" name="roleName" id="roleName" value="${role.roleName }" class="easyui-validatebox" missingMessage="角色名称必填" invalidMessage="长度在0-25之间" data-options="required:true,validType:['length[0,25]']"/></td>
        </tr>
        <tr>
            <td class="tableleft">描述</td>
            <td><input type="text" name="comments" id="comments" value="${role.comments }" class="easyui-validatebox" invalidMessage="长度在0-100之间" data-options="validType:['length[0,100]']"/></td>
        </tr>
        <tr>
            <td class="tableleft">权限</td>
            <td>
                <ul class="easyui-tree" id="tt2"></ul>
            </td>
        </tr>
        <tr>
            <td class="tableleft"></td>
            <td style="font-size: 12px;width: 30%;text-align:center;">
           		<input type="hidden" value="${role.roleId }" id="roleId" name="roleId"/>
				<a href="javascript:void(0)" class="standard-button" onclick="saveOrEditRoleInfo(this)">保存</a>
				<a href="javascript:void(0)" class="standard-button" onclick="toRoleList()">返回列表</a>
			</td>
        </tr>
    </table>
</form>
</body>
</html>