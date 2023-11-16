package com.jays.dao.finance;

import com.jays.model.finance.Finance;
import com.jays.model.inventory.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FinanceRepository extends JpaRepository <Finance, Long> {

    @Query("SELECT MAX(f.id) FROM Finance f")
    Integer findMaxId();

}
