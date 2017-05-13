package utility;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.testng.ITestContext;
import org.testng.Reporter;

import java.io.File;

/**
 * Created by PIIT_NYA on 5/13/2017.
 */
public class ExtentReportManager {
    private static ExtentReporter extent;
    private static ITestContext context;

    public synchronized static ExtentReporter getInstance(){
        if(extent == null){
            File outputDirectory = new File(context.getOutputDirectory());
            File resultDirectory = new File(outputDirectory.getParentFile(), "html");
            extent = new ExtentHtmlReporter("/Extent-Report/Report.html");
            Reporter.log("Extent Report Directory: " + resultDirectory, true);

        }
        return extent;
    }

    public static void setOutputDirectory(ITestContext context){
        ExtentReportManager.context = context;

    }
}
