<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		
		<meta name="viewport" content="width=device-width, initial-scale=1.0"> 
		
		<link rel="stylesheet" type="text/css" href="../css/default.css" />
		
		<link rel="stylesheet" href="../css/course.css">
		<link rel="stylesheet" href="../css/table.css">
		
		<script src="../js/jquery-2.1.3.min.js"></script>
		<script src="../js/util.js"></script>
		<title>五环作业网</title>
		
		
	</head>

	<body>

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
					<li style="color:red;"><b>作业迟交扣分：</b>每迟交<span id="courseLateInterval"></span>小时扣<span id="courseLatePercent"></span>%</li>
					<li><b>选课人数：</b><span id="courseStudentNum"></span></li>
                    <li><b>课程简介：</b><span id="courseIntroduction"></span></li>
                </ul>
            </div> 
        </div> <!-- .sidebar-menu -->

        <!-- MAIN CONTENT -->
        <div class="main-content">
                <div class="content-wrapper">
				     <h2>作业信息</h2>
						<div class="btn" >
					      <button id="homeworkCreate">布置作业</button>
						  <button id="score">分数统计</button>
						</div>
						<hr/>
                          <table id="homeworks" class="bordered">
                              <thead>
                                <tr>   
                                    <th>ID</th>									
                                    <th>作业名</th>
									<th>开始时间</th>
                                    <th>截止时间</th>
		                            <th>提交人数</th>
		                            <th>详情</th>
									<th>查看批改</th>
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
    		
    		
    		$("#homeworkCreate").click(function(){
    			window.location.href='homeworkCreate.html?courseId='+courseId;
    		});
    		
    		$("#score").click(function(){
    			window.location.href='score.html?courseId='+courseId;
    		});
    		
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
	    			addHomework(course.studentNum,homework);
	    		});
	  		});
    	});
    	
    	function addHomework(studentNum,homework){
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
    				+"<td>"+homework.submitStudentNum+"/"+studentNum+"</td>"
    				+"<td><input type='image' value='detail' class='image' src='../images/detail.jpg' onclick='window.location.href=&apos;homework.html?homeworkId="+homework.homeworkId+"&apos;'></td>"
    				+"<td><input type='image' value='submit' class='image' src='../images/edit.jpg' onclick='window.location.href=&apos;correct.html?homeworkId="+homework.homeworkId+"&apos;'></td>"
 					+"</tr>"
    		);
    	          
    	}
    	
   
    </script>
    
	</body>
</html>
		
		

