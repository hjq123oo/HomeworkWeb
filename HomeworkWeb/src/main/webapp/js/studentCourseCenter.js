function initCourse(item){
       		var a ="<li class='course_block' onclick='window.location.href=&apos;course.html?courseId="+item.courseId+"&apos;'><div class='course'><div class='courseName'><span class='course_name'>"+item.name+"</span></div></div><ul class='features'><li class='course_number'>课程号："+item.number+"</li><li class='teacher_name'>任课教师："+item.teacher.realname+"</li><li class='course_times'>上课时间："+item.time+"</li><li class='course_place'>上课地点："+item.place+"</li></ul></li>";

       		$("li#search").before(a);
       	}

$(document).ready(function(){
	$.getJSON("/HomeworkWeb/student/course/all",function(data){
		$.each(data.courses, function(i, item){
			initCourse(item);
		});
	});
});