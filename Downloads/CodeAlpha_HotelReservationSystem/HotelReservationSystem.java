import java.util.ArrayList;
import java.util.Scanner;

class Room {
    int roomNumber;
    String category;
    boolean isBooked;

    Room(int roomNumber, String category) {
        this.roomNumber = roomNumber;
        this.category = category;
        this.isBooked = false;
    }
}

public class HotelReservationSystem {

    static ArrayList<Room> rooms = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        rooms.add(new Room(101, "Standard"));
        rooms.add(new Room(102, "Deluxe"));
        rooms.add(new Room(103, "Suite"));

        int choice;

        do {
            System.out.println("\n===== HOTEL RESERVATION SYSTEM =====");
            System.out.println("1. View Rooms");
            System.out.println("2. Book Room");
            System.out.println("3. Cancel Booking");
            System.out.println("4. View Booked Rooms");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    viewRooms();
                    break;

                case 2:
                    bookRoom();
                    break;

                case 3:
                    cancelBooking();
                    break;

                case 4:
                    viewBookedRooms();
                    break;

                case 5:
                    System.out.println("Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);
    }

    static void viewRooms() {

        System.out.println("\nAvailable Rooms:");

        for (Room r : rooms) {

            System.out.println(
                "Room No: " + r.roomNumber +
                " | Category: " + r.category +
                " | Booked: " + r.isBooked
            );
        }
    }

    static void bookRoom() {

        System.out.print("Enter room number to book: ");
        int roomNo = sc.nextInt();

        for (Room r : rooms) {

            if (r.roomNumber == roomNo) {

                if (!r.isBooked) {

                    r.isBooked = true;
                    System.out.println("Room booked successfully!");

                } else {

                    System.out.println("Room already booked!");
                }

                return;
            }
        }

        System.out.println("Room not found!");
    }

    static void cancelBooking() {

        System.out.print("Enter room number to cancel booking: ");
        int roomNo = sc.nextInt();

        for (Room r : rooms) {

            if (r.roomNumber == roomNo) {

                if (r.isBooked) {

                    r.isBooked = false;
                    System.out.println("Booking cancelled!");

                } else {

                    System.out.println("Room is not booked!");
                }

                return;
            }
        }

        System.out.println("Room not found!");
    }

    static void viewBookedRooms() {

        System.out.println("\nBooked Rooms:");

        for (Room r : rooms) {

            if (r.isBooked) {

                System.out.println(
                    "Room No: " + r.roomNumber +
                    " | Category: " + r.category
                );
            }
        }
    }
}