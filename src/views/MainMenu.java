package views;

import model.Customer;
import model.Reservation;
import service.ReservationService;

import java.util.Collection;
import java.util.HashSet;
import java.util.Scanner;

public class MainMenu {

    public void start() {
        boolean keepRunning = true;
        try (Scanner scanner = new Scanner(System.in)) {
            while (keepRunning) {
                try {
                    System.out.println("1. Find and reserve a room");
                    System.out.println("2. See my reservations");
                    System.out.println("3. Create an account");
                    System.out.println("4. Admin");
                    System.out.println("5. Exit");
                    int selection = Integer.parseInt(scanner.next());

                    if (selection == 1) {
                        System.out.println("1. Find and reserve a room has been selected");
//                        keepRunning = false;
                    } else if (selection == 2) {
                        System.out.println("2. See my reservations has been selected");
//                        keepRunning = false;
                    } else if (selection == 3) {
                        System.out.println("3. Create an account has been selected");
                        Scanner userInput = new Scanner(System.in);
                        System.out.println("--------------------------------------------");
                        System.out.println("Enter email in format: name@domain.com");
                        String email = userInput.next();
                        System.out.println("First Name: ");
                        String firstName = userInput.next();
                        System.out.println("Last Name: ");
                        String lastName = userInput.next();
                        System.out.println("--------------------------------------------");
                        System.out.println("Please make your selection");
                        System.out.println("--------------------------------------------");
                        Collection<Customer> customers = new HashSet<>();
//                        keepRunning = false;
                    } else if (selection == 4) {
                        System.out.println("--------------------------------------------");
                        System.out.println("4. Admin has been selected");
                        AdminMenu adminMenu = new AdminMenu();
                        adminMenu.start();
//                        keepRunning = false;
                    } else if (selection == 5) {
                        System.out.println("--------------------------------------------");
                        System.out.println("5. Exit has been selected");
                        keepRunning = false;
                    } else {
                        System.out.println("Please select menu between 1 and 5");
                    }
                } catch ( Exception ex) {
                    System.out.println("Invalid input");
                }
            }
        }
    }
}
