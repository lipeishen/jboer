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
		<div data-options="region:'west',collapsible:false" title="功能模块" style="width:20%;padding:10px">
			<ul class="easyui-tree"  id="tt"></ul>
		</div>
		<div id="mm" class="easyui-menu" style="width:120px;">
			<div onclick="append()" data-options="iconCls:'icon-add'">新增资源</div>
			<div onclick="del()" data-options="iconCls:'icon-remove'">删除资源</div>
		</div>
		<div id="yy" class="easyui-menu" style="width:120px;">
			<div onclick="del()" data-options="iconCls:'icon-remove'">删除资源</div>
		</div>
		<div data-options="region:'center',title:'模块列表',iconCls:'icon-ok'">
		<div style="heigh: 8px; line-height: 8px; font-size: 20px; font-weight: bold; text-align: center; margin-bottom: 10px;"></div>
			<table style="width: 100%;margin-bottom:10px;">
				<tr>
					<td style="font-size: 12px;width: 30%;text-align:center;">
						<span style="height:30px;vertical-align:middle;font-weight:bold;width:40%;text-align:right">模块名称:</span> 
						<input id="serch_name" name="serch_name" style="width: 50%;" />
					</td>
					<td style="font-size: 12px;width: 30%;text-align:center;">
						<span style="height:30px;vertical-align:middle;font-weight:bold;width:40%;text-align:right">模块编码:</span> 
						<input id="serch_modularCode" name="serch_modularCode" style="width: 50%;" />
					</td>
					<td style="font-size: 12px;width: 30%;text-align:center;" colspan="2">
						<a href="javascript:void(0)"  id="select" onclick="queryModularList()"  class="standard-button" >查询</a>
						<a href="javascript:void(0)"  id="select" onclick="clearAll()"  class="standard-button" >重置</a>
					</td>
				</tr>
			</table>
			<table id="datagrid" style="height: 100%;"></table>
		</div>
		<input type="hidden" name="parentId" id="parentId"/>
	<div id="dlg" class="easyui-dialog" style="width:600px;padding:10px 8px"
            data-options="modal:true,closed:true"  buttons="#dlg-buttons">
        <form id="fm" method="post">
        <input type="hidden" name="modularId" id="modularId" />
  		<input type="hidden" name="modularParentId" id="modularParentId" />
        	<table cellspacing="10px;">
        		 <tr>
			        <td>模块编码:</td>
			        <td><input type="text" name="modularCode" id="modularCode" class="easyui-validatebox" data-options="required:true,validType:['length[0,10]']"  style="width: 200px;"></td>
			      </tr>
			      <tr>
			        <td>模块名称:</td>
				    <td><input type="text" class="easyui-validatebox" required="true"  id="modularName" name="modularName" multiple style="width:200px"/></td>
			      </tr>
			      <tr>
			      	<td>模块地址:</td>
			        <td colspan="3"><input type="text" name="modularUrl" id="modularUrl" class="easyui-validatebox" required="true" style="width: 200px;" ></td>
			      </tr>
			      <tr>
			        <td>描述:</td>
			        <td colspan="3"><textarea rows="2" cols="30"name="comments" id="comments" class="easyui-validatebox" data-options="validType:['length[0,100]']" style="width: 450px;" ></textarea></td>
			      </tr>
        	</table>
        </form>
	</div>
	<div id="dlg-buttons">
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveModular()">保存</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">关闭</a>
	</div>
	</div>
