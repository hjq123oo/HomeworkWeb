﻿<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		
		<meta name="viewport" content="width=device-width, initial-scale=1.0"> 
		
		<link rel="stylesheet" type="text/css" href="../css/default.css" />
		<link rel="stylesheet" type="text/css" href="../css/form.css" />
		<link rel="stylesheet" type="text/css" href="../css/homework.css" />
		<link rel="stylesheet" type="text/css" href="../css/jquery.datetimepicker.css" />
		
		<script src="../js/jquery-2.1.3.min.js"></script>
		<script src="../js/jquery.datetimepicker.js"></script>
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
					
						<label for="titleName">作业标题: </label>
						<input id="titleName" name="title" type="text"></input>
						<br><br>
						<label for="content">作业内容: </label>
						<textarea id="content" name="content"></textarea>
						<br><br>
						<label for="submissionTime">提交时间：</label>
						<input id="end_time" type="text" readonly="readonly">
						<script>
							$(function(){
								Date.prototype.format = function(fmt)   
								{  
								  var o = {   
								    "M+" : this.getMonth()+1,                 //月份   
								    "d+" : this.getDate(),                    //日   
								    "h+" : this.getHours(),                   //小时   
								    "m+" : this.getMinutes(),                 //分   
								    "s+" : this.getSeconds(),                 //秒   
								    "q+" : Math.floor((this.getMonth()+3)/3), //季度   
								    "S"  : this.getMilliseconds()             //毫秒   
								  };   
								  if(/(y+)/.test(fmt))   
								    fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));   
								  for(var k in o)   
								    if(new RegExp("("+ k +")").test(fmt))   
								  fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));   
								  return fmt;   
								}  
								
							
								var minDate = new Date().format("yyyy-MM-dd hh:mm:ss");
								$("#end_time").datetimepicker({
									minDate: minDate
									//minDate:;
								});
							});
								
							</script>
						<br><br>
						<label for="file">上传附件: </label>
						
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
			
			
			var uploadUrl = "/HomeworkWeb/teacher/course/"+getUrlParam("courseId")+"/homework/upload";
			var url = "/HomeworkWeb/teacher/course/"+getUrlParam("courseId")+"/homework/add";
			
			
			 $("#submit").click(function () {
                 $.ajax({
                	 type:"post",
                	 url:url,
                	 data:{name:$("#titleName").val(),content:$("#content").val(),endTime:$("#end_time").val()},
                	 dataType:"json",
                	 success:function(data){
                		 alert(1);
                	 }
                 });
				 
             });
			
			
			$("#file").fileupload({
				dataType: 'json',
				url: uploadUrl,
				
				add: function (e, data) {
					
					$("#fileName").html(data.files[0].name);
		           
		            $("#submit").click(function () {
		                  	alert(2);
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
			
		});	
		</script>	
				</div>
			</div>
		</div>
	</body>
</html>
		
		


		

