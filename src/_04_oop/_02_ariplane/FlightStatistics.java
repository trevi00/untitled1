package _04_oop._02_ariplane;

import java.util.List;

public class FlightStatistics {
    private int totalFlights;
    private int delayedFlights;
    private int canceledFlights;
    private int departedFlights;
    private int totalSeats;
    private int bookedSeats;
    private double totalRevenue;
    private int overbookedPassengers;
    private int totalDelayTime;
    private double averageDelayTime;

    public FlightStatistics(List<Flight> flights) {
        this.totalFlights = flights.size();
        this.delayedFlights = 0;
        this.canceledFlights = 0;
        this.departedFlights = 0;
        this.totalSeats = 0;
        this.bookedSeats = 0;
        this.totalRevenue = 0;
        this.overbookedPassengers = 0;
        this.totalDelayTime = 0;

        for (Flight flight : flights) {
            switch (flight.getStatus()) {
                case "DELAYED":
                    delayedFlights++;
                    totalDelayTime += flight.getDelayMinutes();
                    break;
                case "CANCELED":
                    canceledFlights++;
                    break;
                case "DEPARTED":
                    departedFlights++;
                    break;
            }

            totalSeats += flight.getSeats().size();

            for (Seat seat : flight.getSeats()) {
                if (seat.isBooked()) {
                    bookedSeats++;
                    totalRevenue += seat.getPrice();
                }
            }

            overbookedPassengers += flight.getWaitlist().size();
        }

        this.averageDelayTime = (delayedFlights > 0) ? (totalDelayTime / (double) delayedFlights) : 0.0;
    }

    public int getTotalFlights() {
        return totalFlights;
    }

    public int getDelayedFlights() {
        return delayedFlights;
    }

    public int getCanceledFlights() {
        return canceledFlights;
    }

    public int getDepartedFlights() {
        return departedFlights;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public int getBookedSeats() {
        return bookedSeats;
    }

    public double getTotalRevenue() {
        return totalRevenue;
    }

    public int getOverbookedPassengers() {
        return overbookedPassengers;
    }

    public double getAverageDelayTime() {
        return averageDelayTime;
    }

    public double getOccupancyRate() {
        return (departedFlights > 0) ? (bookedSeats * 100.0 / totalSeats) : 0.0;
    }

    @Override
    public String toString() {
        return "===== 항공편 통계 =====\n" +
                "총 비행편 수: " + totalFlights + "\n" +
                "출발한 비행편: " + departedFlights + "\n" +
                "지연된 비행편: " + delayedFlights + "\n" +
                "취소된 비행편: " + canceledFlights + "\n" +
                "총 좌석 수: " + totalSeats + "\n" +
                "예약된 좌석 수: " + bookedSeats + "\n" +
                "탑승률: " + String.format("%.2f", getOccupancyRate()) + "%\n" +
                "총 매출: $" + String.format("%.2f", totalRevenue) + "\n" +
                "초과 예약 승객 수: " + overbookedPassengers + "\n" +
                "평균 지연 시간: " + String.format("%.2f", averageDelayTime) + "분";
    }
}
