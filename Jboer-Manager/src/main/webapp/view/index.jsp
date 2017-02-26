<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<title>北京京铂儿科技业务管理系统</title>
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
top:50%;margin-left:-70px!important;/*FF IE7 该值为本身宽的一半 */margin-top:-15px!important;/*FF IE7 该值为本身高的一半*/
margin-top:0px;position:fixed!important;/* FF IE7*/position:absolute;/*IE6*/
_top:expression(eval(document.compatMode&&document.compatMode=='CSS1Compat') ?documentElement.scrollTop+(document.documentElement.clientHeight-this.offsetHeight)/2 :/*IE6*/document.body.scrollTop+(document.body.clientHeight-this.clientHeight)/2);/*IE5 IE5.5*/
}
</style>

<link href="<%=path%>/static/css/base.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=path%>/static/js/jquery-2.2.0.min.js"></script>

<script type="text/javascript">
var opentOrOff = function(obj){
	if($(obj).attr("class") == "button"){
		$(obj).removeClass("button").addClass('button-active');
		$(obj).children("img:first-child").attr("src","<%=path%>/static/images/"+$(obj).children("img:first-child").attr("name")+"-a.png");
		$(obj).siblings(".nav-active").show(100);
	}else{
		$(obj).removeClass("button-active").addClass('button'); 
		$(obj).children("img:first-child").attr("src","<%=path%>/static/images/"+$(obj).children("img:first-child").attr("name")+".png");
		$(obj).siblings(".nav-active").hide(100);
	}
};

$(function(){

	var heightCentent = $(window).height();
	var mainHeight = heightCentent - "74" + "px";
   	var bHeight = (heightCentent-"74") + "px";
  	$(".main").css("height",mainHeight);
   	$(".main-right").css("height",bHeight);
   	$(".main-right3").css("height",mainHeight);
   	var rightMain = heightCentent - "71" + "px";
   	var boxHeight = heightCentent - "101" + "px";
   	$(".main-left").css("height",mainHeight);
   	$(".main-right1").css("height",mainHeight);
   	$(".main-right3").css("height",mainHeight);
})
$(function(){
	var getErjiMaxWidth = function( nodes ){
		//var nodes = $(".nav-active").eq( index ).find(".erji")
		var max = 250
		nodes.each( function(){
			var me = $(this);
			var width = me.find("span").width();
			max = Math.max( max, width );
		} )
		return max;
	}
	function abc(eventType,yangshi){
		var navActiveNodes = $(".nav-active");
		navActiveNodes.each(function(){
			var me = $(this);
			me.on(eventType,".erji1", function(){
				$(".erji-active").removeClass("erji-active").addClass("erji")
				$(this).addClass(yangshi).removeClass("erji");
			})
		})
	}
	abc("click","erji-active");
	$(".erji1").hover(
		function () {
			var max = getErjiMaxWidth( $(".erji1") );
			$(this).css({"width" : max}).addClass("erji-hover");
			},
		function () {
			$(this).removeClass("erji-hover");
			}
	);
});
   $(function(){
	var tabs = function(eventType){
	var items = $(".header-center").find("li");
	var content = $(".main").find(".main-content");
	items.on(eventType,function(){
		var number = $(this).index();
		$(this).addClass("headernav-active").removeClass("headernav").siblings("li").addClass("headernav").removeClass("headernav-active");
		content.eq(number).show().siblings().hide();
	})		
	};
	tabs("click");
});
  $(function(){
var tabs = function(eventType){
	var items = $(".link11").find("p");
	var content = $(".main").find(".main-content1");
	var item1s = $(".header-center").find(".abc1");
	items.on(eventType,function(){
		$(item1s).addClass("headernav-active").removeClass("headernav").siblings("li").addClass("headernav").removeClass("headernav-active");
		content.show().siblings().hide();
		})		
};
tabs("click");
});

