package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "students")
@DynamicUpdate
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int studentId;
	private String fullName;
	private double gpa;
	@ManyToMany(mappedBy = "studentsTakesLesson")
	@JsonIgnoreProperties("students")
	private List<Lesson> lessons = new ArrayList<>();

	public Student() {

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
		double sum = getLessons().stream().map(lesson -> {
			int firstgrade = lesson.getFirstGrade();
			int secondgrade = lesson.getSecondGrade();
			double average = (firstgrade + secondgrade) / 2;
			return average;
		}).toList().stream().reduce(0.0, (a, b) -> a + b);
		int lessonNumber = getLessons().size();
		gpa = sum / lessonNumber;
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
		return "Student [id=" + studentId + ", fullName=" + fullName + ", gpa=" + gpa + ", lessons=" + lessons + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(studentId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(studentId, other.studentId);
	}

}
