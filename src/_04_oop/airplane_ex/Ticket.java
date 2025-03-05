package _04_oop.airplane_ex;

public class Ticket {
    private Flight flight;
    private Seat seat;
    private Passenger passenger;
    private double price;

    public Ticket(Flight flight, Seat seat, Passenger passenger, double price) {
        this.flight = flight;
        this.seat = seat;
        this.passenger = passenger;
        this.price = price;
        passenger.addBooking(this);
    }

    public double getPrice() {
        return price;
    }

    public Flight getFlight() {
        return flight;
    }

    public Seat getSeat() {
        return seat;
    }

    public Passenger getPassenger() {
        return passenger;
    }

}
