package com.paypal.examples;

import org.junit.BeforeClass;
import org.junit.Test;
import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;




public class BaseClass {
	
	public static String accesToken;
	
	public static final String ClientID="ASv2ocjv6209WGDXYUwUE7r1FwlBZUFlTphOw1kEcf42Z-t9q6alk_p9uOgArBCNNMkRBy34ewjMCUhc";
	
	public static final String ClientSecret="EGLXfdWZ2pOJ9-6ehsHlDi5jSbRgK342o_SEupQK_ZLby8Z7SANYMvyys6jaNjHO8tvO22YkomOwdBr_";
	
	@BeforeClass
	 public static void init() {
		
		RestAssured.baseURI="https://api.sandbox.paypal.com";
		RestAssured.basePath="/v1";
		
		accesToken=	given()
		.parameters("grant_type","client_credentials")
		.auth()
		.preemptive()
		.basic(ClientID, ClientSecret)
		.when()
		.post("/oauth2/token")
		.then()
		.log()
		.all()
		.extract()
		.path("access_token");
		System.out.println("Access Token is :"+accesToken);
	}

	
}
