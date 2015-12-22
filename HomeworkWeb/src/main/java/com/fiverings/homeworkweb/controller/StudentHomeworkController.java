package com.fiverings.homeworkweb.controller;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;





import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;





import com.fiverings.homeworkweb.model.StudentHomework;
import com.fiverings.homeworkweb.service.ManageCourseService;
import com.fiverings.homeworkweb.service.ManageHomeworkService;
import com.fiverings.homeworkweb.service.ManageStudentHomeworkService;
import com.fiverings.homeworkweb.service.ManageStudentService;



@Controller
public class StudentHomeworkController {

	@Resource
	ManageStudentService manageStudentService;
	
	@Resource
	ManageCourseService manageCourseService;
	
	@Resource
	ManageHomeworkService manageHomeworkService;
	
	@Resource
	ManageStudentHomeworkService manageStudentHomeworkService;
	
	@Resource
	HttpSession session;
	
	
	@RequestMapping(value = "/student/homework/{homeworkId}/student_homework/add", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> uploadHomework(@PathVariable Integer homeworkId,@RequestParam(value="file")  MultipartFile file) {

		Integer studentId = (Integer)session.getAttribute("id");
	
		manageStudentHomeworkService.uploadStudentHomework(studentId, homeworkId, file);
		
		
		Map<String, String> result = new HashMap<String, String>();
		result.put("success", "true");
		
		return result;
		
	}
	
	
	@RequestMapping(value = "/student/homework/{homeworkId}/student_homework/all", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, List<String>> getHomeworks(@PathVariable Integer homeworkId) {

		Integer studentId = (Integer)session.getAttribute("id");
		
	
		List<String> allFile = manageStudentHomeworkService.getAllStudentHomwrokFilePath(studentId, homeworkId);
		
		Map<String, List<String>> result = new HashMap<String, List<String>>();
		
		result.put("allFile", allFile);
		
		return result;
		
	}
	
	@RequestMapping(value = "/student/home", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, String> getHomeworks() {

		Integer studentId = (Integer)session.getAttribute("id");
		
		List<StudentHomework> homeworkList = new ArrayList<StudentHomework>();
		Map<String, String> result = new HashMap<String, String>();
		
		homeworkList = manageStudentService.getStudentHomeworks(studentId);
		
		if(homeworkList.size() == 0){
			result.put("success", "false");
			return result;
		}
		//如果存在需提交作业
		else{
			result.put("success", "true");
			result.put("homeworkNum", String.valueOf(homeworkList.size()));
			String returnStr = "";
			for(int i = 0; i < homeworkList.size(); i++){
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd%hh:mm");  
				String dateStr = sdf.format(homeworkList.get(i).getHomework().getEndTime());
				String nameStr = homeworkList.get(i).getHomework().getName();
				String contentStr = homeworkList.get(i).getHomework().getContent();
				
				returnStr += dateStr + "#" + nameStr + "#" + contentStr + "&";
			}
			result.put("homeworkContent", returnStr);
		}
		return result;
	}
}
