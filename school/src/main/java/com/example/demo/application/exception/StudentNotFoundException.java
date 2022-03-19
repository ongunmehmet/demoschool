package com.example.demo.application.exception;

@SuppressWarnings("serial")
public class StudentNotFoundException extends RuntimeException {

	public StudentNotFoundException() {
		super("Cannot find the student");

	}

}