package com.anirudh.order_service.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "ORDER_TB")
public class Order {

    @Id
    private int id;
    private String name;
    private int quantity;
    private double price;

    public Order(String name, int quantity, double price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }
}
