package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "carts")
@Getter
@Setter
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    @JsonProperty("id")
    private Long id;

    @Column(name = "package_price", precision = 19, scale = 2)
    @JsonProperty("package_price")
    private BigDecimal packagePrice;

    @Column(name = "party_size")
    @JsonProperty("party_size")
    private int partySize;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    @JsonProperty("status")
    private StatusType status;

    @Column(name = "order_tracking_number")
    @JsonProperty("orderTrackingNumber")
    private String orderTrackingNumber;

    @Column(name = "create_date")
    @JsonProperty("create_date")
    private LocalDateTime createDate;

    @Column(name = "last_update")
    @JsonProperty("last_update")
    private LocalDateTime lastUpdate;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    @JsonProperty("customer")
    private Customer customer;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<CartItem> items = new HashSet<>();

    public enum StatusType {
        pending,
        ordered,
        canceled
    }
}