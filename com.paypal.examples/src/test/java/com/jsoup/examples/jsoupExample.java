package com.jsoup.examples;




import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;


import io.restassured.RestAssured;
import io.restassured.authentication.FormAuthConfig;
import io.restassured.filter.session.SessionFilter;

public class jsoupExample {
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
	public void extractTitle() {
		String response=RestAssured.given().when().get("http://localhost:8085/").asString();
		
		Document documnet= Jsoup.parse(response);
		
		//System.out.println("Title:"+documnet.title().toUpperCase());
				
	}
	
	@Test
	public void extractElemenntTag() {
		String response=RestAssured.given().when().get("http://localhost:8085/").asString();
		
		Document documnet= Jsoup.parse(response);
		
		Elements element=documnet.getElementsByTag("form");
			System.out.println("Size "+element.size());
		for(Element e:element) {
			 //System.out.println(e);
		}
		
	}
	
	@Test
	public void extractElemenntID() {
		String response=RestAssured.given().when().get("http://localhost:8085/").asString();
		
		Document documnet= Jsoup.parse(response);
		
		Element element=documnet.getElementById("command");
		
			//System.out.println("Element contents "+element.text());
	}
	@Test
	public void extractElemenntLinks() {
		String response=RestAssured.given().when().get("http://localhost:8085/").asString();
		
		Document documnet= Jsoup.parse(response);
		
		Elements element=documnet.select("a[href]");
		
		for(Element e:element) {
			// System.out.println(e);
		}
	}
		
	@Test
	public void extractEmailInformation() {
		String response=RestAssured.given().sessionId(filter.getSessionId()).when().get("/student/list").asString();
		
		Document documnet= Jsoup.parse(response);
		
		Elements elements=documnet.select("table tbody tr td:nth-child(4)");
		System.out.println("Size of Emails :"+elements.size());
		
		
		ArrayList<String> actual=new ArrayList<String>();
		for(Element e:elements) {
			// System.out.println(e.text());
			actual.add(e.text());
		}
		assertThat(actual, hasItem("faucibus.orci.luctus@Duisac.netdhfg"));
		
		}
	}
	
	

