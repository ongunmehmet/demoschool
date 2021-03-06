package com.example.demo.application.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.demo.application.StudentApplication;
import com.example.demo.application.exception.LessonNotFoundException;
import com.example.demo.application.exception.StudentNotFoundException;
import com.example.demo.dto.request.AcquireStudentRequest;
import com.example.demo.dto.response.AcquireStudentResponse;
import com.example.demo.dto.response.DetailedStudentResponse;
import com.example.demo.entity.Lesson;
import com.example.demo.entity.Student;
import com.example.demo.repository.LessonRepository;
import com.example.demo.repository.StudentRepository;

@Service
public class StandartStudentService implements StudentApplication {
	private StudentRepository studentRepository;
	private ModelMapper modelMapper;
	private LessonRepository lessonRepository;

	public StandartStudentService(StudentRepository studentRepository, ModelMapper modelMapper,LessonRepository lessonRepository) {
		this.studentRepository = studentRepository;
		this.modelMapper = modelMapper;
		this.lessonRepository=lessonRepository;
	}

	@Override
	public DetailedStudentResponse findStudentByIdentity(int identity) {
		var student = studentRepository.findById(identity).orElseThrow(() -> new StudentNotFoundException());
		var detailedStudentResponse = modelMapper.map(student, DetailedStudentResponse.class);		
	return  detailedStudentResponse;
	}

	@Override
	public AcquireStudentResponse addStudent(AcquireStudentRequest request) {
		var student = modelMapper.map(request, Student.class);
		return modelMapper.map(studentRepository.save(student), 
				AcquireStudentResponse.class);
	}

	@Override
	public List<DetailedStudentResponse> getAllStudent() {
	List<DetailedStudentResponse> students=studentRepository.findAll().stream().map(student->modelMapper.map(student, DetailedStudentResponse.class)).toList();
	return students;
	}

	@Override
	public List<DetailedStudentResponse> findByLessonId(int lessonId) {
		List<DetailedStudentResponse> students=studentRepository.findAllBy_LessonId(lessonId).stream().map(student->modelMapper.map(student, DetailedStudentResponse.class)).toList();
	 
		return students;
	}

	@Override
	public List<DetailedStudentResponse> findBySeasonId(int seasonId) {
		List<DetailedStudentResponse> students=studentRepository.findAllBySeasonId(seasonId).stream().map(student->modelMapper.map(student, DetailedStudentResponse.class)).toList();
		 
		return students;
	}

	@Override
	public DetailedStudentResponse addLesson(int studentId, int lessonId) {
		Student student= studentRepository.findById(studentId).orElseThrow(() -> new StudentNotFoundException());
		Lesson addedLesson=lessonRepository.findById(lessonId).orElseThrow(() -> new LessonNotFoundException());
		var studentLessons = student.getLessons();
		studentLessons.add(addedLesson);
		student.setLessons(studentLessons);
		studentRepository.save(student);
		return modelMapper.map(student,DetailedStudentResponse.class);
	}

	@Override
	public DetailedStudentResponse addFirstGrade(int studentId, int lessonId, int grade) {
		Student student= studentRepository.findById(studentId).orElseThrow(() -> new StudentNotFoundException());
		Lesson addedLesson=lessonRepository.findById(lessonId).orElseThrow(() -> new LessonNotFoundException());
		var studentLessons = student.getLessons();
		studentLessons.get(lessonId).setFirstGrade(grade);
		student.setLessons(studentLessons);
		studentRepository.save(student);
		
		return modelMapper.map(student,DetailedStudentResponse.class);
	}

	@Override
	public DetailedStudentResponse addSecondGrade(int studentId, int lessonId, int grade) {
		Student student= studentRepository.findById(studentId).orElseThrow(() -> new StudentNotFoundException());
		Lesson addedLesson=lessonRepository.findById(lessonId).orElseThrow(() -> new LessonNotFoundException());
		var studentLessons = student.getLessons();
		studentLessons.get(lessonId).setSecondGrade(grade);
		student.setLessons(studentLessons);
		studentRepository.save(student);
		
		return modelMapper.map(student,DetailedStudentResponse.class);
	}
	



}