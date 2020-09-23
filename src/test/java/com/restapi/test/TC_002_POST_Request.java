package com.restapi.test;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_002_POST_Request {

	@Test
	void createUser() {

		// specify endpoint
		RestAssured.baseURI = "https://reqres.in";

		// Request object
		RequestSpecification httpRequest = RestAssured.given();

		//payload
		JSONObject requestParams = new JSONObject();
		requestParams.put("name", "morpheus");
		requestParams.put("job", "leader");

		//adding header
		httpRequest.header("application/form-data", ContentType.TEXT);

		httpRequest.body(requestParams.toJSONString()); //attach data to request

		Response response = httpRequest.request(Method.POST, "/api/users");

		String responseBody = response.getBody().asString();

		// Step 4: Validate & Print response
		System.out.println("Response is :" + responseBody);

		int statusCode = response.getStatusCode();
		System.out.println("Status Code is :" + statusCode);
		Assert.assertEquals(statusCode, 201);

		String id = response.jsonPath().get("id");
		System.out.println("User has been created with id:" +id);

	}

}
