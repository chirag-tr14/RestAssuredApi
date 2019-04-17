package com.paypalexamples.test;

import static io.restassured.RestAssured.*;

import org.junit.BeforeClass;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.FormAuthConfig;
import io.restassured.filter.session.SessionFilter;
public class FormAuthExamples {
	
	public static SessionFilter filter;
	@BeforeClass
	public static void init() {
		
		filter=new SessionFilter();
		RestAssured.baseURI="http://localhost:8085";
		
		RestAssured.given().auth().form("user", "user",new FormAuthConfig("/login","uname","pwd"))
		.filter(filter)
		.get();
		
		System.out.println(filter.getSessionId());
	}

	@Test
	public void getAllStudents() {
		RestAssured.given()
		.sessionId(filter.getSessionId())
		.get("/student/list")
		.then()
		.log().all();
		
	}
}
