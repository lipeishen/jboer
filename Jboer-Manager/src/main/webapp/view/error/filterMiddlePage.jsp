<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE>
<html>
<head>
	<title>中国人寿大健康平台管理系统</title>
	<script type="text/javascript"	src="<%=path%>/static/js/jquery-2.2.0.min.js"></script>
	<script type="text/javascript">
		if(window != top){
			window.top.location.href = "<%=path %>/user/loginView.do";
		}else{
			window.location.href = "<%=path %>/user/loginView.do";
		}
		
	</script>
</head>
</html>
