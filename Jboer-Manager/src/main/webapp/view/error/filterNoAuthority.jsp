<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>无权访问</title>
<script type="text/javascript">
var toIndexPage = function(){
	if(window != top){
		window.top.location.href = "<%=path %>/user/isLogin.do";
	}else{
		window.location.href = "<%=path %>/user/isLogin.do";
	}
}


</script>
</head>
<body>
<div style="width:100%; margin:0 auto; text-align:center; font-size:16px; font-family:'微软雅黑'; color:#0f9460;">
	<img src="<%=path%>/static/images/pic-filternoauth.png"/>
    <p>您无权访问此页面<br>5秒钟后为您自动跳转</p>
    <a href="javascript:void(0)" onclick="toIndexPage()"><img style="margin-top:100px;" src="<%=path%>/static/images/button-filternoauth.png"/></a>
</div>
</body>
<script type="text/javascript">
setTimeout('toIndexPage()',5000);
</script>
</html>
