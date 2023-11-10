package com.jays.service.inventory;

import com.jays.dao.inventory.InventoryRepository;
import com.jays.model.inventory.Inventory;
import com.jays.model.price.Price;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class InventoryServices
{

    private final InventoryRepository inventoryRepository;

    @Autowired
    private InventoryRepository invRepository;



    @PostConstruct
    public void initInventory()
    {
        invRepository.saveAll(Stream.of(new Inventory
                (201,"Underwear",10,100,3.40,"Clothes"),new Inventory
                (202,"T shirts",5,50,11.50,"Clothes"))
                .collect(Collectors.toList()));

    }

    @Autowired
    public InventoryServices(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }
    public List<Inventory> findLowStockItems(int threshold){
        return inventoryRepository.findByQuantityLessThan(threshold);
    }
    public Inventory updateInventoryItemStock(int itemId, int quantityToAdd) {
        Inventory inventoryItem = inventoryRepository.findById(itemId)
                .orElseThrow(() -> new RuntimeException("Item not found with id: " + itemId));
        int newQuantity = inventoryItem.getQuantity() + quantityToAdd;
        inventoryItem.setQuantity(newQuantity);
        return inventoryRepository.save(inventoryItem);
    }
    public List<Inventory> getInventory() {
        try
        {
            System.out.println("getInventory is called");
        } catch (Exception e)
        {
            e.printStackTrace();

        }
        return invRepository.findAll();
    }
}
