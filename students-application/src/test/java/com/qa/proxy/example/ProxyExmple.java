package com.qa.proxy.example;

import org.apache.http.client.methods.RequestBuilder;
import org.junit.BeforeClass;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.ProxySpecification;
import io.restassured.specification.RequestSpecification;

public class ProxyExmple {

	public static RequestSpecBuilder rsec;
	public static RequestSpecification rp;
	
	@BeforeClass
	public static void Init() {
		RestAssured.baseURI="http://localhost:8080/student";
		
		ProxySpecification ps =new ProxySpecification("localhost", 5555, "http");
		//RestAssured.proxy(ps);
		
		rsec= new RequestSpecBuilder();
		rsec.setProxy(ps);
		rp=rsec.build();
	}
	
	@Test
	public void sendReques() {
		
		
		RestAssured.given()
		//.proxy("localhost",5555)
		.spec(rp)
		.when()
		.get("/list")
		.then()
		.log()
		.body();
		
	}
	
}
