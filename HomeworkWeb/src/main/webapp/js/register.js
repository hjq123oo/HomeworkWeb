window.checkArray = new Array(8);

function initInfo(){
	for(i = 0; i < 8; i++){
		checkArray[i] = false;
	}
}

function checkRole(){
	var teaEle = document.getElementById("role_teacher");
	var stuEle = document.getElementById("role_student");
	
	if(teaEle.checked){
		document.getElementById("regForm2").style.display="block"; 
		document.getElementById("regForm").style.display="none";  
	}else if(stuEle.checked){
		document.getElementById("regForm2").style.display="none";  
		document.getElementById("regForm").style.display="block";  
	}
}

//检查账号信息
function checkStuAccount(infoId){
	var value = document.getElementById(infoId).value;
	var text = infoId + "_text";

	if(value == "" || value == null){
		document.getElementById(text).innerHTML = "账号信息不得为空";
	}
	else{
		if(value.length <= 6 || value.length >= 18){
			document.getElementById(text).innerHTML = "账号信息为6-18个字符";
		}
		else{
			document.getElementById(text).innerHTML = "";
			checkArray[0] = true;
		}
	}
}

//检查密码信息
function checkStuPassword(infoId, number){
	//如果是第一次输入密码
	if(number == 1){
		var value = document.getElementById(infoId).value;
		var text = infoId + "_text";

		if(value == "" || value == null){
			document.getElementById(text).innerHTML = "密码不得为空";
		}
		else{
			if(value.length <= 6 || value.length >= 18){
				document.getElementById(text).innerHTML = "密码信息为6-18个字符";
			}
			else{
				document.getElementById(text).innerHTML = "";

				
					checkArray[1] = true;
			}
		}
	}
	

	//如果是第二次输入密码
	else if(number == 2){
		var firstInput = document.getElementById("reg_password_stu").value;
		var value = document.getElementById(infoId).value;
		
		var text = infoId + "_text";

		if(value != firstInput){
			document.getElementById(text).innerHTML = "密码不相符";
		}else{
			document.getElementById(text).innerHTML = "";
			checkArray[2] = true;
		}

	}
}

//检查学生信息
function checkStuInfo(infoId, number){
	var info = new Array("学校","学院","班级","学号","姓名");

	var value = document.getElementById(infoId).value;
	var text = infoId + "_text";

	if(value == "" || value == null){
		document.getElementById(text).innerHTML = info[number-1] + "不得为空";
	}
	else{
		document.getElementById(text).innerHTML = "";
		checkArray[number+2] = true;
	}
}

function checkEmailInfo(infoId){
	
	var regx = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;

	var value = document.getElementById(infoId).value;
	var text = infoId + "_text";

	if(!regx.test(value)){
		document.getElementById(text).innerHTML = "邮箱格式错误";
	}
	else{
		document.getElementById(text).innerHTML = "";
	}
}

//只允许输入整数
function onlyNum() {
    if(!(event.keyCode==46) && !(event.keyCode==8) && !(event.keyCode==37) && !(event.keyCode==39))

    if( !( (event.keyCode>=48 && event.keyCode<=57) || (event.keyCode>=96 && event.keyCode<=105) ) )
    	event.returnValue=false;
}

//提交事件
function checkSubmit(){
	for(var i = 0; i < 8; i++){
		if(checkArray[i]){
			continue;
		}else{
			for(i = 0; i < 8; i++){
				checkArray[i] = false;
			}
			return false;
		}
	}
	return true;
}



$(document).ready(function(){
	$("#tea_reg").click(function (){
		
		 $("#tea_reg").attr({"disabled":"disabled"});
		
		 $.ajax({
			type: "post",
			url: "/HomeworkWeb/teacher/add",
			data: {name:$("#reg_account_tea").val(),
				pwd:$("#reg_password_tea").val(),
				school:$("#reg_school_tea").val(),
				teacherNO:$("#reg_number_tea").val(),
				realname:$("#reg_name_tea").val(),
				email:$("#reg_email_tea").val(),
				phone:$("#reg_phone_tea").val()
				},
			dataType : "json",
			success : function(data) {
				alert(data.success);
				
			},
			error : function() {
				
				$("#postBtn").removeAttr("disabled");
			}
		});	
	});
});



