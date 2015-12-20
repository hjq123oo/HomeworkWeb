<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		
		<meta name="viewport" content="width=device-width, initial-scale=1.0"> 
		
		<meta name="viewport" content="width=device-width, initial-scale=1.0"> 
		
		
		<link rel="stylesheet" type="text/css" href="../css/default.css" />
		<link rel="stylesheet" type="text/css" href="../css/form.css" />
		<link rel="stylesheet" type="text/css" href="../css/courseCreate.css" />
		<link rel="stylesheet" type="text/css" href="../css/jquery.datetimepicker.css" />
		<script src="../js/jquery-2.1.3.min.js"></script>
		<script src="../js/jquery.datetimepicker.js"></script>
		
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
			<div class="title">创建课程</div>
			<div class="form">
			<form name="create">
				<table class = "courseCreate_table">
					<tr>
						<td class = "first_col"><label for="create-0">课程院系：</label></td>
						<td class = "courseCreate_input"><input type="text"></td>
					</tr>
					<tr>
						<td class = "first_col"><label for="create-1">课程名称：</label></td>
						<td class = "courseCreate_input"><input type="text"></td>
					</tr>
					<tr>
						<td class = "first_col"><label for="create-0">课程编号：</label></td>
						<td class = "courseCreate_input"><input  type="text"></td>
					</tr>
					<tr>
						<td class = "first_col"><label for="create-0">所属专业：</label></td>
						<td class = "courseCreate_input"><input  type="text"></td>
					</tr>
					<tr>
						<td class = "first_col"><label for="create-0">课程简介：</label></td>
						<td class = "courseCreate_input"><textarea></textarea></td>
					</tr>
					<tr>
						<td class = "first_col"><label for="create-3">上课时间：</label></td>
						<td class = "courseCreate_input"><input  type="text"></td>
					</tr>
					<tr>
						<td class = "first_col"><label for="create-4">上课地点：</label></td>
						<td class = "courseCreate_input"><input type="text"></td>
					</tr>
					<tr>
						<td class = "first_col"><label for="create-5">作业迟交扣分：</label></td>
						
						<td class = "courseCreate_input">
							每迟交<select>
									<option value="1">1</option>
									<option value="2">12</option>
									<option value="3">24</option>
									<option value="4">48</option>
								</select>
							小时扣<select>
									<option value="1">10</option>
									<option value="2">20</option>
									<option value="3">50</option>
									<option value="4">100</option>
								</select>%
						</td>
					</tr>
					<tr>
						<td class = "first_col"><label for="create-5">课程截止时间：</label></td>
							<td><input id="datetimepicker" type="text" readonly="readonly"><td/>
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
								$("#datetimepicker").datetimepicker({
									minDate: minDate
									//minDate:;
								});
							});
								
							</script>
					</tr>
					<tr>
						<td></td>
						<td style="text-align:right">
							<Button class = "btn" type = "submit" >提交</Button>
						</td>
					</tr>
				</table>			
        </form>
			</div>
		</div>
	</div>
    
	</body>
</html>
		
		


		
		

