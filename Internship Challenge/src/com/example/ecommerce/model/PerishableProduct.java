package com.example.ecommerce.model;

import java.time.LocalDate;

public class PerishableProduct extends Products {
    private LocalDate expiryDate;

    PerishableProduct(String name, double price, int quantity, LocalDate expiryDate) {

        super(name, price, quantity);
        this.expiryDate = expiryDate;
    }


}
