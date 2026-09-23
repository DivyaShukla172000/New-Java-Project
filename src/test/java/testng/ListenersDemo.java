package testng;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenersDemo implements ITestListener {
	
	
	ExtentSparkReporter sp ;
	ExtentReports er ;
	ExtentTest et;

	//Alt+Shift+s to fetch all these implemented  method from ITestListener
	@Override
	public void onStart(ITestContext context) {
		System.out.println("om Start");
		Date myDate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("hhmmss");
		String filename =sdf.format(myDate);

		String reportPath=System.getProperty("user.dir")+"/TestReports/ExtentReport"+filename+".html";
		 sp = new ExtentSparkReporter(reportPath);
	 er = new ExtentReports();
				
		
		sp.config().setReportName("STAD Selenium Automation");
		sp.config().setDocumentTitle("TEST AUTOMATION REPORT");
		sp.config().setTheme(Theme.STANDARD);
		
		
		er.attachReporter(sp);
		er.setSystemInfo("Team", "STAD QA");
		er.setSystemInfo("Tester", "Divya");
		er.setSystemInfo("Environment", "QA");
		
		
	}
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("om Test Start");
		 et = er.createTest(result.getName());
		et.log(Status.INFO, "The Method" + result.getName()+"Started");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("om Test Pass");
		 et = er.createTest(result.getName());
		et.log(Status.PASS, "The Method" + result.getName()+"Pass");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("om test fail");
		 et = er.createTest(result.getName());
		et.log(Status.FAIL, "The Method" + result.getName()+"Fail");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("om Test Skip");
		 et = er.createTest(result.getName());
		et.log(Status.SKIP, "The Method" + result.getName()+"SKIP");
	}
	
	@Override
	public void onFinish(ITestContext context) {
		System.out.println("om Finish");
		er.flush();
	}
	
 
}
