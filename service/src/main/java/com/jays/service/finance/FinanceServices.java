package com.jays.service.finance;

import com.jays.dao.finance.FinanceRepository;
import com.jays.dao.price.PriceRepository;
import com.jays.model.finance.Finance;
import com.jays.model.loyalty.Loyalty;
import com.jays.model.price.Price;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FinanceServices
{
    @Autowired
    private FinanceRepository financeRepository;

    public Finance submitFinanceRequest(Finance request) {
        request.setStatus("Pending");
        return financeRepository.save(request);
    }
    public void updateFinance(long id, double newPrice) {
        Finance finance = financeRepository.findById(id).orElse(null);
        if (finance != null) {
            finance.updateFinance(newPrice);
            financeRepository.save(finance);
        }
    }
    public void addFinance(Finance finance) {
        financeRepository.save(finance);
    }

    public int getNextAvailableId() {
        //   Assuming a method in PriceRepository to get the max ID
        Integer maxId = financeRepository.findMaxId();
        return (maxId == null) ? 1 : maxId + 1;
    }
}
