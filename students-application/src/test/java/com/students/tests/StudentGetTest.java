package com.students.tests;

import org.junit.BeforeClass;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static org.hamcrest.Matcher.*;
import static io.restassured.RestAssured.*;

public class StudentGetTest {
	
@BeforeClass
public static  void init() {
	
	RestAssured.baseURI="http://localhost";
	RestAssured.port=8085;
	RestAssured .basePath="/student";
	
}
	

@Test
public void getStudentInformation() {
	 Response response =given()
			 
	.when()
	.get("/list");
	 //System.out.println(response.body().prettyPrint());
	 
	 given()
		.when()
		.get("/list")
		.then()
		.statusCode(400);

}

@Test
public void getStudentInfor() {
	/* Response response =given()
			 .when()
			 .get("/1");
	 System.out.println(response.body().prettyPrint());
	
	*/
	 Response response=given()
	.param("programme", "Financial Analysis")
	.param("limit", "2")
	.when()
	.get("/list");
	 System.out.println(response.prettyPeek());
	

}

}
