package com.example.demo.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import com.example.demo.application.LessonApplication;
import com.example.demo.entity.Lesson;

@RestController
@RequestScope
@RequestMapping("lesson")
public class LessonController {
	private LessonApplication lessonApplication;

	public LessonController(LessonApplication lessonApplication) {
		this.lessonApplication = lessonApplication;
	}
	
	@PostMapping
	public Lesson addLesson(@RequestBody Lesson lesson) {
		return lessonApplication.addLesson(lesson);
	}
	@PutMapping("{identity}")
	public Lesson updateLesson(@PathVariable int identity,
			@RequestBody Lesson request) {
		return lessonApplication.updateStudent(identity, request);
	}
	

}
