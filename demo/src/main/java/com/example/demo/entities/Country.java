package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "countries")
@Getter
@Setter

public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id")
    @JsonProperty("id")
    private Long id;
    //changed to countryName
    @Column(name = "country", nullable = false, length = 255)
    @JsonProperty("country_name")
    private String countryName;

    @Column(name = "create_date")
    @JsonProperty("create_date")
    private LocalDateTime createDate;

    @Column(name = "last_update")
    @JsonProperty("last_update")
    private LocalDateTime lastUpdate;

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL)
    @JsonProperty("divisions")
    private Set<Division> divisions;
    }
