package com.jays.dao.inventory;

import com.jays.model.inventory.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InventoryRepository extends JpaRepository<Inventory, Integer>
{
    List<Inventory> findByQuantityLessThan(int threshold);
}
