package com.restapi.test;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DataDrivenTest {

	@Test(dataProvider = "getUserData")
	void createUsersTest(String name, String job) {

		RestAssured.baseURI = "https://reqres.in";

		RequestSpecification httpRequest = RestAssured.given();

		JSONObject requestParams = new JSONObject();
		requestParams.put("name", name);
		requestParams.put("job", job);

		httpRequest.header("application/form-data", ContentType.TEXT);

		httpRequest.body(requestParams.toJSONString());

		Response response = httpRequest.request(Method.POST, "/api/users");

		String responseBody = response.getBody().asString();
		System.out.println("Response is :" + responseBody);

		int status = response.getStatusCode();
		Assert.assertEquals(status, 201);

	}

	@DataProvider(name = "getUserData")
	Object[][] getUserData() {

		Object data[][] = XLUtils.getTestData("sheet1");

		return data;
	}

}
