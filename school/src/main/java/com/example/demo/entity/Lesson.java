package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "lessons")

public class Lesson {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	private int lessonId;
	private String lessonName;
	@ManyToMany
	@JoinTable(
			name="students_lessons",
	joinColumns= @JoinColumn(name="lesson_id"),inverseJoinColumns = @JoinColumn(name="student_id")
			)
	 @JsonIgnoreProperties("lessons")
	private List<Student> studentsTakesLesson =new ArrayList<>();
	@ManyToOne
    @JoinColumn(name="season_id")
	private Season season;
	private int firstGrade;
	private int secondGrade;
	
	public Lesson() {
		
	}



	public int getLessonId() {
		return lessonId;
	}



	public void setLessonId(int lessonId) {
		this.lessonId = lessonId;
	}



	public String getLessonName() {
		return lessonName;
	}

	public void setLessonName(String lessonName) {
		this.lessonName = lessonName;
	}

	


	public List<Student> getStudentsTakesLesson() {
		return studentsTakesLesson;
	}

	public void setStudentsTakesLesson(List<Student> studentsTakesLesson) {
		this.studentsTakesLesson = studentsTakesLesson;
	}
	
	

	public Season getSeason() {
		return season;
	}



	public void setSeason(Season season) {
		this.season = season;
	}



	public int getFirstGrade() {
		return firstGrade;
	}



	public void setFirstGrade(int firstGrade) {
		this.firstGrade = firstGrade;
	}



	public int getSecondGrade() {
		return secondGrade;
	}



	public void setSecondGrade(int secondGrade) {
		this.secondGrade = secondGrade;
	}







	@Override
	public String toString() {
		return "Lesson [lessonId=" + lessonId + ", lessonName=" + lessonName + ", studentsTakesLesson="
				+ studentsTakesLesson + ", season=" + season + ", firstGrade=" + firstGrade + ", secondGrade="
				+ secondGrade + "]";
	}



	@Override
	public int hashCode() {
		return Objects.hash(lessonId);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Lesson other = (Lesson) obj;
		return lessonId == other.lessonId;
	}


	
 
}
