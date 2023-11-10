package com.jays.dao.finance;

import com.jays.model.finance.Finance;
import com.jays.model.inventory.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FinanceRepository extends JpaRepository <Finance, Long> {

}
