package GenericUtilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * This class provides Implemention for ITestListners Interface of Testng
 * @author hp
 *
 */

public class ListenerImplementation implements ITestListener
{
	ExtentReports report;
	ExtentTest test;
	
	public void onTestStart(ITestResult result) {
		
		String MethodName = result.getMethod().getMethodName();
		System.out.println(MethodName+"------Test Execution Started------");
		
		//add @Test to extent reports
		test = report.createTest(MethodName);
	}

	public void onTestSuccess(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		System.out.println(MethodName+"------Test Pass------");
		
		//Log the PASS status to extent Report
		test.log(Status.PASS, MethodName+"------Test Pass------");
	}

	public void onTestFailure(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		System.out.println(MethodName+"------Test Fail------");
		
		//Log the FAIL status to extent Report
		test.log(Status.FAIL,MethodName+"------Test Fail------");
		
		SeleniumUtility s=new SeleniumUtility();
		JavaUtility j=new JavaUtility();
		String screenshotName = MethodName+"-"+j.getDate();       
		
		try 
		{
			String path = s.captureScreenShot(BaseClass.sDriver, screenshotName);
		
		
		//Attach ScreenShot to Extent reports
		test.addScreenCaptureFromPath(path);
		
		
		
	}catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		System.out.println(MethodName+"------Test Skip------");
		
		//Log the status to exteent reports
		test.log(Status.SKIP,MethodName+"------Test Skip------");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		System.out.println("----suite Execution Started-----");

        //Extent Report Configuration
		ExtentSparkReporter rep=new ExtentSparkReporter(".\\ExtentReports\\Report-"+new JavaUtility().getDate()+".html");
		rep.config().setDocumentTitle("ExecutionReport");
		rep.config().setReportName("VTiger execution report");
		rep.config().setTheme(Theme.DARK);
		
		report=new ExtentReports();
		report.attachReporter(rep);
		report.setSystemInfo("Base platform", "Windows");
		report.setSystemInfo("Base browser", "edge");
		report.setSystemInfo("Base url", "http://localhost:8888/");
		report.setSystemInfo("Reporter Name", "Nisha");
		
	}

	public void onFinish(ITestContext context) {
	     System.out.println("------Suite Execution Finished------");
	     
	     //Generate Extent Report
	      report.flush();
	}

}
