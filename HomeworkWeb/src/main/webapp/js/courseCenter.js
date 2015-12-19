function initCourse(item){
       		var a ="<li class='course_block'><div class='course'><div class='courseName'><span class='course_name'>"+item.name+"</span></div></div><ul class='features'><li class='course_number'>课程号："+item.number+"</li><li class='teacher_name'>任课教师："+item.teacher.realname+"</li><li class='course_times'>"+item.time+"</li><li class='course_place'>"+item.place+"</li></ul></li>";
       		
    		$("li#add").before(a);
       	}