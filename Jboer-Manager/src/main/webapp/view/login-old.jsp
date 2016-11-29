<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE HTML>
<html>
<head>
<link href="static/css/base.css" rel="stylesheet" />
<script type="text/javascript" src="<%=path%>/static/js/jquery-2.2.0.min.js"></script>
<meta charset="utf-8">
<title>中国人寿大健康管理系统</title>
<style type="text/css">
#bgDiv {
	position: absolute;
	top: 0px;
	left: 0px;
	z-index:99998;
	right:0px;
	background-color: #dbc9c9;
	opacity: 0.3;//css3以后兼容所有浏览器，透明度50%*/
	filter:alpha(opacity=40);
}
.msgdiv {
	text-align: center;
	line-height: 40px;
	font-size: 20px;
	font-weight: bold;
	z-index:99999;
	width: 200px;
	height: 130px;
	left:50%;
	top:50%;
	margin-left:-100px!important;/*FF IE7 该值为本身宽的一半 */
	margin-top:-55px!important;/*FF IE7 该值为本身高的一半*/
	margin-top:0px;
	position:fixed!important;/* FF IE7*/
	position:absolute;/*IE6*/
	_top:       expression(eval(document.compatMode&&
	document.compatMode=='CSS1Compat') ?
	documentElement.scrollTop+(document.documentElement.clientHeight-this.offsetHeight)/2 :/*IE6*/
	document.body.scrollTop+(document.body.clientHeight-this.clientHeight)/2);/*IE5 IE5.5*/

}
</style>
</head>
<script type="text/javascript">
function check(){
	if (document.getElementById("loginName").value=="") {
		document.getElementById("msg").innerHTML ="请输入用户名";
		document.getElementById("loginName").focus();
	}else if (document.getElementById("password").value==""){
		document.getElementById("msg").innerHTML="请输入密码";
		document.getElementById("password").focus();
	}else if (document.getElementById("validateCode").value==""){
		document.getElementById("msg").innerHTML="请输入验证码";
		document.getElementById("loginPwd").focus();
	}else{
		showDiv();
		document.getElementById("f").submit();
	}
}
document.onkeydown=function(event){ 
	e = event ? event :(window.event ? window.event : null); 
	if(e.keyCode==13){ 
		//执行的方法 
		check();
		
	}
} 
function showDiv(){
	var i = 0;
	document.getElementById('bgDiv').style.display = '';
	if(document.getElementById('test') != null && document.getElementById('test') != undefined){
		document.getElementById('test').innerHTML = "<img src=\"<%=path%>/static/images/wait.gif\" style=\"width:30px;height:30px;\"/>正在登陆中...";
		document.getElementById('test').style.display = '';
	}else{
		var dom = document;
		var div = dom.createElement("div");
		div.id = "test";
		div.className = "msgdiv";//添加上面的样式
		div.innerHTML = "<img src=\"<%=path%>/static/images/wait.gif\" style=\"width:30px;height:30px;\"/>正在登陆中...";
		dom.body.appendChild(div);
	}
//定义y层，覆盖原页面
	var bgObj = window.top.document.getElementById("bgDiv");
	bgObj.style.width = window.screen.width + "px";
	bgObj.style.height = window.screen.height + "px";
//其余背景变暗，并与bgDiv背景色保持一致
	//dom.body.style.background = "#adadad";
	window.top.document.body.style.overflow = "hidden";
}

function closeDiv(){
	document.getElementById('bgDiv').style.display = 'none';
	document.getElementById('test').style.display = 'none';
}
function changeImg(){
	var imgObj = document.getElementById('validateCodeImg');
	imgObj.src="<%=path %>/user/kaptcha.do?"+(new Date).getTime();
}
</script>

<body class="login-bg">
    <div id="bgDiv"></div>
	<div class="login-bg1">
		<div style="width: 680px; height: 70px; margin: 0 auto; position: relative; top: 60px;">
			<img src="<%=path%>/static/images/login-logo.png" />
		</div>
		<div class="login" style="height: 275px;">
			<form style="height: 10px;" id="f" action="<%=path%>/user/login.do" method="post">

				<input style="border: 0; width: 155px; height: 26px; position: relative; left: 105px; top: 60px; background: none; line-height: 26px; color: #333; font-size: 14px;" type="text" placeholder="用户名"  name="loginName" id="loginName"> 
				<input style="border: 0; width: 155px; height: 26px; position: relative; left: -56px; top: 106px; background: none; line-height: 26px; color: #333; font-size: 14px;" type="password" name="password" id="password" placeholder="密码" autocomplete="off">
				<div style="border:0;width:220px;height:42px;position:relative;left:66px;top:116px;line-height:26px;color:#333;font-size:14px;">
					<span style="float:left;margin-top:8px;"><B>验证码：</B></span>
					<input style="width:68px;line-height:20px;height:34px;color:#333;font-size:14px;float:left;margin-right:4px;" type="text" name="validateCode" id="validateCode"  maxlength="4"/>
					<a href="javascript:void(0)" onclick="changeImg()"><img id="validateCodeImg" style="vertical-align: middle;float:right;" title="点击更换" src="<%=path %>/user/kaptcha.do" height="40" width="85"/></a>
				</div>
				
				<div id="inputinfo" style="width: 208px; height: 40px; margin: 0 auto; position: relative; top: 120px; clear: both;">
					<a href="javascript:void(0)" onclick="check()"><div class="button1"></div></a>
					<center style="position: relative; left: 0px; top: -210px;">
						<label id="msg" class="co">${fail}</label>
					</center>
				</div>
			</form>
		</div>
	</div>
</body>
</html>
