<%@page import="com.dcits.djk.manager.vo.PostRoleDataLevel"%>
<%@page import="com.dcits.djk.manager.single.model.BhSysUserRoleInfo"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	/* List<PostRoleDataLevel> roleList = (List<PostRoleDataLevel>)request.getAttribute("roleList"); */
	
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
 body {
        padding-bottom: 40px;
    }
.datagrid-view{
    height:31px;
    }

 @media (max-width: 980px) {
     /* Enable use of floated navbar text */
     .navbar-text.pull-right {
         float: none;
         padding-left: 5px;
         padding-right: 5px;
     }
 }
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
.btn {
    border-image: none;
    border-radius: 4px;
    border-style: solid;
    border-width: 1px;
    box-shadow: 0 1px 0 rgba(255, 255, 255, 0.2) inset, 0 1px 2px rgba(0, 0, 0, 0.05);
    cursor: pointer;
    display: inline-block;
    font-size: 14px;
    line-height: 20px;
    margin-bottom: 0;
    padding: 4px 12px;
    text-align: center;
    vertical-align: middle;
}
.btn-success {
    background-color: #5bb75b;
    background-image: linear-gradient(to bottom, #62c462, #51a351);
    background-repeat: repeat-x;
    border-color: rgba(0, 0, 0, 0.1) rgba(0, 0, 0, 0.1) rgba(0, 0, 0, 0.25);
    color: #ffffff;
    text-shadow: 0 -1px 0 rgba(0, 0, 0, 0.25);
}
.btn-primary {
    background-color: #006dcc;
    background-image: linear-gradient(to bottom, #0088cc, #0044cc);
    background-repeat: repeat-x;
    border-color: rgba(0, 0, 0, 0.1) rgba(0, 0, 0, 0.1) rgba(0, 0, 0, 0.25);
    color: #ffffff;
    text-shadow: 0 -1px 0 rgba(0, 0, 0, 0.25);
}
</style>
<script type="text/javascript">
	$(document).ready(function(){
		$.ajaxSetup({
			//关闭AJAX相应的缓存
			cache:false
		});
		var postid=$.trim($("#postId").val());
		if(postid==''){
			//新增岗位
			$('#dg').datagrid({    
				url:'<%=path%>/userSystem/postInfo/getRoles.do',
		        columns:[[    
			        {field:'role_name',title:'角色名称',width:'100%',align:'center'},
			        {field:'role_id',title:'角色ID',hidden:true}
			        ]] ,
			        onDblClickRow:function(rowIndex,rowData){
			        	 var rightrows= $('#dg1').datagrid('getRows');//获取当前页所有的选项
				           //判断右边表中是否已经添加选中的记录
					   	 for(var k=0;k<rightrows.length;k++){
						   			if(rowData.role_id==rightrows[k].roleid){
						   			$.messager.alert("系统提示","已经添加了"+rowData.role_name+"角色");
										return false;
						   				
						   			}
						   			
					   		  }
			          	$('#dg1').datagrid('appendRow',{selectname:rowData.role_name,roleid:rowData.role_id  ,datalevel:"<input  name='"+rowData.role_id+"' type='radio' id='my' value='1' checked='checked'> 自己"+
			        		"<input type='radio' name='"+rowData.role_id+"' id='mydepart' value='2' > 部门 <input type='radio' name='"+rowData.role_id+"' id='subdepart' value='3' > 下级部门 "  });
			        },
			        singleSelect: true,
					rownumbers:true,

		     });  
		    $('#dg1').datagrid({
		        columns:[[ 
				        {field:'selectname',title:'角色名称',width:'40%',align:'center'},    
				        {field:'datalevel',title:'数据级别',width:'50%',align:'center' },
				        {field:'roleid',title:'角色ID',hidden:true}
				        ]],
				        onDblClickRow:function(rowIndex,rowData){
				        	$('#dg1').datagrid('deleteRow', rowIndex);  
				        },
				  singleSelect: true,
				  rownumbers:true,
	        });
		    $('#dg1').datagrid('appendRow', {});
		    $('#dg1').datagrid('deleteRow', 0);
			$("#add_selected").bind('click', function(){
		        var rows= $('#dg').datagrid('getSelections');//获取选中的选项
		        var rightrows= $('#dg1').datagrid('getRows');//获取当前页所有的选项
	           //判断右边表中是否已经添加选中的记录
		   	 for(var k=0;k<rightrows.length;k++){
			   		for(var j=0;j<rows.length;j++){
			   			if(rows[j].role_id==rightrows[k].roleid){
			   			$.messager.alert("系统提示","已经添加了"+rows[j].role_name+"角色");
							return false;
			   				
			   			}
			   			
			   		   }
		   		  }
		     //追加给对方  
		        for(var i=0;i<rows.length;i++){
		        		$('#dg1').datagrid('appendRow',{selectname:rows[i].role_name,roleid:rows[i].role_id  ,datalevel:"<input  name='"+rows[i].role_id+"' type='radio' id='my' value='1' checked='checked'> 自己"+
			        		"<input type='radio' name='"+rows[i].role_id+"' id='mydepart' value='2' > 部门 <input type='radio' name='"+rows[i].role_id+"' id='subdepart' value='3' > 下级部门 "  });
		        	
		        }
		   		 
		      
		    });
		    $("#remove_selected").bind('click', function(){
		    	var rows= $('#dg1').datagrid('getSelections'); //获取选中的选项  
		    	 for(var i=0;i<rows.length;i++){
		    		 if (rows[i]) {
		    	          var rowIndex = $('#dg1').datagrid('getRowIndex', rows[i]);
		    	          $('#dg1').datagrid('deleteRow', rowIndex);  
		    	          $('#dg1').datagrid('reload');//删除后重新加载下
		    	  } 
			        }
		    	
		    })  
		    $("#add_all").bind('click', function(){
		    	 var rows= $('#dg').datagrid('getRows');//获取选中的选项
		    	 var rightrows= $('#dg1').datagrid('getRows');//获取当前页所有的选项
		           //判断右边表中是否已经添加选中的记录
			   	 for(var k=0;k<rightrows.length;k++){
				   		for(var j=0;j<rows.length;j++){
				   			if(rows[j].role_id==rightrows[k].roleid){
				   			$.messager.alert("系统提示","已经添加了"+rows[j].role_name+"角色");
								return false;
				   				
				   			}
				   			
				   		   }
			   		  }
			     //追加给对方  
			        for(var i=0;i<rows.length;i++){
			        		$('#dg1').datagrid('appendRow',{selectname:rows[i].role_name,roleid:rows[i].role_id  ,datalevel:"<input  name='"+rows[i].role_id+"' type='radio' id='my' value='1' checked='checked'> 自己"+
				        		"<input type='radio' name='"+rows[i].role_id+"' id='mydepart' value='2' > 部门 <input type='radio' name='"+rows[i].role_id+"' id='subdepart' value='3' > 下级部门 "  });
			        	
			        }
			        
		    });
		    $("#remove_all").bind('click', function(){ 
		    	var rows= $('#dg1').datagrid('getRows'); //获取选中的选项 
		    	 for(var i=rows.length;i>=0;i--){
		    	          var rowIndex = $('#dg1').datagrid('getRowIndex', rows[i]);
		    	          $('#dg1').datagrid('deleteRow', rowIndex);  
		    	      
			        }
		    }) 
			
		}else{
			//编辑岗位
			$('#comments').val("${post.comments}");
			$('#dg').datagrid({    
				url:'<%=path%>/userSystem/postInfo/getRoles.do',
		        columns:[[    
			        {field:'role_name',title:'角色名称',width:'100%',align:'center'},
			        {field:'role_id',title:'角色ID',hidden:true}
			        ]] ,
			        onDblClickRow:function(rowIndex,rowData){
			        	 var rightrows= $('#dg1').datagrid('getRows');//获取当前页所有的选项
				           //判断右边表中是否已经添加选中的记录
					   	 for(var k=0;k<rightrows.length;k++){
						   			if(rowData.role_id==rightrows[k].roleid){
						   			$.messager.alert("系统提示","已经添加了"+rowData.role_name+"角色");
										return false;
						   				
						   			}
						   			
					   		  }
			          	$('#dg1').datagrid('appendRow',{selectname:rowData.role_name,roleid:rowData.role_id  ,datalevel:"<input  name='"+rowData.role_id+"' type='radio' id='my' value='1' checked='checked'> 自己"+
			        		"<input type='radio' name='"+rowData.role_id+"' id='mydepart' value='2' > 部门 <input type='radio' name='"+rowData.role_id+"' id='subdepart' value='3' > 下级部门 "  });
			        },
			        singleSelect: true,
					rownumbers:true,
		     });  
		    $('#dg1').datagrid({
		        columns:[[ 
				        {field:'selectname',title:'角色名称',width:'40%',align:'center'},    
				        {field:'datalevel',title:'数据级别',width:'50%' ,align:'center'},
				        {field:'roleid',title:'角色ID',hidden:true}
				        ]],
				        onDblClickRow:function(rowIndex,rowData){
				        	$('#dg1').datagrid('deleteRow', rowIndex);  
				        },   
				  singleSelect: true,
				  rownumbers:true,
				  onBeforeLoad:function(data){
					  $.ajax({
							 url:"<%=path%>/userSystem/postInfo/getHaveRoles.do",    //请求的url地址
							 dataType:"json",   //返回格式为json
							 async:false,//请求是否异步，默认为异步，这也是ajax重要特性
							 data:{"postId":postid},    //参数值
							 type:"POST",   //请求方式
						     success:function(data){
						    	 var le = data.length;
						    	 //把查询到的已分配的角色增加到已选择的位置去
	                         for(var i=0;i <le;i++){
	                        	 var radioHtml="<input  name="+data[i].roleId+" type= 'radio'  id="+data[i].roleId+"_1  value='1'/>自己"+
	                        	 "<input type='radio' name="+data[i].roleId+" id="+data[i].roleId+"_2  value='2' > 部门"+ 
		        		            "<input type='radio' name="+data[i].roleId+" id="+data[i].roleId+"_3 value='3' > 下级部门";
	        		              $('#dg1').datagrid('appendRow',{selectname:data[i].roleName,roleid:data[i].roleId  ,datalevel:radioHtml });
	        		              $("input[name='"+data[i].roleId+"'][value='"+data[i].dateLevel+"']").attr("checked",true);
	                         }	 
						     },
						     error:function(){
						        //请求出错处理
						        alert("请求异常");
						     }
						});
					  
					  
				  }
		    
	        });
		   //判断元素是否在数组中
		   function IsInArray(elem,array){
			   var len=array.length;
			   for(var i=0;i<len;i++){
				   if(elem.roleid==array[i].role_id){
					   return false;
				   }
				   
			   }
			   return true;
			   
		   }
			$("#add_selected").bind('click', function(){
		        var rows= $('#dg').datagrid('getSelections');//获取选中的选项
		        var rightrows= $('#dg1').datagrid('getRows');//获取当前页所有的选项
		        if(rows.length==0){$.messager.alert("系统提示","请选择要添加的角色");}
	           //判断右边表中是否已经添加选中的记录
		        for(var k=0;k<rightrows.length;k++){
			   		for(var j=0;j<rows.length;j++){
			   			if(rows[j].role_id==rightrows[k].roleid){
			   			$.messager.alert("系统提示","已经添加了"+rows[j].role_name+"角色");
							return false;
			   				
			   			}
			   			
			   		   }
		   		  }
		   //追加给对方  
		        for(var i=0;i<rows.length;i++){
		        		$('#dg1').datagrid('appendRow',{selectname:rows[i].role_name,roleid:rows[i].role_id  ,datalevel:"<input  name='"+rows[i].role_id+"' type='radio' id='my' value='1' checked='checked'> 自己"+
			        		"<input type='radio' name='"+rows[i].role_id+"' id='mydepart' value='2' > 部门 <input type='radio' name='"+rows[i].role_id+"' id='subdepart' value='3' > 下级部门 "  });
		        	
		        }

		    });
			//双击行记录添加到右边
		    $("#remove_selected").bind('click', function(){
		    	var rows= $('#dg1').datagrid('getSelections'); //获取选中的选项  
		    	  if(rows.length==0){$.messager.alert("系统提示","请选择要移除的角色");}
		    	 for(var i=0;i<rows.length;i++){
		    		 if (rows[i]) {
		    	          var rowIndex = $('#dg1').datagrid('getRowIndex', rows[i]);
		    	          $('#dg1').datagrid('deleteRow', rowIndex);  
		    	         
		    	  } 
			        }
		    	
		    })  
		    $("#add_all").bind('click', function(){
		    	 var rows= $('#dg').datagrid('getRows');//获取选中的选项
		    	 var rightrows= $('#dg1').datagrid('getRows');//获取当前页所有的选项
		    	  if(rows.length==0){$.messager.alert("系统提示","暂未分配角色");}
		           //判断右边表中是否已经添加选中的记录
			        for(var k=0;k<rightrows.length;k++){
				   		for(var j=0;j<rows.length;j++){
				   			if(rows[j].role_id==rightrows[k].roleid){
				   			$.messager.alert("系统提示","已经添加了"+rows[j].role_name+"角色");
								return false;
				   				
				   			}
				   			
				   		   }
			   		  }
			     //追加给对方  
			     for(var i=0;i<rows.length;i++){
		        		$('#dg1').datagrid('appendRow',{selectname:rows[i].role_name,roleid:rows[i].role_id  ,datalevel:"<input  name='"+rows[i].role_id+"' type='radio' id='my' value='1' checked='checked'> 自己"+
			        		"<input type='radio' name='"+rows[i].role_id+"' id='mydepart' value='2' > 部门 <input type='radio' name='"+rows[i].role_id+"' id='subdepart' value='3' > 下级部门 "  });
		        	
		        }
			        
		    });
		    $("#remove_all").bind('click', function(){ 
		    	var rows= $('#dg1').datagrid('getRows'); //获取选中的选项 
		    	 for(var i=rows.length;i>=0;i--){
		    	          var rowIndex = $('#dg1').datagrid('getRowIndex', rows[i]);
		    	          $('#dg1').datagrid('deleteRow', rowIndex);  
		    	      
			        }
		    }) 
		}
	   
	});
	
	var toPostList = function() {
		window.location.href = "<%=path%>/userSystem/postInfo/toPostList.do";
	}
		var saveOrEditPostInfo = function(){
			var postid=$.trim($("#postId").val());
			var postName=$.trim($("#postName").val());
			var comments=$.trim($("#comments").val());
			var rows=$("#dg1").datagrid('getRows');
			var len=rows.length;
			var rowid=new Array();
			var datalev=new Array();
			if(len>0){
				for(var i = 0; i < len; i++){
					var datal = $("input[name='"+rows[i].roleid+"']:checked").val();
					rowid.push(rows[i].roleid);
					datalev.push(datal);
				}
			}
			if(postName==null||postName==''){
				$.messager.alert("系统提示","岗位名称不能为空！");
				return false;
			}
			 if(len==0){
				$.messager.alert("系统提示","角色不能为空！");
				return false;
			} 
			if(postid==''){
				//新增岗位
				$.ajax({
					 url:"<%=path%>/userSystem/postInfo/postSave.do",    //请求的url地址
					 dataType:"json",   //返回格式为json
					 async:false,//请求是否异步，默认为异步，这也是ajax重要特性
					 data:{"postName":postName,
						   "comments":comments,
						   "rowid":rowid,
						   "datalev":datalev
					 },    //参数值
					 type:"POST",   //请求方式
				     success:function(data){
				    	 if(data.code == '01'){
				    		 //请求成功时处理
				    		 window.location.href = '<%=path%>/userSystem/postInfo/toPostList.do';
				    	 } else{
				    		 $.messager.alert("系统提示",data.msg);
				    	 } 
				     },
				     error:function(){
				        //请求出错处理
				        alert(123);
				     }
				});
			}else{
				//编辑岗位信息
				$('#comments').val("${post.comments }");
				$.ajax({
					 url:"<%=path%>/userSystem/postInfo/editPostInfo.do",    //请求的url地址
					 dataType:"json",   //返回格式为json
					 async:false,//请求是否异步，默认为异步，这也是ajax重要特性
					 data:{"postId":postid,
						  "postName":postName,
						  "comments":comments,
						 "rowid":rowid,
						 "datalev":datalev
					 },    //参数值
					 type:"POST",   //请求方式
				     success:function(data){
				    	 if(data.code == '01'){
				    		 //请求成功时处理
					    	 window.location.href = "<%=path%>/userSystem/postInfo/toPostList.do";
				    	 }else{
				    		 $.messager.alert("系统提示",data.msg);
				    	 }
				     },
				     error:function(){
				        //请求出错处理
				        alert(456);
				     }
				});
			}
		}
		
		$.extend($.fn.validatebox.defaults.rules, {    
		    maxLength: {    
		        validator: function(value, param){    
		            return value.length <= param[0];    
		        },    
		        message: '请最多输入 {0}个 字符.'   
		    }    
		});  


		
</script>
<meta charset="utf-8">
<title>岗位信息管理</title>
</head>
<body>
<form  id="postinfo"  method="post" class="definewidth m20">
    <table class="table table-bordered table-hover definewidth m10">
        <tr>
            <td width="10%" class="tableleft">岗位名称</td>
            <td><input type="text" id="postName" name="postName" class="easyui-validatebox" value="${post.postName}" data-options="required:true,validType:['length[0,50]']" style="width: 200px;"/></td>
        </tr>
        <tr >
            <td class="tableleft">描述</td>
            <td colspan="5" >
           <textarea name="comments" id="comments"  class="textarea easyui-validatebox" data-options="validType:'maxLength[0，100]'" maxlength='180' style="width:100%"></textarea>
            </td>
        </tr>
        <tr>
            <td class="tableleft">角色分配</td>
             <td colspan="5">
             <div style="float:left;display:inline;width:42%;height:205px;background:#fafafa;border:1px solid #ccc">
			   <div style="text-align:center;"><font size="15" color=blue>所有角色(双击添加)</font></div>
                <div style=" overflow:auto;width:100%;height:186px; ">
                 <div id="dg"></div>
                </div>
             </div>
             <div style="float:left;display:inline;margin-left:3%;width:10%;height:205px;line-height:50px;">
				<!-- <div style="margin-top:2px;margin-left:10px;"><input type="button" value="选中右移" id="add_selected" /></div>  -->
                <div style="margin-top:50px;margin-left:10px;"><input type="button" value="全部右移" id="add_all" /> </div>
               <!--  <div style="margin-top:2px;margin-left:10px;"><input type="button" value="选中移除" id="remove_selected" /></div> -->
				<div style="margin-top:10px;margin-left:10px;"><input type="button" value="全部移除" id="remove_all" /></div>
			</div>
             <div style="float:left;display:inline;margin-left:3%;width:41.5%;height:205px;background:#fafafa;border:1px solid #ccc">
					<div style="text-align:center;"><font size="15" color=red>已选中角色（双击移除）</font></div>
					 <div style=" overflow:auto;width:100%;height:186px; ">
					<div id="dg1"></div>
					</div>
				</div>
             </td>
        </tr>
    </table>
     <p style="text-align:center;"><br/>
                <input type="hidden" value="${post.postId }" name="postId" id="postId" />
                <input type="hidden" value="${roleList}" name="roleId" id="roleId" />
                <a href="javascript:void(0)" id="saveButton" class="standard-button" onclick="saveOrEditPostInfo(this)">保存</a>
	            <a href="javascript:void(0)" id="backid" class="standard-button" onclick="toPostList()">返回列表</a>
            </p>
</form>
<div >
</div>
</body>
</html>