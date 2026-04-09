package Resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class ExtendReporterNG {


    public static ExtentReports getReportObject(){
        String path = System.getProperty("user.dir") + "/reports/index.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("Web Automation");
        reporter.config().setDocumentTitle("Test Result");

        ExtentReports extend = new ExtentReports();
        extend.attachReporter(reporter);
        extend.setSystemInfo("Tester","Ganpat Shevale");


        return extend;
    }
}
