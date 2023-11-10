package com.jays.controller.price;

import com.jays.model.price.Price;
import com.jays.service.price.PriceServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prices") // Base path for all endpoints in this controller
public class PriceController {

    @Autowired
    private PriceServices service;

    // Existing endpoint to get all prices
    @GetMapping
    public List<Price> getPrices(){
        return service.getPrices();
    }

    // Endpoint to update a price
    @PutMapping("/{id}")
    public String updatePrice(@PathVariable int id, @RequestParam double newPrice) {
        service.updatePrice(id, newPrice);
        return "Price updated successfully";
    }

    // Endpoint to apply a sale offer
    @PostMapping("/{id}/applySale")
    public String applySaleOffer(@PathVariable int id, @RequestParam String saleType, @RequestParam boolean isDeliveryFree) {
        service.applySaleOffer(id, saleType, isDeliveryFree);
        return "Sale offer applied successfully";
    }

    // Endpoint to remove a sale offer
    @PostMapping("/{id}/removeSale")
    public String removeSaleOffer(@PathVariable int id) {
        service.removeSaleOffer(id);
        return "Sale offer removed successfully";
    }
}
