package com.megopalec3.appcore.entity;

import java.util.ArrayList;
import java.util.List;

public class OrderRepresentation implements Order{
    private User user;
    private List<Product> products = new ArrayList<>();
    private boolean paid = false;

    @Override
    public User getUser() {
        return user;
    }

    @Override
    public Order setUser(User user) {
        this.user = user;
        return this;
    }

    @Override
    public List<Product> getProducts() {
        return products;
    }

    @Override
    public Order addProducts(List<Product> products) {
        this.products.addAll(products);
        return this;
    }

    @Override
    public Order addProduct(Product product) {
        this.products.add(product);
        return this;
    }

    @Override
    public double getTotal() {
        return products
                .stream()
                .mapToDouble(Product::getPrice)
                .sum();
    }

    @Override
    public boolean isPaid() {
        return paid;
    }

    @Override
    public Order setPaid(boolean paid) {
        this.paid = paid;
        return this;
    }
}
