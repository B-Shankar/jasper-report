package com.bhimashankar.jasper_report;

import com.bhimashankar.jasper_report.model.Education;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class JasperReportApplication {

	public static void main(String[] args) {
		SpringApplication.run(JasperReportApplication.class, args);

		// Create an instance of the class to use getClass()
		JasperReportApplication app = new JasperReportApplication();

		try {
			InputStream filePath = app.getClass().getResourceAsStream("/reports/sample.jasper");
			JasperReport report = (JasperReport) JRLoader.loadObject(filePath);

			// Sample data for the report
			List<Education> educations = Arrays.asList(
					new Education("SSLC", "CYF School", "2018"),
					new Education("PUC", "CPM College", "2020"),
					new Education("B.TECH", "APPA Engineering College", "2024")
			);

			JRBeanCollectionDataSource education = new JRBeanCollectionDataSource(educations);
			Map<String, Object> parameters = new HashMap<>();
			parameters.put("education", education);
			parameters.put("position", "Software Engineer");
			parameters.put("name", "Bhimashankar Holkundi");

			// Fill the report
			JasperPrint print = JasperFillManager.fillReport(report, parameters, new JREmptyDataSource());
			System.out.println("Report filled successfully.");

			// Export to PDF
			System.out.println("Exporting PDF...");
			JasperExportManager.exportReportToPdfFile(print, "C:\\Users\\B.Shankar\\Desktop\\Learn\\jasper-report\\src\\main\\resources\\static\\sample12345.pdf");
			System.out.println("Report generated successfully!");
		} catch (JRException e) {
			System.out.println("Error generating report: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error: " + e.getMessage());
		}
	}

}
