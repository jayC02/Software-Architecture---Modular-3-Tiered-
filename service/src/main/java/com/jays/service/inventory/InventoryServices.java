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
    private EmailService emailService; // Assuming you have an EmailService

    @Scheduled(fixedRate = 10000) // Checks every 10 seconds, adjust as needed
    public void checkStockLevels() {
        List<Inventory> lowStockItems = inventoryRepository.findByQuantityLessThanEqual(10); // Example threshold
        for (Inventory item : lowStockItems) {
            if (item.getQuantity() == 0) {
                reorderItem(item);
            }
            sendLowStockAlert(item);
        }
    }

    private void reorderItem(Inventory item) {
        // Logic to reorder item from central inventory
    }

    private void sendLowStockAlert(Inventory item) {
        // Logic to send alert (e.g., email) about low stock item
        emailService.sendEmail("manager@example.com", "Low Stock Alert", "Item " + item.getItemName() + " is low in stock.");
    }
}

