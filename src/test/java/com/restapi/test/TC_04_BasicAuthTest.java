package com.restapi.test;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class TC_04_BasicAuthTest {

	@Test
	void getUser() {

		RestAssured.baseURI = "http://localhost:8080";
		
		RestAssured.given().auth().preemptive().basic("admin", "admin1SS")
		.when().get("/login").then().assertThat().statusCode(200);

			

	}

}
