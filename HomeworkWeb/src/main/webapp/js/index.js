//ajax响应登录操作
$(document).ready(function(){
	$("#loginBtn").click(function (){
		 $("#loginBtn").attr({"disabled":"disabled"});
		
		 $.ajax({
			type: "post",
			url: "/HomeworkWeb/",
			data: {
				name:$("#login_name").val(),
				pwd:$("#login_pwd").val()
			},
			dataType : "json",
			success : function(data) {
				if(data.result == "true"){
					if(data.user == "student"){
						window.location.href = "/HomeworkWeb/student/home";
					}
					else if(data.user == "teacher"){
						window.location.href = "/HomeworkWeb/teacher/home";
					}
					$("#loginBtn").removeAttr("disabled");
				}else if(data.result == "false"){
					alert("账号或密码有误");
					$("#loginBtn").removeAttr("disabled");
				}
			},
			error : function() {
				$("#loginBtn").removeAttr("disabled");
			}
		});	
	});
});


//ajax响应注册操作
$(document).ready(function(){
	$("#regBtn").click(function (){
		window.location.href = "/HomeworkWeb/register";
	});
});