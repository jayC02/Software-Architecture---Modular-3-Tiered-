package com.jays.controller.reportanalysis;

import com.jays.model.price.Price;
import com.jays.model.reportanalysis.ReportAndAnalysis;
import com.jays.service.reportanalysis.ReportAndAnalysisServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReportAndAnalysisController {

    @Autowired
    private ReportAndAnalysisServices service;

    @GetMapping("/reportanalysis")
    public List<ReportAndAnalysis> getReportAndAnalysis(){
        return service.getReportAndAnalysis();
    }
}
