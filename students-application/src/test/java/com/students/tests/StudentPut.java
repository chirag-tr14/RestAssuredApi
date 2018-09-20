package com.students.tests;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matcher.*;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

import com.student.model.Student;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
public class StudentPut {

	
	@BeforeClass
	public static  void init() {
		
		RestAssured.baseURI="http://localhost";
		RestAssured.port=8085;
		RestAssured .basePath="/student";
		
	}
	@Test
	public void updateStudent() {
		ArrayList<String> courses= new ArrayList<String>();
		courses.add("java");
		courses.add("c++");
		courses.add("c");
		
		Student student= new Student();
		student.setFirstName("sgdfghdf.n");
		student.setLastName("Aslam.shaik");
		student.setEmail("aslam@gmail.com");
		student.setProgramme("Electroncis");
		student.setCourses(courses);
		
		given()
		.contentType(ContentType.JSON)
		.when()
		.body(student)
		.put("/101")
		.then()
		.statusCode(200);
		
	}
}
