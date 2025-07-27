package com.bhimashankar.jasper_report.controller;

import com.bhimashankar.jasper_report.model.Education;
import com.bhimashankar.jasper_report.model.TestSample;
import com.bhimashankar.jasper_report.service.ReportService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/report")
public class ReportController {

    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping("/bill")
    public ResponseEntity<byte[]> generatePatientBillTest() throws Exception {
        List<TestSample> patients = Arrays.asList(
                new TestSample(1L, "John Doe", "X-Ray", 500.00),
                new TestSample(2L, "Jane Smith", "MRI", 1500.00),
                new TestSample(3L, "Bob Lee", "Surgery", 8000.00)
        );

        byte[] report = reportService.generatePatientBill(patients);

        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=patient_bill.pdf");

        return ResponseEntity.ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(report);
    }

    @GetMapping("/sample")
    public ResponseEntity<byte[]> generateSampleReport() throws Exception {

        List<Education> educations = Arrays.asList(
                new Education("SSLC", "CYF School", "2018"),
                new Education("PUC", "CPM College", "2020"),
                new Education("B.TECH", "APPA Engineering College", "2024")
        );

        byte[] report = reportService.generateSamplePDF(educations);

        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=sample_report.pdf");

        return ResponseEntity.ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(report);
    }

    @GetMapping("/sample-test")
    public ResponseEntity<byte[]> generatePDF() throws Exception {

        List<Education> educations = Arrays.asList(
                new Education("SSLC", "CYF School", "2018"),
                new Education("PUC", "CPM College", "2020"),
                new Education("B.TECH", "APPA Engineering College", "2024")
        );

        byte[] report = reportService.generatePDF(educations);

        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=sample_report.pdf");

        return ResponseEntity.ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(report);
    }
}
