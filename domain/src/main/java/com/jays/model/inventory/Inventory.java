package com.jays.model.inventory;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Entity
public class Inventory
{
    @Id
    private int itemId;
    private String itemName;
    private int quantity;
    private int reorderThreshold;
    private double Price;
    private String category;


}
