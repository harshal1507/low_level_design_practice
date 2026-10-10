package com.example.ecommerce.model;

import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String customerEmail;
    private double totalAmount;

    public Order() {}

    public Order(String customerEmail, double totalAmount) {
        this.customerEmail = customerEmail;
        this.totalAmount = totalAmount;
    }

    public Long getId() { return id; }
    public String getCustomerEmail() { return customerEmail; }
    public double getTotalAmount() { return totalAmount; }
}