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
.btn {
    border-image: none;
    border-radius: 4px;
    border-style: solid;
    border-width: 1px;
    box-shadow: 0 1px 0 rgba(255, 255, 255, 0.2) inset, 0 1px 2px rgba(0, 0, 0, 0.05);
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
	var saveOrEdit= function(){
	 $.messager.confirm("系统提示","您确定要修改您的信息吗?",function(r){
		 if(r){
				var userId = $("#userId").val();
				var email = $("#email").val();
				var phone = $("#phone").val();
				var mobilePhone = $("#mobilePhone").val();
				var comments = $("#comments").val();
				//  ^([a-zA-Z0-9]*[-_]?[a-zA-Z0-9]+)*@([a-zA-Z0-9]*[-_]?[a-zA-Z0-9]+)+[\\.][A-Za-z]{2,3}([\\.][A-Za-z]{2})?$
				//var reg = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/; 
				var reg =/^([a-zA-Z0-9]*[-_]?[a-zA-Z0-9]+)*@([a-zA-Z0-9]*[-_]?[a-zA-Z0-9]+)+[\\.][A-Za-z]{2,3}([\\.][A-Za-z]{2})?$/;
				if(!reg.test(email)){
						$.messager.alert("系统提示","邮箱格式不正确");
						return false;
				}
				//  ^[0][0-9]{2,3}-[0-9]{5,10}$   ^[1-9]{1}[0-9]{5,8}$"
				if(phone.length>9){// ^[0][0-9]{2,3}-[0-9]{5,10}$
					//var tel = /^(\d{3,4}-?)?\d{7,9}$/g;
					var tel = /^[0][0-9]{2,3}-[0-9]{5,10}$/; 
					if(!tel.test(phone)){
						$.messager.alert("系统提示","请输入正确的固定电话");
						return false;
					}
				}else{//^[1-9]{1}[0-9]{5,8}$");         // 验证没有区号的  
					var tel = /^[1-9]{1}[0-9]{5,8}$/; 
					if(!tel.test(phone)){
						$.messager.alert("系统提示","请输入正确的固定电话");
						return false;
					}
				}
				//联系电话(手机)验证   ^1[3|4|5|6|7|8|9][0-9]{9}$
				var length = mobilePhone.length;   
                var mobile =/(^1[3|4|5|6|7|8|9][0-9]{9}$)/;  
				if(!(length==11 && mobile.test(mobilePhone))){
					$.messager.alert("系统提示","请输入正确的手机号");
					return false;
				}
				//编辑登录用户信息
					$.ajax({
						 url:"<%=path%>/user/editSelfUserInfo.do",    //请求的url地址
						 dataType:"json",   //返回格式为json
						 async:false,//请求是否异步，默认为异步，这也是ajax重要特性
						 data:{"userId":userId,"email":email,"phone":phone,"mobilePhone":mobilePhone,"comments":comments},    //参数值
						 type:"POST",   //请求方式
					     success:function(data){
					    	 if(data.code == '01'){
					    		 //请求成功时处理
					    		  $.messager.alert("系统提示","修改成功!");
					    		 setTimeout(function() {
					    			 window.location.href = "<%=path%>/user/toUserInfo.do";
								 }, 6000);
					    	 }else{
					    		 $.messager.alert("系统提示",data.msg);
					    	 }
					     },
					     error:function(){
					        //请求出错处理
					     }
					});
		 }
	
	  });
	}
</script>
<meta charset="utf-8">
<title>用户信息管理</title>
</head>
<body>
<form action="index.html" method="post" class="definewidth m20">
    <table class="table table-bordered table-hover definewidth m10">
        <tr>
            <td class="tableleft">用户名称:</td>
            <td><input type="text" name="name" id="name" value="${sysuser.name }" class="easyui-validatebox" data-options="required:true,validType:['length[0,25]']" style="width: 200px;" disabled></td>
            <td class="tableleft">登录名称:</td>
	        <td><input type="text" name="loginName" id="loginName" value="${sysuser.loginName }"  class="easyui-validatebox" data-options="required:true,validType:['singLoginName','account[6,20]']" style="width: 200px;" disabled></td>
        </tr>
        <tr>
	        <td class="tableleft">员工编号:</td>
	        <td><input type="text" name="staffNum" id="staffNum" value="${sysuser.staffNum }" class="easyui-validatebox" data-options="required:true,validType:['singStaffNum','account[0,20]']" style="width: 200px;" disabled></td>
            <td class="tableleft">邮箱:</td>
         	<td><input type="text" name="email" id="email" value="${sysuser.email }" class="easyui-validatebox" data-options="required:false,validType:['email','length[0,50]']" style="width: 200px;"></td>
        </tr>
        <tr>
            <td class="tableleft">固定电话:</td>
	        <td><input type="text" name="phone" id="phone" value="${sysuser.phone }" data-options="required:false,validType:['length[0,9]']" style="width: 200px;"></td>
	      	<td class="tableleft">手机号:</td>
	        <td><input type="text" name="mobilePhone" id="mobilePhone" value="${sysuser.mobilePhone }" data-options="required:false,validType:['length[0,11]']" style="width: 200px;"></td>
        </tr>
        <tr>
      	  <td class="tableleft">描述:</td>
          <td colspan="4">
            <textarea name="comments" id="comments" value="${sysuser.comments }" class="textarea easyui-validatebox" data-options="required:false,validType:['length[0,100]']" style="width:100%">${sysuser.comments }</textarea>
          </td>
        </tr>
        <tr>
            <td class="tableleft"></td>
            <td style="font-size: 12px;width: 30%;text-align:center;" colspan="2">
            	<input type="hidden" value="${sysuser.userId }" id="userId" name="userId"/>
            	 <a href="javascript:void(0)" class="standard-button" onclick="saveOrEdit()">修改</a>&nbsp;&nbsp;
            </td>
        </tr>
    </table>
</form>
</body>
</html>