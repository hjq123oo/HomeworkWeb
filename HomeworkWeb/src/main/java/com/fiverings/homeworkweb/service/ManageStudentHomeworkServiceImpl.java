package com.fiverings.homeworkweb.service;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fiverings.homeworkweb.global.FileRootUtil;
import com.fiverings.homeworkweb.jparepository.HomeworkJpaRepository;
import com.fiverings.homeworkweb.jparepository.StudentHomeworkJpaRepository;
import com.fiverings.homeworkweb.model.Homework;
import com.fiverings.homeworkweb.model.Student;
import com.fiverings.homeworkweb.model.StudentHomework;

@Service("manageStudentHomeworkService")
public class ManageStudentHomeworkServiceImpl implements ManageStudentHomeworkService {
	@Resource
	private StudentHomeworkJpaRepository studentHomeworkJpaRepository;
	
	@Resource
	private HomeworkJpaRepository homeworkJpaRepository;

	public StudentHomework getStudentHomework(Integer studentId, Integer homeworkId) {
		return studentHomeworkJpaRepository.find(studentId, homeworkId);
	}
	
	
	public Integer getScore(Integer studentId, Integer homeworkId) {
		return studentHomeworkJpaRepository.find(studentId, homeworkId).getScore();
	}

	public StudentHomework updateScore(StudentHomework studentHomework) {
		StudentHomework persistStudentHomework = studentHomeworkJpaRepository.findOne(studentHomework.getId());
		
		
		persistStudentHomework.setScore(studentHomework.getScore());
		return studentHomeworkJpaRepository.save(persistStudentHomework);
	}
	
	
	

	public StudentHomework uploadStudentHomework(Integer studentId, Integer homeworkId, MultipartFile file) {
		StudentHomework studentHomework = getStudentHomework(studentId, homeworkId);

		Homework homework = studentHomework.getHomework();
		Student student = studentHomework.getStudent();

		// 路径: /file/course/课程id/homework/作业id/
		String path = "/file/course/" + homework.getCourse().getCourseId() + "/homework/" + homeworkId + "/";

		String originalFileName = file.getOriginalFilename();
		String type = originalFileName.substring(originalFileName.lastIndexOf('.'));

		// 提交次数
		int submitNum = studentHomework.getSubmitNum();

		
		if(submitNum == 0){
			homework.setSubmitStudentNum(homework.getSubmitStudentNum()+1);
		}
		
		String fileName = student.getStudentNO() + "-" + student.getRealname() + "-" + homework.getName() + "-"
				+ (submitNum + 1) + type;

		String filePath = path + fileName;
		
		Date date = new Date();
		studentHomework.setSubmitTime(date);
		
		//添加扣分数目
		long timeDeviationMilliseconds = date.getTime()-studentHomework.getHomework().getEndTime().getTime();
		if(timeDeviationMilliseconds<=0){
			studentHomework.setDeduction(0);
		}else{
		Integer timeDeviationHours = (Integer)((int)(timeDeviationMilliseconds/3600000));
		Integer lateInterval = studentHomework.getHomework().getCourse().getLateInterval();
		Integer latePercent = studentHomework.getHomework().getCourse().getLatePercent();
		Integer fullScore = studentHomework.getHomework().getFullScore();
		Integer deductScore = (timeDeviationHours/lateInterval+1)*(latePercent*fullScore/100);
		if (deductScore>fullScore){
			deductScore=fullScore;
		}
		studentHomework.setDeduction(deductScore);
		}
		
		
		studentHomework.setSubmitNum(submitNum+1);
		studentHomework.setFilePath(filePath);
		
		
		
		//保存文件
		File f = new File(FileRootUtil.getFileRoot() + filePath);

		try {
			if (!f.exists()) {
				if (!f.getParentFile().exists()) {
					// 如果目标文件所在的目录不存在，则创建父目录
					if (!f.getParentFile().mkdirs()) {

						return null;
					}
				}
				if (!f.createNewFile()) {
					return null;
				}

			}
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}

		try {
			FileUtils.copyInputStreamToFile(file.getInputStream(), f);

		} catch (IOException e) {

			e.printStackTrace();
			return null;
		}

		
		homeworkJpaRepository.save(homework);
		return studentHomeworkJpaRepository.save(studentHomework);
	}

	
	public List<String> getAllStudentHomwrokFilePath(Integer studentId, Integer homeworkId){
		StudentHomework studentHomework = getStudentHomework(studentId, homeworkId);
	
		Homework homework = studentHomework.getHomework();
		Student student = studentHomework.getStudent();
		
		// 路径: /file/course/课程id/homework/作业id/
		String path = "/file/course/" + homework.getCourse().getCourseId() + "/homework/" + homeworkId + "/";
	
		String startStr = student.getStudentNO()+"-"+student.getRealname()+"-"+homework.getName();
		
		FilenameFilter filter  = new MyFilenameFilter(startStr);
		
		File file = new File(FileRootUtil.getFileRoot()+path);
		String[] allFilePath = file.list(filter);
		
		List<String> filePathList = new ArrayList<String>();
		
		if(allFilePath == null){
			return filePathList;
		}
		
		for(String filePath : allFilePath){
			filePathList.add(path+filePath);
		}
		
		return filePathList;
	}
}


class MyFilenameFilter implements FilenameFilter{

	//学号-姓名-作业名
	private String startStr;
	public MyFilenameFilter(String startStr){
		this.startStr=startStr;
	}
	
	@Override
	public boolean accept(File dir, String name) {
		
		return name.startsWith(startStr);
	}
	
}