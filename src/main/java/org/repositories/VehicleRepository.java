package org.repositories;

import org.models.Vehicle;
import java.util.List;

public class VehicleRepository {

    // Returns only active vehicles for catalog display
    List<Vehicle> findByActiveTrue();

    // Used by NotificationService to detect low stock
    List<Vehicle> findByActiveTrueAndStockLessThanEqual(int umbral);  
}
