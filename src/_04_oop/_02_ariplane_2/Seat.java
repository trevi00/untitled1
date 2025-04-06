package _04_oop._02_ariplane_2;

public class Seat {
    private int serialNum;
    private String seatId;
    private SeatClass seatClass;
    private boolean booked;
    private Passenger bookedBy;
    private double price;

    public Seat(int serialNum, String seatId, SeatClass seatClass, double basePrice) {
        this.serialNum = serialNum;
        this.seatId = seatId;
        this.seatClass = seatClass;
        this.booked = false;
        this.bookedBy = null;
        this.price = basePrice * seatClass.getPriceMultiplier();
    }

    public boolean reserve(Passenger passenger) {
        if (booked) return false;
        this.booked = true;
        this.bookedBy = passenger;
        return true;
    }

    public void cancelReservation() {
        this.booked = false;
        this.bookedBy = null;
    }

    public boolean isBooked() {
        return booked;
    }

    public Passenger getBookedBy() {
        return bookedBy;
    }

    public SeatClass getSeatClass() {
        return seatClass;
    }

    public double getPrice() {
        return price;
    }

    public int getSerialNum() {
        return serialNum;
    }

    public String getSeatId() {
        return seatId;
    }
}
