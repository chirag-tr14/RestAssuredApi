package com.students.tests;
import static org.hamcrest.Matcher.*;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

import com.student.model.Student;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class StudentPostTest {

	
	@BeforeClass
	public static  void init() {
		
		RestAssured.baseURI="http://localhost";
		RestAssured.port=8085;
		RestAssured .basePath="/student";
		
	}
	
	@Test
	public void createNewStudent() {
		ArrayList<String> courses= new ArrayList<String>();
		courses.add("java");
		courses.add("c++");
		
		Student student= new Student();
		student.setFirstName("rajesh");
		student.setLastName("Aslam");
		student.setEmail("rajesh@gmail.com");
		student.setProgramme("Computer Science");
		student.setCourses(courses);
		
		given()
		.contentType(ContentType.JSON)
		.when()
		.body(student)
		.post()
		.then()
		.statusCode(201);
		
	}
}
