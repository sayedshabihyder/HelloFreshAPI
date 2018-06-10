package com.hellofresh.utils;

public class GlobalConstant {

	// Url of API requests
	public static final String BASEURI = "http://services.groupkt.com";
	public static final String ALLCOUNTRIES = "/country/get/all";
	public static final String SPECIFICCOUNTRY = "/country/get/iso2code/";

	// Some country code to check in API
	public static final String UNITEDSTATES = "US";
	public static final String GERMANY = "DE";
	public static final String GREATBRITAIN = "GB";

	// Http response Code
	public static final int HTTP_OK = 200;
	public static final int HTTP_BAD_REQUEST = 400;
	public static final int HTTP_UNAUTHORIZED = 401;
	public static final int HTTP_INTERNAL_SERVER_ERROR = 500;
	public static final int HTTP_NOT_FOUND = 404;
	public static final int HTTP_CONFLICT = 409;
	public static final int HTTP_FORBIDDEN = 403;
	public static final int HTTP_SERVICE_UNAVAILABLE = 503;

	// Global Response Messages
	public static final String NOCOUNTRYFOUND = "No matching country found for requested code";

}
