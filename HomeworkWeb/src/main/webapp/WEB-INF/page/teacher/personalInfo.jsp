<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		
		<meta name="viewport" content="width=device-width, initial-scale=1.0"> 
		
		<link rel="stylesheet" type="text/css" href="../css/default.css" />
		<link rel="stylesheet" type="text/css" href="../css/form.css" />
		<link rel="stylesheet" type="text/css" href="../css/info.css" />
		<title>个人信息修改</title>

		<script type="text/javascript" src = "../js/jquery-2.1.3.min.js"></script>
		<script type="text/javascript" src = "../js/personalInfo.js"></script>
		
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
				<div class="title">个人信息</div>
				<div class="form">
					<div class = "reg_part">
						<div id = "personalInfoForm" method="post">
							<table class = "infomation_table">
								<tr>
									<td class = "first_col">账号：</td>
									<td><input type = "text" class = "text" readonly value="xxxxxx" id = "tea_account"></td>
									<td><a href="modifyPwd.html">修改密码</a></td>
								</tr>
								<tr>
									<td class = "first_col">学校：</td>	
									<td><input type = "text" class = "text" readonly value="北京交通大学" id = "tea_school"></td>
								</tr>
								<tr>
									<td class = "first_col">工号：</td>
									<td><input type = "text" class = "text" readonly value="10086" id = "tea_number"></td>
								</tr>
								<tr>
									<td class = "first_col">姓名：</td>
									<td><input type = "text" class = "text" readonly value="XXX" id = "tea_name"></td>
								</tr>
								<tr>
									<td class = "first_col">常用邮箱：</td>
									<td><input type = "text" class = "text" readonly value="10086@bjtu.edu.cn"  id = "tea_email"></td>
								</tr>
								<tr>
									<td class = "first_col">联系方式：</td>
									<td><input type = "text" class = "text" readonly value="1881309xxxx"  id = "tea_phone"></td>
								</tr>
								<tr>
									<td colspan="3">
										<input type="button" class = "btn" id = "modify_btn_tea" value = "修改信息">
										<input type="button" class = "btn" id = "save_btn_tea" value = "保存信息"></td>
								</tr>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>
		
		

