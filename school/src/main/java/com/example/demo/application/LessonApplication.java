package com.example.demo.application;

import com.example.demo.entity.Lesson;

public interface LessonApplication {

	Lesson addLesson(Lesson lesson);

	Lesson updateStudent(int identity, Lesson request);
	

}
