package utilities;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import libraries.ReusableLibrary;

public class ExtentReportManager {
	
	public static ExtentReports report;
	public static ExtentTest test;
	public static String applicationName;
	public static String testcasename_for_report="";
	public static ReusableLibrary reuse = new ReusableLibrary();
	
	 public static ExtentReports invokeExtentReport() throws Exception {
         applicationName = reuse.getProperty("ApplicationName");
         String path = System.getProperty("user.dir") + "\\Reports\\" +applicationName + "\\"
                                         + reuse.dateStamp() + "\\" + applicationName  + "_"
                                         + "_TestReport_" + reuse.dateStamp() + ".html";
         System.out.println("Path of the HTML Report: " + path);
         report = new ExtentReports(path, false);
         report.addSystemInfo("Report Name", "Cucumber Framework Report").addSystemInfo("Report Type", "Automation Report");
         return report;
	 }
     
	 public void invokeReport(String SceanrioName) {
		 try {
           if(report==null){
             report = invokeExtentReport();
             test = report.startTest(SceanrioName);
             test.assignAuthor(reuse.getProperty("Author_Name"));
             test.assignCategory(reuse.getProperty("Test_Category"));
             test.setDescription("My Store End to End Testing");
             }
             else if(report !=null && testcasename_for_report !=SceanrioName) {
				testcasename_for_report=SceanrioName;
				tearReport();
				report = invokeExtentReport();
				test = report.startTest(SceanrioName);
				test.assignAuthor( reuse.getProperty("Author_Name"));
				test.assignCategory(reuse.getProperty("Test_Category"));
				test.setDescription("Automation Practice");
             	}
		 	} catch (Exception e) {
             System.out.println("Reporting has not been created");
		 	}
	 }
	 
	 public void tearReport() throws Exception{
         report.endTest(test);
         report.flush();
	 }
}
