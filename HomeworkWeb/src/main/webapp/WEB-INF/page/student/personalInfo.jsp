<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		
		<meta name="viewport" content="width=device-width, initial-scale=1.0"> 
		
		<link rel="stylesheet" type="text/css" href="../css/default.css" />
		<link rel="stylesheet" type="text/css" href="../css/form.css" />
		<link rel="stylesheet" type="text/css" href="../css/info.css" />
		
		<script type="text/javascript" src = "../js/jquery-2.1.3.min.js"></script>
		<script type="text/javascript" src = "../js/personalInfo.js"></script>

		<title>个人信息修改</title>
	</head>

	<body>

    <div id="nav">
		<div id="logo"><img src="../images/logo.png" alt="LOGO" width="200" height="60"/></div>
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
					<div id = "personalInfoForm">
						<table class = "infomation_table">
							<tr>
								<td class = "first_col">账号：</td>
								<td><input class = "text" type = "text" readonly value="" id = "stu_account"></td>
								<td><a href="modifyPwd.html">修改密码</a></td>
							</tr>
							<tr>
								<td class = "first_col">学校：</td>	
								<td><input class = "text" type = "text" readonly value="" id = "stu_school"></td>
							</tr>
							<tr>
								<td class = "first_col">学院：</td>	
								<td><input class = "text" type = "text" readonly value="" id = "stu_college"></td>
							</tr>
							<tr>
								<td class = "first_col">班级：</td>	
								<td><input class = "text" type = "text" readonly value="" id = "stu_class"></td>
							</tr>
							<tr>
								<td class = "first_col">学号：</td>
								<td><input class = "text" type = "text" readonly value="" id = "stu_number"></td>
							</tr>
							<tr>
								<td class = "first_col">姓名：</td>
								<td><input class = "text" type = "text" readonly value="" id = "stu_name"></td>
							</tr>
							<tr>
								<td class = "first_col">常用邮箱：</td>
								<td><input class = "text" type = "text" readonly value="" id = "stu_email"></td>
							</tr>
							<tr>
								<td class = "first_col">联系方式：</td>
								<td><input class = "text" type = "text" readonly value="" id = "stu_phone"></td>
							</tr>
							<tr>
								<td colspan="3">
									<input type="button" class = "btn" id = "modify_btn" value = "修改信息">
									<input type="button" class = "btn" id = "save_btn" value = "保存信息">
								</td>
							</tr>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
    
	</body>
</html>
		
		

