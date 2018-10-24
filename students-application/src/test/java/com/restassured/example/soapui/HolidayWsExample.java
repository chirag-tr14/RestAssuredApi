package com.restassured.example.soapui;

import org.junit.Test;

import io.restassured.RestAssured;

public class HolidayWsExample {

	
	@Test
	public void getHoildays() {
		
		String wsdlUrl="http://www.holidaywebservice.com//HolidayService_v2/HolidayService2.asmx?wsdl";
		String Payload="<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:hs=\"http://www.holidaywebservice.com/HolidayService_v2/\"> \r\n" + 
				"<soapenv:Body>\r\n" + 
				"    <hs:GetHolidaysAvailable>\r\n" + 
				"        <hs:CountryCode>Canada</hs:CountryCode>\r\n" + 
				"	</hs:GetHolidaysAvailable>\r\n" + 
				"</soapenv:Body>\r\n" + 
				"</soapenv:Envelope>";
		
		RestAssured.given()
		.contentType("text/xml")
		.body(Payload)
		.post(wsdlUrl)
		.then()
		.log()
		.all();
		
	}
}
