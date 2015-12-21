<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		
		<meta name="viewport" content="width=device-width, initial-scale=1.0"> 
		
		<link rel="stylesheet" type="text/css" href="../css/default.css" />
		<link rel="stylesheet" type="text/css" href="../css/form.css" />
		<link rel="stylesheet" type="text/css" href="../css/homework.css" />
		<link rel="stylesheet" type="text/css" href="../css/info.css" />
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
			<div class="title">布置作业</div>
			<div class="form">
				
				<label>作业标题: </label>
				<input id="titleName" name="titleName" type="text" readOnly="true" value=""></input>
				<br><br>
				<label>作业内容: </label>
				<textarea id="content" style = "resize:none" readOnly="true"></textarea>
				<br><br>
				<label>截止时间: </label>
				<input id="end_time" type="text" readonly="readonly">
				<br><br>
				<label>附件:&nbsp&nbsp&nbsp&nbsp</label>
				<img src="../images/file.png" width="60px" height="60px"/><a id="download" href="#">下载</a>
				<br><br>
					
				
			</div>
		</div>
	</div>
	<script>
	    $(function(){
	    	var homeworkId = getUrlParam("homeworkId");
	    	$.getJSON("/HomeworkWeb/teacher/homework/"+homeworkId,function(data){
	    		$("#titleName").val(data.homework.name);
	    		$("#content").html(data.homework.content);
	    		var date = new Date();
	    		date.setTime(data.homework.endTime);
	    		
	    		
	    		$("#end_time").val(date.getString());
	    		$("#download").attr("href",data.homework.filePath);
	    	});
	    });
    </script>
	</body>
</html>
		