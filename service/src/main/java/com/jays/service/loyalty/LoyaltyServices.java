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


    public void addPoints(int cardNumber, int points) {
        System.out.println("Loyalty Services called!");
        Loyalty card = loyaltyRepository.findById(cardNumber).orElseThrow();
        card.setPoints(card.getPoints() + points);
        loyaltyRepository.save(card);
    }
}
