package com.fiverings.homeworkweb.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fiverings.homeworkweb.global.FileRootUtil;
import com.fiverings.homeworkweb.global.ZipFiles;
import com.fiverings.homeworkweb.jparepository.HomeworkJpaRepository;
import com.fiverings.homeworkweb.model.Homework;
import com.fiverings.homeworkweb.model.Student;
import com.fiverings.homeworkweb.model.StudentHomework;

@Service("manageHomeworkService")
public class ManageHomeworkServiceImpl implements ManageHomeworkService{
	
	@Resource
	private HomeworkJpaRepository homeworkJpaRepository;



	
	public Homework getHomework(Integer homeworkId) {
		Homework returnHomework = new Homework();
		
		Homework homework = homeworkJpaRepository.findOne(homeworkId);
		
		returnHomework.setHomeworkId(homework.getHomeworkId());
		returnHomework.setName(homework.getName());
		returnHomework.setStartTime(homework.getStartTime());
		returnHomework.setEndTime(homework.getEndTime());
		returnHomework.setContent(homework.getContent());
		returnHomework.setFilePath(homework.getFilePath());
		returnHomework.setFullScore(homework.getFullScore());
		
		return returnHomework;
	}



	@Transactional
	public List<StudentHomework> getStudentHomeworks(Integer homeworkId) {
		
		List<StudentHomework> studentHomeworks = homeworkJpaRepository.findOne(homeworkId).getStudentHomeworks();
		
		List<StudentHomework> returnStudentHomeworks = new ArrayList<StudentHomework>();
		
		Iterator<StudentHomework> it = studentHomeworks.iterator();
		
		while(it.hasNext()){
			StudentHomework returnStudentHomework = new StudentHomework();
			StudentHomework studentHomework = it.next();
			
			returnStudentHomework.setId(studentHomework.getId());
			returnStudentHomework.setFilePath(studentHomework.getFilePath());
			returnStudentHomework.setScore(studentHomework.getScore());
			returnStudentHomework.setSubmitTime(studentHomework.getSubmitTime());
			returnStudentHomework.setSubmitNum(studentHomework.getSubmitNum());
		
			Student returnStudent = new Student();
			Student student = studentHomework.getStudent();
			
			returnStudent.setStudentNO(student.getStudentNO());
			returnStudent.setRealname(student.getRealname());
			returnStudent.setCollege(student.getCollege());
			returnStudent.setClassName(student.getClassName());
			returnStudentHomework.setStudent(returnStudent);
		
			
			returnStudentHomeworks.add(returnStudentHomework);
		}
		
		return returnStudentHomeworks;
	}


	@Transactional
	public String zipStudentHomeworks(Integer homeworkId) {
		
		Homework homework = homeworkJpaRepository.findOne(homeworkId);
		List<StudentHomework> studentHomeworks = homework.getStudentHomeworks();
	
		
		int size = studentHomeworks.size();

		List<File> files = new ArrayList<File>();
		
	
		for(int i=0;i<size;i++){	
			StudentHomework studentHomework = studentHomeworks.get(i);
			
			if(studentHomework.getSubmitNum() != 0){
				File file = new File(FileRootUtil.getFileRoot()+studentHomework.getFilePath());
				files.add(file);
			}
		
		}
		if(files.size() == 0){
			return null;
		}
		
		String path = "/file/course/" + homework.getCourse().getCourseId() + "/homework/" + homeworkId + "/";
		
		String fileName = homework.getCourse().getName()+"-"+homework.getName()+".zip";
		String filePath = path + fileName;
		File file = new File( FileRootUtil.getFileRoot()+filePath);
		
		try {
			if (!file.exists()) {
				if (!file.getParentFile().exists()) {
					// 如果目标文件所在的目录不存在，则创建父目录
					if (!file.getParentFile().mkdirs()) {

						return null;
					}
				}
				if (!file.createNewFile()) {
					return null;
				}

			}
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		
		ZipFiles.zipFiles(files,file);
		return filePath;
	}
	
	
	
}
