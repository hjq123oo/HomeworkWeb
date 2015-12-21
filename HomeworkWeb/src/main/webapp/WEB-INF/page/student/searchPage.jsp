﻿<!DOCTYPE html>

<html>
    <head>
        <title>课程搜索</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src="../js/jquery-2.1.3.min.js"></script>
        <link href="../css/default.css" rel="stylesheet" type="text/css">
        <link href="../css/searchPage.css" rel="stylesheet" type="text/css">
        <link rel="stylesheet" href="../css/table.css" type="text/css">
        <script src="../js/searchPage.js" type="text/javascript"></script>
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
            <div id="center" style="margin-left: 30px;margin-right: 30px;">
                <div id="centerlogo"><a href="#"><img src="../images/centerlogo.png" alt="LOGO" width="250"/></a></div>
                <div class="form-wrapper cf">
                    <input id="courseId" type="text" placeholder="输入课程编号进行查询" required="required">
                    <button id="search">Search</button>
                </div>
                
                <table class="bordered" id="courselist" style="display:none">
                    <thead>
                        <tr>
                            <th>课程ID</th>        
                            <th>课程名</th>
                            <th>任课教师</th>
		            <th>上课时间</th>
		            <th>上课地点</th>
		            
                            <th>加入课程</th>
                        </tr>
                    </thead>
                    <tbody id="tbody">
                    	
                    </tbody>
				</table>
            </div>
        </div>
    </body>
</html>
