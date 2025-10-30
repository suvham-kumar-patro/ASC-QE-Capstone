package com.automation.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.File;

public class ExtentManager {
    private static ExtentReports extent;
    static String projectPath = System.getProperty("user.dir");

    public static ExtentReports getinstance() {
        if (extent == null) {
            String reportPath = projectPath + "\\src\\test\\resources\\Reports\\ExtentReport.html";

            // Ensure folder exists
            new File(projectPath + "\\src\\test\\resources\\Reports").mkdirs();

            ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
            spark.config().setReportName("TataCliq Automation Report");
            spark.config().setDocumentTitle("Test Results");

            extent = new ExtentReports();
            extent.attachReporter(spark);
        }
        return extent;
    }
}
