package _04_oop._02_ariplane;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Management {
    private List<Flight> flights;

    public Management() {
        flights = new ArrayList<>();
    }

    public void addFlight(Flight flight) {
        flights.add(flight);
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public Flight findFlight(String flightNumber) {
        for (Flight flight : flights) {
            if (flight.getFlightNumber().equals(flightNumber)) {
                return flight;
            }
        }
        return null;
    }

    public double calculateTotalRevenue() {
        double totalRevenue = 0;
        for (Flight flight : flights) {
            for (Seat seat : flight.getSeats()) {
                if (seat.isBooked() && !seat.getBookedBy().isRefunded()) {
                    totalRevenue += seat.getPrice();
                }
            }
        }
        return totalRevenue;
    }

    public FlightStatistics getFlightStatistics() {
        return new FlightStatistics(flights);
    }

    public void departureCheck() {
        for (Flight flight : flights) {
            if (flight.getStatus().equals("ONTIME") &&
                    flight.getDepartureTime().isBefore(LocalDateTime.now())) {
                System.out.println("항공편 " + flight.getFlightNumber() + " 출발 완료.");
                flight.processNoShow();
                flight.setStatus("DEPARTED");
            }
        }
    }

    public void delayFlight(String flightNumber, int delayMinutes) {
        Flight flight = findFlight(flightNumber);
        if (flight != null) {
            System.out.println("항공편 " + flightNumber + "이(가) " + delayMinutes + "분 지연되었습니다.");
            flight.setStatus("DELAYED");
        }
    }

    public void cancelFlight(String flightNumber) {
        Flight flight = findFlight(flightNumber);
        if (flight != null) {
            System.out.println("항공편 " + flightNumber + "이(가) 취소되었습니다. 예약자 전원 환불.");
            flight.setStatus("CANCELED");
        }
    }

    public void simulatePeriod(int days) {
    }

    public void suggestRouteChanges() {
    }
}
