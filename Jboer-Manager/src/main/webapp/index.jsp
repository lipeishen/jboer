<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE>
<html>
<head>
	<title>中国人寿大健康平台管理系统</title>
	<script type="text/javascript"	src="<%=path%>/static/js/jquery-2.2.0.min.js"></script>
	<script type="text/javascript">
		window.location.href = "<%=path %>/user/isLogin.do";
	</script>
</head>
<!-- 
<body>
<iframe height="100%" width="100%" style="border:0;" src="<%=path %>/user/isLogin.do" name="rightFrame" id="rightFrame" title="rightFrame"></iframe>
</body>
 -->
</html>
