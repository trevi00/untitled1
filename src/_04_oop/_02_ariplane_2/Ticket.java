package _04_oop._02_ariplane_2;

public class Ticket {
    private Flight flight;
    private Seat seat;
    private Passenger passenger;
    private double price;
    private boolean refunded;

    public Ticket(Flight flight, Seat seat, Passenger passenger) {
        this.flight = flight;
        this.seat = seat;
        this.passenger = passenger;
        this.price = seat.getPrice();
        this.refunded = false;
    }

    public void refund() {
        if (!refunded) {
            refunded = true;
            passenger.setCanceledGain((int) price);
            price = 0;
        }
    }

    public double getPrice() {
        return price;
    }

    public Seat getSeat() {
        return seat;
    }

    public boolean isRefunded() {
        return refunded;
    }
}
