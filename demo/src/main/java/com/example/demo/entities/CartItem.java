package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "cart_items")
@Getter
@Setter
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_item_id")
    @JsonProperty("id")
    private Long id;

    @Column(name = "create_date")
    @JsonProperty("create_date")
    private LocalDateTime createDate;

    @Column(name = "last_update")
    @JsonProperty("last_update")
    private LocalDateTime lastUpdate;

    @ManyToOne
    @JoinColumn(name = "cart_id", nullable = false)
    @JsonProperty("cart")
    private Cart cart;


    @ManyToOne
    @JoinColumn(name = "vacation_id", nullable = false)
    @JsonProperty("vacation")
    private Vacation vacation;

    @ManyToMany
    @JoinTable(
            name = "excursion_cartitem",
            joinColumns = @JoinColumn(name = "cart_item_id"),
            inverseJoinColumns = @JoinColumn(name = "excursion_id")
    )
    @JsonProperty("excursions")
    private Set<Excursion> excursions;
}