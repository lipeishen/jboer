$.extend($.fn.validatebox.defaults.rules, {
	phone : {
		validator : function(value) {
			var mobile = /^(((13[0-9]{1})|(15[0-9]{1})|(17[0-9]{1})|(18[0-9]{1}))+\d{8})$/;
			if (mobile.test(value)) {
				return true;
			} else {
				return false;
			}
		},
		message : '请输入正确电话号码',
	},
	isTel : {
		validator : function(value) {
			var mobile = /^(((13[0-9]{1})|(15[0-9]{1})|(17[0-9]{1})|(18[0-9]{1}))+\d{8})$/;
			var tel = /^(\d{3,4}-?)?\d{7,9}$/;
			if (mobile.test(value) || tel.test(value)) {
				return true;
			} else {
				return false;
			}
		},
		message : '请输入正确的联系方式',
	},
	digist : {
		validator : function(value) {
			var number = /^\d+$/;
			if (number.test(value)) {
				return true;
			} else {
				return false;
			}
		},
		message : '请输入正整数',
	},
	digistOrz : {
		validator : function(value) {
			var number = /^\d+$/;
			if (number.test(value)) {
				return true;
			} else {
				return false;
			}
		},
		message : '请输入0或正整数',
	},
	isBlank: {
         validator: function (value) {
        	 return $.trim(value) != '' 
         },
         message: '该输入项为必填项'
     }
});
