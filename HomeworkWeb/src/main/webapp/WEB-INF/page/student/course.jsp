<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		
		<meta name="viewport" content="width=device-width, initial-scale=1.0"> 
		
		<link rel="stylesheet" type="text/css" href="../css/default.css" />
		<link rel="stylesheet" href="../css/templatemo-style.css">
		<link rel="stylesheet" href="../css/course.css">
		<link rel="stylesheet" href="../css/table.css">
		<script src="../js/jquery-2.1.3.min.js"></script>
		
		<script src="../js/jquery.ui.widget.js"></script>
		<script src="../js/jquery.iframe-transport.js"></script>
		<script src="../js/jquery.fileupload.js"></script>
		<title>五环作业网</title>
		
		
	</head>

	<body>
	<input id="file" type="file" name="file" data-url="/HomeworkWeb/student_homework/add" multiple/>
	 
	<script>
	$(function () {
		$("#file").fileupload({
			dataType: 'json',
		    done:function(e,data){
		        
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
	
	
	<div id="progress">
    	<div class="bar" style="width: 0%;height:18px;background:green;"></div>
	</div>
	
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
	  <div class="course">
		 <!-- SIDEBAR -->
        <div class="sidebar-menu hidden-xs hidden-sm">
            <div>
                <div class="profile-image">
                    <img src="../images/郭关飞.jpg" alt="user">
                </div>
                <h3 class="profile-title">郭关飞</h3>
                <h3 class="profile-title">北京交通大学</h3>
            </div>
            <div>
                <ul class="navigation">
					<li><b>课程ID：</b>00000001</li>
                    <li><b>课程院系：</b>软件学院</li>
					<li><b>课程名称：</b>软件系统分析与设计技术</li>
					<li><b>课程编号：</b>A738129</li>
					<li><b>所属专业：</b>软件工程</li>
					<li><b>上课时间：</b>星期五第二节</li>
					<li><b>上课地点：</b>逸夫楼603</li>
					<li><b>作业迟交扣分：</b>迟交24小时扣10%</li>
					<li><b>选课人数：</b>30</li>
                    <li><b>课程简介：</b>本课程为软件学院高年级本科生开设的一门专业必修课，属于软件工程专业主干课。授课对象需较强的软件工程专业技术基础，是一门融合多门课程知识进行的软件产品或系统从构思、设计到构建的综合技术应用类课程。</li>
                </ul>
            </div> 
        </div> <!-- .sidebar-menu -->

        <!-- MAIN CONTENT -->
        <div class="main-content">
                <div class="content-wrapper">
				     <h2>作业信息</h2>
					     <br/>
						 <br/>
						 <form enctype="multipart/form-data" style="display:none">
							<input id="file" type="file" multiple >
						 </form>
                          <table class="bordered">
                              <thead>
                                <tr>   
                                    <th>ID</th>									
                                    <th>作业名</th>
									<th>开始时间</th>
                                    <th>截止时间</th>
		                            <th>提交人数</th>
		                            <th>详情</th>
									<th>提交</th>
									<th>分数</th>
                                </tr>
                              </thead>
                                <tr>  
                                    <td>432</td>								
                                    <td>需求分析展示</td>
									<td>2015.9.25</td>
                                    <td>2015.10.5</td>
									<td>45</td>
									<td><input type="image" value="detail" class="image" src="../images/detail.jpg" onclick="window.location.href='homework.html'"></td>
									<td><input type="image" value="submit" class="image" src="../images/edit.jpg" onclick="document.getElementById('file').click();"></td>
									<td>15</td>
							    </tr>        
						
								
							
					</table>
                </div>
        </div>
      </div>
	</div>
    
	</body>
</html>
		
		

