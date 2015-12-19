//学生修改信息
$(document).ready(function(){
	$("#save_btn").hide();
	
});


$(document).ready(function(){
	$("#modify_btn").click(function(){
		$("#stu_school").attr("readonly", false);
		$("#stu_college").attr("readonly", false);
		$("#stu_class").attr("readonly", false);
		$("#stu_number").attr("readonly", false);
		$("#stu_name").attr("readonly", false);
		$("#stu_email").attr("readonly", false);
		$("#stu_phone").attr("readonly", false);

		$("#save_btn").show();
		
		if($("#stu_school").val() == "" || $("#stu_school").val() == null){
			$("#save_btn").attr("disabled",true);
		}
	});
});

$(document).ready(function(){
	$("#stu_school").keyup(function(){	
		if($("#stu_school").val() == "" || $("#stu_school").val() == null){
			$("#save_btn").attr("disabled",true);
		}else{
			$("#save_btn").attr("disabled",false);
		}
	});

	$("#stu_college").keyup(function(){	
		if($("#stu_college").val() == "" || $("#stu_college").val() == null){
			$("#save_btn").attr("disabled",true);
		}else{
			$("#save_btn").attr("disabled",false);
		}
	});

	$("#stu_class").keyup(function(){	
		if($("#stu_class").val() == "" || $("#stu_class").val() == null){
			$("#save_btn").attr("disabled",true);
		}else{
			$("#save_btn").attr("disabled",false);
		}
	});

	$("#stu_number").keyup(function(){	
		if($("#stu_number").val() == "" || $("#stu_number").val() == null){
			$("#save_btn").attr("disabled",true);
		}else{
			$("#save_btn").attr("disabled",false);
		}
	});

	$("#stu_name").keyup(function(){	
		if($("#stu_name").val() == "" || $("#stu_name").val() == null){
			$("#save_btn").attr("disabled",true);
		}else{
			$("#save_btn").attr("disabled",false);
		}
	});
});

$(document).ready(function(){
	$("#save_btn").click(function(){
		$("#stu_school").attr("readonly", true);
		$("#stu_college").attr("readonly", true);
		$("#stu_class").attr("readonly", true);
		$("#stu_number").attr("readonly", true);
		$("#stu_name").attr("readonly", true);
		$("#stu_email").attr("readonly", true);
		$("#stu_phone").attr("readonly", true);
		$("#save_btn").hide();

		$.ajax({
			type: "post",
			url: "/HomeworkWeb/student/info",
			data: {
				school:$("#stu_school").val(),
				college:$("#stu_college").val(),
				className:$("#stu_class").val(),
				studnetNo:$("#stu_number").val(),
				realName:$("#stu_name").val(),
				eamil:$("#stu_email").val(),
				phone:$("#stu_phone").val()
			},
			dataType : "json",
			success : function(data) {
				if(data.result == "true"){
					//window.location.href = "/HomeworkWeb/";
					alert("奈斯");
				}else if(data.result == "false"){
					alert("错误");
					$("#save_btn").removeAttr("disabled");
				}
			},
			error : function() {
				$("#save_btn").removeAttr("disabled");
			}
		});	

	});
});

//教师修改信息
$(document).ready(function(){
	$("#save_btn_tea").hide();
});

$(document).ready(function(){
	$("#modify_btn_tea").click(function(){
		$("#tea_school").attr("readonly", false);
		$("#tea_number").attr("readonly", false);
		$("#tea_name").attr("readonly", false);
		$("#tea_email").attr("readonly", false);
		$("#tea_phone").attr("readonly", false);

		$("#save_btn_tea").show();
	});
});

$(document).ready(function(){
	$("#tea_school").keyup(function(){	
		if($("#tea_school").val() == "" || $("#tea_school").val() == null){
			$("#save_btn_tea").attr("disabled",true);
		}else{
			$("#save_btn_tea").attr("disabled",false);
		}
	});

	$("#tea_number").keyup(function(){	
		if($("#tea_number").val() == "" || $("#tea_number").val() == null){
			$("#save_btn_tea").attr("disabled",true);
		}else{
			$("#save_btn_tea").attr("disabled",false);
		}
	});

	$("#tea_name").keyup(function(){	
		if($("#tea_name").val() == "" || $("#tea_name").val() == null){
			$("#save_btn_tea").attr("disabled",true);
		}else{
			$("#save_btn_tea").attr("disabled",false);
		}
	});

	$("#tea_email").keyup(function(){	
		if($("#tea_email").val() == "" || $("#tea_email").val() == null){
			$("#save_btn_tea").attr("disabled",true);
		}else{
			$("#save_btn_tea").attr("disabled",false);
		}
	});

	$("#tea_phone").keyup(function(){	
		if($("#tea_phone").val() == "" || $("#tea_phone").val() == null){
			$("#save_btn_tea").attr("disabled",true);
		}else{
			$("#save_btn_tea").attr("disabled",false);
		}
	});
});

$(document).ready(function(){
	$("#save_btn_tea").click(function(){
		$("#tea_school").attr("readonly", true);
		$("#tea_number").attr("readonly", true);
		$("#tea_name").attr("readonly", true);
		$("#tea_email").attr("readonly", true);
		$("#tea_phone").attr("readonly", true);
		$("#save_btn_tea").hide();

		$.ajax({
			type: "post",
			url: "/HomeworkWeb/student/info",
			data: {
				school:$("#tea_school").val(),
				teacherNO:$("#tea_number").val(),
				realName:$("#tea_name").val(),
				eamil:$("#tea_email").val(),
				phone:$("#tea_phone").val()
			},
			dataType : "json",
			success : function(data) {
				if(data.result == "true"){
					//window.location.href = "/HomeworkWeb/";
					
				}else if(data.result == "false"){
					alert("错误");
					$("#save_btn_tea").removeAttr("disabled");
				}
			},
			error : function() {
				$("#save_btn_tea").removeAttr("disabled");
			}
		});	
	});
});