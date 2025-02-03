package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "excursions")
@Getter
@Setter
public class Excursion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "excursion_id")
    @JsonProperty("id")
    private Long id;

    @Column(name = "create_date")
    @JsonProperty("create_date")
    private LocalDateTime createDate;
    //changed to excursionPrice
    @Column(name = "excursion_price", precision = 19, scale = 2)
    @JsonProperty("excursion_price")
    private BigDecimal excursion_price;
    //line 26 changed Title to excursionTitle following dto model
    @Column(name = "excursion_title", nullable = false, length = 255)
    @JsonProperty("excursion_title")
    private String excursionTitle;

    @Column(name = "image_url", length = 255)
    @JsonProperty("image_URL")
    private String image_URL;

    @Column(name = "last_update")
    @JsonProperty("last_update")
    private LocalDateTime lastUpdate;

    @ManyToOne
    @JoinColumn(name = "vacation_id", nullable = false)
    @JsonProperty("vacation")
    private Vacation vacation;

    @ManyToMany(mappedBy = "excursions")
    private Set<CartItem> cartItems;
}
