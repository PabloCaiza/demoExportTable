package com.example.demoexporttable;

import jakarta.annotation.ManagedBean;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Named
@ApplicationScoped
public class ProductService {

    private List<Product> products;

    @PostConstruct
    public void init() {
        products = new ArrayList<>();
        products.add(new Product("1","potato","a",1,2.90));
        products.add(new Product("1","potato","a",1,2.90));
        products.add(new Product("1","potato","a",1,2.90));
        products.add(new Product("1","potato","a",1,2.90));
        products.add(new Product("1","potato","a",1,2.90));
    }

    public List<Product> getProducts() {
        return products;
    }
}
