package com.fileupload.example;

import org.junit.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.File;


public class FileUploadExample {
	
	@Test
	public void uploadFileExample() {
		
		String apiKey="f5186784a6f4889cdb67636769beb18bb598f35a";
		 File inputFile= new File(System.getProperty("user.dir")+File.separator+"video-to-gif-sample.gif");
		 System.out.println(inputFile.length());
		 String endpoint = "https://sandbox.zamzar.com/v1/jobs";
		 
		 
		given() 
		.auth()
		.basic(apiKey, "")
		.multiPart("source_file",inputFile)
		.multiPart("target_format","png")
		.when()
		.post(endpoint)
			.then()
			.log()
			.all();
	}

}
