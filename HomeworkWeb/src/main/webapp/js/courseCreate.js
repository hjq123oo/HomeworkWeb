$(document).ready(function(){
	
	window.messArray = new Array("cSchool", "cCollege", "cName", "cNumber", 
			"cSpecialty", "cIntroduction", "cTime", "cPlace", "cEndTime");
	window.atext = "不能为空";
	window.infoArray = new Array(9);
	window.boolArray = new Array()
	
	for(var i = 0; i < infoArray.length; i++){
		infoArray[i] = $("#" + messArray[i]).val();
	}
		
	$("#submit").click(function(){
		for(var i = 0; i < infoArray.length; i++){
			infoArray[i] = $("#" + messArray[i]).val();
		}	
		
		if(infoArray[0] == "" || infoArray[0] == null
			    || infoArray[1] == "" || infoArray[1] == null
			    || infoArray[2] == "" || infoArray[2] == null
			    || infoArray[3] == "" || infoArray[3] == null
			    || infoArray[4] == "" || infoArray[4] == null
			    || infoArray[5] == "" || infoArray[5] == null
			    || infoArray[6] == "" || infoArray[6] == null
			    || infoArray[7] == "" || infoArray[7] == null
			    || infoArray[8] == "" || infoArray[8] == null){
			
			if(infoArray[0] == "" || infoArray[0] == null)
				$("#cSchoolText").text(atext);
			if(infoArray[1] == "" || infoArray[1] == null)
				$("#cCollegeText").text(atext);
			if(infoArray[2] == "" || infoArray[2] == null)
				$("#cNameText").text(atext);
			if(infoArray[3] == "" || infoArray[3] == null)
				$("#cNumberText").text(atext);
			if(infoArray[4] == "" || infoArray[4] == null)
				$("#cSpecialtyText").text(atext);
			if(infoArray[5] == "" || infoArray[5] == null)
				$("#cIntroductionText").text(atext);
			if(infoArray[6] == "" || infoArray[6] == null)
				$("#cTimeText").text(atext);
			if(infoArray[7] == "" || infoArray[7] == null)
				$("#cPlaceText").text(atext);
			if(infoArray[8] == "" || infoArray[8] == null)
				$("#cEndTimeText").text(atext);
			
		}else{
			$("#submit").attr("disabled","true");
			$.ajax({
	        	 type:"post",
	        	 url:"/HomeworkWeb/teacher/course/add",
	        	 data:{school:$("#cSchool").val(),
	        		 college:$("#cCollege").val(),
	        		 name:$("#cName").val(),
	        		 number:$("#cNumber").val(),
	        		 specialty:$("#cSpecialty").val(),
	        		 introduction:$("#cIntroduction").val(),
	        		 time:$("#cTime").val(),
	        		 place:$("#cPlace").val(),
	        		 lateInterval:$("#lateInterval").find("option:selected").text(),
	        		 latePercent:$("#latePercent").find("option:selected").text(),
	        		 endTime:$("#cEndTime").val()},
	        		 
	        	 dataType:"json",
	        	 success:function(data){
	        		 window.location.href="courseCenter.html"
	        	 },
	        	 error:function(){
	        		 alert("提交异常");
	        	 }
	         });
			$("#submit").attr("disabled","false");
		}
	});
	
	$("#cSchool").keyup(function(){
		if($("#cSchool").val() == "" || $("#cSchool").val() == null){
			$("#submit").attr("disabled",true);
			$("#cSchoolText").text(atext);
		}else{
			$("#cSchoolText").text("");
			$("#submit").attr("disabled",false);
		}
	});
	
	$("#cCollege").keyup(function(){
		if($("#cCollege").val() == "" || $("#cCollege").val() == null){
			$("#submit").attr("disabled",true);
			$("#cCollegeText").text(atext);
		}else{
			$("#cCollegeText").text("");
			$("#submit").attr("disabled",false);
		}
	});
	
	$("#cName").keyup(function(){
		if($("#cName").val() == "" || $("#cName").val() == null){
			$("#submit").attr("disabled",true);
			$("#cNameText").text(atext);
		}else{
			$("#cNameText").text("");
			$("#submit").attr("disabled",false);
		}
	});
	
	$("#cNumber").keyup(function(){
		if($("#cNumber").val() == "" || $("#cNumber").val() == null){
			$("#submit").attr("disabled",true);
			$("#cNumberText").text(atext);
		}else{
			$("#cNumberText").text("");
			$("#submit").attr("disabled",false);
		}
	});
	
	$("#cSpecialty").keyup(function(){
		if($("#cSpecialty").val() == "" || $("#cSpecialty").val() == null){
			$("#submit").attr("disabled",true);
			$("#cSpecialtyText").text(atext);
		}else{
			$("#cSpecialtyText").text("");
			$("#submit").attr("disabled",false);
		}
	});
	
	$("#cIntroduction").keyup(function(){
		if($("#cIntroduction").val() == "" || $("#cIntroduction").val() == null){
			$("#submit").attr("disabled",true);
			$("#cIntroductionText").text(atext);
		}else{
			$("#cIntroductionText").text("");
			$("#submit").attr("disabled",false);
		}
	});
	
	$("#cTime").keyup(function(){
		if($("#cTime").val() == "" || $("#cTime").val() == null){
			$("#submit").attr("disabled",true);
			$("#cTimeText").text(atext);
		}else{
			$("#cTimeText").text("");
			$("#submit").attr("disabled",false);
		}
	});
	
	$("#cPlace").keyup(function(){
		if($("#cPlace").val() == "" || $("#cPlace").val() == null){
			$("#submit").attr("disabled",true);
			$("#cPlaceText").text(atext);
		}else{
			$("#cPlaceText").text("");
			$("#submit").attr("disabled",false);
		}
	});
	
	$("#cEndTime").keyup(function(){
		if($("#cEndTime").val() == "" || $("#cEndTime").val() == null){
			$("#submit").attr("disabled",true);
			$("#cEndTimeText").text(atext);
		}else{
			$("#cEndTimeText").text("");
			$("#submit").attr("disabled",false);
		}
	});
	
});