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

    public List<Finance> getFinance() {
        try
        {
            System.out.println("getFinance is called");
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return financeRepository.findAll();
    }
}
