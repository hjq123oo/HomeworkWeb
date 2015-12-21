<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		
		<meta name="viewport" content="width=device-width, initial-scale=1.0"> 
		
		<link rel="stylesheet" type="text/css" href="../css/default.css" />
		<link rel="stylesheet" href="../css/templatemo-style.css">
		<link rel="stylesheet" href="../css/course.css">
		<link rel="stylesheet" href="../css/table.css">
		<script src="../js/jquery-2.1.3.min.js"></script>
		
		<script src="../js/jquery.ui.widget.js"></script>
		<script src="../js/jquery.iframe-transport.js"></script>
		<script src="../js/jquery.fileupload.js"></script>
		<script src="../js/util.js"></script>
		<title>五环作业网</title>
		
		
	</head>

	<body>
	<input id="file" type="file" name="file" data-url="/HomeworkWeb/student_homework/add"/>
	 
	<script>
	$(function () {
		$("#file").fileupload({
			dataType: 'json',
		    done:function(e,data){
		        
		    },
		    progressall: function (e, data) {
		        var progress = parseInt(data.loaded / data.total * 100, 10);
		        $('#progress .bar').css(
		            'width',
		            progress + '%'
		        );
		    }
		});
	});
			
	

	</script>
	
	

    <div id="nav">
		<div id="logo"><a href="home.html"><img src="../images/logo.png" alt="LOGO" width="200" height="60"/></a></div>
        <div id="navarea">
			
            <ul id="navs">
                <li class="navItem"><a href="home.html"><span>首页</span></a></li>
                <li class="navItem"><a href="courseCenter.html"><span>课程中心</span></a></li>
                <li class="navItem"><a href="notice.html"><span>公告</span></a></li>
               

                <li id = "info"><a href="personalInfo.html" ><img src="../images/user.jpg"></a></li>
				<li id = "logout"><a href="index.html"><span>注销</span></a></li>
            </ul>
        </div>
    </div>

	<div id="container">
	  <div class="course">
		 <!-- SIDEBAR -->
        <div class="sidebar-menu hidden-xs hidden-sm">
            <div>
                <div class="profile-image">
                    <img src="../images/person.jpg" alt="user">
                </div>
                <h3 class="profile-title" id="teacherName"></h3>
                
            </div>
            <div>
                <ul class="navigation">
					<li><b>课程ID：</b><span id="courseId"></span></li>
					<li><b>课程编号：</b><span id="courseNumber"></span></li>
					<li><b>课程学校：</b><span id="courseSchool"></span></li>
                    <li><b>课程院系：</b><span id="courseCollege"></span></li>
                    <li><b>所属专业：</b><span id="courseSpecialty"></span></li>
					<li><b>课程名称：</b><span id="courseName"></span></li>
					<li><b>上课时间：</b><span id="courseTime"></span></li>
					<li><b>上课地点：</b><span id="coursePlace"></span></li>
					<li><b>作业迟交扣分：</b>迟交<span id="courseLateInterval"></span>小时扣<span id="courseLatePercent"></span>%</li>
					<li><b>选课人数：</b><span id="courseStudentNum"></span></li>
                    <li><b>课程简介：</b><span id="courseIntroduction"></span></li>
                </ul>
            </div>
        </div> <!-- .sidebar-menu -->

        <!-- MAIN CONTENT -->
        <div class="main-content">
                <div class="content-wrapper">
				     <h2>作业信息</h2>
					     <br/>
						 <br/>
						 <form enctype="multipart/form-data" style="display:none">
							<input id="file" type="file" multiple >
						 </form>
                          <table id="homeworks" class="bordered">
                              <thead>
                                <tr>   
                                    <th>ID</th>									
                                    <th>作业名</th>
									<th>开始时间</th>
                                    <th>截止时间</th>
		                            <th>提交人数</th>
		                            <th>详情</th>
									<th>提交</th>
									<th>分数</th>
                                </tr>
                              </thead>
                                   
						
								
							
					</table>
                </div>
        </div>
      </div>
	</div>
        
    <script>
    	$(function(){
    		var param = window.location.search;
    		var courseId = getUrlParam("courseId");
    		$.getJSON("/HomeworkWeb/teacher/course/"+courseId,function(data){
    			var course = data.course;
    			$("#teacherName").html(course.teacher.realname);

                $("#courseName").html(course.name);
    			$("#courseId").html(course.courseId);
    			$("#courseNumber").html(course.number);
    			$("#courseSchool").html(course.school);
    			$("#courseCollege").html(course.college);
    			$("#courseSpecialty").html(course.specialty);
    			$("#courseTime").html(course.time);
    			$("#coursePlace").html(course.place);
    			$("#courseLateInterval").html(course.lateInterval);
    			$("#courseLatePercent").html(course.latePercent);
    			$("#courseStudentNum").html(course.studentNum);
    			$("#courseIntroduction").html(course.introduction);
    			
    		    
	    		$.each(course.homeworks, function(i, homework){
	    			addHomework(homework);
	    		});
	  		});
    	});
    	
    	function addHomework(homework){
    		var date = new Date();
    		date.setTime(homework.startTime);
    		var startTime = date.getString();
    		
    		date.setTime(homework.endTime);
    		var endTime = date.getString();
    		$("#homeworks").append(
    				"<tr>"
    				+"<td>"+homework.homeworkId+"</td>"
    				+"<td>"+homework.name+"</td>"
    				+"<td>"+startTime+"</td>"
    				+"<td>"+endTime+"</td>"
    				+"<td>"+homework.submitStudentNum+"</td>"
    				+"<td><input type='image' value='detail' class='image' src='../images/detail.jpg' onclick='window.location.href='/HomeworkWeb/teacher/homework?homeworkId="+homework.homeworkId+"''></td>"
    				+"<td><input type='image' value='submit' class='image' src='../images/edit.jpg' onclick='document.getElementById('file').click();'></td>"		
 					+"</tr>"
    		);
    	          
    	}
    	
    
    </script>
	</body>
</html>
		
		

