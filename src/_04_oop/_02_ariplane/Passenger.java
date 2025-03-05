package _04_oop._02_ariplane;

import java.util.ArrayList;
import java.util.List;

public class Passenger {
    private String name;
    private String passportNumber;
    private String memberTier;

    private int mileage;

    public int getMileage() {
        return mileage;
    }

    private List<Ticket> myBookings;

    public Passenger(String name, String passportNumber) {
        this.name = name;
        this.passportNumber = passportNumber;
        this.memberTier = "STANDARD";
        this.mileage = 0;
        this.myBookings = new ArrayList<>();
    }

    public void addBooking(Ticket ticket) {
        myBookings.add(ticket);
        addMileage((int) ticket.getPrice());
    }

    public void printBookingStatus() {
        if (myBookings.isEmpty()) {
            System.out.println("예약 실패");
        } else {
            for (Ticket ticket : myBookings) {
                System.out.println(ticket.getSeat().getSerialNum() + "" + ticket.getSeat().getSeatId() +
                        " 예약 성공 (" + ticket.getSeat().getSeatClass() + ")");
            }
        }
    }

    private void addMileage(int amount) {
        mileage += amount / 10;
        updateTier();
    }

    private void updateTier() {
        if (mileage > 500) {
            memberTier = "Diamond";
        } else if (mileage > 100) {
            memberTier = "Gold";
        }
    }

    public List<Ticket> getMyBookings() {
        return myBookings;
    }

    public String getName() {
        return name;
    }
}
