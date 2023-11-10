package com.jays.service.loyalty;

import com.jays.dao.loyalty.LoyaltyRepository;
import com.jays.model.loyalty.Loyalty;
import com.jays.model.price.Price;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoyaltyServices {

    @Autowired
    private LoyaltyRepository loyaltyRepository;

    public List<Loyalty> getLoyalty() {
        try
        {
            System.out.println("getLoyaty is called");
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return loyaltyRepository.findAll();
    }
}
