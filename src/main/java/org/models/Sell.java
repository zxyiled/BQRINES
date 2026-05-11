package org.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.PrePersist;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "sells")
@Getter
@Setter
@NoArgsConstructor
public class Sell {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, updatable = false)
    private LocalDateTime date;

    @Column(nullable = false, length = 150)
    private String clientName;

    // Type of product sold: "vehicle" or "spares"
    @Column(nullable = false, length = 50)
    private String productType;

    @Column(nullable = false)
    private Long productId;
    
    @Column(nullable = false, length = 200)
    private String productName;
    
    @Column(nullable = false)
    private Integer quantity;

    @Column(nullable = false)
    private Double unitaryPrice;

    @Column(nullable = false)
    private Double total;

    // Actor who registered the sale (email of the user)
    @Column(nullable = false, length = 150, updatable = false)
    private String registeredBy;

    @PrePersist
    private void prePersist() {
        this.date = LocalDateTime.now();
    }
}
