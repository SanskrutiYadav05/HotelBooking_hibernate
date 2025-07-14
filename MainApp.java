package com.hotel;
import com.hotel.Dao.HotelDao;
import com.hotel.entity.Room;
import com.hotel.entity.Booking;

import java.util.List;
import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HotelDao dao = new HotelDao();

        while (true) {
            System.out.println("\n--- Hotel Room Booking ---");
            System.out.println("1. Add Room");
            System.out.println("2. View All Rooms");
            System.out.println("3. Book Room");
            System.out.println("4. View Bookings");
            System.out.println("5. Exit");
            System.out.print("Choose: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Room Type: ");
                    String type = sc.nextLine();
                    System.out.print("Price: ");
                    double price = sc.nextDouble();
                    dao.addRoom(new Room(type, price, true));
                    break;
                case 2:
                    List<Room> rooms = dao.getAllRooms();
                    rooms.forEach(System.out::println);
                    break;
                case 3:
                    System.out.print("Enter Room ID: ");
                    int roomId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Customer Name: ");
                    String name = sc.nextLine();
                    dao.bookRoom(roomId, name);
                    break;
                case 4:
                    List<Booking> bookings = dao.getAllBookings();
                    bookings.forEach(System.out::println);
                    break;
                case 5:
                    System.exit(0);
            }
        }
    }
}
