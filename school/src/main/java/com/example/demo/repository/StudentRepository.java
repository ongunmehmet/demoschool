package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
	@Query("SELECT s FROM Student s left join  s.lessons c WHERE c.id = :lessonId")
	List<Student> findAllBy_LessonId(int lessonId);
	
	@Query(value="SELECT s.studentId,s.fullName,s.gpa FROM students s, lessons l, seasons se, students_lessons sl WHERE\r\n"
			+ "sl.student_id=s.studentId AND\r\n"
			+ "sl.lesson_id=l.lessonId AND\r\n"
			+ "l.season_id=se.seasonId AND\r\n"
			+ "se.seasonId=(?1)",nativeQuery = true)
	List<Student> findAllBySeasonId(int seasonId);

}
