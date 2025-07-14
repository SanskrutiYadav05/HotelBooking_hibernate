package com.hotel.Dao;

import com.hotel.HibernateUtil;
import com.hotel.entity.Booking;
import com.hotel.entity.Room;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.time.LocalDate;
import java.util.List;

public class HotelDao {

    public void addRoom(Room room) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            session.persist(room);
            tx.commit();
        }
    }

    public List<Room> getAllRooms() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Room", Room.class).list();
        }
    }

    public Room getAvailableRoomById(int roomId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Room room = session.get(Room.class, roomId);
            return (room != null && room.isAvailable()) ? room : null;
        }
    }

    public void bookRoom(int roomId, String customerName) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            Room room = session.get(Room.class, roomId);
            if (room != null && room.isAvailable()) {
                room.setAvailable(false);
                Booking booking = new Booking(customerName, LocalDate.now(), room);
                session.persist(booking);
                tx.commit();
                System.out.println("Room booked successfully!");
            } else {
                System.out.println("Room not available.");
            }
        }
    }

    public List<Booking> getAllBookings() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Booking", Booking.class).list();
        }
    }
}