function showWaitingDiv(){
	var i = 0;
	document.getElementById('bgDiv').style.display = '';
	if(document.getElementById('test') != null && document.getElementById('test') != undefined){
		document.getElementById('test').innerHTML = "<img src=\"<%=path%>/static/images/wait.gif\" style=\"width:30px;height:30px;\"/>请稍候...";
		document.getElementById('test').style.display = '';
	}else{
		var dom = document;
		var div = dom.createElement("div");
		div.id = "test";
		div.className = "msgdiv";//添加上面的样式
		div.innerHTML = "<img src=\"<%=path%>/static/images/wait.gif\" style=\"width:30px;height:30px;\"/>请稍候...";
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

function closeWaitingDiv(){
	document.getElementById('bgDiv').style.display = 'none';
	document.getElementById('test').style.display = 'none';
}

function toZgrs(){
	window.open("http://www.jboer.com/");
}

var topTiltleToLeft = function(){
	document.getElementById('headerTitleDiv').scrollLeft += -250
}
var topTiltleToRight = function(){
	document.getElementById('headerTitleDiv').scrollLeft += 250
}
</script>
</head>
<body class="body_index">
    <div class="header">
        <div class="header-left">
            <a href="javascript:void(0)" onclick="toZgrs()"><img style="margin-left:5px;height:50px;margin-right:5px;" src="<%=path%>/static/images/logo.png"/></a>
        </div>
        <!-- <div class="header-center-left">
            <a href="javascript:void(0)" onclick="topTiltleToLeft()"><img style="margin-left:5px;" src="<%=path%>/static/images/left1.png"/></a>
        </div> -->
        <div class="header-nav" style="width:820px;">
        <ul class="header-center" id="headerTitleDiv">
        	<li class="headernav-active">首页</li>
       		<c:forEach var="session_modular_head_list" items="${session_modular_head_list}">
       			<li class="headernav abc3">${session_modular_head_list.modularName} </li>
       		</c:forEach>
        </ul>
       </div> 
        <!-- <div class="header-center-right">
            <a href="javascript:void(0)" onclick="topTiltleToRight()"><img style="margin-left:5px;" src="<%=path%>/static/images/right1.png"/></a>
        </div> -->
        <div class="header-right">
            <div class="nav" style="line-height:50px;height:50px;">
            	<table>
            	<tr>
            	<td style="padding-right:5px;height:50px;line-height:16px;color:#fff;width:245px;vertical-align:middle;text-align:right;">${session_user.name}，欢迎您</td> 
               	<td><a title="退出" href="<%=path%>/user/exitUser.do"><img src="<%=path%>/static/images/exit.png"/></a>   </td>
               	</tr>
               	</table>    	                      
            </div>
        </div>
    </div>
    <div class="main">
        <div class="main-content main-content">
        <div class="main-left" style="overflow-y:auto;overflow-x:hidden;">
        	<div>
        		<div class="button" onclick="opentOrOff(this)">
        			<img class="iocn" name="fawen" src="<%=path%>/static/images/fawen.png"/>
        			<span title="用户信息维护" style="width:150px;text-overflow:ellipsis;white-space:nowrap;overflow:hidden;display:block;float:left;">用户信息维护</span>
        		</div>
        		<div class="nav-active">
        			<a style="text-decoration:none;" href="<%=path %>/user/toUserInfo.do" target="rightFrame0">
        				<div class="erji erji1"  style="text-overflow:ellipsis;white-space:nowrap;overflow:hidden">
        					<span style=" line-height:46px;margin-left:80px;" title="用户基本信息">用户基本信息</span>
        				</div>
        			</a>
        			<a style="text-decoration:none;" href="<%=path %>/view/headpage/editpassword.jsp" target="rightFrame0">
        				<div class="erji erji1"  style="text-overflow:ellipsis;white-space:nowrap;overflow:hidden">
        					<span style=" line-height:46px;margin-left:80px;" title="修改密码">修改密码</span>
        				</div>
        			</a>
        		</div>
        	</div>
        </div>
        <div class="main-right1">
       		<div class="right-main">
        		<div class="box">
        			<div class="box-main">
            			<iframe height="100%" width="100%" style="border:0;" src="" name="rightFrame0" id="rightFrame0" title="rightFrame0"></iframe>
            		</div>
            	</div>
            </div>
        </div>
        </div>
        
        <c:forEach var="session_modular_head_list" items="${session_modular_head_list}" varStatus="status">
        <div class="main-content main-content" style="display:none;">
	        <div class="main-left" style="overflow-y:auto;overflow-x:hidden;">
	         <c:forEach var="session_modular_big_list" items="${session_modular_list}">
	         <c:if test="${session_modular_big_list.modularParentId == session_modular_head_list.modularId}">
	         	<div>
	        		<div class="button" onclick="opentOrOff(this)">
	        			<img class="iocn" name="fawen" src="<%=path%>/static/images/fawen.png"/>
	        			<span title="${session_modular_big_list.modularName}" style="width:150px;text-overflow:ellipsis;white-space:nowrap;overflow:hidden;display:block;float:left;">${session_modular_big_list.modularName}</span>
	        		</div>
	        		<div class="nav-active">
	        		<c:forEach var="session_modular_list" items="${session_modular_list}">
	        		<c:if test="${session_modular_list.modularParentId == session_modular_big_list.modularId}">
	        		<a style="text-decoration:none;" href="<%=path%>${session_modular_list.modularUrl}" target="rightFrame${status.index+1}">
	        			<div class="erji erji1"  style="text-overflow:ellipsis;white-space:nowrap;overflow:hidden">
	        				
		                    	<span style=" line-height:46px;margin-left:80px;" title="${session_modular_list.modularName}">${session_modular_list.modularName}</span>
	        				
        				</div>
        			</a>
	        		</c:if>
	        		</c:forEach>
	        		</div>
        		</div>
	         </c:if>
	         </c:forEach>
	        </div>
	        <div class="main-right1">
       		<div class="right-main">
        		<div class="box">
        			<div class="box-main">
            			<iframe height="100%" width="100%" style="border:0;" src="" name="rightFrame${status.index+1}" id="rightFrame${status.index+1}" title="rightFrame${status.index+1}"></iframe>
            		</div>
            	</div>
            </div>
        </div>
        </div>
        </c:forEach>
    </div>
    <div class="footer">北京京铂儿有限公司 @ Copyright</div>
	<div id="bgDiv" style="display:none;"></div>
</body>
</html>

