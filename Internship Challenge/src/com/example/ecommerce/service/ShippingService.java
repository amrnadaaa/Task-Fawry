package com.example.ecommerce.service;

import com.example.ecommerce.interfaces.Shippable;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ShippingService {
    static void ship(List<Shippable> items) {
        double totalWeight = 0;
        System.out.println("** Shipment notice **");

        Map<String, Integer> counts = new LinkedHashMap<>();
        Map<String, Double>  weights = new LinkedHashMap<>();

        for (Shippable p : items) {
            counts.merge(p.getName(), 1, Integer::sum);
            weights.putIfAbsent(p.getName(), p.getWeight());
            totalWeight += p.getWeight();
        }

        counts.forEach((name, count) -> {
            double weightGrams = weights.get(name) * 1000;
            System.out.printf("%dx %s %.0fg%n", count, name, weightGrams);
        });

        System.out.printf("Total package weight %.1fkg%n", totalWeight);
    }
}

