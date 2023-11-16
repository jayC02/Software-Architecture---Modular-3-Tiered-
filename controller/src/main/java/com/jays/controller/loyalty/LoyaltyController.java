package com.jays.controller.loyalty;

import com.jays.model.loyalty.Loyalty;
import com.jays.service.loyalty.LoyaltyServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loyalty")
public class LoyaltyController {

    @Autowired
    private LoyaltyServices loyaltyService;

    @PostMapping("/addPoints")
    public void addPoints(@RequestBody Loyalty request)
    {
        loyaltyService.addPoints(request.getCardNumber(), request.getPoints());
    }
}
