package com.hellofresh.utils;

import java.io.IOException;

import org.testng.Assert;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestUtil {

	public static Response getRequest(RequestSpecification requestSpecification, String queryURL) throws IOException {

		// ExecutionLog.logGetRequestAndRespons(requestSpecification.log())
		Response response = requestSpecification.get(queryURL);

		return response;
	}

	/**
	 * Validate response data
	 * 
	 * @param response
	 * @param statusCode
	 * @param errorMsg
	 */
	public static void verifyResponseData(Response response, int statusCode, String errorMsg) {
		if (response.getStatusCode() != GlobalConstant.HTTP_OK) {
			String msg = response.then().extract().response().path("RestResponse.messages");
			Assert.assertTrue(msg.contains(errorMsg), "Not contains Expected: " + errorMsg + " Actual: " + msg);
		} else {
			Assert.assertEquals(response.getStatusCode(), statusCode);
		}

	}

	/**
	 * Verify specific country code in response
	 * 
	 * @param response
	 * @param countryCode
	 * @param errorMsg
	 */
	public static void validateSpecificCountryCodeInResponse(Response response, String countryCode, String errorMsg) {
		String message = response.then().extract().response().path("RestResponse.messages").toString();
		if (response.getStatusCode() != GlobalConstant.HTTP_OK && message.contains("")) {

			String codeToExtract = response.then().extract().response().path("RestResponse.result.alpha2_code")
					.toString();
			Assert.assertTrue(codeToExtract.contains(countryCode),
					"Not contains Expected: " + countryCode + " Actual: " + codeToExtract);
		} else {
			String msg = response.then().extract().response().path("RestResponse.messages").toString();
			Assert.assertTrue(msg.contains(errorMsg), "Not contains Expected: " + errorMsg + " Actual: " + msg);
		}
	}

}
