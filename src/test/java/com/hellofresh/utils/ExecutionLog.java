package com.hellofresh.utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ExecutionLog {

	public static void Log(String text) {
		try {
			ExecutionLog executionLog = new ExecutionLog();
			String dateTime = executionLog.getDate();
			String fileName = executionLog.getFileName();
			// Create file
			FileWriter fstream = new FileWriter("ExecutionLog//" + fileName + ".txt", true);
			BufferedWriter out = new BufferedWriter(fstream);
			text = dateTime + " [info]  " + text;
			out.write(text);
			out.newLine();

			// Close the output stream
			out.close();

		} catch (Exception e) {// Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
	}

	public static void LogExceptionMessage(Exception e) {

		try {
			ExecutionLog executionLog = new ExecutionLog();
			String dateTime = executionLog.getDate();
			ExecutionLog.Log(dateTime
					+ " [info]  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< Error message >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			String fileName = executionLog.getFileName();
			PrintWriter pw;
			pw = new PrintWriter(new FileWriter("ExecutionLog//" + fileName + ".txt", true));
			e.printStackTrace(pw);
			pw.close();
		} catch (Exception e1) {

			e1.printStackTrace();
		}
	}

	public static void LogErrorMessage(Error e) {
		ExecutionLog executionLog = new ExecutionLog();
		String dateTime = executionLog.getDate();
		ExecutionLog.Log(
				dateTime + " [info]  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< Error message >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		String fileName = executionLog.getFileName();
		PrintWriter pw;
		try {
			pw = new PrintWriter(new FileWriter("ExecutionLog//" + fileName + ".txt", true));
			e.printStackTrace(pw);
			pw.close();
		} catch (Exception e1) {
			
			e1.printStackTrace();
		}
	}

	public String getFileName() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		String fileName = "Report-" + dateFormat.format(cal.getTime());
		return fileName;
	}

	public String getDate() {
		DateFormat dateFormat = new SimpleDateFormat("MMM dd,yyyy HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		String dateTime = dateFormat.format(cal.getTime());
		return dateTime;
	}

	public static void LogEndClass(String text) {
		ExecutionLog executionLog = new ExecutionLog();
		String dateTime = executionLog.getDate();
		String fileName = executionLog.getFileName();
		try {
			// Create file
			FileWriter fstream = new FileWriter("ExecutionLog//" + fileName + ".txt", true);
			BufferedWriter out = new BufferedWriter(fstream);
			text = dateTime + " [info]  End Execution of Test Class " + text;
			out.write(text);
			out.newLine();
			out.write("*****************************************************************************");
			out.newLine();
			// Close the output stream
			out.close();

		} catch (Exception e) {// Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
	}

	public static void logGetRequestAndResponse(String text, Response response, String uriSubPart, String requestType)
			throws IOException {
		ExecutionLog executionLog = new ExecutionLog();
		String dateTime = executionLog.getDate();
		String fileName = executionLog.getFileName();
		try {
			FileWriter fstream = new FileWriter("ExecutionLog//" + fileName + ".txt", true);
			BufferedWriter out = new BufferedWriter(fstream);
			text = dateTime + " [info]  " + " Execution Started of Test Class " + text;
			out.newLine();
			out.write("*****************************************************************************");
			out.newLine();
			out.write(text);
			out.newLine();
			out.write("*****************************************************************************");
			out.newLine();
			out.write("------------Request and Response Content-----------");
			out.newLine();
			out.write("Method:" + requestType);
			out.newLine();
			out.write("URI=" + RestAssured.baseURI.toString() + uriSubPart);
			out.newLine();
			out.write("Response Body=" + response.asString());
			out.newLine();
			out.write("Response Code=" + response.statusCode());
			out.newLine();
			out.write("*****************************************************************************");
			out.newLine();
			// Close the output stream
			out.close();

		} catch (Exception e) {// Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
	}

}
