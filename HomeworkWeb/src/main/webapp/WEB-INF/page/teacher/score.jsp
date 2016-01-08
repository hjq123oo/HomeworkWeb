<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		
		<meta name="viewport" content="width=device-width, initial-scale=1.0"> 
		
		<link rel="stylesheet" type="text/css" href="../css/default.css" />
		
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
			
			
			    <table id="table" class="bordered" style="width:90%;margin:75px auto;">
                    <thead>
                        <tr id="headTR">    
						
                        </tr>
                    </thead>
                            
				
					</table>
			
		</div>
	</div>
    
    
    <script>
    $(function(){
		var courseId = getUrlParam("courseId");		
		
		var url = "/HomeworkWeb/teacher/course/"+courseId+"/student_homework/all";
		$.getJSON(url,function(data){
			
			var students = data.students;
			var homeworks = data.homeworks;
			var scores = data.scores;
			
			var stuLength = students.length;
			var hwLength = homeworks.length;
			
			
			$("#headTR").append("<th>学号</th>");
			$("#headTR").append("<th>姓名</th>");

			for(var i=0;i<hwLength;i++){
				$("#headTR").append("<th>"+homeworks[i].name+"</th>");
			}
			
			$("#headTR").append("<th>总分</th>");
			
			
			for(var i=0;i<stuLength;i++){
				var total = 0;
				var row="<tr>";
				row = row + "<td>"+students[i].studentNO+"</td>";
				row = row + "<td>"+students[i].realname+"</td>";
				for(var j=0;j<hwLength;j++){
					if(scores[i*hwLength+j] == null){
						row = row + "<td>未评分</td>";
					}else{
						row =  row + "<td>"+scores[i*hwLength+j]+"</td>";
						total = total + scores[i*hwLength+j];
					}
				}
				row = row + "<td>"+total+"</td>";
				row += "</tr>";
				$("#table").append(row);
			}
  		});
	});
    </script>
	</body>
</html>
		
		

