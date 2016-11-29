<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<title>服务监控</title>
<link href="<%=path%>/static/css/base.css" rel="stylesheet" />
<link href="<%=path%>/static/js/jquery-easyui-1/themes/icon.css" rel="stylesheet" />
<link href="<%=path%>/static/js/jquery-easyui-1/themes/default/easyui.css" rel="stylesheet" />

<script type="text/javascript" src="<%=path%>/static/js/jquery-2.2.0.min.js"></script>
<script type="text/javascript" src="<%=path%>/static/js/jquery-easyui-1/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=path%>/static/js/jquery-easyui-1/locale/easyui-lang-zh_CN.js"></script>

<script type="text/javascript" src="<%=path%>/static/js/monitor/echarts.min.js"></script>
</head>
<style>
body{ margin:10px; padding:0; list-style:none;color:#8f8d88;}
.m-box{ border:1px solid #eaeaea; overflow:hidden;height:100%;}
.m-box-title{height:40px;line-height:40px;font-size:16px;font-family:'微软雅黑';font-weight:600;color:#00b471;}
.box{width:200px;height:200px;margin-left:10px;margin-bottom:10px;float:left;background:#fff;}
.box-title{width:100%;height:30px;line-height:30px;font-size:14px;font-family:'微软雅黑'; font-weight:600;padding-left:10px;}
.title-box{width:200px;height:40px;line-height:40px;font-size:14px;font-family:'微软雅黑'; font-weight:600; text-align:center;}
</style>

<body>
<div class="m-box">
  <c:forEach items="${monitorList}" var="monitorMap" varStatus="monitorIndex">
    <div class="m-box-title"><img style="vertical-align:middle;" src="<%=path%>/static/images/monitor/m-box-pic.png"/>认证服务器(${monitorMap.authServiceUrl})<c:choose><c:when test="${monitorMap.authServiceStatus=='1'}">(正常)</c:when><c:otherwise>(异常)</c:otherwise></c:choose></div>
    <c:forEach items="${monitorMap.serviceMonitorList}" var="servlist" varStatus="servIndex">
    <div style="background:#f6f6f6;height:auto;overflow: hidden;width:100%;margin-bottom:10px;">
      <div class="box-title">${servlist.serviceName}</div>
      <c:choose>
        <c:when test="${servlist.serviceOnOff=='1'}">
          <div class="box"><div class="title-box">通断<img style="vertical-align:middle;margin:0 0 0 10px;" src="<%=path%>/static/images/monitor/td.png"/></div><div style="width: 160px;height:160px;margin:0 20px;"><img style="margin:69px 50px;" src="<%=path%>/static/images/monitor/jt.png"/></div></div>
        </c:when>
        <c:otherwise>
          <div class="box"><div class="title-box">通断<img style="vertical-align:middle;margin:0 0 0 10px;" src="<%=path%>/static/images/monitor/td.png"/></div><div style="width: 160px;height:160px;margin:0 20px;"><img style="margin:69px 50px;" src="<%=path%>/static/images/monitor/dk.gif"/></div></div>
        </c:otherwise>
      </c:choose>
      <c:choose>
        <c:when test="${servlist.serviceReadDb=='1'}">
          <div class="box"><div class="title-box">读数据<img style="vertical-align:middle;margin:0 0 0 10px;" src="<%=path%>/static/images/monitor/dsj.png"/></div><div style="width: 160px;height:160px;margin:0 20px;"><img style="margin:69px 50px;" src="<%=path%>/static/images/monitor/jt.png"/></div></div>
        </c:when>
        <c:otherwise>
          <div class="box"><div class="title-box">读数据<img style="vertical-align:middle;margin:0 0 0 10px;" src="<%=path%>/static/images/monitor/dsj.png"/></div><div style="width: 160px;height:160px;margin:0 20px;"><img style="margin:69px 50px;" src="<%=path%>/static/images/monitor/dk.gif"/></div></div>
        </c:otherwise>
      </c:choose>
      <c:choose>
        <c:when test="${servlist.serviceWriteDb=='1'}">
          <div class="box"><div class="title-box">写数据<img style="vertical-align:middle;margin:0 0 0 10px;" src="<%=path%>/static/images/monitor/xsj.png"/></div><div style="width: 160px;height:160px;margin:0 20px;"><img style="margin:69px 50px;" src="<%=path%>/static/images/monitor/jt.png"/></div></div>
        </c:when>
        <c:otherwise>
          <div class="box"><div class="title-box">写数据<img style="vertical-align:middle;margin:0 0 0 10px;" src="<%=path%>/static/images/monitor/xsj.png"/></div><div style="width: 160px;height:160px;margin:0 20px;"><img style="margin:69px 50px;" src="<%=path%>/static/images/monitor/dk.gif"/></div></div>
        </c:otherwise>
      </c:choose>
      <div class="box"><div class="title-box">cpu利用率</div><div id="cpuAvg-${monitorIndex.index}-${servIndex.index}" style="width: 160px;height:160px;margin:0 20px;"></div></div>
      <div class="box"><div class="title-box">内存利用率</div><div id="memAvg-${monitorIndex.index}-${servIndex.index}" style="width: 160px;height:160px;margin:0 20px;"></div></div>
    </div>
    </c:forEach>
  </c:forEach>
</div>
</body>
<script type="text/javascript">
  var valueMap = {};
</script>

<c:forEach items="${monitorList}" var="monitorMap" varStatus="monitorIndex">
  <c:forEach items="${monitorMap.serviceMonitorList}" var="servlist" varStatus="servIndex">
  <script type="text/javascript">
    var cpuavg=0;
    var memavg=0;
    if("${servlist.serviceCpuAvg}" != ""){cpuavg=${servlist.serviceCpuAvg};}
    if("${servlist.servioceMemAvg}" != ""){memavg=${servlist.servioceMemAvg};}
    valueMap["cpuAvg-${monitorIndex.index}-${servIndex.index}"] = cpuavg;
    valueMap["memAvg-${monitorIndex.index}-${servIndex.index}"] = memavg;
  </script>
  </c:forEach>
</c:forEach>

<script type="text/javascript">

var initfunction = function(){
	for(var key in valueMap){
		var documId = key;
		//alert(documId);
		var documValue = valueMap[documId];
		var myChart = echarts.init(document.getElementById(documId));
		var cloumnName = "cpu";
		if(documId.indexOf('mem') >=0){
			cloumnName = "内存";
		}
		option = {
			tooltip:{formatter: "{a} <br/>{b} : {c}%"},
			toolbox:{show:true,feature : {
			            mark : {show: false},
			            restore : {show: false},
			            saveAsImage : {show: false}}
			},
			series:[
				{
					name:'业务指标',
					type:'gauge',
			        splitNumber: 10,       // 分割段数，默认为5
			        axisLine:{            // 坐标轴线
			        	lineStyle: {       // 属性lineStyle控制线条样式
			            	color: [[0.5, '#228b22'],[0.85, '#48b'],[1, '#ff4500']], 
			            	width: 2
			           	}
			        },
			        axisTick:{            // 坐标轴小标记
			        	splitNumber: 10,   // 每份split细分多少段
			        	length :4,        // 属性length控制线长
			        	lineStyle: {color: 'auto'}// 属性lineStyle控制线条样式   
			        },
			        axisLabel:{           // 坐标轴文本标签，详见axis.axisLabel
			        	textStyle:{       // 其余属性默认使用全局文本样式，详见TEXTSTYLE
			            	color: 'auto',
							fontSize: 12,
			            }
			        },
			        splitLine: {           // 分隔线
		                show: true,        // 默认显示，属性show控制显示与否
		                length :6,         // 属性length控制线长
		                lineStyle: {       // 属性lineStyle（详见lineStyle）控制线条样式
		                    color: 'auto'
		                }
			        },
			        pointer:{width : 5},
			        title:{
		                show : true,
		                offsetCenter: [0, '-40%'],       // x, y，单位px
		                textStyle: {       // 其余属性默认使用全局文本样式，详见TEXTSTYLE
		                    fontWeight: 'bolder',
		                  	fontSize: 12,
		                }
		            },
		            detail : {
		                formatter:'{value}%',
		                textStyle: {       // 其余属性默认使用全局文本样式，详见TEXTSTYLE
		                    color: 'auto',
		                    fontWeight: 'bolder',
		                  fontSize: 14,
		                }
		            },
		            data:[{value:documValue, name:cloumnName}]
		        }
		    ]
		};
		myChart.setOption(option);
	}
}
initfunction();
</script>
<script type="text/javascript">
var checkServiceStatus = function(){
	//alert("1");
	//window.location.reload();
}
setTimeout('checkServiceStatus()',300000);
</script>
</html>