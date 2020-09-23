package com.restapi.test;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_003_GetHeaders_GoogleAPI {

	@Test
	void getHeaderDetails() {

		// Define endpoint
		RestAssured.baseURI = "https://maps.googleapis.com";

		// Request Object
		RequestSpecification httpRequest = RestAssured.given();

		// Response Object
		Response response = httpRequest.request(Method.GET,
				"https://maps.googleapis.com/maps/api/place/nearbysearch/xml?location=-33.8670522,151.1957362&radius=1500&type=supermarket&key=AIzaSyBMX5PP8AGvYCeVmEXL-WLPpOsn5zhiqDI");

		String responseBody = response.getBody().asString();
		System.out.println("Response Body Is:" + responseBody);

		Headers header = response.getHeaders();
		for (Header h : header) {
			System.out.println(h.getName() + "-->" + h.getValue());
		}

		Headers header2 = response.headers();
		for (Header h : header2) {
			System.out.println(h.getName() + "-->" + h.getValue());
		}
	
	}

}
