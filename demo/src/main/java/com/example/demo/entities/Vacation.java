package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "vacations")
@Getter
@Setter

public class Vacation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vacation_id")
    @JsonProperty("id")
    private Long id;

    @Column(name = "vacation_title", nullable = false, length = 255)
    @JsonProperty("vacation_title")
    private String vacationTitle;

    @Column(name = "description", length = 255)
    @JsonProperty("description")
    private String description;


    @Column(name = "image_url", length = 255)
    @JsonProperty("image_URL")
    private String image_URL;

    @Column(name = "travel_fare_price", precision = 19, scale = 2)
    @JsonProperty("travel_price")
    private BigDecimal travelPrice;

    @Column(name = "create_date")
    @JsonProperty("create_date")
    private LocalDateTime createDate;

    @Column(name = "last_update")
    @JsonProperty("last_update")
    private LocalDateTime lastUpdate;

    @OneToMany(mappedBy = "vacation", cascade = CascadeType.ALL)
    @JsonProperty("excursions")
    private Set<Excursion> excursions;
}