package com.hellofresh.test;

import org.testng.annotations.Test;

import com.hellofresh.utils.BaseTest;
import com.hellofresh.utils.ExecutionLog;
import com.hellofresh.utils.GlobalConstant;
import com.hellofresh.utils.RestUtil;
import com.hellofresh.utils.Utilities;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

import java.io.IOException;

public class RequestsForCountries extends BaseTest {

	String countryCode = Utilities.randomString(3);

	@Test
	public void retrieveAllCountries() throws IOException {

		reportLog("Send Get Request");
		Response response = given().when().get(GlobalConstant.BASEURI + GlobalConstant.ALLCOUNTRIES);

		reportLog("validate that US is returned in the response");
		RestUtil.validateSpecificCountryCodeInResponse(response, GlobalConstant.UNITEDSTATES, "");

		reportLog("validate DE is returned in the response");
		RestUtil.validateSpecificCountryCodeInResponse(response, GlobalConstant.GERMANY, "");

		reportLog("validate GB is returned in the response");
		RestUtil.validateSpecificCountryCodeInResponse(response, GlobalConstant.GREATBRITAIN, "");

		reportLog("Validate Response Code");
		RestUtil.verifyResponseData(response, GlobalConstant.HTTP_OK, "");

		reportLog("log request/response contents in ExecutionLog file");
		ExecutionLog.logGetRequestAndResponse(
				this.getClass().getName() + " and Test method "
						+ Thread.currentThread().getStackTrace()[1].getMethodName(),
				response, GlobalConstant.ALLCOUNTRIES, "GET");

		ExecutionLog.LogEndClass(this.getClass().getName());

	}

	@Test
	public void retrieveDataForUnitedStates() throws IOException {

		reportLog("Send Get Request");
		Response response = given().when()
				.get(GlobalConstant.BASEURI + GlobalConstant.SPECIFICCOUNTRY + GlobalConstant.UNITEDSTATES);

		reportLog("validate that US is returned in the response");
		RestUtil.validateSpecificCountryCodeInResponse(response, GlobalConstant.UNITEDSTATES, "");

		reportLog("Validate Response Code");
		RestUtil.verifyResponseData(response, GlobalConstant.HTTP_OK, "");

		reportLog("print request/response contents");
		ExecutionLog.logGetRequestAndResponse(
				this.getClass().getName() + " and Test method "
						+ Thread.currentThread().getStackTrace()[1].getMethodName(),
				response, GlobalConstant.SPECIFICCOUNTRY + GlobalConstant.UNITEDSTATES, "GET");

		ExecutionLog.LogEndClass(this.getClass().getName());

	}

	@Test
	public void retrieveDataForGermany() throws IOException {

		reportLog("Send Get Request");
		Response response = given().when()
				.get(GlobalConstant.BASEURI + GlobalConstant.SPECIFICCOUNTRY + GlobalConstant.GERMANY);

		RestUtil.validateSpecificCountryCodeInResponse(response, GlobalConstant.GERMANY, "");

		reportLog("Validate Response Code");
		RestUtil.verifyResponseData(response, GlobalConstant.HTTP_OK, "");

		reportLog("print request/response contents");
		ExecutionLog.logGetRequestAndResponse(
				this.getClass().getName() + " and Test method "
						+ Thread.currentThread().getStackTrace()[1].getMethodName(),
				response, GlobalConstant.SPECIFICCOUNTRY + GlobalConstant.GERMANY, "GET");

		ExecutionLog.LogEndClass(this.getClass().getName());

	}

	@Test
	public void retrieveDataForGreatBritain() throws IOException {

		reportLog("Send Get Request");
		Response response = given().when()
				.get(GlobalConstant.BASEURI + GlobalConstant.SPECIFICCOUNTRY + GlobalConstant.GREATBRITAIN);

		RestUtil.validateSpecificCountryCodeInResponse(response, GlobalConstant.GREATBRITAIN, "");

		reportLog("Validate Response Code");
		RestUtil.verifyResponseData(response, GlobalConstant.HTTP_OK, "");

		reportLog("print request/response contents");
		ExecutionLog.logGetRequestAndResponse(
				this.getClass().getName() + " and Test method "
						+ Thread.currentThread().getStackTrace()[1].getMethodName(),
				response, GlobalConstant.SPECIFICCOUNTRY + GlobalConstant.GREATBRITAIN, "GET");

		ExecutionLog.LogEndClass(this.getClass().getName());

	}

	@Test
	public void retrieveInExistentCountry() throws IOException {

		reportLog("Send Get Request");
		Response response = given().when().get(GlobalConstant.BASEURI + GlobalConstant.SPECIFICCOUNTRY + countryCode);

		reportLog("Validate Response Code");
		RestUtil.verifyResponseData(response, GlobalConstant.HTTP_OK, GlobalConstant.NOCOUNTRYFOUND);

		reportLog("validate country code is not in response");
		RestUtil.validateSpecificCountryCodeInResponse(response, countryCode, GlobalConstant.NOCOUNTRYFOUND);

		reportLog("print request/response contents");
		ExecutionLog.logGetRequestAndResponse(
				this.getClass().getName() + " and Test method "
						+ Thread.currentThread().getStackTrace()[1].getMethodName(),
				response, GlobalConstant.SPECIFICCOUNTRY + countryCode, "GET");

		ExecutionLog.LogEndClass(this.getClass().getName());

	}

	@Test
	public void addRequiredCountry() throws IOException {

		reportLog("Send post request");
		Response response = given().formParam("name", "Test Country").formParam("", "").formParam("", "").when()
				.post(GlobalConstant.BASEURI);

		reportLog("Validate Response Code");
		RestUtil.verifyResponseData(response, GlobalConstant.HTTP_OK, "");

		reportLog("print request/response contents");
		ExecutionLog.logGetRequestAndResponse(
				this.getClass().getName() + " and Test method "
						+ Thread.currentThread().getStackTrace()[1].getMethodName(),
				response, GlobalConstant.BASEURI+ "", "POST");

		ExecutionLog.LogEndClass(this.getClass().getName());
	}

}
