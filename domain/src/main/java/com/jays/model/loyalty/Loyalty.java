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
    private int loyaltyCardId;
    private Long customerId;
    private int points;
    private LocalDate dateIssued; // The date the card was issued
    private LocalDate lastUsed; // The last date the card was used
    private Long totalSpent; // Total amount spent by the customer
    private Boolean isActive; // Status of the loyalty card
}

