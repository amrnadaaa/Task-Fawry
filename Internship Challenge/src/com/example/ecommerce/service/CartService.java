package com.example.ecommerce.service;

import com.example.ecommerce.model.Products;

import java.util.LinkedHashMap;
import java.util.Map;

public class CartService {
    private final Map<Products, Integer> items = new LinkedHashMap<>();



    public void add(Products product, int quantity) {
        if (quantity <= 0) throw new IllegalArgumentException("Quantity must be >0");
        if (quantity > product.getQuantity())
            throw new IllegalArgumentException("Requested quantity exceeds available stock for" + product.getName());
        items.merge(product, quantity, Integer::sum);

    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public void clear() {
        items.clear();
    }

    public Map<Products, Integer> getItems() {
        return items;
    }
}
