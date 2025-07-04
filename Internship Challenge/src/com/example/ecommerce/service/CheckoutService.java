package com.example.ecommerce.service;
import com.example.ecommerce.interfaces.Expirable;
import com.example.ecommerce.interfaces.Shippable;
import com.example.ecommerce.model.Customer;
import com.example.ecommerce.model.Products;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CheckoutService {
    private static final double FLAT_SHIPPING_FEE_PER_KG = 20.0;

    public static void checkout(Customer cust, CartService cart) {
        if (cart.isEmpty()) throw new IllegalStateException("com.example.ecommerce.service.Cart is empty");
        double subtotal = 0;
        List<Shippable> shipList = new ArrayList<>();

        for (Map.Entry<Products, Integer> e : cart.getItems().entrySet()) {
            Products p = e.getKey();
            int qty = e.getValue();
            if (qty > p.getQuantity())
                throw new IllegalStateException(p.getName() + " out of stock");
            if (p instanceof Expirable exp && exp.isExpired())
                throw new IllegalStateException(p.getName() + " is expired");
            subtotal += p.getPrice() * qty;
            if (p instanceof Shippable s) {
                for (int i = 0; i < qty; i++) shipList.add(s);
            }
        }

        double shipping = 0;
        if (!shipList.isEmpty()) {

            ShippingService.ship(shipList);
            double totalKg = shipList.stream().mapToDouble(Shippable::getWeight).sum();
            shipping = totalKg * FLAT_SHIPPING_FEE_PER_KG;
        }

        double total = subtotal + shipping;
        if (total > cust.getBalance())
            throw new IllegalStateException("com.example.ecommerce.model.Customer balance is insufficient");


        cart.getItems().forEach((p, q) -> p.decreaseQty(q));
        cust.debit(total);
        System.out.println("** Checkout receipt **");
        cart.getItems().forEach((p, q) ->
                System.out.printf("%dx %s %.0f%n", q, p.getName(), p.getPrice() * q));
        System.out.println("----------------------");
        System.out.printf("Subtotal %.0f%n", subtotal);
        System.out.printf("Shipping %.0f%n", shipping);
        System.out.printf("Amount %.0f%n", total);
        cart.clear();
    }


}
