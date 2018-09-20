package com.jsonpath.examples;
import static io.restassured.RestAssured.*;

import org.junit.BeforeClass;
import org.junit.Test;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;


import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.List;


public class SearchJsonPathExample {
	
	static final String APIKEY="75e3u4sgb2khg673cbv2gjup";

	@BeforeClass
	
	public static void init() {
		RestAssured.baseURI="http://api.walmartlabs.com";
		RestAssured.basePath="/v1";
	}
	
	
	@Test
	public void test001() {
		
		int num=given()
		.queryParam("query", "ipod")
		.queryParam("format", "json")
		.queryParam("apiKey", APIKEY)
		.when()
		.get("/search")
		.then().extract().path("numItems");
		
			System.out.println("------Starting Test---------");
		System.out.println("------The Total Number of items are:"+num);
		System.out.println("------Ending Test---------");
		assertEquals(10, num);
	}
	
	@Test
	public void test002() {
		
		String queryValue  =given()
		.queryParam("query", "ipod")
		.queryParam("format", "json")
		.queryParam("apiKey", APIKEY)
		.when()
		.get("/search")
		.then().extract().path("query");
		
			System.out.println("------Starting Test---------");
		System.out.println("------The Total Number of items are :"+queryValue);
		System.out.println("------Ending Test---------");
		
	}
	
	
	@Test
	public void test003() {
		
		String queryValue  =given()
		.queryParam("query", "ipod")
		.queryParam("format", "json")
		.queryParam("apiKey", APIKEY)
		.when()
		.get("/search")
		.then().extract().path("items[0].name");
		
			System.out.println("------Starting Test---------");
		System.out.println("------The Total Number of items are :"+queryValue);
		System.out.println("------Ending Test---------");
		
	}
	
	
	@Test
	public void test004() {
		
		HashMap<String , String > values  =given()
		.queryParam("query", "ipod")
		.queryParam("format", "json")
		.queryParam("apiKey", APIKEY)
		.when()
		.get("/search")
		.then().extract().path("items[0].giftOptions");
		
			System.out.println("------Starting Test---------");
		System.out.println("------The Total Number of items are :"+values);
		System.out.println("------Ending Test---------");
		
	}
	
	@Test
	public void test005() {
		
		int size  =given()
		.queryParam("query", "ipod")
		.queryParam("format", "json")
		.queryParam("apiKey", APIKEY)
		.when()
		.get("/search")
		.then().extract().path("items.size()");
		
		
			System.out.println("------Starting Test---------");
		System.out.println("------The Total Number of items are :"+size);
		System.out.println("------Ending Test---------");
		
	}
	
	@Test
	public void test006() {
		
		List<String> names =given()
		.queryParam("query", "ipod")
		.queryParam("format", "json")
		.queryParam("apiKey", APIKEY)
		.when()
		.get("/search")
		.then().extract().path("items.name");
		
			System.out.println("------Starting Test---------");
		System.out.println("------The Total Number of items are :"+names);
		System.out.println("------Ending Test---------");
		
	}
	
/*	
	@Test
	public void test007() {
		
		List<HashMap<String,Object>>  values =given()
		.queryParam("query", "ipod")
		.queryParam("format", "json")
		.queryParam("apiKey", APIKEY)
		.when()
		.get("/search")
		.then().extract().path("items.findaAll{it.name=='Apple iPod touch 128GB'}");
		
			System.out.println("------Starting Test---------");
		System.out.println("------The Total Number of items are :"+values);
		System.out.println("------Ending Test---------");
		
	}*/
	
	@Test
	public void test008() {
		
		List<String>  price =given()
		.queryParam("query", "ipod")
		.queryParam("format", "json")
		.queryParam("apiKey", APIKEY)
		.when()
		.get("/search")
		.then().extract().path("items.findaAll{it.name=='salePrice<300'}.name");
		
			System.out.println("------Starting Test---------");
		System.out.println("------The Total Number of items are :"+price);
		System.out.println("------Ending Test---------");
		
	}
	
}
