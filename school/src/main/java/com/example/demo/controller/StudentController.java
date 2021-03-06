package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import com.example.demo.application.StudentApplication;
import com.example.demo.dto.request.AcquireStudentRequest;
import com.example.demo.dto.response.AcquireStudentResponse;
import com.example.demo.dto.response.DetailedStudentResponse;
import com.example.demo.entity.Lesson;
import com.example.demo.entity.Student;
import com.fasterxml.jackson.annotation.JsonIgnore;

@RestController
@RequestScope
@RequestMapping("/student")
public class StudentController {
	private StudentApplication studentApplication;

	public StudentController(StudentApplication studentApplication) {
		this.studentApplication = studentApplication;
	}

	@GetMapping("{identity}")
	public DetailedStudentResponse getStudentByIdentity(@PathVariable int identity) {
		return studentApplication.findStudentByIdentity(identity);

	}

	@PostMapping
	public AcquireStudentResponse acquireStudent(@RequestBody AcquireStudentRequest request) {
		return studentApplication.addStudent(request);

	}

	@GetMapping("/getall")
	public List<DetailedStudentResponse> getAllStudents() {
		return studentApplication.getAllStudent();

	}

	@GetMapping("/l/{lessonId}")

	public List<DetailedStudentResponse> findByLessonId(@PathVariable int lessonId) {
		return studentApplication.findByLessonId(lessonId);
	}

	@GetMapping("/s/{seasonId}")

	public List<DetailedStudentResponse> findBySeasonId(@PathVariable int seasonId) {
		return studentApplication.findBySeasonId(seasonId);
	}
	@PutMapping("addlesson/{studentId}/{lessonId}")
	public DetailedStudentResponse addLessonToStudent(@PathVariable int lessonId,@PathVariable int studentId) {
		return studentApplication.addLesson(studentId,lessonId);
		
	}
	@PutMapping("addfirstgrade{studentId}/{lessonId}/{grade}")
	public DetailedStudentResponse addFirstGradeToStudent (@PathVariable int lessonId,@PathVariable int studentId,int grade) {
		return studentApplication.addFirstGrade(studentId,lessonId,grade);
	}
	@PutMapping("addsecondgrade{studentId}/{lessonId}/{grade}")
	public DetailedStudentResponse addSecondGradeToStudent (@PathVariable int lessonId,@PathVariable int studentId,int grade) {
		return studentApplication.addSecondGrade(studentId,lessonId,grade);
	}
	
}
