package com.jays.controller.inventory;

import com.jays.model.inventory.Inventory;
import com.jays.service.inventory.InventoryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class InventoryController
{
    @Autowired
    private InventoryServices service;

    @GetMapping("/inventory")
    public List<Inventory> getInventory(){
        return service.getInventory();
    }

}
