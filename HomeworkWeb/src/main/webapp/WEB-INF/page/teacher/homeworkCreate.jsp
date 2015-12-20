<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		
		<meta name="viewport" content="width=device-width, initial-scale=1.0"> 
		
		<link rel="stylesheet" type="text/css" href="../css/default.css" />
		<link rel="stylesheet" type="text/css" href="../css/form.css" />
		<link rel="stylesheet" type="text/css" href="../css/homework.css" />
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
					<form enctype="multipart/form-data" name="homework">
						<label for="text-0">作业标题: </label>
						<input name="text-0" type="text"></input>
						<br><br>
						<label for="text-1">作业内容: </label>
						<textarea name="text-1" style = "resize:none"></textarea>
						<br><br>
						<label for="file-0">提交附件: </label>
						<input name="file-0" class="upload_file" type="file" multiple data-min-file-

count="1">
						<br><br>
						<button type="submit"  class="btn1">提交</button>
						<button type="reset" class="btn2 ">重置</button>
					</form>
				</div>
			</div>
		</div>
	</body>
</html>
		
		


		

