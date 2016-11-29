jQuery.extend(jQuery.validator.messages, {
	required : "必选字段",
	remote : "请修正该字段",
	email : "请输入正确格式的电子邮件",
	url : "请输入合法的网址",
	date : "请输入合法的日期",
	dateISO : "请输入合法的日期 (ISO).",
	number : "请输入合法的数字",
	digits : "只能输入整数",
	creditcard : "请输入合法的信用卡号",
	equalTo : "请再次输入相同的值",
	accept : "请输入拥有合法后缀名的字符串",
	maxlength : jQuery.validator.format("请输入一个 长度最多是 {0} 的字符串"),
	minlength : jQuery.validator.format("请输入一个 长度最少是 {0} 的字符串"),
	rangelength : jQuery.validator.format("请输入 一个长度介于 {0} 和 {1} 之间的字符串"),
	range : jQuery.validator.format("请输入一个介于 {0} 和 {1} 之间的值"),
	max : jQuery.validator.format("请输入一个最大为{0} 的值"),
	min : jQuery.validator.format("请输入一个最小为{0} 的值")
});
$(document).ready(function() {
	// 特殊字符验证
	jQuery.validator.addMethod("stripscript", function(value, element) {
		return stripscript(value);
	}, "标题不要填写特殊字符");
	// ljf 接口管理 用户名唯一
	// jQuery.validator.addMethod("unInterfaceUser", function(value, element) {
	// return this.optional(element) || unInterfaceUser(value);
	// }, "此用户名已存在！");
	// ljf 接口管理 用户名唯一
	jQuery.validator.addMethod("unOrgInfoByCode", function(value, element) {
		return this.optional(element) || unOrgInfoByCode(value);
	}, "此机构编码已存在！");
});
// 机构编码唯一
function unOrgInfoByCode(value) {
	return true;
}
// 用户名唯一
// function unInterfaceUser(value) {
// var hosId = $("#hosId").val();
// var channel = $("#channel").val();
// var InterfaceUserName = $("#username").val();
// var interfaceManagId=$("#interfaceManagIdHiddenInput").val();
// if (!!channel) {
// if(channel=='77'){
// alert("此渠道不能操作！");
// return false;
// }
// }else{
// alert("请选择渠道！");
// return false;
// }
// $.ajax({
// type: "POST",
// url:
// "<%=path%>/medical/interfacemanag/interface_manag/interfaceManag/isHaveUserName",
// data:
// {username:value,InterfaceUserName:InterfaceUserName,interfaceManagId:interfaceManagId,channel:channel,hosId:hosId},
// dataType: "json",
// async:false,
// success: function(data){
// data1 = data;
// },
// error : function(XMLHttpRequest, textStatus, errorThrown) {
// if(XMLHttpRequest.responseText.indexOf('/index.jsp') >= 0){
// document.write(XMLHttpRequest.responseText);
// }else{
// return false;
// }
// }
// });
// if(data1.resultval == "yes"){
// return false;
// }
// return true;
// }
// 判断特殊字符
function stripscript(s) {
	var pattern = new RegExp(
			"[`~%\_+!@#$^&*=|{}':;',\\[\\].<>/?~！@#￥……&*——|{}（）【】‘；：”“'。，、？]");
	var rs = pattern.test(s);
	if (rs) {
		// alert("标题不要填写特殊字符");
		return false;
	}
	return true;
}
