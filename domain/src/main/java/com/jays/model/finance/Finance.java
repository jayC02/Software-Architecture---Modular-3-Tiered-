package com.jays.model.finance;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity

public class Finance {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String customerId;
    private Double amount;
    private String status;

    public void updateFinance(double newFinance) {
        if (validateFinance(newFinance)) {
            this.amount = newFinance;
        }
    }
    private boolean validateFinance(double finance) {
        return finance >= 0;
    }

}

