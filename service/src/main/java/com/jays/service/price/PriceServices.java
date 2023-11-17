package com.jays.service.price;

import com.jays.dao.price.PriceRepository;
import com.jays.mailservice.EmailService;
import com.jays.model.price.Price;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class PriceServices {

    @Autowired
    private PriceRepository repository;

    @Autowired
    private EmailService emailService;

    @PostConstruct
    public void initPrice() {
        repository.saveAll(Stream.of(
                new Price(101, "ProductA", 20.456, "3 for 2", false),
                new Price(102, "ProductB", 30.00, "buy one get one free", true)
        ).collect(Collectors.toList()));
    }

    public List<Price> getPrices() {
        try {
            System.out.println("getPrices is called");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return repository.findAll();
    }

    public List<Price> getAllPrices() {
        return repository.findAll();
    }


    public void addPrice(Price price) {
        repository.save(price);
    }


    public void updatePrice(int id, double newPrice) {
        Price price = repository.findById(id).orElse(null);
        if (price != null) {
            price.updatePrice(newPrice);
            repository.save(price);
        }
    }

    public void applySaleOffer(int id, String saleType, boolean isDeliveryFree) {
        Price price = repository.findById(id).orElse(null);
        if (price != null) {
            price.applySaleOffer(saleType, isDeliveryFree);
            repository.save(price);
        }
    }

    public void removeSaleOffer(int id) {
        Price price = repository.findById(id).orElse(null);
        if (price != null) {
            price.removeSaleOffer();
            repository.save(price);
        }
    }

    public int getNextAvailableId() {
        //   Assuming a method in PriceRepository to get the max ID
        Integer maxId = repository.findMaxId();
        return (maxId == null) ? 1 : maxId + 1;
    }
}

