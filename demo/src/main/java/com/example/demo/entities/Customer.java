package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "customers")
@Getter
@Setter
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    @JsonProperty("id") // Matches the "id" property in the DTO
    private Long id;

    @Column(name = "customer_first_name", nullable = false, length = 255)
    @JsonProperty("firstName") // Matches the "firstName" property in the DTO
    private String firstName;

    @Column(name = "customer_last_name", nullable = false, length = 255)
    @JsonProperty("lastName") // Matches the "lastName" property in the DTO
    private String lastName;

    @Column(name = "address", nullable = false, length = 255)
    @JsonProperty("address") // Matches the "address" property in the DTO
    private String address;

    @Column(name = "postal_code", length = 255)
    @JsonProperty("postalCode") // Matches the "postalCode" property in the DTO
    private String postalCode;

    @Column(name = "phone", length = 255)
    @JsonProperty("phone") // Matches the "phone" property in the DTO
    private String phone;

    @Column(name = "create_date", nullable = false)
    private LocalDateTime createDate;

    @Column(name = "last_update", nullable = false)
    private LocalDateTime lastUpdate;

    @ManyToOne
    @JoinColumn(name = "division_id", nullable = false)
    private Division division;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private Set<Cart> carts;

    public Customer(String firstName, String lastName, String address, String postalCode, String phone, LocalDateTime createDate, LocalDateTime lastUpdate, Division division) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.postalCode = postalCode;
        this.phone = phone;
        this.createDate = createDate;
        this.lastUpdate = lastUpdate;
        this.division = division;
    }
}