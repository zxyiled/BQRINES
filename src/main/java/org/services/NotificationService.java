package org.services;

import org.models.Spare;
import org.models.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NotificationService {

    @Autowired
    private InventoryService inventoryService;

    // In-memory alert lists, refreshed every 5 minutes by the scheduler.
    // Controllers inject these lists into the Thymeleaf model for the GERENTE dashboard.
    private List<Vehicle> vehiclesWithLowStock = new ArrayList<>();
    private List<Spare> sparesWithLowStock = new ArrayList<>();

    // Runs every 5 minutes — checks for items at or below the minimum stock threshold
    @Scheduled(fixedRate = 300000)
    public void checkLowStock() {
        vehiclesWithLowStock = inventoryService.findVehiclesWithLowStock();
        sparesWithLowStock = inventoryService.findSparesWithLowStock();
    }

    public List<Vehicle> getVehiclesWithLowStock() {
        return vehiclesWithLowStock;
    }

    public List<Spare> getSparesWithLowStock() {
        return sparesWithLowStock;
    }

    // Returns total alert count for navbar badge indicator
    public int getTotalAlerts() {
        return vehiclesWithLowStock.size() + sparesWithLowStock.size();
    }
}