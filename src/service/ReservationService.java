package service;

import model.Customer;
import model.IRoom;
import model.Reservation;

import java.util.*;

public class ReservationService {

    private static ReservationService reservationService = null;
    public Collection<Reservation> reservations = new HashSet<>();
    public Collection<IRoom> rooms = new ArrayList<>();

    private ReservationService() {
    }

    public static ReservationService getInstance() {
        if (null == reservationService) {
            reservationService = new ReservationService();
        }
        return reservationService;
    }

    public void addRoom(IRoom room) {
        rooms.add(room);
    }

    public IRoom getARoom(String roomID) {
        for (IRoom room : rooms) {
            if (roomID.equals(room.getRoomNumber())) {
                return room;
            }
        }
        return null;
    }

    public Reservation reserveARoom(Customer customer, IRoom room, Date checkInDate, Date checkOutDate) {
        Reservation reservedRooms = new Reservation(customer, room, checkInDate, checkOutDate);
        reservations.add(reservedRooms);
        return reservedRooms; //do we really need this return statement? as this method for reserve room.
    }

    public Collection<IRoom> findRooms(Date checkInDate, Date checkOutDate) {
        for (IRoom room : rooms) {
            if (checkInDate.after(checkInDate) && checkOutDate.before(checkOutDate)) {
                Iterator<IRoom> iRoomIterator = rooms.iterator();
                while (iRoomIterator.hasNext()) {
                    System.out.println(iRoomIterator);
                }
                return rooms; //same here, do we really need this?
            }
        }
        return null;
    }

    public Collection<Reservation> getCustomersReservation(Customer customer) {
        CustomerService.getInstance().getCustomer(customer.getEmail());
        return reservations;
    }

    public void printAllReservation() {
        for ( Reservation reservation : reservations ) {
            System.out.println(reservations);
        }
    }
}
