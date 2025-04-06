package _04_oop._02_ariplane_2;

public class InternationalFlightStrategy implements BookingStrategy {
    public boolean isMatch(Flight flight, Passenger passenger) {
        return flight.getAirplane().isInternational();
    }
}
