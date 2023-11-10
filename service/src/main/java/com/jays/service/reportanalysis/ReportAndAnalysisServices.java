package com.jays.service.reportanalysis;

import com.jays.dao.reportanalysis.ReportAndAnalysisRepository;
import com.jays.model.price.Price;
import com.jays.model.reportanalysis.ReportAndAnalysis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportAndAnalysisServices {

    @Autowired
    private ReportAndAnalysisRepository repository;

    public List<ReportAndAnalysis> getReportAndAnalysis() {
        try
        {
            System.out.println("getReportAndAnalysis is called");
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return repository.findAll();
    }
}
