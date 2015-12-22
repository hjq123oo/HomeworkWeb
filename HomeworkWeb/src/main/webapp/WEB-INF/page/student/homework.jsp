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
		<script src="../js/jquery.datetimepicker.js"></script>
		<script src="../js/jquery.ui.widget.js"></script>
		<script src="../js/jquery.iframe-transport.js"></script>
		<script src="../js/jquery.fileupload.js"></script>
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
				<label for="fullScore">作业满分:</label>
				<input id="fullScore" type="text"  readonly="readonly">
				<br><br>
				<label>截止时间:</label>
				<input id="end_time" type="text" readonly="readonly">
				<br><br>
			
				<div id="annex" style="display:none;">
				<label>附件:&nbsp&nbsp&nbsp&nbsp</label>
				
				<img src="../images/file.png" width="60px" height="60px"/>
				<span id="annexName"></span>&nbsp;&nbsp;
				<a id="download" href="#">下载</a>
				</div>
				<br><br>
				<button id="submit">提交作业</button>
				<input id="file" type="file" name="file" class="upload_file" style="display:none;"/>
				<br><br>
				<label>提交情况:&nbsp;&nbsp;</label><span id="isSubmit"></span>
				<div id="allFile">
				</div>
				<br/>
				<br/>
			</div>
		</div>
	</div>
	
	
			
		<div id="blackDiv">
		</div>
		
		
		<div id="waitDiv">
			<div><img id="upload" src="../images/upload.png"/></div>
			<div>上传中......</div>
		
			<div id="progress">
    			<div class="bar" style="width: 0%;height:18px;background:green;"></div>
			</div>
		</div>
	
	
	<script>
	    $(function(){
	    	var homeworkId = getUrlParam("homeworkId");
	    	var homeworkUrl = "/HomeworkWeb/teacher/homework/"+homeworkId;
	    	var allFileUrl = "/HomeworkWeb/student/homework/"+homeworkId+"/student_homework/all";
	    	var url = "/HomeworkWeb/student/homework/"+homeworkId+"/student_homework/add";
	    	
	    	
	    	$.getJSON(homeworkUrl,function(data){
	    		$("#titleName").val(data.homework.name);
	    		$("#content").html(data.homework.content);
	    		$("#fullScore").val(data.homework.fullScore);
	    		var date = new Date();
	    		date.setTime(data.homework.endTime);
	    		$("#end_time").val(date.getString());
	    		
	    		var filePath = data.homework.filePath;
	    		if(filePath != null){
	    			var fileName = filePath.substring(filePath.lastIndexOf("/")+1);
	    			$("#annexName").html(fileName);
	    			$("#download").attr("href","/HomeworkWeb"+data.homework.filePath);
	    			$("#annex").show();
	    		}
	    		
	    	});
	    	
	    	
	    	$.getJSON(allFileUrl,function(data){
	    		var fileArr = data.allFile;
	    		var length = fileArr.length;
	    		if(length == 0){
	    			$("#isSubmit").html("未提交");
	    		}else{
	    			$("#isSubmit").html("已提交");
	    			
	    			
	    			for(var i=length-1;i>=0;i--){
	    				var filePath = fileArr[i];
	    				var fileName = filePath.substring(filePath.lastIndexOf("/")+1);
	    				
	    				$("#allFile").append(
	    						"<div>"+
	    						"<img src='../images/file.png' width='60px' height='60px'/>"+
	    						fileName+"&nbsp;&nbsp;"+
	    						"<a href='/HomeworkWeb"+filePath+"'>下载</a>"+
	    						"</div>"
	    				);
	    			}
	    		}
	    		
	    	});
	    	
	    
	    	
	    	$("#submit").click(function(){
	    		$("#file").click();
	    	});
	    	
	    	$("#file").fileupload({
				dataType: 'json',
				url: url,
				
				
				add: function (e, data) {
		           
		            $("#waitDiv").show();
					$("#blackDiv").show();
		            data.submit();
		        },
			    done:function(e,data){
			    	window.location.href="homework.html?homeworkId="+homeworkId;
			    },
			    fail: function(e, data) {
			    	 alert("上传异常");
            		 $("#waitDiv").hide();
            		 $("#blackDiv").hide();
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
	</body>
</html>
		