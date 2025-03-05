package _04_oop.airplane_ex;

import java.util.ArrayList;
import java.util.List;

public class Management {
    private List<Flight> flights;

    public Management() {
        flights = new ArrayList<>();
    }

    public void addFlight(Flight flight) {
        flights.add(flight);
    }

    public double calculateTotalRevenue() {
        double totalRevenue = 0;
        // 예약된 좌석마다의 기본 요금(간단히 계산)
        for (Flight flight : flights) {
            for (Seat seat : flight.getSeats()) {
                if (seat.isBooked()) {
                    totalRevenue += flight.getBasePrice();
                }
            }
        }
        return totalRevenue;
    }

    public FlightStatistics getFlightStatistics() {
        int totalFlights = flights.size();
        int delayedCount = 0;
        int canceledCount = 0;

        for (Flight flight : flights) {
            if (flight.getStatus().equals("DELAYED"))
                delayedCount++;
            if (flight.getStatus().equals("CANCELED"))
                canceledCount++;
        }
        return new FlightStatistics(totalFlights, delayedCount, canceledCount);
    }

    public List<Flight> getFlights() {
        return flights;
    }

}
