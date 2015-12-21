$(document).ready(function(){
	$("#search").click(function(){
		var a = "/HomeworkWeb/student/search/"+$("#courseId").val();
		var b = "/HomeworkWeb/student/course/"+$("#courseId").val();
		$.getJSON(a,function(data){
			if(data.success == "true"){
				document.getElementById("courselist").style.display="";
				$("#tbody").html("");
				$("#tbody").append(
	    				"<tr>"
	    				+"<td>"+data.course.courseId+"</td>"
	    				+"<td>"+data.course.name+"</td>"
	    				+"<td>"+data.course.teacher.realname+"</td>"
	    				+"<td>"+data.course.time+"</td>"
	    				+"<td>"+data.course.place+"</td>"
	    				+"<td id='joinCourse'><input type='image' value='submit' class='image' src='../images/join.png' width='25px' height='25px'></td>"
	 					+"</tr>"
	    		);
			}else{
				$("#tbody").html("");
				document.getElementById("courselist").style.display="none";
				alert("并没有这个课程，请重新输入");
				$("#courseId").val("");
			}
			
			if(data.choise == "true"){
				$("#joinCourse").html("已添加");
			}else{
				$("#joinCourse").click(function(){
					$.ajax({
						type:"post",
						url:b,
						success:function(data){
							alert("成功添加");
						},
						error:function(){
							alert(b);
						}
					});
				});
			}
				

			});
	});
});