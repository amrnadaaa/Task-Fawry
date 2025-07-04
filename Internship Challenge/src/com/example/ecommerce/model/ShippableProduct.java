package com.example.ecommerce.model;

import com.example.ecommerce.interfaces.Shippable;

public class ShippableProduct extends Products implements Shippable {
    private double weight;

    public ShippableProduct(String name, double price, int quantity, double weight) {
        super(name, price, quantity);
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

}
