package com.restapi.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_001_GET_Request {

	@Test
	public void getWeatherDetails() {

		// Step 1: Specify the URI
		RestAssured.baseURI = "https://reqres.in/";

		// Step 2: Request Object
		RequestSpecification httpRequest = RestAssured.given();

		// Step 3: Response Object
		Response response = httpRequest.request(Method.GET, "/api/users/2");

		String responseBody = response.getBody().asString();

		// Step 4: Validate & Print response
		System.out.println("Response is :" + responseBody);

		int statusCode = response.getStatusCode();
		System.out.println("Status Code is :" + statusCode);
		Assert.assertEquals(statusCode, 200);

		String statusLine = response.getStatusLine();
		System.out.println("Status Line is :" + statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");

	}

}
