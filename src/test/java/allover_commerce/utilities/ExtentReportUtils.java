package allover_commerce.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReportUtils {

    protected static ExtentReports extentReports;
    protected static ExtentHtmlReporter extentHtmlReporter;
    protected static ExtentTest extentTest;


    @BeforeClass
    public static void extentReportsSetUp(){

//        REPORT  PATH
        String currentTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String path = System.getProperty("user.dir")+"/test-output/reports/"+currentTime+"html_report.html";

//        creating HTML report in the path
        extentHtmlReporter = new ExtentHtmlReporter(path);

//        creating extent reports object for generating the Entire reports with configuration
        extentReports = new ExtentReports();


//        adding custom System Info(with extentReports obj)
        extentReports.setSystemInfo("Test Environment","Regression");
        extentReports.setSystemInfo("Application","TechProEd");
        extentReports.setSystemInfo("Browser","Chrome");
        extentReports.setSystemInfo("Team","Eagles");
        extentReports.setSystemInfo("SQA","John Fox");
        extentReports.setSystemInfo("Sprint Number", "SP206"); //adding Sprint Number


//        adding more custom info (with extentHtmlReporter)
        extentHtmlReporter.config().setReportName("TechProEd home page");
        extentHtmlReporter.config().setDocumentTitle("TechProEd extent reports");


//        DONE WITH CONFIGURATION
        extentReports.attachReporter(extentHtmlReporter); //create the report
//        SUMMARY : Extent Reports and Extent HTML Reporter is used to add custom information on the report and create the report in a PATH

//        REPORT IS DONE. NOW CREATING EXTENT TEST TO LOG INFO IN THE TEST CASE
//        Creating extent test
        extentTest= extentReports.createTest("My Extent Reporter","Regression Test Report");

    }



    @AfterClass
    public static void extentReportsTearDown(){
        // generating the report
        extentReports.flush();
    }


}


//https://www.extentreports.com/docs/versions/4/java/index.html

//Download extent reports dependency from Maven.
