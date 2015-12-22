<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0"> 
		
		<link rel="stylesheet" type="text/css" href="../css/default.css" />
		
		<link rel="stylesheet" href="../css/table.css">
		<link rel="stylesheet" href="../css/correct.css">
		
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
		<div id="main" >
			
			
			
				
			    <table id="table" class="bordered" style="width:80%;">
                    <thead>
                        <tr>    
                            <th>学号</th>
                            <th>姓名</th>
		                    <th>学院</th>
		                    <th>班级</th>
		                    <th>作业&nbsp&nbsp<button id="pack" style="display:none;">打包下载</button></th>
		                    <th>提交时间</th>
							<th>分数</th>
							
                        </tr>
                    </thead>
                          			
						
					</table>
					
			
		</div>
	</div>
    <script>
   		 $(function(){
   			function addStudentHomework(i,studentHomework){
   				var student = studentHomework.student;
   				
   				var submitNum = studentHomework.submitNum;
   				
   			
   				var submitTime = "";
   				var filePath = "";
   				var fileName = "";
   				if(submitNum != 0){
   					var date = new Date();
   					date.setTime(studentHomework.submitTime);
   					submitTime = date.getString();
   					
   					filePath = studentHomework.filePath;
   					fileName = filePath.substring(filePath.lastIndexOf("/")+1);
   				}
   				
   				
   				var score = studentHomework.score;
   				if(score == null){
   					score = "";
   				}
   				
   				if(submitNum==0){
   					$("#table").append(	
   		   					"<tr>"+
   		                        "<td>"+student.studentNO+"</td>"+      
   		                        "<td>"+student.realname+"</td>"+
   		                        "<td>"+student.college+"</td>"+
   		                        "<td>"+student.className+"</td>"+
   								"<td>未提交</td>"+
   								 "<td></td>"+
   								"<td><input type='text' id='"+studentHomework.id+"' size='2' tabindex='"+(i+1)+"' readOnly/></td>"+	
   							"</tr>"        
   		   				);
   				}else{
   					$("#table").append(	
   		   					"<tr>"+
   		                        "<td>"+student.studentNO+"</td>"+      
   		                        "<td>"+student.realname+"</td>"+
   		                        "<td>"+student.college+"</td>"+
   		                        "<td>"+student.className+"</td>"+
   								"<td><img src='../images/file.png' width='40px' height='40px'/>"+fileName+"&nbsp;<a href='/HomeworkWeb"+filePath+"'>下载</a></td>"+
   								 "<td>"+submitTime+"</td>"+
   								"<td><input type='text' id='"+studentHomework.id+"' size='2' tabindex='"+(i+1)+"' value='"+score+"'/></td>"+	
   							"</tr>"        
   		   				);
   					
   					$("#"+studentHomework.id).change(function(){
   						
   						$.ajax({
   							type: "PUT",
   							url: "/HomeworkWeb/teacher/student_homework/"+studentHomework.id,
   							data: {
   								score:$("#"+studentHomework.id).val()
   							},
   							dataType : "json",
   							success : function(data) {
   								if(data.success == "false"){
   									alert("修改异常");
   								}
   							},
   							error : function() {
   								alert("修改异常");
   							}
   						});
   						
   					});
   				}
   				
   				
   			}
   			 
   			 
    		var homeworkId = getUrlParam("homeworkId");
    		
    		
    		$.getJSON("/HomeworkWeb/teacher/homework/"+homeworkId+"/student_homework/all",function(data){
    		
    			
    			$("#pack").click(function(){
    				window.location.href="/HomeworkWeb"+data.packagePath;
    			});
    			
    			
    			if(data.packagePath != null){
    				$("#pack").show();
    			}
    			
    			var studentHomeworks = data.studentHomeworks;
    		    
    			
    			
	    		$.each(studentHomeworks, function(i, studentHomework){
	    			addStudentHomework(i,studentHomework);
	    		});
	  		});
    		
    		
    	});
    </script>
	</body>
</html>
		
		

