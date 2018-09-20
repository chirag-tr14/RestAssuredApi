package com.qa.assertion;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import  static org.hamcrest.Matcher.*;

import static org.hamcrest.Matchers.*;
import io.restassured.RestAssured;

public class Example1 {
	static final String APIKEY="75e3u4sgb2khg673cbv2gjup";

	@BeforeClass
	
	public static void init() {
		RestAssured.baseURI="http://api.walmartlabs.com";
		RestAssured.basePath="/v1";
	}
	
	
	@Test
	public void test001() {
		
		given()
		.queryParam("query", "ipod")
		.queryParam("format", "json")
		.queryParam("apiKey", APIKEY)
		.when()
		.get("/search")
		.then()
		.body("numItems", equalTo(11));
		
			System.out.println("------Starting Test---------");
		System.out.println("------The Total Number of items are:");
		System.out.println("------Ending Test---------");
		
	}
	@Test
	public void test002() {
		
		given()
		.queryParam("query", "ipod")
		.queryParam("format", "json")
		.queryParam("apiKey", APIKEY)
		.when()
		.get("/search")
		.then()
		.body("query", equalToIgnoringCase("IPOD"));
		
			System.out.println("------Starting Test---------");
		System.out.println("------The Total Number of items are:");
		System.out.println("------Ending Test---------");
		
	}
	
	@Test
	public void test003() {
		
		given()
		.queryParam("query", "ipod")
		.queryParam("format", "json")
		.queryParam("apiKey", APIKEY)
		.when()
		.get("/search")
		.then()
		.body("items.name", hasItem(("Apple iPod touch 32GB")));
		
			System.out.println("------Starting Test---------");
		System.out.println("------The Total Number of items are:");
		System.out.println("------Ending Test---------");
	}		
	@Test
	public void test004() {
		
		given()
		.queryParam("query", "ipod")
		.queryParam("format", "json")
		.queryParam("apiKey", APIKEY)
		.when()
		.get("/search")
		.then()
		.body("items.name", hasItem(("Apple iPod touch 32GB")));
		//.body("items.name", hasItem(("Apple iPod touch 32GB","Apple iPod touch 32GB")));
			System.out.println("------Starting Test---------");
		System.out.println("------The Total Number of items are:");
		System.out.println("------Ending Test---------");
	}		
	@Test
	public void test005() {
		
		given()
		.queryParam("query", "ipod")
		.queryParam("format", "json")
		.queryParam("apiKey", APIKEY)
		.when()
		.get("/search")
		.then()
		.body("items[0].giftOptions", hasKey("allowGiftReceipt"));
		//.body("items.name", hasItem(("Apple iPod touch 32GB","Apple iPod touch 32GB")));
			System.out.println("------Starting Test---------");
		System.out.println("------The Total Number of items are:");
		System.out.println("------Ending Test---------");
	}		
	@Test
	public void test006() {
		
		given()
		.queryParam("query", "ipod")
		.queryParam("format", "json")
		.queryParam("apiKey", APIKEY)
		.when()
		.get("/search")
		.then()
		.body("items[0].giftOptions", hasKey("allowGiftReceipt"));
		//.body("items.name", hasItem(("Apple iPod touch 32GB","Apple iPod touch 32GB")));
			System.out.println("------Starting Test---------");
		System.out.println("------The Total Number of items are:");
		System.out.println("------Ending Test---------");
	}	
}
