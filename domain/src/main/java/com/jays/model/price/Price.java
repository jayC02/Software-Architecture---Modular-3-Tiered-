package com.jays.model.price;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity


public class Price {
    @Id
    private int id;
    private String name;
    private Double price;
    private String saleType;
    private Boolean isDeliveryFree;

    public Price(int id, String name, double price, String saleType, boolean isDeliveryFree) {
        this.id = id;
        this.name = name;
        this.price = validatePrice(price) ? price : 0.0;
        this.saleType = saleType;
        this.isDeliveryFree = isDeliveryFree;
    }

    public void updatePrice(double newPrice) {
        if (validatePrice(newPrice)) {
            this.price = newPrice;
        }
    }

    public void applySaleOffer(String saleType, boolean isDeliveryFree) {
        this.saleType = saleType;
        this.isDeliveryFree = isDeliveryFree;
    }

    public void removeSaleOffer() {
        this.saleType = null;
        this.isDeliveryFree = false;
    }

    private boolean validatePrice(double price) {
        return price >= 0;
    }
}