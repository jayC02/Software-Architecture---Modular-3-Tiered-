package com.jays.model.loyalty;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity


public class Loyalty
{
    @Id
    private int cardNumber;
    private String customerName;
    private int points;
    private Long totalSpent;
    private Boolean isActive;
}

