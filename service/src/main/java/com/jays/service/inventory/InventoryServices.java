package com.jays.service.inventory;

import com.jays.dao.inventory.InventoryRepository;
import com.jays.mailservice.EmailService;
import com.jays.model.inventory.Inventory;
import com.jays.model.price.Price;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class InventoryServices {

    @Autowired
    private InventoryRepository inventoryRepository;
    @Autowired
    private EmailService emailService;

    @Scheduled(fixedRate = 100000) // Checks every 100 seconds
    public void checkStockLevels() {
        System.out.println("Stock level Test");
        List<Inventory> lowStockItems = inventoryRepository.findByQuantityLessThanEqual(10);
        for (Inventory item : lowStockItems) {
            if (item.getQuantity() == 0) {
                reorderItem(item);
            }
            sendLowStockAlert(item);
        }
    }

    private void reorderItem(Inventory item) {
        // Logic to reorder item from central inventory
        System.out.println("Item " + item.getItemName() + " is out of stock. and has been reordered.");
    }
    private void sendLowStockAlert(Inventory item) {
        emailService.sendEmail("destorespring@gmail.com", "Low Stock Alert", "Item " + item.getItemName() + " is low in stock.");
    }
    public List<Inventory> getInventory() {
        return inventoryRepository.findAll();

    }
}

