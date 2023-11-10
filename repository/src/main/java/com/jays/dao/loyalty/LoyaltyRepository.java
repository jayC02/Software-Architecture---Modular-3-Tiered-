package com.jays.dao.loyalty;

import com.jays.model.loyalty.Loyalty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface LoyaltyRepository extends JpaRepository<Loyalty, Integer>
{
    List<Loyalty> findByIsActiveTrue();
}
