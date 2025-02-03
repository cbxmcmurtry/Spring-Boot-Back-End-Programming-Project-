package com.example.demo.bootstrap;

import com.example.demo.dao.CountryRepository;
import com.example.demo.dao.CustomerRepository;
import com.example.demo.dao.DivisionRepository;
import com.example.demo.entities.Country;
import com.example.demo.entities.Customer;
import com.example.demo.entities.Division;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class BootstrapData implements CommandLineRunner {

    private final CustomerRepository customerRepository;
    private final DivisionRepository divisionRepository;
    private final CountryRepository countryRepository;

    public BootstrapData(CustomerRepository customerRepository, DivisionRepository divisionRepository, CountryRepository countryRepository) {
        this.customerRepository = customerRepository;
        this.divisionRepository = divisionRepository;
        this.countryRepository = countryRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("BootstrapData is running...");

        // Ensure the country exists or create it
        Country country = countryRepository.findByCountryName("United States")
                .orElseGet(() -> {
                    Country newCountry = new Country();
                    newCountry.setCountryName("United States");
                    newCountry.setCreateDate(LocalDateTime.now());
                    newCountry.setLastUpdate(LocalDateTime.now());
                    return countryRepository.save(newCountry);
                });

        Division division = divisionRepository.findByDivisionName("California")
                .orElseGet(() -> {
                    System.out.println("No 'California' division found. Adding sample data...");
                    Division newDivision = new Division();
                    newDivision.setDivisionName("California");
                    newDivision.setCreateDate(LocalDateTime.now());
                    newDivision.setLastUpdate(LocalDateTime.now());
                    newDivision.setCountry(country);
                    return divisionRepository.save(newDivision);
                });

        if (customerRepository.count() == 1) {
            System.out.println("Adding sample customers...");

            Customer customer1 = new Customer("John", "Doe", "123 Main St", "90001", "555-555-5555", LocalDateTime.now(), LocalDateTime.now(), division);
            customerRepository.save(customer1);

            Customer customer2 = new Customer("Jane", "Smith", "456 Oak St", "90002", "555-555-5556", LocalDateTime.now(), LocalDateTime.now(), division);
            customerRepository.save(customer2);

            Customer customer3 = new Customer("Alice", "Johnson", "789 Pine St", "90003", "555-555-5557", LocalDateTime.now(), LocalDateTime.now(), division);
            customerRepository.save(customer3);

            Customer customer4 = new Customer("Michael", "Williams", "101 Maple St", "90004", "555-555-5558", LocalDateTime.now(), LocalDateTime.now(), division);
            customerRepository.save(customer4);

            Customer customer5 = new Customer("Mary", "Brown", "202 Birch St", "90005", "555-555-5559", LocalDateTime.now(), LocalDateTime.now(), division);
            customerRepository.save(customer5);
        } else {
            System.out.println("Sample customers already exist, skipping data initialization.");
        }
    }
}
