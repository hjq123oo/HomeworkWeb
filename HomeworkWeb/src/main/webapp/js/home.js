$(document).ready(function(){
	
	//初始化学生主页
	function initHome(item){
		var date = new Date();
		date.setTime(item.endTime);
		var str = date.getHomeworkString();
		var strArray = str.split("#");
		
		$("#homeworkul").append(
			"<li>"
			+ "<time class='timepoint'>"	
			+ "<span>" + strArray[0] + "</span>"
			+ "<span>" + strArray[1] + "</span>"
			+ "</time>"
			+ "<div class='timeicon'></div>"
			+ "<div class='timelabel'>"
			+ "<h2 onclick = 'window.location.href = &apos;homework.html?homeworkId=" + item.homeworkId + "&apos;'>" + item.name + "</h2>"
			+ "<p>" + item.content + "</p>"
			+ "</div>"
			+ "</li>"
		);

		<div class="good_img">
			<img src="" id = "goodsImg"/>
		</div>
		<div class="good_name">
			<p id = "goodsName">0</p>
		</div>
		<div class="good_price">
			<p id="price">0</p>
		</div>		
		<input type="text" value="0" id="good_num" />
		<p class="total_price" id="total_price">$0</p>
		<button class="delete">remove</button>
	}
	
	//学生获取所有作业
	$.ajax({
		type: "get",
		url: "/HomeworkWeb/student/student_homework/rest",
		
		data: {
			
		},
		dataType : "json",			
				
		success : function(data) {				

			if(data.success == "true"){
				$.each(data.content, function(i, item){
					initHome(item);
				});			
			}else if(data.result == "false"){
				alert("加载数据失败");
			}
		},
		
		error : function() {
			alert("加载数据失败");
		}
	});	
});