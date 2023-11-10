package com.jays.controller.finance;

import com.jays.model.finance.Finance;
import com.jays.model.inventory.Inventory;
import com.jays.service.finance.FinanceServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FinanceController {

    @Autowired
    private FinanceServices service;

    @GetMapping("/finance")
    public List<Finance> getFinance(){
        return service.getFinance();
    }
}
