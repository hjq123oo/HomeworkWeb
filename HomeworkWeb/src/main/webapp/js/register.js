$(document).ready(function(){
	window.checkArray = new Array(8);

	function initInfo(){
		for(i = 0; i < 8; i++){
			checkArray[i] = false;
		}
	}
	
	//检查角色
	function checkRole(){
		var teaEle = document.getElementById("role_teacher");
		var stuEle = document.getElementById("role_student");
		
		if(teaEle.checked){
			document.getElementById("regDiv_tea").style.display="block"; 
			document.getElementById("regDiv_stu").style.display="none";  
		}else if(stuEle.checked){
			document.getElementById("regDiv_tea").style.display="none";  
			document.getElementById("regDiv_stu").style.display="block";  
		}
	}
	
	$("#reg_account_stu").keyup(function(){
		var value = $("#reg_account_stu").val();
		if(value == "" || value == null){
			$("#reg_account_stu_text").text("账号信息不得为空");
		}else{
			if(value.length <= 6 || value.length >= 18){
				$("#reg_account_stu_text").text("账号信息为6-18个字符");
			}
			else{
				document.getElementById(text).innerHTML = "";
				checkArray[0] = true;
			}
		}
	});
	
});





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
    if(!(event.keyCode==46) && !(event.keyCode==8) && !(event.keyCode==37) && !(event.keyCode == 39))
    	
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

//ajax响应学生注册
$(document).ready(function(){
	$("#stu_reg").click(function (){
		
		 $("#stu_reg").attr({"disabled":"disabled"});
		
		 $.ajax({
			type: "post",
			url: "/HomeworkWeb/student/add",
			data: {name:$("#reg_account_stu").val(),
				pwd:$("#reg_password_stu").val(),
				school:$("#reg_school_stu").val(),
				college:$("#reg_dept_stu").val(),
				className:$("#reg_class_stu").val(),
				studentNO:$("#reg_number_stu").val(),
				realname:$("#reg_name_stu").val(),
				email:$("#reg_email_stu").val(),
				phone:$("#reg_phone_stu").val()
				},
			dataType : "json",
			success : function(data) {
				
				if(data.success == "true"){
					window.location.href = "/HomeworkWeb/";
					
				}else if(data.success == "false"){
					alert("信息有误");
					$("#stu_reg").removeAttr("disabled");
				}
				
			},
			error : function() {
				$("#stu_reg").removeAttr("disabled");
			}
		});	
	});
});


//ajax响应教师注册
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
				if(data.success == "true"){
					window.location.href = "/HomeworkWeb/";
					
				}else if(data.success == "false"){
					alert("信息有误");
					$("#stu_reg").removeAttr("disabled");
				}
			},
			error : function() {
				$("#tea_reg").removeAttr("disabled");
			}
		});	
	});
});



