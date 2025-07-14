package com.hotel.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "bookings")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String customerName;
    private LocalDate bookingDate;

    @ManyToOne
    private Room room;

    public Booking() {}
    public Booking(String customerName, LocalDate bookingDate, Room room) {
        this.customerName = customerName;
        this.bookingDate = bookingDate;
        this.room = room;
    }

    // Getters and Setters
    public int getId() { return id; }
    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }
    public LocalDate getBookingDate() { return bookingDate; }
    public void setBookingDate(LocalDate bookingDate) { this.bookingDate = bookingDate; }
    public Room getRoom() { return room; }
    public void setRoom(Room room) { this.room = room; }

    @Override
    public String toString() {
        return id + " | " + customerName + " | " + bookingDate + " | Room ID: " + room.getId();
    }
}
