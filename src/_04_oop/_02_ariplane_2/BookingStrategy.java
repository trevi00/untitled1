package _04_oop._02_ariplane_2;

public interface BookingStrategy {
    boolean isMatch(Flight flight, Passenger passenger);
}
