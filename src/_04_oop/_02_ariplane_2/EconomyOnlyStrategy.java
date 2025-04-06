package _04_oop._02_ariplane_2;

public class EconomyOnlyStrategy implements BookingStrategy {
    public boolean isMatch(Flight flight, Passenger passenger) {
        return flight.getSeats().stream()
                .anyMatch(s -> !s.isBooked() && s.getSeatClass() == SeatClass.ECONOMY);
    }
}
