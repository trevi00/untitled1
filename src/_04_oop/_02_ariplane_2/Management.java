package _04_oop._02_ariplane_2;

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

    public void addMorePopularRoute() {
        Flight mostReserved = null;
        int maxReservations = -1; // 최대 예약 인덱스

        for (Flight flight : flights) { // 최대 예약 도출
            int count = 0;
            for (Seat seat : flight.getSeats()) {
                if (seat.isBooked()) {
                    count++;
                }
            }
            if (count > maxReservations) {
                maxReservations = count;
                mostReserved = flight;
            }
        }

        if (mostReserved == null) { // 최대 예약이 null일 경우는 아예 예약되지 않았을 경우.
            System.out.println("증편할 인기 노선이 없습니다.");
            return;
        }

        String newFlightNumber = mostReserved.getFlightNumber() + "_EX"; // 인기 항공 넘버
        String departure = mostReserved.getDeparture(); // 이륙
        String destination = mostReserved.getDestination(); // 도착
        double basePrice = mostReserved.getSeats().get(0).getPrice() / mostReserved.getSeats().get(0).getSeatClass().getPriceMultiplier();

        int eco = 0, biz = 0, first = 0;
        for (Seat seat : mostReserved.getSeats()) {
            if (seat.getSeatClass() == SeatClass.ECONOMY) eco++;
            else if (seat.getSeatClass() == SeatClass.BUSINESS) biz++;
            else if (seat.getSeatClass() == SeatClass.FIRST) first++;
        } // 기본 값을 토대로 클래스대로 곱할 멀티인자

        // 출발시간과 이륙시간
        LocalDateTime depTime = mostReserved.getDepartureTime().plusDays(1);
        LocalDateTime arrTime = depTime.plusHours(2);

        Airplane airplane = mostReserved.getAirplane();
        Maintenance maintenance = mostReserved.getMaintenance();

        // 인기 노선 추가
        Flight newFlight = new Flight(newFlightNumber, departure, destination, depTime, arrTime, basePrice, eco, biz, first, airplane, maintenance);
        flights.add(newFlight);

        System.out.println("인기 노선 증편 완료: " + newFlightNumber + " (" + departure + " → " + destination + ")");
    }


    public void suggestRouteChanges() {
        List<Flight> toRemove = new ArrayList<>();
        for (Flight flight : flights) {
            int reservationCount = 0;
            for (Seat seat : flight.getSeats()) {
                if (seat.isBooked()) {
                    reservationCount++;
                }
            }
            boolean lowReservation = reservationCount <= 5;
            boolean oldEnough = flight.getMaintenance().getFlightsSinceLastMaintenance() >= 3; // 운항 횟수 기준 추가

            if (lowReservation && oldEnough) {
                toRemove.add(flight);
                System.out.println("비인기 노선 감지 → " +
                        flight.getFlightNumber() + " (" +
                        flight.getDeparture() + " → " + flight.getDestination() + ") 폐지됨.");
            }
        }
        flights.removeAll(toRemove);
    }
}