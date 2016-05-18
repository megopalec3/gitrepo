package com.megopalec3.appcore.entity;

import java.io.Serializable;
import java.util.List;

public interface Order extends Serializable {

    User getUser();

    Order setUser(User user);

    List<Product> getProducts();

    Order addProducts(List<Product> products);

    Order addProduct(Product product);

    double getTotal();

    boolean isPaid();

    Order setPaid(boolean paid);
}