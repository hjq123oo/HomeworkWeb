<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		
		<meta name="viewport" content="width=device-width, initial-scale=1.0"> 
		
		<link rel="stylesheet" type="text/css" href="../css/default.css" />
		<link rel="stylesheet" type="text/css" href="../css/form.css" />
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
		<div id="main">
			<div class="point"></div>
			<div class="title">分数统计</div>
			<div class="form"  style="margin-top:75px;">
			    <table class="bordered" style="width:90%;">
                    <thead>
                        <tr>    
							<th>学号</th>
                            <th>姓名</th>
                            <th>Homework1</th>
		                    <th>Homework2</th>
		                    <th>Homework3</th>
		                    <th>Homework4</th>
							<th>Homework5</th>
							<th>总分</th>
                        </tr>
                    </thead>
                        <tr>
							<td>13301001</td>
                            <td>赵一</td>        
                            <td>10</td>
                            <td>9</td>
							<td>8</td>
							<td>9</td>
							<td>8</td>
							<td>44</td>
						</tr>        
				
					</table>
			</div>
		</div>
	</div>
    
    
    <script>
    $(function(){
		var courseId = getUrlParam("courseId");		
		
		$.getJSON("/teacher/course/"+courseId+"/student_homework/all",function(data){
			var course = data.course;
		
			
		    
    		$.each(course.homeworks, function(i, homework){
    			addHomework(course.studentNum,homework);
    		});
  		});
	});
    </script>
	</body>
</html>
		
		

