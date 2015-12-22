$(document).ready(function(){
	//name 
	
	//隐藏所有控件
	var li1 = document.getElementById("li1");
	li1.style.display = "none";
	
	var li2 = document.getElementById("li2");
	li2.style.display = "none";
	
	var li3 = document.getElementById("li3");
	li3.style.display = "none";
	
	var li4 = document.getElementById("li4");
	li4.style.display = "none";
	
	var li5 = document.getElementById("li5");
	li5.style.display = "none";
	
	$.ajax({
		type: "get",
		url: "/HomeworkWeb/student/home",
		
		data: {
			
		},
		dataType : "json",
		success : function(data) {
			if(data.success == "true"){
				alert("true");
			}else if(data.result == "false"){
				
			}
		},
		
		error : function() {
			alert("false");
		}
	});	
	
});

