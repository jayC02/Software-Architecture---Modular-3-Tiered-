package com.jays.dao.price;

import com.jays.model.price.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PriceRepository extends JpaRepository<Price, Integer> {

    // Find all prices with a specific sale type
    List<Price> findBySaleType(String saleType);

    // Find all prices where delivery is free
    List<Price> findByIsDeliveryFree(boolean isDeliveryFree);

    // Example of a custom query using JPQL
    @Query("SELECT p FROM Price p WHERE p.price > :price")
    List<Price> findPricesHigherThan(@Param("price") double price);

    @Query("SELECT MAX(p.id) FROM Price p")
    Integer findMaxId();
}
