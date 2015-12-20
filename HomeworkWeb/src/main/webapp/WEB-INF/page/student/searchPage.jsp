<!DOCTYPE html>

<html>
    <head>
        <title>课程搜索</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/default.css" rel="stylesheet" type="text/css">
        <link href="css/searchPage.css" rel="stylesheet" type="text/css">
        <link rel="stylesheet" href="css/table.css" type="text/css">
        <script src="js/searchPage.js" type="text/javascript"></script>
    </head>
    <body>
        <div id="nav">
		<div id="logo"><a href="home.html"><img src="images/logo.png" alt="LOGO" width="200" height="60"/></a></div>
        <div id="navarea">
			
            <ul id="navs">
                <li class="navItem"><a href="home.html"><span>首页</span></a></li>
                <li class="navItem"><a href="courseCenter.html"><span>课程中心</span></a></li>
                <li class="navItem"><a href="notice.html"><span>公告</span></a></li>
               

                <li id = "info"><a href="personalInfo.html" ><img src="images/user.jpg"></a></li>
				<li id = "logout"><a href="index.html"><span>注销</span></a></li>
            </ul>
        </div>
    </div>
        <div id="container">
            <div id="center" style="margin-left: 30px;margin-right: 30px;">
                <div id="centerlogo"><a href="#"><img src="images/centerlogo.png" alt="LOGO" width="250"/></a></div>
                <div class="form-wrapper cf">
                    <input type="text" placeholder="search" required>
                    <button onclick="search();">Search</button>
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
                        <tr>
                            <td>000000001</td>        
                            <td>软件系统分析与设计技术</td>
                            <td>张红延</td>
                            <td>星期2第4节</td>
                            <td>逸夫教学楼308</td>
                           
                            <td><input type="image" value="submit" class="image" src="images/join.png" width="25px" height="25px"></td>
					</tr>
              
				</table>
            </div>
        </div>
    </body>
</html>
