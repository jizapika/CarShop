package com.jizapika.carShop.domain;

import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String color;
    private Integer price;

    public Car() {
    }

    public Car(String color, Integer price) {
        this.color = color;
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getPrice() {
        return price;
    }

    public void setTag(Integer price) {
        this.price = price;
    }
}