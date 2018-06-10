package com.hellofresh.utils;

import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BaseTest {
	private static final Logger logger = LoggerFactory.getLogger(BaseTest.class);
	private static final String BREAK_LINE = "\n";

	public static ExtentTest test;
	public static ExtentReports extent;

	@BeforeSuite
	public void before() {
		extent = new ExtentReports("target/surefire-reports/ExtentReport.html", true);
	}

	@BeforeMethod
	public void setUp(Method method) throws Exception {
		test = extent.startTest(method.getName(), this.getClass().getName());
		test.assignAuthor("HelloFresh");
		test.assignCategory(this.getClass().getSimpleName());
	}

	@AfterSuite
	public void tearDownSuite() {
		extent.flush();
	}

	/* Report logs */
	public void reportLog(String message) {
		test.log(LogStatus.PASS, message);
		message = BREAK_LINE + message;
		logger.info("Message: " + message);
		Reporter.log(message);
	}

}
