package api;

import model.Customer;
import model.IRoom;
import model.Reservation;
import service.CustomerService;
import service.ReservationService;

import java.util.Collection;
import java.util.List;


public class AdminResource {
    private static  AdminResource adminResource = new AdminResource();
//    public static CustomerService customerService = CustomerService.getInstance();
    ReservationService reservationService = ReservationService.getInstance();

    public AdminResource() {
    }

    public static AdminResource getInstance() {
        if ( null == adminResource) {
            adminResource = new AdminResource();
        }
        return adminResource;
    }

    public Customer getCustomer(String email) {
        return CustomerService.customerService.getCustomer(email);
    }

    public void addRoom(List<IRoom> rooms) {
        for (IRoom room : rooms) {
            reservationService.addRoom(room);
        }
    }

    public Collection<IRoom> getAllRooms() {
        return ReservationService.getInstance().rooms;
    }

    public Collection<Customer> getAllCustomers() {
        return CustomerService.getInstance().getAllCustomers();
    }

    public void displayAllReservations() {
        ReservationService.getInstance().printAllReservation();
    }
}
