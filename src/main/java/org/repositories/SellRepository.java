package org.repositories;

import org.models.Sell;

import java.time.LocalDateTime;
import java.util.List;

public class SellRepository {

    // Used by ReportController for date-range filtered reports
    List<Sell> findByDateBetween(LocalDateTime start, LocalDateTime end);

    //Audit trail: all sales registered by a specific user
    List<Sell> findByRegisteredBy(String email);
    
}
