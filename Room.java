package com.hotel.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "rooms")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String type;
    private double price;
    private boolean available;

    public Room() {}
    public Room(String type, double price, boolean available) {
        this.type = type;
        this.price = price;
        this.available = available;
    }

    // Getters and Setters
    public int getId() { return id; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }

    @Override
    public String toString() {
        return id + " | " + type + " | Rs." + price + " | " + (available ? "Available" : "Booked");
    }
}
