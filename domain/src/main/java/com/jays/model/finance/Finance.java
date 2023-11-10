package com.jays.model.finance;

import jakarta.persistence.Entity;
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
    private Long transactionId;
    private Long customerId;
    private Long amount;
    private LocalDateTime applicationDate;
    private LocalDateTime approvalDate;
}
