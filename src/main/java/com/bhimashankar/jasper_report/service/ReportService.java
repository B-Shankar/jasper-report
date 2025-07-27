package com.bhimashankar.jasper_report.service;

import com.bhimashankar.jasper_report.model.Education;
import com.bhimashankar.jasper_report.model.TestSample;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.*;

@Service
public class ReportService {
    public byte[] generatePatientBill(List<TestSample> patients) throws Exception {
        InputStream reportStream = new ClassPathResource("reports/bill.jrxml").getInputStream();
        JasperReport jasperReport = JasperCompileManager.compileReport(reportStream);

        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(patients);

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("createdBy", "Hospital Management System");

        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);

        return JasperExportManager.exportReportToPdf(jasperPrint);
    }

    public byte[] generateSamplePDF(List<Education> educations) throws Exception {
        try {
            InputStream reportStream = new ClassPathResource("reports/sample.jrxml").getInputStream();
            JasperReport jasperReport = JasperCompileManager.compileReport(reportStream);

            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(educations);

            Map<String, Object> parameters = new HashMap<>();
            parameters.put("education", dataSource);
            parameters.put("position", "Software Engineer");
            parameters.put("name", "Bhimashankar Holkundi");

            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);

            return JasperExportManager.exportReportToPdf(jasperPrint);
        } catch (Exception e) {
            e.printStackTrace();
            return new byte[0];
        }
    }

    public byte[] generatePDF(List<Education> educations) {
        try {
            InputStream filePath = getClass().getResourceAsStream("/reports/sample.jasper");
            JasperReport report = (JasperReport) JRLoader.loadObject(filePath);

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
            return JasperExportManager.exportReportToPdf(print);

        } catch (Exception e) {
            e.printStackTrace();
            return new byte[0];
        }
    }
}
