package com.jays.controller.loyalty;

import com.jays.model.loyalty.Loyalty;
import com.jays.service.loyalty.LoyaltyServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoyaltyController {

    @Autowired
    private LoyaltyServices service;

    @GetMapping("/loyaltycard")
    public List<Loyalty> getLoyalty(){
        return service.getLoyalty();
    }
}
