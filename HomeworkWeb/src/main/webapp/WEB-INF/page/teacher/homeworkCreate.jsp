<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		
		<meta name="viewport" content="width=device-width, initial-scale=1.0"> 
		
		<link rel="stylesheet" type="text/css" href="../css/default.css" />
		<link rel="stylesheet" type="text/css" href="../css/form.css" />
		<link rel="stylesheet" type="text/css" href="../css/homework.css" />
		<script src="../js/jquery-2.1.3.min.js"></script>
		
		<script src="../js/jquery.ui.widget.js"></script>
		<script src="../js/jquery.iframe-transport.js"></script>
		<script src="../js/jquery.fileupload.js"></script>
		<script src="../js/util.js"></script>
		<title>五环作业网</title>
	</head>

	<body>
		<div id="nav">
			<div id="logo"><a href="home.html"><img src="../images/logo.png" alt="LOGO" width="200" 

height="60"/></a></div>
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
				<div class="title">作业信息</div>
				<div class="form">
					
						<label for="title">作业标题: </label>
						<input id="title" name="title" type="text"></input>
						<br><br>
						<label for="content">作业内容: </label>
						<textarea id="content" name="content"></textarea>
						<br><br>
						<label for="file">提交附件: </label>
						
						<button id="chooseFile">浏览</button>
						<span id="fileName"></span>
						<input id="file" type="file" name="file" class="upload_file" style="display:none;"/>
						<div id="progress" style="width:100px;border:solid 1px #CCCCCC;">
    						<div class="bar" style="width: 0%;height:18px;background:green;"></div>
						</div>
	
						
						<br><br>
						<button id="submit" class="submit">提交</button>
						
					
	 
		<script>
		$(function () {
			$("#chooseFile").click(function(){
				$("#file").click();
			});
			
			
			var url = "/HomeworkWeb/teacher/course/"+getUrlParam("courseId")+"/homework/add";
			
			
			
			$("#file").fileupload({
				dataType: 'json',
				url: url,
				formData:{name:$("title").val(),content:$("content").val(),endTime:$("endTime").val()},
				add: function (e, data) {
					
					$("#fileName").html(data.files[0].name);
		           
		            $("#submit").click(function () {
		                  
		                    data.submit();
		                });
		        },
			    done:function(e,data){
			        alert(data.result.success);
			        alert(data.result.fileName);
			    },
			    progressall: function (e, data) {
			        var progress = parseInt(data.loaded / data.total * 100, 10);
			        $('#progress .bar').css(
			            'width',
			            progress + '%'
			        );
			    }
			});
			
			$("#submit").click(function(){
				alert("a");
				
			});
			
		});	
		</script>	
				</div>
			</div>
		</div>
	</body>
</html>
		
		


		

