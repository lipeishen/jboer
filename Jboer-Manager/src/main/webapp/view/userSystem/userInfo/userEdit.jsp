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
 .sav { width: 90%; margin-left: 20%; margin-top: 10px; float: left;} 
</style>
<script type="text/javascript">
var loginFlag = true; 
var numFlag = true;  
var rows;
	$(document).ready(function(){
		$.ajaxSetup({
			//关闭AJAX相应的缓存
			cache:false
		});
		$('#fm').submit(function (e) {        	
 	        e.preventDefault();
			var url ="<%=path%>/userSystem/userInfo/userSave.do?postRows="+JSON.stringify(rows);
 	        $.ajax({
 	            url: url,
 	            type: 'POST',
 	            dataType:"json",
 	            data: new FormData(this),
 	            processData: false,
 	            contentType: false
 	        }).done(function (result){
				$('#saveButton').attr("onclick","saveOrEditUserInfo(this)");
 	        	document.getElementById("saveButton").className = "standard-button";
 	        	if(result.success){
					window.location.href = "<%=path%>/userSystem/userInfo/toUserList.do?modularId=${modularId }";
				}else{
					$.messager.alert("系统提示",result.errorMsg);
					return;
				} 
 	        }).fail(function (data){
 	        	$('#saveButton').attr("onclick","saveOrEditUserInfo(this)");
 	        	document.getElementById("saveButton").className = "standard-button";
 	        	$.messager.alert("系统提示","保存失败");
 	        	return;
 	        });
 	    });
		$('#comments').val("${sysuser.comments }");
		var userId = $('#userId').val();
        
        $("#orgPost").datagrid({
        	toolbar:[{
				text:'添加',
				iconCls:'icon-add',
				handler:function(){
					chooseOP();
				}
			},'-',{
				text:'删除',
				iconCls:'icon-remove',
				handler:function(){
					deleteOrgPost();
				}
			}],
    		method:"post",
    		url:"<%=path%>/userSystem/userInfo/getUserRels.do?userId="+ userId,
    		title:"",iconCls:"icon-save",pagination:"true",
    		pagination : false,
    		rownumbers:"true",border:"true",height:230,
    		columns:[ [
    	    	{title:"机构id",field:"org_id",width:"1%",align:"center" ,hidden:true },
    			{title:"机构名称",field:"org_name",width:"44%",align:"center"},
    			{title:"岗位名称",field:"post_name",width:"44%",align:"center"},
    	    	{title:"岗位id",field:"post_id",width:"1%",align:"center" ,hidden:true },
    	    	/* {title:"操作",field:"user_org_id",width:"16%",align:"center",
    				formatter:function(value, rowData,rowIndex) {
    					var userId = "\""+rowData.user_id+"\"";
    					var htmlDelete = "<a href='javascript:void(0)' onclick='deleteOrgPost("+userId+")'>删除</a>";
    					return htmlDelete;
    				}
    			}  */
    		] ]
    	});
        
	});

	var saveOrEditUserInfo = function(e){
		var userId = $('#userId').val();
		var name = $('#name').val();
		var loginName = $('#loginName').val();
		var staffNum = $('#staffNum').val();
		if(name==""){
			$.messager.alert("系统提示","用户名称不能为空！");
			return;
		}
		if(loginName==""){
			$.messager.alert("系统提示","登录名称不能为空！");
			return;
		}
		if(loginName.length < 6 || loginName.length > 20){
			$.messager.alert("系统提示","登录名称的长度必须在6-20之间！");
			return;
		}
		if (!/^[\w]+$/.test(loginName)) {
			$.messager.alert("系统提示","登录名称只能包含 字母 数字 _");
			return;
         } 
		if(staffNum==""){
			$.messager.alert("系统提示","员工编号不能为空！");
			return;
		}
		if (!/^[\w]+$/.test(staffNum)) {
			$.messager.alert("系统提示","员工编号只能包含 字母 数字 _");
			return;
         } 
		if(!numFlag){
			$.messager.alert("系统提示","员工编号不能重复！");
			return;
		}
		if(!loginFlag){
			$.messager.alert("系统提示","登录名称不能重复！");
			return;
		}
		//判断是否维护了权限
		rows = $("#orgPost").datagrid("getRows"); 
		if(rows.length < 1){
			$.messager.alert("系统提示","请维护用户权限!");
			return;
		}
		e.removeAttribute('onclick');
		document.getElementById("saveButton").className = "standard-disable-button";
		//新增用户提交数据
        $('#fm').submit();
	};
	
	var toUserList = function() {
		window.location.href = "<%=path%>/userSystem/userInfo/toUserList.do?modularId=${modularId }";
	}

	$.extend($.fn.validatebox.defaults.rules, {    
		//验证登录名称不能重复 
		singLoginName: {   
			validator: function (loginName) {    
				var userId = $("#userId").val();
				//var flag = true;     
				$.ajax({       
					type: "post",       
					async: false,       
					url: "<%=path%>/userSystem/userInfo/checkLoginName.do?loginName="+loginName+"&userId="+userId,       
					success: function(result){
						var results=eval('('+result+')');
						loginFlag = results.success;
					}     
				});           
			return loginFlag;   
		},   
		message: '登录名称重复'
		} 
	});  
	$.extend($.fn.validatebox.defaults.rules, {    
		//验证登录名称不能重复 
		singStaffNum: {   
			validator: function (staffNum) {    
				var userId = $("#userId").val();
				//var flag = true;     
				$.ajax({       
					type: "post",   
					//dataType:"json",
					async: false,       
					url: "<%=path%>/userSystem/userInfo/checkStaffNum.do?staffNum="+staffNum+"&userId="+userId,       
					success: function(result){
						var results=eval('('+result+')');
						numFlag = results.success;
					}     
				});           
			return numFlag;   
		},   
		message: '员工编号重复'
		} 
	});
	$.extend($.fn.validatebox.defaults.rules, {    
		//只能包含 _ 数字 字母
		account: {   
			validator: function (value, param) {
	            if (value.length < param[0] || value.length > param[1]) {
	                $.fn.validatebox.defaults.rules.account.message = "长度必须在" + param[0] + "至" + param[1] + "之间";
	                return false;
	            } else {
	                if (!/^[\w]+$/.test(value)) {
	                    $.fn.validatebox.defaults.rules.account.message = "只能包含 字母 数字 _";
	                    return false;
	                } else {
	                    return true;
	                }
	            }
	        },message: "只能包含 _ 数字 字母"
		}
	});
	function chooseOP(){
		//清空表单内容
		$('#fmOP').form('clear');
		//清空岗位的选择项
		$("#postId_sel2").empty();  
		var userId = $('#userId').val();
		//加载所有岗位
		var allPost;
		$.post('<%=path%>/userSystem/userInfo/getPosts.do?modularId=${modularId}',function(result){
			allPost = result;
			 $("#postId_sel1").empty();    
			for(var i=0;i<allPost.length;i++){
				$('#postId_sel1').append("<option value="+allPost[i].post_id+">"+allPost[i].post_name+"</option>");
			}
		},'json');
		//添加选中的岗位
		/* $("#add_selected").bind('click', function(){  
	        $options = $("#postId_sel1 option:selected"); //获取选中的选项  
	        $options.appendTo('#postId_sel2');            //追加给对方  
	    })  
	    //移除选中的岗位
	    $("#remove_selected").bind('click', function(){  
	        $options = $("#postId_sel2 option:selected"); //获取选中的选项  
	        $options.appendTo('#postId_sel1');            //追加给对方  
	    })   */
	    //添加所有的岗位
	    $("#add_all").bind('click', function(){  
	        var orgPosts = [];
    	 	var choose_orgId = $('#choose_orgId').combobox('getValue');
    	 	var rows = $("#orgPost").datagrid("getRows");
    	 	var flag = false;
    	 	for(var i=0;i<rows.length;i++)  
    	 	{  
    	    	var orgPost = rows[i]; 
    	     	var org_id = orgPost.org_id;
    	     	if(org_id == choose_orgId){
    		     	var post_id = orgPost.post_id;
    		     	orgPosts.push(post_id);
    	     	}
    	 	}
	        $("#postId_sel1 option").each(function(){
	            var numIndex = $.inArray($(this).val(), orgPosts);
	            if(numIndex != "-1"){
	            	flag = true;
	            }
	        });
	        if(flag){
	        	$.messager.alert("系统提示","该机构下已选择的岗位不能重复选择，请重新选择！");
    			return;
	        }
    	 	$options = $("#postId_sel1 option");  //获取选中的选项 
	        $options.appendTo('#postId_sel2');            //追加给对方  
	    })  
	    //移除所有的岗位
	    $("#remove_all").bind('click', function(){  
	        $options = $("#postId_sel2 option");          //获取选中的选项  
	        $options.appendTo('#postId_sel1');            //追加给对方  
	    }) 
	    //双击选项
        $('#postId_sel1').dblclick(function(){     //绑定双击事件
        	var orgPosts = [];
    	 	var choose_orgId = $('#choose_orgId').combobox('getValue');
    	 	var rows = $("#orgPost").datagrid("getRows");
    	 	for(var i=0;i<rows.length;i++)  
    	 	{  
    	    	var orgPost = rows[i]; 
    	     	var org_id = orgPost.org_id;
    	     	if(org_id == choose_orgId){
    		     	var post_id = orgPost.post_id;
    		     	orgPosts.push(post_id);
    	     	}
    	 	}
    	 	var numIndex = $.inArray($("option:selected",this).val(), orgPosts);
    	 	if(numIndex != "-1"){
    	 		var choose_orgName = $('#choose_orgId').combobox('getText');
    	 		var post_name = $("option:selected",this).text();
    	 		$.messager.alert("系统提示",choose_orgName+" 的岗位： "+post_name+" 已选择，不能重复选择，请选择其他岗位！");
    			return;
    	 	}
            //获取选项,删除并追加给对方
            $("option:selected",this).appendTo('#postId_sel2');     //追加给对方
        });
        //双击选项
        $('#postId_sel2').dblclick(function(){
            $("option:selected",this).appendTo('#postId_sel1');
        });
        $("#choose_orgId").combobox({
	       	onChange: function (n,o) {
	       	 	$options = $("#postId_sel2 option"); //获取选中的选项  
		        $options.appendTo('#postId_sel1');            //追加给对方  
	       	}
        });
		$("#dlg").dialog('open').dialog('setTitle','选择机构及对应的岗位');
	}
	function saveOrgPost(){
		var choose_orgId = $('#choose_orgId').combobox('getValue');
		var choose_orgName = $('#choose_orgId').combobox('getText');
		if (choose_orgId == "")
		{
			$.messager.alert("系统提示","请选择机构");
			return;
		}
		var postId_sel2 = $("#postId_sel2 option");
		if(postId_sel2.length > 0){
    		for(var i=0;i<postId_sel2.length;i++)  
            {  
                var postId = postId_sel2[i].value; 
                var postName = postId_sel2[i].text;
                $('#orgPost').datagrid('appendRow',{
                	org_id: choose_orgId,
                	org_name: choose_orgName,
                	post_name: postName,
                	post_id: postId
                });
            }
    		$('#dlg').dialog('close');
    	}else{
    		$.messager.alert("系统提示","请选择岗位");
    		return;
    	}
	}
	function deleteOrgPost(e){
		var rows = $('#orgPost').datagrid('getSelections');
		if(rows.length > 0){
			for (var i = rows.length - 1; i >= 0; i--) {  
				var rowIndex = $('#orgPost').datagrid('getRowIndex', rows[i]);
				$('#orgPost').datagrid('deleteRow', rowIndex); 
			}  
	        var newRows = $('#orgPost').datagrid("getRows");
	        $('#orgPost').datagrid("loadData", newRows);
		}else{
			$.messager.alert("系统提示","请选择需要删除的记录!");
			return;
		}
	}
