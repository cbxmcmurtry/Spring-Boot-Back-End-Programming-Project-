package com.example.demo.entities;

import com.example.demo.entities.Country;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "divisions")
@Getter
@Setter
public class Division {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "division_id")
    @JsonProperty("id")
    private Long id;

    @Column(name = "division")
    @JsonProperty("division_name")
    private String divisionName;

    @Column(name = "create_date")
    @JsonProperty("create_date")
    private LocalDateTime createDate;

    @Column(name = "last_update")
    @JsonProperty("last_update")
    private LocalDateTime lastUpdate;

    @Column(name = "country_id")
    @JsonProperty("country_id")
    private long country_id;

    public void setCountry(Country country) {
        setCountryId(country.getId());
        this.country = country;
    }

    private void setCountryId(Long id) {
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id", nullable = false, insertable = false, updatable = false)
    @JsonProperty("country")
    private Country country;

    // Renamed to avoid conflicts
    public long getCountryId() {
        return country_id;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "division")
    private Set<Customer> customers = new HashSet<>();
}
