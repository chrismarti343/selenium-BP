package utils;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentFactory {
    public static ExtentReports getInstance() {
        ExtentReports extent;
        String projectPath = System.getProperty("user.dir");
        String path = projectPath + "/reporte/reporte.html";
        extent = new ExtentReports(path, false);

        return extent;
    }
}
