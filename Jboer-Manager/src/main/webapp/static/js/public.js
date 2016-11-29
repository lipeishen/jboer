function addTitle(value){
	if(value==null || typeof(value)=="undefined"){
		return "";
	}else if(value.indexOf("没有相关记录")>0){
		return value;
	}else{
		return "<span title=\"" + value + "\">" + value+ "</span>";
	}
}

function formateDate(value){
	if(value==null || value.toString()==""){
		return "";
	}
	var now=new Date(value.time);
	var year = now.getFullYear();       //年
    var month = now.getMonth() + 1;     //月
    var day = now.getDate();            //日
    var hh = now.getHours();            //时
    var mm = now.getMinutes();          //分
    var clock = year + "-";
    if(month < 10)
        clock += "0";
    clock += month + "-";
    if(day < 10)
        clock += "0";
    clock += day + " ";
    if(hh < 10)
        clock += "0";
    clock += hh + ":";
    if (mm < 10) clock += '0';
    clock += mm;
	return "<span title=\"" + clock + "\">" + clock+ "</span>";
}

var openOrOff = function(obj){
	if($(obj).attr("class") == "biaodan-content-nav-active"){
		$(obj).removeClass("biaodan-content-nav-active").addClass('biaodan-content-nav');
		$(obj).next().show(100);
	}else{
		$(obj).removeClass("biaodan-content-nav").addClass('biaodan-content-nav-active');
		$(obj).next().hide(100);
	}
}

/* 身份证校验规则
1、15位身份证号码组成：
	ddddddyymmddxxs共15位，其中：
	dddddd为6位的地方代码，根据这6位可以获得该身份证号所在地。
	yy为2位的年份代码，是身份证持有人的出身年份。
	mm为2位的月份代码，是身份证持有人的出身月份。
	dd为2位的日期代码，是身份证持有人的出身日。
	这6位在一起组成了身份证持有人的出生日期。
	xx为2位的顺序码，这个是随机数。
	s为1位的性别代码，奇数代表男性，偶数代表女性。
2、18位身份证号码组成：
	ddddddyyyymmddxxsp共18位，其中：
	其他部分都和15位的相同。年份代码由原来的2位升级到4位。最后一位为校验位。
	校验规则是：
	（1）十七位数字本体码加权求和公式 
	S = Sum(Ai * Wi), i = 0, ... , 16 ，先对前17位数字的权求和 
	Ai:表示第i位置上的身份证号码数字值 
	Wi:表示第i位置上的加权因子 
	Wi: 7 9 10 5 8 4 2 1 6 3 7 9 10 5 8 4 2 
	（2）计算模 
	Y = mod(S, 11) 
	（3）通过模得到对应的校验码 
	Y: 0 1 2 3 4 5 6 7 8 9 10 
	校验码: 1 0 X 9 8 7 6 5 4 3 2
	也就是说，如果得到余数为1则最后的校验位p应该为对应的0.如果校验位不是，则该身份证号码不正确。	
*/

var powers=new Array("7","9","10","5","8","4","2","1","6","3","7","9","10","5","8","4","2");   
var parityBit=new Array("1","0","X","9","8","7","6","5","4","3","2");   
var sex;   
//校验身份证号码的主调用   

function validId(obj){   
    var _id=obj;   
    if(_id=="")return;   
    var _valid=false;   
    if(_id.length==15){   
         _valid=validId15(_id);   
     }else if(_id.length==18){   
         _valid=validId18(_id);   
     }   
    if(!_valid){   
        return false;   
     }  
    return true;
 }       
//校验18位的身份证号码   

function validId18(_id){ 
	var promoterSex = $('#promoterSex').combobox('getValue');
     _id=_id+"";   
    var _num=_id.substr(0,17);   
    var _parityBit=_id.substr(17);   
    var _power=0;   
    for(var i=0;i< 17;i++){   
        //校验每一位的合法性   

        if(_num.charAt(i)<'0'||_num.charAt(i)>'9'){   
            return false;   
            break;   
         }else{   
            //加权   
             _power+=parseInt(_num.charAt(i))*parseInt(powers[i]);   
            //校验性别   
            if(i==16){  
            	if(parseInt(_num.charAt(i))%2==0){
            		sex="F";
            	}else{
               	 sex="M";
                }
                           	 
             }else{
            	 continue;
             }
            if(promoterSex!=sex){
            	return false;
            	break;
            }
         }   
     }   
    //取模   

    var mod=parseInt(_power)%11;   
    if(parityBit[mod]==_parityBit){   
        return true;   
     }else{
    	 return false;
     }   
    return true;   
 }   
//校验15位的身份证号码   

function validId15(_id){   
     _id=_id+"";   
    for(var i=0;i<_id.length;i++){   
        //校验每一位的合法性   

        if(_id.charAt(i)<'0'||_id.charAt(i)>'9'){   
            return false;   
            break;   
         }   
     }   
    var year=_id.substr(6,2);   
    var month=_id.substr(8,2);   
    var day=_id.substr(10,2);   
    var sexBit=_id.substr(14);   
    //校验年份位   

    if(year<'01'||year >'90')return false;   
    //校验月份   

    if(month<'01'||month >'12')return false;   
    //校验日   

    if(day<'01'||day >'31')return false;   
    //设置性别   

    if(sexBit%2==0){   
         sex="F";   
     }else{   
         sex="M";   
     }   
    return true;   
 }  