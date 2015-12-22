$(document).ready(function(){
	//检验输入是否合格
	oldPwdText = $("#modify_oldPwd").val();
	newPwdText = $("#modify_newPwd").val();
	
	if(oldPwdText == "" || oldPwdText == null || newPwdText == "" || newPwdText == null){
		$("#save_btn").attr("disabled",true);
	}else{
		$("#save_btn").attr("disabled",false);
	}
	
	$("#save_btn").click(function (){
		if($("#modify_newPwd").val() == "" || $("#modify_newPwd").val() == null){
			$("#save_btn").attr("disabled",true);
		}else{
			$("#save_btn").attr("disabled",true);
			 $.ajax({
				type: "post",
				url: "/HomeworkWeb/student/modifyPwd",
				
				data: {
					name:$("#modify_account").val(),
					oldPwd:$("#modify_oldPwd").val(),
					newPwd:$("#modify_newPwd").val()
				},
				dataType : "json",
				success : function(data) {
					if(data.success == "true"){
						window.location.href = "/HomeworkWeb/student/personalInfo";
						$("#save_btn").removeAttr("disabled");
					}else if(data.result == "false"){
						alert("账号或密码有误");
						$("#save_btn").removeAttr("disabled");
					}
				},
				error : function() {
					alert("false");
				}
			});	
		}
	});
	
	//获取教师账号
	$.ajax({
		type: "get",
		url: "/HomeworkWeb/student/info",
		data: {
			
		},
		dataType : "json",
		success : function(data) {
			if(data.success == "true"){
				$("#modify_account").attr("value", data.name);	
			}else if(data.result == "false"){
				alert("错误");
			}
		},
		error : function() {
			
		}
	});
	
	$("#modify_oldPwd").change(function(){
		if($("#modify_oldPwd").val() == "" || $("#modify_oldPwd").val() == null){
			$("#messOldPwd").text("请务必填写该内容");
			$("#save_btn").attr("disabled",true);
		}else{
			
			$.ajax({
				type: "get",
				url: "/HomeworkWeb/student/info",
				data: {
					
				},
				dataType : "json",
				success : function(data) {
					if(data.success == "true"){
						if(data.pwd != $("#modify_oldPwd").val()){
							$("#messOldPwd").text("旧密码不正确");
						}else{
							$("#messOldPwd").text("");
							$("#save_btn").removeAttr("disabled");
						}
						
						$("#modify_account").attr("value", data.name);	
					}else if(data.result == "false"){
						alert("错误");
					}
				},
				error : function() {
					
				}
			});
		}
	});
	
	$("#modify_newPwd").keyup(function(){
		if($("#modify_newPwd").val() == "" || $("#modify_newPwd").val() == null){
			$("#messNewPwd").text("请务必填写该内容");
			$("#save_btn").attr("disabled",true);
		}else{
			$("#messNewPwd").text("");
			$("#save_btn").attr("disabled",false);
		}
	});	
});