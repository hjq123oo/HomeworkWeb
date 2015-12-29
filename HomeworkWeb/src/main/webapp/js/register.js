$(document).ready(function(){
	window.checkArray = new Array(8);

	function initInfo(){
		for(i = 0; i < 8; i++){
			checkArray[i] = false;
		}
	}
	
	window.checkTeacher = new Array(6);

	function initTeacherInfo(){
		for(i = 0; i < 6; i++){
			checkTeacher[i] = false;
		}
	}
	
	//学生账号
	$("#reg_account_stu").keyup(function(){
		var value = $("#reg_account_stu").val();
		if(value == "" || value == null){
			$("#reg_account_stu_text").text("账号信息不得为空");
		}else{
			if(value.length <= 6 || value.length >= 18){
				$("#reg_account_stu_text").text("账号信息为6-18个字符");
			}
			else{
				$("#reg_account_stu_text").text("");
				checkArray[0] = true;
			}
		}
	});
	
	//学生密码
	$("#reg_password_stu").keyup(function(){
		var value = $("#reg_password_stu").val();
		if(value == "" || value == null){
			$("#reg_password_stu_text").text("密码不得为空");
			checkArray[1] = false;
		}else{
			if(value.length <= 6 || value.length >= 18){
				$("#reg_password_stu_text").text("密码为6-18个字符");
				checkArray[1] = false;
			}
			else{
				$("#reg_password_stu_text").text("");
				checkArray[1] = true;
			}
		}
	});
	
	//学生密码2
	$("#reg_password_stu2").keyup(function(){
		var value = $("#reg_password_stu2").val();
		
		if(value == $("#reg_password_stu").val()){
			$("#reg_password_stu2_text").text("");
			checkArray[2] = true;
		}else{
			$("#reg_password_stu2_text").text("两次密码不相符");
			checkArray[2] = false;
		}
	});
	
	//学生学校
	$("#reg_school_stu").keyup(function(){
		var value = $("#reg_school_stu").val();
		if(value == "" || value == null){
			$("#reg_school_stu_text").text("学校信息不得为空");
			checkArray[3] = false;
		}else{
			$("#reg_school_stu_text").text("");
			checkArray[3] = true;
		}
	});
	
	//学生学院
	$("#reg_dept_stu").keyup(function(){
		var value = $("#reg_dept_stu").val();
		if(value == "" || value == null){
			$("#reg_dept_stu_text").text("学院信息不得为空");
			checkArray[4] = false;
		}else{
			$("#reg_dept_stu_text").text("");
			checkArray[4] = true;
		}
	});
	
	//学生班级
	$("#reg_class_stu").keyup(function(){
		var value = $("#reg_class_stu").val();
		if(value == "" || value == null){
			$("#reg_class_stu_text").text("班级信息不得为空");
			checkArray[5] = false;
		}else{
			$("#reg_class_stu_text").text("");
			checkArray[5] = true;
		}
	});
	
	//学生学号
	$("#reg_number_stu").keyup(function(){
		var value = $("#reg_number_stu").val();
		if(value == "" || value == null){
			$("#reg_number_stu_text").text("学号信息不得为空");
			checkArray[6] = false;
		}else{
			$("#reg_number_stu_text").text("");
			checkArray[6] = true;
		}
	});
	
	//学生姓名
	$("#reg_name_stu").keyup(function(){
		var value = $("#reg_name_stu").val();
		if(value == "" || value == null){
			$("#reg_name_stu_text").text("姓名信息不得为空");
			checkArray[7] = false;
		}else{
			$("#reg_name_stu_text").text("");
			checkArray[7] = true;
		}
	});
	
	                                               //教师
	
	//教师账号
	$("#reg_account_tea").keyup(function(){
		var value = $("#reg_account_tea").val();
		if(value == "" || value == null){
			$("#reg_account_tea_text").text("账号信息不得为空");
			checkTeacher[0] = false;
		}else{
			if(value.length <= 6 || value.length >= 18){
				$("#reg_account_tea_text").text("账号信息为6-18个字符");
				checkTeacher[0] = false;
			}
			else{
				$("#reg_account_tea_text").text("");
				checkTeacher[0] = true;
			}
		}
	});
	
	//教师密码
	$("#reg_password_tea").keyup(function(){
		var value = $("#reg_password_tea").val();
		if(value == "" || value == null){
			$("#reg_password_tea_text").text("密码不得为空");
			checkTeacher[1] = false;
		}else{
			if(value.length <= 6 || value.length >= 18){
				$("#reg_password_tea_text").text("密码为6-18个字符");
				checkTeacher[1] = false;
			}
			else{
				$("#reg_password_tea_text").text("");
				checkTeacher[1] = true;
			}
		}
	});
	
	//教师密码2
	$("#reg_password2_tea").keyup(function(){
		var value = $("#reg_password2_tea").val();
		
		if(value == $("#reg_password_tea").val()){
			$("#reg_password2_tea_text").text("");
			checkTeacher[2] = true;
		}else{
			$("#reg_password2_tea_text").text("两次密码不相符");
			checkTeacher[2] = false;
		}
	});
	
	//教师学校
	$("#reg_school_tea").keyup(function(){
		var value = $("#reg_school_tea").val();
		if(value == "" || value == null){
			$("#reg_school_tea_text").text("学校信息不得为空");
			checkTeacher[3] = false;
		}else{
			$("#reg_school_tea_text").text("");
			checkTeacher[3] = true;
		}
	});
	
	//教师工号
	$("#reg_number_tea").keyup(function(){
		var value = $("#reg_number_tea").val();
		if(value == "" || value == null){
			$("#reg_number_tea_text").text("工号信息不得为空");
			checkTeacher[4] = false;
		}else{
			$("#reg_number_tea_text").text("");
			checkTeacher[4] = true;
		}
	});
	
	//教师姓名
	$("#reg_name_tea").keyup(function(){
		var value = $("#reg_name_tea").val();
		if(value == "" || value == null){
			$("#reg_name_tea_text").text("姓名信息不得为空");
			checkTeacher[5] = false;
		}else{
			$("#reg_name_tea_text").text("");
			checkTeacher[5] = true;
		}
	});
});

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



//ajax响应学生注册
$(document).ready(function(){
	$("#stu_reg").click(function (){
		$("#stu_reg").attr("disabled",true);
		
		if(checkArray[0] && checkArray[1] && checkArray[2] && checkArray[3] &&
		   checkArray[4] && checkArray[5] && checkArray[6] && checkArray[7]){
			
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
		}
		else{
			$("#stu_reg").removeAttr("disabled");
			alert("请按要求填写信息");
		} 
	});
});





//ajax响应教师注册
$(document).ready(function(){
	$("#tea_reg").click(function (){
		
		 $("#tea_reg").attr({"disabled":"disabled"});
		 if(checkTeacher[0] && checkTeacher[1] && checkTeacher[2] && checkTeacher[3] && 
		    checkTeacher[4] && checkTeacher[5]){
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
						$("#tea_reg").removeAttr("disabled");
					}
				},
				error : function() {
					$("#tea_reg").removeAttr("disabled");
				}
			 });
		 }
		 else{
			 $("#tea_reg").removeAttr("disabled");
				alert("请按要求填写信息");
		 } 	
	});
});



