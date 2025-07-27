package com.bhimashankar.jasper_report.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Education {
    private String className;
    private String college;
    private String percentage;
}
