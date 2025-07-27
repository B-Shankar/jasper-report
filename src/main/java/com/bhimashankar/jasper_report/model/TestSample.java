package com.bhimashankar.jasper_report.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestSample {
    private Long id;
    private String name;
    private String treatment;
    private double amount;
}
