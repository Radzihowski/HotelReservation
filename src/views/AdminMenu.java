package views;

import api.AdminResource;
import model.*;
import service.ReservationService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class AdminMenu {
    private static final  AdminResource adminResource = AdminResource.getInstance();
    public void start() {
        boolean keepRunning = true;
        try (Scanner scanner = new Scanner(System.in)) {
            while (keepRunning) {
                try {
                    System.out.println("1. See all Customers");
                    System.out.println("2. See all Rooms");
                    System.out.println("3. See all Reservations");
                    System.out.println("4. Add a Room");
                    System.out.println("5. Back to Main Menu");
                    int selection = Integer.parseInt(scanner.next());

                    if (selection == 1) {
                        System.out.println("See all Customers");
                        Collection<Customer>  customers = AdminResource.getInstance().getAllCustomers();
//                        keepRunning = false;
                    } else if (selection == 2) {
                        System.out.println("See all Rooms");
                        Collection<IRoom> rooms = AdminResource.getInstance().getAllRooms();
//                        keepRunning = false;
                    } else if (selection == 3) {
                        System.out.println("See all Reservations");
                        AdminResource.getInstance().displayAllReservations();
//                        keepRunning = false;
                    } else if (selection == 4) {
                        System.out.println("Add a Room");
//                        keepRunning = false;
                        addARoom(scanner);
                    } else if (selection == 5) {
                        System.out.println("Back to Main Menu");
                        keepRunning = false;
                        MainMenu mainMenu = new MainMenu();
                        mainMenu.start();
                    } else {
                        System.out.println("Please select menu between 1 and 5");
                    }
                } catch (Exception ex) {
                    System.out.println("Invalid input");
                }
            }
        }
    }

    private static void addARoom(Scanner input) {
        AdminResource adminResource = AdminResource.getInstance();
        String addRoom;
        int type;

        do {
            RoomType roomType = null;
            input.nextLine();
            System.out.println("Enter room number: ");
            String roomNumber = input.nextLine();
            System.out.println("Enter price per night: ");
            Double roomPrice = input.nextDouble();
            do {
                System.out.println("Enter room type: 1 - Single bed, 2 - Double bed");
                type = input.nextInt();
                if (type == 1) {
                    roomType = RoomType.SINGLE;
                } else if (type == 2) {
                    roomType = RoomType.DOUBLE;
                } else {
                    System.out.println("Invalid user input");
                }
            } while (type != 1 && type != 2);
            IRoom room = new Room(roomNumber, roomPrice, roomType);
            List<IRoom> rooms = new ArrayList<>();
            rooms.add(room);
            adminResource.addRoom(rooms);
            do {
                System.out.println("Would you like to add add another room? Y/N");
                addRoom = input.next().toLowerCase().trim();
            } while (!addRoom.equals("y") && !addRoom.equals("n"));
        } while (addRoom.equals("y"));
    }
}
