package com.filedownload.example;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

import java.io.File;

import org.junit.Test;


public class FileDownloadExample {
	
	@Test
	public void VerifyDowLoadFile() {
		File inputFile= new File(System.getProperty("user.dir")+File.separator+"geckodriver-v0.22.0-arm7hf.tar.gz");
		
		int expected=(int)inputFile.length();
		System.out.println("The size of File :"+expected);
		
		
		//read the downlaoded file
	byte[] actualValue= given()
		.when()
		.get("https://github.com/mozilla/geckodriver/releases/download/v0.22.0/geckodriver-v0.22.0-arm7hf.tar.gz")
		.then()
		.extract()
		.asByteArray();
	
	System.out.println("The size of Actual File :"+actualValue.length);
	
	assertThat(expected, equalTo(actualValue.length));
		
		
	}

}