</body>
<script type="text/javascript">
$(document).ready(function(){
	$.ajaxSetup({
		//关闭AJAX相应的缓存
		cache:false
	});
	$('#tt').tree({
	    url: "<%=path%>/userSystem/modularInfo/treeLoad.do",
	    loadFilter: function(data){
			if (data.d){
				return data.d;
			} else {
				return data;
			}
	    },
	    onClick: function(node){
	    	//根据ID查询，加载右侧列表
	    	$('input[name="serch_name"]').val("");
			$('input[name="serch_modularCode"]').val("");
			$('input[name="parentId"]').val("");
	    	$("#parentId").val(node.id);
	    	queryModularList();
		},
		//双击
		onDblClick:function(node){
	    	editModular(node.id);
		},
		//树右键
		onContextMenu: function(e, node){
			e.preventDefault();
			// select the node
			$('#tt').tree('select', node.target);
			var node1 = $('#tt').tree('getParent',node.target);
			if(node1){
				var node2 = $('#tt').tree('getParent',node1.target);
				if(node2){
					var node3 = $('#tt').tree('getParent',node2.target);
					if(node3){
						$('#yy').menu('show', {
							left: e.pageX,
							top: e.pageY
						});
					}else{
						// display context menu
						$('#mm').menu('show', {
							left: e.pageX,
							top: e.pageY
						});
					}
				}else{
					$('#mm').menu('show', {
						left: e.pageX,
						top: e.pageY
					});
				}
			}else{
				$('#mm').menu('show', {
					left: e.pageX,
					top: e.pageY
				});
			}
		}
	});
	//右侧列表
	$("#datagrid").datagrid({
		method:"post",
		url:"<%=path%>/userSystem/modularInfo/getModularList.do",
	   onLoadSuccess: function (data) {  
            if (data.total == 0) {  
                //添加一个新数据行，第一列的值为你需要的提示信息，然后将其他列合并到第一列来，注意修改colspan参数为你columns配置的总列数  
                $(this).datagrid('appendRow', { modularCode: '<div style="text-align:center;color:red">没有相关记录！</div>' }).datagrid('mergeCells', { index: 0, field: 'modularCode', colspan: 5 })  
                //隐藏分页导航条，这个需要熟悉datagrid的html结构，直接用jquery操作DOM对象，easyui datagrid没有提供相关方法隐藏导航条  
                $(this).closest('div.datagrid-wrap').find('div.datagrid-pager').hide();  
            }  
            //如果通过调用reload方法重新加载数据有数据时显示出分页导航容器  
            else $(this).closest('div.datagrid-wrap').find('div.datagrid-pager').show();  
        },
		title:"",iconCls:"icon-save",pagination:"true",
		pagePosition:"bottom",pageNumber:1,pageSize:10,pageList:[10,20],striped:"true",fitColumns:"true",nowrap:"true",singleSelect:"true",
		rownumbers:"true",border:"false",idField:"id",height:"89%",
		columns:[ [
			{title:"编码",field:"modularCode",width:"8%",align:"center"},
			{title:"模块名称",field:"modularName",width:"20%",align:"center"},
			{title:"模块地址",field:"modularUrl",width:"30%",align:"center"},
			{title:"描述",field:"comments",width:"30%",align:"center"},
			{title:"操作",field:"modularId",width:"10%",align:"center",
				formatter:function(value, rowData,rowIndex) {
					var htmlEdit = "<a href='javascript:void(0)' onclick='editModular(\""+rowData.modularId+"\")'>编辑</a>";
					var htmlDelete = "<a href='javascript:void(0)' onclick='deleteModular(\""+rowData.modularId+"\")'>删除</a>";
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
		$("#modularParentId").val(node.id);
	};
	//删除子节点
	function del(){
		var node = $('#tt').tree('getSelected');
		var modularId=node.id;
		deleteModular(modularId);
	};
	//保存
	function saveModular(){
		$('#fm').form('submit',{
			url:"<%=path%>/userSystem/modularInfo/saveModular.do",
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
					$.messager.alert("系统提示","保存成功");
					$('#dlg').dialog('close');
					var id = $("#modularId").val();
					if(id==''){
						var t = $('#tt');
						var node = t.tree('getSelected');
						t.tree('append', {
							parent: (node?node.target:null),
							data: [{
								id : result.data.modularId,
								text: result.data.modularName
							}]
						}); 
					}
					$('#tt').tree('reload');
					$("#datagrid").datagrid("reload");
				}
			},
			error:function(result){
				$.messager.alert("系统提示","保存失败");
			}
		});
	}
	//查询
	var queryModularList = function(){
		$('#datagrid').datagrid('load',{  
			name:$('input[name="serch_name"]').val(),
			modularCode:$('input[name="serch_modularCode"]').val(),
			modularId:$('input[name="parentId"]').val()
		});
	}
	//重置
	var clearAll = function(){
		$('input[name="serch_name"]').val("");
		$('input[name="serch_modularCode"]').val("");
		$('input[name="parentId"]').val("");
		$('#tt').find('.tree-node-selected').removeClass('tree-node-selected');
	}
	//编辑模块
	function editModular(modularId){
		if(modularId != ""){ 
			$("#dlg").dialog('open').dialog('setTitle','编辑模块');
			$.post('<%=path%>/userSystem/modularInfo/getModularById.do?modularId='+modularId,function(result){
				if(result.success){
					$('#fm').form('load',result.data);
				}else{
					$.messager.alert("系统提示",result.errorMsg);
				}
			},'json');
		}
	}
	function deleteModular(modularId){
		if(modularId != ""){ 
			$.messager.confirm("系统提示","您确定要删除这条记录吗?",function(r){
				if(r){
					$.post('<%=path%>/userSystem/modularInfo/deleteModular.do?modularId='+modularId,function(result){
						if(result.success){
							$.messager.alert("系统提示","已成功删除这条记录!");
							$("#datagrid").datagrid("reload");
							$('#tt').tree('reload');
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