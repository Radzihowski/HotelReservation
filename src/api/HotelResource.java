package api;

import model.Customer;
import model.IRoom;
import model.Reservation;
import service.CustomerService;
import service.ReservationService;

import java.util.Collection;
import java.util.Date;

public class HotelResource {
    private static HotelResource hotelResource;
    public static CustomerService customerService = CustomerService.getInstance();
    public static ReservationService reservationService = ReservationService.getInstance();

    //static reference
    private HotelResource() {
    }

    public static HotelResource getInstance() {
        if (null == hotelResource) {
            hotelResource = new HotelResource();
        }
        return hotelResource;
    }

    public Customer getCustomer(String email) {
        return customerService.getCustomer(email);
    }

    public void createACustomer(String email, String firstName, String lastName) {
        customerService.addCustomer(email, firstName, lastName);
    }

    public IRoom getRoom(String roomNumber) {
        return reservationService.getARoom(roomNumber);
    }

    public Reservation bookARoom(String customerEmail, IRoom room, Date checkInDate, Date checkOutDate) {
        Customer customer = CustomerService.getInstance().getCustomer(customerEmail);
        if ( customer == null ) {
            return null;
        }
        return reservationService.reserveARoom(customer, room, checkInDate, checkOutDate);
    }

    public Collection<Reservation> getCustomerReservations(String customerEmail){
        Customer customer = CustomerService.getInstance().getCustomer(customerEmail);
        if ( customer == null ) {
            return null;
        }
        return reservationService.getCustomersReservation(customer);
    }

    public Collection<IRoom> findARoom(Date checkIn, Date checkOut) {
        return reservationService.findRooms(checkIn, checkOut);
    }
}
