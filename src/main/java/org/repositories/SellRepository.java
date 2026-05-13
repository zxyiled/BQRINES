package org.repositories;

import org.models.Sell;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface SellRepository extends JpaRepository<Sell, Long> {

    // Used by ReportController for date-range filtered reports
    List<Sell> findByDateBetween(LocalDateTime start, LocalDateTime end);

    //Audit trail: all sales registered by a specific user
    List<Sell> findByRegisteredBy(String email);
    
}
