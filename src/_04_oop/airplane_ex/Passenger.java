package _04_oop.airplane_ex;

import java.util.ArrayList;
import java.util.List;

public class Passenger {
    private String name;
    private String passportNumber;
    private String memberTier;
    private int mileage;
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

    public List<String> getBookingStatuses() {
        List<String> statuses = new ArrayList<>();
        if (myBookings.isEmpty()) {
            statuses.add("예약 내역이 없습니다.");
        } else {
            for (Ticket ticket : myBookings) {
                statuses.add("좌석 " + ticket.getSeat().getSeatId() + " (" + ticket.getSeat().getSeatClass() + ") 예약됨");
            }
        }
        return statuses;
    }

    private void addMileage(int amount) {
        mileage += amount / 10;
        updateTier();
    }

    private void updateTier() {
        if (mileage > 5000) {
            memberTier = "Diamond";
        } else if (mileage > 1000) {
            memberTier = "Gold";
        }
    }

    public List<Ticket> getMyBookings() {
        return myBookings;
    }

    public String getName() {
        return name;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public int getMileage() {
        return mileage;
    }

    public String getMemberTier() {
        return memberTier;
    }

}
