package utility;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import java.util.HashMap;
import java.util.Map;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

/**
 * Created by PIIT_NYA on 5/13/2017.
 */
public class ExtentTestManager {

    static Map<Integer, ExtentTest> extentTestMap = new HashMap<Integer, ExtentTest>();

    private static ExtentReporter extent = utility.ExtentReportManager.getInstance();
    private static ExtentReporter extentUpdate = utility.ExtentReportManager.getInstance();

    public static synchronized ExtentTest getTest() {
        return extentTestMap.get((int) (long) (Thread.currentThread().getId()));
    }

    public static synchronized void endTest() {
        extent.setEndTime(extentTestMap.get((int) (long) (Thread.currentThread().getId()));
    }

    public static synchronized ExtentTest startTest(String testName) {
        return startTest(testName, "");
    }
    public static synchronized ExtentTest startTestClass(String className, String testName) {
        return startTest(className,testName, "");
    }

    public static synchronized ExtentTest startTest(String testName, String desc) {
        ExtentTest test = extent..startTest(testName, desc);
        extentTestMap.put((int) (long) (Thread.currentThread().getId()), test);

        return test;
    }
    public static synchronized ExtentTest startTest(String className,String testName, String desc) {
        ExtentTest test = extentUpdate.startTest(testName, desc);
        extentTestMap.put((int) (long) (Thread.currentThread().getId()), test);

        return test;
    }
}
