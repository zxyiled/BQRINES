package org.repositories;

import org.models.Spare;
import java.util.List;

public class SpareRepository {

    // Returns only active spare parts for catalog display
    List<Spare> findByActiveTrue();

    // Filter by category for inventory views
    List<Spare> findByCategory(String category);

    // Used by NotificationService to detect low stock
    List<Spare> findByActiveTrueAndStockLessThanEqual(int umbral);
}
