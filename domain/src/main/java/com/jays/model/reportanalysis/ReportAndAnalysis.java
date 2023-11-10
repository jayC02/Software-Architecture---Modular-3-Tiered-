package com.jays.model.reportanalysis;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity

public class ReportAndAnalysis {

    @Id
    private int reportId;
    private String reportType;
    private String period;
    private Long totalSales;
    private int totalUnitsSold;

}
