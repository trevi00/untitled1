package _04_oop._02_ariplane;

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
        for (Flight flight : flights) {
            totalRevenue += flight.getBasePrice();
        }
        return totalRevenue;
    }

    public void getFlightStatistics() {
        int totalFlights = flights.size();
        int delayedCnt = 0;
        int canceledCnt = 0;

        for (Flight flight : flights) {
            if (flight.getStatus().equals("DELAYED")) delayedCnt++;
            if (flight.getStatus().equals("CANCELED")) canceledCnt++;
        }

        System.out.println("총 비행편 수: " + totalFlights);
        System.out.println("지연된 비행편: " + delayedCnt);
        System.out.println("취소된 비행편: " + canceledCnt);
    }
}
