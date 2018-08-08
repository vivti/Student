package student.Maven;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentManager {
	private static ExtentReports extent;
	private static ExtentHtmlReporter htmlReporter;
	private static ExtentTest test;
	private static String filepath="./Report/htmlReport.html";
	public static ExtentReports GetExtent() {
		if(extent!=null)
			return extent;
		extent=new ExtentReports();
		extent.attachReporter(getHtmlReporter());
		return extent;
	}
	public static ExtentHtmlReporter getHtmlReporter() {
		htmlReporter=new ExtentHtmlReporter(filepath);
		htmlReporter.config().setChartVisibilityOnOpen(true);
		htmlReporter.config().setDocumentTitle("Simple  extent Report");
		htmlReporter.config().setReportName("Google Test");
		return htmlReporter;
	}
	public static ExtentTest createTest(String name,String description) {
		
		test=extent.createTest(name,description);
		return test;
		
	}

}
