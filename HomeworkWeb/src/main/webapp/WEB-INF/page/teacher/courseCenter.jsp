<!DOCTYPE html>

<html>

    <head>
        <title>课程列表</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="../css/default.css" />

        <link href="../css/courseCenter.css" type="text/css" rel="stylesheet">

        <script src="../js/jquery-2.1.3.min.js"></script>
        <script src="../js/courseCenter.js" type="text/javascript"></script>
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
    
    
  
    <div id="container>">
        <ul class="course_table">
        	<li class="course_block" id="add" onclick="window.location.href='courseCreate'">
              <div id="addcourse" style="background: url(../images/add.png) 0px 0px no-repeat"></div>
          	</li>
        </ul>
    </div>
        <script src="js/prefixfree.min.js" type="text/javascript"></script>
    </body>
    



</html>
