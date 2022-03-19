package com.example.demo.application.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.application.LessonApplication;
import com.example.demo.application.exception.StudentNotFoundException;
import com.example.demo.entity.Lesson;
import com.example.demo.entity.Student;
import com.example.demo.repository.LessonRepository;
@Service
public class StandartLessonService implements LessonApplication {
 private LessonRepository lessonRepository;
 private ModelMapper modelMapper;

public StandartLessonService(LessonRepository lessonRepository,ModelMapper modelMapper) {
	this.lessonRepository = lessonRepository;
	this.modelMapper= modelMapper;
}

 public Lesson addLesson( Lesson lesson) {
	 return lessonRepository.save(lesson);
 }

@Override
public Lesson updateStudent(int identity, Lesson request) {
	var managedLesson = lessonRepository.findById(identity)
			.orElseThrow(() -> new StudentNotFoundException());
	managedLesson.setLessonName(request.getLessonName());
	managedLesson.setSeason(request.getSeason());
	managedLesson.getStudentsTakesLesson().clear();
	managedLesson.getStudentsTakesLesson().addAll(request.getStudentsTakesLesson().stream().map(student ->modelMapper.map(student,Student.class)).toList());
	lessonRepository.save(managedLesson);
  return managedLesson;
	
}
 
}
