package _04_oop.airplane_ex;

public class Seat {
    private int serialNum;
    private char seatId;
    private String seatClass;
    private boolean booked;
    private Passenger bookedBy;

    public Seat(int serialNum, char seatId, String seatClass) {
        this.serialNum = serialNum;
        this.seatId = seatId;
        this.seatClass = seatClass;
        this.booked = false;
        this.bookedBy = null;
    }

    public boolean reserve(Passenger passenger) {
        if (!booked) {
            this.booked = true;
            this.bookedBy = passenger;
            return true;
        }
        return false;
    }

    public void cancelReservation() {
        this.booked = false;
        this.bookedBy = null;
    }

    public boolean isBooked() {
        return booked;
    }

    public int getSerialNum() {
        return serialNum;
    }

    public char getSeatId() {
        return seatId;
    }

    public String getSeatClass() {
        return seatClass;
    }

}
