package com.example.demo.application;

import java.util.List;

import com.example.demo.dto.request.AcquireStudentRequest;
import com.example.demo.dto.response.AcquireStudentResponse;
import com.example.demo.dto.response.DetailedStudentResponse;
import com.example.demo.entity.Lesson;
import com.example.demo.entity.Student;

public interface StudentApplication {

	DetailedStudentResponse findStudentByIdentity(int identity);

	AcquireStudentResponse addStudent(AcquireStudentRequest request);

	List<DetailedStudentResponse> getAllStudent();

	List<DetailedStudentResponse> findByLessonId(int lessonId);

	List<DetailedStudentResponse> findBySeasonId(int seasonId);

	DetailedStudentResponse addLesson(int studentId, int lessonId);


	DetailedStudentResponse addFirstGrade(int studentId, int lessonId, int grade);

	DetailedStudentResponse addSecondGrade(int studentId, int lessonId, int grade);



	
}
