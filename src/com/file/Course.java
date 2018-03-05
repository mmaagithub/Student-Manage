package com.file;

import java.io.Serializable;

public class Course implements Serializable{

	public String courseId = null;  //课程编号
	public String courseName = null;  //课程名
	public String courseMark = null;  //课程分数
	
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public Course(String courseName) {
		super();
		this.courseName = courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCourseMark() {
		return courseMark;
	}
	public void setCourseMark(String courseMark) {
		this.courseMark = courseMark;
	}
	
	public Course(String courseId, String courseName, String courseMark) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.courseMark = courseMark;
	}
	
	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int searchCourse(){
		
		return 0;
	}
	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseName=" + courseName
				+ ", courseMark=" + courseMark + "]";
	}
	
//	
//	public float average(){
//		ArrayList<Student> arr= IOStreamStudent.readFromFile();
//		Iterator<Student> it = arr.iterator();
//		float sum = 0;
//		int number = 1;
//		while(it.hasNext()){
//			Student newstu = it.next();
//			
//			number++;
//		}		
//		return sum/number;		
//	}
}
