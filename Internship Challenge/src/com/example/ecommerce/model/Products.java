package com.example.ecommerce.model;

public class Products {
    private String name ;
    private double price ;
    private int quantity;

    public Products(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
    public Products(String name, double price, int quantity,double weight)
    {
        this.name = name;
        this.price = price;
        this.quantity = quantity;

    }
    public int getQuantity()    { return quantity; }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void decreaseQty(Integer q) {
        quantity -= q;
    }


}
