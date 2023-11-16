package com.jays.controller.finance;

import com.jays.model.finance.Finance;
import com.jays.model.inventory.Inventory;
import com.jays.service.finance.FinanceServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/finance")
public class FinanceController {

    @Autowired
    private FinanceServices financeService;

    @PostMapping("/request")
    public Finance createFinanceRequest(@RequestBody Finance request) {
        return financeService.submitFinanceRequest(request);
    }
    @PutMapping("/{id}")
    public String updateFinance(@PathVariable Long id, @RequestParam double newFinance) {
        financeService.updateFinance(id, newFinance);
        return "Finance updated successfully";
    }
}
