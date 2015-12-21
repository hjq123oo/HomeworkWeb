<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		
		<meta name="viewport" content="width=device-width, initial-scale=1.0"> 
		
		<link rel="stylesheet" type="text/css" href="../css/default.css" />
		<link rel="stylesheet" type="text/css" href="../css/form.css" />
		<link rel="stylesheet" type="text/css" href="../css/modifyPwd.css"/>
		<script src = "../js/jquery-2.1.3.min.js"></script>
		<script src = "../js/modifyStudentPwd.js"></script>
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
			<div class="title">修改密码</div>
			<div class="form">
			 <div class = "reg_part">
                <table class = "modifyPassword_table">
                	<tr>
                		<td>账号</td>
                		<td><input type = "text" readonly id = "modify_account" value=""></td>
                	</tr>
                	<tr>
                		<td>旧密码</td>	
                		<td><input type = "password" id = "modify_oldPwd" value=""></td>
                		<td><label class = "messInfo" id = "messOldPwd">请务必填写该内容</label></td>
                	</tr>
                    <tr>
                        <td>新密码</td>
                        <td><input type = "password" id = "modify_newPwd" value=""></td>
                        <td><label class = "messInfo" id = "messNewPwd">请务必填写该内容</label></td>
                    </tr>
                    <tr>
                        <td colspan="2"><input type = "button" id = "save_btn" value = "保存修改"></td>
                    </tr>
                </table>
            </div>
			</div>
		</div>
	</div>
    
	</body>
</html>
		
		