</script>
<meta charset="utf-8">
<title>用户信息管理</title>
</head>
<body>
<form id="fm" method="post" class="definewidth m20">
    <table class="table table-bordered table-hover definewidth m10">
        <tr>
            <td class="tableleft">用户名称:</td>
            <td><input type="text" name="name" id="name" value="${sysuser.name }" class="easyui-validatebox" data-options="required:true,validType:['length[0,25]']" style="width: 200px;"></td>
            <td class="tableleft">登录名称:</td>
	        <td><input type="text" name="loginName" id="loginName" value="${sysuser.loginName }"  class="easyui-validatebox" data-options="required:true,validType:['singLoginName','account[6,20]']" style="width: 200px;" ></td>
        </tr>
        <tr>
	        <td class="tableleft">员工编号:</td>
	        <td><input type="text" name="staffNum" id="staffNum" value="${sysuser.staffNum }" class="easyui-validatebox" data-options="required:true,validType:['singStaffNum','account[0,20]']" style="width: 200px;" ></td>
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
            <textarea name="comments" id="comments" value="${sysuser.comments }" class="textarea easyui-validatebox" data-options="required:false,validType:['length[0,100]']" style="width:100%"></textarea>
          </td>
        </tr>
    </table>
    <h2 align="center">用户权限列表</h2>
   <table id="orgPost" style="height: 100%;width:98%"></table>
    <p style="text-align:center;"><br/>
    <input type="hidden" name="userId" id="userId" value="${sysuser.userId }"  />
    <input type="hidden" name="orgId" id="orgId"  />
	<input type="hidden" name="password" id="password" value="${sysuser.password }"  />
	<input type="hidden" name="postId" id="postId" />
	<a href="javascript:void(0)" id="saveButton" class="standard-button" onclick="saveOrEditUserInfo(this)">保存</a>
	<a href="javascript:void(0)" id="backid" class="standard-button" onclick="toUserList()">返回列表</a>
	</p>
