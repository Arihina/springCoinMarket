package com.example.springCoinMarket.dao.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "shop")
public class Shop {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(name = "quantity")
    private Integer quantity;
    @Column(name = "currency")
    private String currency;
}
