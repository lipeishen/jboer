<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE HTML>
<html>
<head>
<link href="<%=path%>/static/css/base.css" rel="stylesheet" />
<script type="text/javascript" src="<%=path%>/static/js/jquery-2.2.0.min.js"></script>
<meta charset="utf-8">
<title>北京京铂儿科技业务管理系统</title>
<style type="text/css">
body{
	background:#fff url(<%=path%>/static/images/bg.png) repeat-x;
	margin:0;
	padding:0;
	}
.logo{
	width:700px;
	margin:56px auto 0;
	}
.login-text{
	width:700px;
	height:335px;
	margin:0 auto;
	}
.login-pic{
	width:400px;
	height:335px;
	float:left;
	}
.login-f{
	width:280px;
	height:335px;
	float:left;
	margin-left:20px;
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
</style>

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
		toLogin();;
	}
}


var toLogin = function(){
	showDiv();
	$.ajax({
		type : "post",
		url : "<%=path%>/user/login.do",
		data : $("#f").serialize(),
		success : function(data) {
			closeDiv();
			if(data == "ok"){
				window.location.href = "<%=path%>/user/isLogin.do";
				return;
			}else if(data == "validateCode"){
				$("#msg").text("验证码错误");
			}else if(data == "param"){
				$("#msg").text("传入信息错误");
			}else if(data == "userpwd"){
				$("#msg").text("用户名或密码错误");
			}else if(data == "allow"){
				$("#msg").text("当前用户无任何访问权限");
			}else{
				$("#msg").text("登陆异常");
			}
			changeImg();
		}
	});
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
</head>
<body> 
<div id="bgDiv"></div>
<div class="logo">
	<img src="<%=path%>/static/images/logo-login.png"/>
</div>
<div class="login-text">
	<div class="login-pic">
    <img src="<%=path%>/static/images/logo-pic.png"/>
    </div>
    <div class="login-f">
    <form style="height: 10px;" id="f" action="" method="post">
	    <input style="width:250px; height:40px; background:#fff; border:0;margin-top:84px;color:#828282;padding-left:10px;font-size:16px;font-family:'微软雅黑';" placeholder="用户名" type="text" name="loginName" id="loginName" value="${loginName}">
	    <input style="width:250px; height:40px; background:#fff; border:0;margin-top:12px;color:#828282;padding-left:10px;font-size:16px;font-family:'微软雅黑';" placeholder="密码" type="password" name="password" id="password" autocomplete="off">
	    <input style="width:150px; height:40px; background:#fff; border:0;margin-top:12px;color:#828282;float:left;padding-left:10px;font-size:16px;font-family:'微软雅黑';" placeholder="验证码" name="validateCode" id="validateCode"  maxlength="4">
	    <a href="javascript:void(0)" onclick="changeImg()"><img id="validateCodeImg" style="vertical-align: middle;float:left;margin-top:12px;margin-left:14px;" title="点击更换" src="<%=path %>/user/kaptcha.do" height="42" width="85"/></a>
	    <input style="width:260px; height:40px; background:#ff8400; border:0;margin-top:28px;margin-bottom:10px;color:#fff; font-size:16px;font-family:'微软雅黑';" value="登    录" type="button" onclick="check();">
    	<label style="color:#f00;line-height:20px;font-size:14px;font-family:'微软雅黑';float:left" id="msg"></label>
    </form>
    </div>
</div>
</body>
</html>

