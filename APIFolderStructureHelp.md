# HelloFreshAPI help for folder structure and files

Repo URL:https://github.com/sayedshabihyder/HelloFreshAPI

Added API test cases in above location.

Following are some important point for the framework folder structure:

1. src/test/java: This location contains three packages:

a) com.hellofresh.report: This package is the container of Extent report files used to generate extent report for the test scripts.You can see extent report "ExtentReport.html" file in "target\surefire-reports" folder.

b) com.hellofresh.test: Is the home of all test script created for API. All scripts uses reportLog for providing information what user is doing in each step.reportLog will display in extent report to provide detailed information of test execution.

c) com.hellofresh.utils: This package contains following java files:

    1) BaseTest: BaseTest is used to configure extent report for tests.
	
	2)ExecutionLog: ExecutionLog is used to provide detailed information of API request, response complete URI,response code and error message information in a file, which enable end user to understand what is tested and can easily tested manually with this file.
	
	3)GlobalConstant: Is created to store all constant values used in project.
	
	4) RestUtil: Contains all functions related to API request , validation of response code, validation of response content etc.
	
	5)Utilities: This contains method like generating random string, reading application file etc.
	
2. src/test/resources: This folder contains suit.xml file in testngsuite folder.

3. ExecutionLog Folder: ExecutionLog contains details logs of api test in "Report-2018-06-10.txt".Following are the main components of file:

   a) Method: Name of method used (POST,GET etc)
   b) URI: Complete web services url for the request made.
   c) Response Body: Complete response body content.
   d) Response Code: Response code received for response made.
   
 Note: For adding new country following are the details:
 There are two possible URI:
  a) http://services.groupkt.com
  b) http://services.groupkt.com/country
 
 I manually execute POST request with both options(a and b) and result is same. Response of POST method provide a 200 code but is not able to add anything,you can verify it with ExecutionLog report details of test case "addRequiredCountry".
 
 
 

