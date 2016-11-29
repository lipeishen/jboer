<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<title>Basic Tree - jQuery EasyUI Demo</title>
<link href="<%=path%>/static/css/base.css" rel="stylesheet" />
<link href="<%=path%>/static/js/jquery-easyui-1/themes/icon.css" rel="stylesheet" />
<link href="<%=path%>/static/js/jquery-easyui-1/themes/default/easyui.css" rel="stylesheet" />
<script type="text/javascript" src="<%=path%>/static/js/jquery-2.2.0.min.js"></script>
<script type="text/javascript" src="<%=path%>/static/js/jquery-easyui-1/jquery.easyui.min.js"></script>
<script src="<%=path%>/static/js/validatejs/vendor/jquery.validate-1.13.1.js" type="text/javascript"></script>
<script src="<%=path%>/static/js/validatejs/vendor/mc.public.js" type="text/javascript"></script>
<script type="text/javascript" src="<%=path%>/static/js/jquery-easyui-1/locale/easyui-lang-zh_CN.js"></script>
<style>
* {font-family: '微软雅黑';font-size: 14px;margin: 0;padding: 0;}
td {height: 32px;color: #505052;padding-left：10px;}
input {height: 30px;width: 70%;border: 1px solid #cbcbcd;color: #666;line-height: 28px;font-size: 14px;}
select {height: 30px;width: 70%;background: #ededef;border: 1px solid #cbcbcd;color: #666;font-size: 14px;}
</style>
</head>
<body >
	<div class="easyui-layout" data-options="fit:true" >
		<div data-options="region:'west'" title="组织机构" style="width:25%;padding:10px">
			<ul class="easyui-tree"  id="tt"></ul>
		</div>
		<div id="mm" class="easyui-menu" style="width:120px;">
			<div onclick="append()" data-options="iconCls:'icon-add'">增加机构</div>
			<div onclick="removeOrg()" data-options="iconCls:'icon-remove'">删除机构</div>
		</div>
		<div data-options="region:'center',title:'机构列表',iconCls:'icon-ok'" >
		<div style="heigh: 8px; line-height: 8px; font-size: 20px; font-weight: bold; text-align: center; margin-bottom: 10px;"></div>
			<table style="width: 100%;margin-bottom:10px;">
				<tr>
					<td style="font-size: 12px;width: 30%;text-align:center;">
						<span style="height:30px;vertical-align:middle;font-weight:bold;width:40%;text-align:right">机构名称:</span> 
						<input id="serch_name" name="serch_name" style="width: 50%;" />
					</td>
					<td style="font-size: 12px;width: 30%;text-align:center;">
						<span style="height:30px;vertical-align:middle;font-weight:bold;width:40%;text-align:right">机构编码:</span> 
						<input id="serch_orgCode" name="serch_orgCode" style="width: 50%;" />
					</td>
					<td style="font-size: 12px;width: 30%;text-align:center;" colspan="2">
						<a href="javascript:void(0)" class="standard-button" onclick="queryOrgList()">查询</a>
				        <a href="javascript:void(0)" class="standard-button" onclick="clearAll()">重置</a>
					</td>
				</tr>
			</table>
			<table id="datagrid" style="height: 100%;width:97%"></table>
		</div>
		<input type="hidden" name="modularId" id="modularId" value="${modularId}" />
		<input type="hidden" name="parentOrgId" id="parentOrgId" value="${modularId}" />
	<div id="dlg" class="easyui-dialog" style="width:600px;padding:10px 8px"
            data-options="modal:true,closed:true"  buttons="#dlg-buttons">
        <form id="fm" method="post">
  		<input type="hidden" name="orgId" id="orgId" />
  		<input type="hidden" name="orgParentId" id="orgParentId" />
        	<table cellspacing="10px;">
        		  <tr>
			        <td>机构编码:</td>
			        <td><input type="text" name="orgCode" id="orgCode" class="easyui-validatebox" required="true"  style="width: 200px;" maxlength="200" /></td>
			      </tr>
			      <tr>
			         <td>机构名称:</td>
				     <td><input type="text" class="easyui-validatebox" required="true"  id="orgName" name="orgName" multiple style="width:200px" maxlength="45"  /></td>
			      </tr>
			      <tr>
			        <td>描述:</td>
			        <td colspan="3"><textarea rows="2" cols="30"name="comments" id="comments" class="easyui-validatebox"  style="width: 450px;" maxlength="180"></textarea></td>
			     </tr>
        	</table>
        </form>
	</div>
	<div id="dlg-buttons">
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveOrgInfo()">保存</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">关闭</a>
	</div>
	</div>
</body>
<script type="text/javascript">
var modularId = $("#modularId").val();
$(document).ready(function(){
	var parentOrgId = $("#parentOrgId").val();
	$('#tt').tree({
	    url:"<%=path%>/userSystem/orgInfo/getOrgIdTree.do?modularId="+modularId,
	    loadFilter: function(data){
	    	//debugger;
			if (data.d){
				return data.d;
			} else {
				return data;
			}
	    },
	    onClick: function(node){
	    	//根据ID查询，加载右侧列表
	    	$("#orgParentId").val(node.id);
	    	queryOrgList();
		},
		//双击
		onDblClick:function(node){
			editOrg(node.id);
		},
		//树右键
		onContextMenu: function(e, node){
			e.preventDefault();
			// select the node
			$('#tt').tree('select', node.target);
			// display context menu
			$('#mm').menu('show', {
				left: e.pageX,
				top: e.pageY
			});
		}
	});
	//右侧列表
	$("#datagrid").datagrid({
		method:"post",
		url:"<%=path%>/userSystem/orgInfo/getOrgList.do?modularId="+modularId,
		title:"",iconCls:"icon-save",pagination:"true",
		pagePosition:"bottom",pageNumber:1,pageSize:10,pageList:[10,20],striped:"true",fitColumns:"true",nowrap:"true",singleSelect:"true",
		rownumbers:"true",border:"true",idField:"id",height:470,
		columns:[ [
			{title:"机构名称",field:"orgName",width:"30%",align:"center"},
			{title:"机构编码",field:"orgCode",width:"10%",align:"center"},
			{title:"描述",field:"comments",width:"48%",align:"center"},
			{title:"操作",field:"orgId",width:"11%",align:"center",
				formatter:function(value, rowData,rowIndex) {
					var htmlEdit = "<a href='javascript:void(0)' onclick='editOrg(\""+rowData.orgId+"\")'>编辑</a>";
					var htmlDelete = "<a href='javascript:void(0)' onclick='deleteOrg(\""+rowData.orgId+"\")'>删除</a>";
					return htmlEdit + "&nbsp" + htmlDelete;
				}
			} 
		] ]
	});
})
	//添加子节点
	function append(){
		var t = $('#tt');
		var node = t.tree('getSelected');
		$("#dlg").dialog('open').dialog('setTitle','新增模块');
		$('#fm').form('clear');
		//$("#modularParentName").val(node.text);
		$("#orgParentId").val(node.id);
	/* 	t.tree('append', {
			parent: (node?node.target:null),
			data: [{
				text: 'new item1'
			},{
				text: 'new item2'
			}]
		}); */
	};
	//删除子节点
	function removeOrg(){
		var node = $('#tt').tree('getSelected');
		var orgId=node.id;
		deleteOrg(orgId);
	}
	//保存
	function saveOrgInfo(){
		$('#fm').form('submit',{
			url:"<%=path%>/userSystem/orgInfo/saveOrgInfo.do",
			/* onSubmit:function(){
				//return $(this).form('validate');
				$('#orgId_edit').combotree('getValues');
				return true;
			}, */
			success:function(result){
				var result=eval('('+result+')');
				if(result.errorMsg){
					$.messager.alert("系统提示",result.errorMsg);
					return;
				}else{
				//	var id = $("#orgId").val();
					$.messager.alert("系统提示","保存成功");
					$('#dlg').dialog('close');
					//var id = $("#orgId").val();
					/* if(id==''){
						var t = $('#tt');
						var node = t.tree('getSelected');
						t.tree('append', {
							parent: (node?node.target:null),
							data: [{
								id : result.data.orgId,
								text: result.data.orgName
							}]
						}); 
					} */
					$('#tt').tree({url:"<%=path%>/user/addJgReflushOrgIdTree.do?modularId="+modularId},'reload');
					$("#datagrid").datagrid("reload");
				}
			},
			error:function(result){
				$.messager.alert("系统提示","保存失败");
			}
		});
	}
	//查询
	var queryOrgList = function(){
		$('#datagrid').datagrid('load',{  
			serch_name:$('input[name="serch_name"]').val(),
			serch_orgCode:$('input[name="serch_orgCode"]').val(),
			orgParentId:$('input[name="orgParentId"]').val()
		});
	}
	//重置
	var clearAll = function(){
		$('input[name="serch_name"]').val("");
		$('input[name="serch_orgCode"]').val("");
		$('input[name="orgId"]').val("");
		$('input[name="orgParentId"]').val("");
		$('#tt').find('.tree-node-selected').removeClass('tree-node-selected');
	}
	//编辑模块
	function editOrg(selforgId){
		if(selforgId != ""){ 
			$("#dlg").dialog('open').dialog('setTitle','编辑机构');
			$.post('<%=path%>/userSystem/orgInfo/getOrgById.do?selforgId='+selforgId,function(result){
				if(result.success){
					$('#fm').form('load',result.data);
				}else{
					$.messager.alert("系统提示",result.errorMsg);
				}
			},'json');
		}
	}
	function deleteOrg(orgId){
		if(orgId != ""){ 
			$.messager.confirm("系统提示","您确定要删除这条记录吗?",function(r){
				if(r){
					$.post('<%=path%>/userSystem/orgInfo/deleteOrgInfo.do?orgId='+orgId,function(result){
						if(result.success){
							$.messager.alert("系统提示","已成功删除这条记录!");
							$("#datagrid").datagrid("reload");
							$('#tt').tree({url:"<%=path%>/userSystem/orgInfo/getOrgIdTree.do?modularId="+modularId},'reload');
						}else{
							$.messager.alert("系统提示",result.errorMsg);
						}
					},'json');
				}
			});
		}
	}
</script>
</html>