</form>
<div id="dlg" class="easyui-dialog" style="width: 780px; padding: 5px 4px" closed="true" modal="true" buttons="#dlg-buttons">
	<form id="fmOP" method="post">
	 <table cellspacing="10px;">
	 <tr>
        <td class="tableleft">组织机构:</td>
        <td>
			<input id="choose_orgId" class="easyui-combobox" name="choose_orgId" data-options="valueField:'org_id',textField:'org_name',url:'<%=path%>/userSystem/common/getOrgs.do?modularId=${modularId}'"  style="width: 75%;height: 30px;"/>
        </td>
      </tr>
      <tr>
        <td class="tableleft">岗位:</td>
        <td>
			<div style="float:left;display:inline;  width:270px;height:220px;background:#fafafa;border:1px solid #ccc;margin:5px;margin-top:10px;">
		    	<div>未选中岗位<font size="8" color=red> 双击选择</font></div>
			    <select id="postId_sel1" multiple style="width:270px;height:200px;">  
				</select> 
	    	</div>
	    	<div style="float:left;display:inline;margin-left:30px;width:80px;height:220px;background:#fafafa;line-height:40px;margin:5px;margin-top:10px;">
				<div class="sav">
					<!-- <input type="button" value="选中右移" id="add_selected" /> 
					<input type="button" value="选中左移" id="remove_selected" /> -->
					<input type="button" value="全部右移" id="add_all" /> 
					<input type="button" value="全部左移" id="remove_all" />
				</div>
			</div>
			<div style="float:left;display:inline;margin-left:30px;width:270px;height:220px;background:#fafafa;border:1px solid #ccc;margin:5px;margin-top:10px;">
				<div>已选中岗位<font size="8" color=red> 双击移除</font></div>
				<select id="postId_sel2" multiple style="width:270px;height:200px;"></select>
			</div>
	 	</td>
    </tr>
    </table>
	</form>
</div>
<div id="dlg-buttons">
	<p style="text-align:center;"><br/>
		<a href="javascript:void(0)" id="saveOrgPostButton" class="standard-button" onclick="saveOrgPost()">确定</a>
		<a href="javascript:void(0)" id="saveOrgPostButton" class="standard-button" onclick="javascript:$('#dlg').dialog('close')">关闭</a>
	</p>
</div>
</body>
</html>