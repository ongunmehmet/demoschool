package com.example.demo.dto.response;

import java.util.ArrayList;
import java.util.List;


import com.example.demo.entity.Lesson;

public class DetailedStudentResponse {
	private int studentId;
	private String fullName;
	private double gpa;
	private List<Lesson> lessons=new ArrayList<>();
	public DetailedStudentResponse() {
		
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public double getGpa() {
		return gpa;
	}
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	public List<Lesson> getLessons() {
		return lessons;
	}
	public void setLessons(List<Lesson> lessons) {
		this.lessons = lessons;
	}
	@Override
	public String toString() {
		return "DetailedStudentResponse [studentId=" + studentId + ", fullName=" + fullName + ", gpa=" + gpa
				+ ", lessons=" + lessons + "]";
	}
	

	
}
