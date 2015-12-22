$(document).ready(function(){
	
	//初始化教师主页
	function initTeacherHome(item){
		
		var date = new Date();
		date.setTime(item.endTime);
		var str = date.getHomeworkString();
		var strArray = str.split("#");

		$("#homeworkul").append(
			"<li>"
			+ "<time class='timepoint'>"	
			+ "<span>" + strArray[0] + "</span>"
			+ "<span>" + strArray[1] + "</span>"
			+ "</time>"
			+ "<div class='timeicon'></div>"
			+ "<div class='timelabel'>"
			+ "<h2 onclick = 'window.location.href = &apos;homework.html?homeworkId=" + item.homeworkId + "&apos;'>" + item.name + "</h2>"
			+ "<p>" + item.content + "</p>"
			+ "</div>"
			+ "</li>"
		);
	}
	
	//教师获取所有作业
	$.ajax({
		type: "get",
		url: "/HomeworkWeb/teacher/teacher_homework/all",
		
		data: {
			
		},
		dataType : "json",
		success : function(data) {
			if(data.success == "true"){			
				console.log();
				$.each(data.studentHomeworks, function(i, item){
					initTeacherHome(item);
				});			
			}else if(data.success == "false"){
				
			}
		},
		
		error : function() {
			alert("fddd");
			
		}
	});	
	
	
});