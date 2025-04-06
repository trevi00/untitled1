package _04_oop._02_ariplane_2;

import java.util.List;

public class FlightStatistics {
    private int totalFlights;
    private int delayedFlights;
    private int canceledFlights;
    private int departedFlights;
    private int totalSeats;
    private int bookedSeats;
    private int actualPassengers;
    private double totalRevenue;
    private int overbookedPassengers;
    private int totalDelayTime;
    private double averageDelayTime;
    private double cancelRate;
    private double delayRate;
    private double loadFactor;
    private double satisfactionRate;
    private Flight mostPopularRoute;

    public FlightStatistics(List<Flight> flights) {
        int totalSatisfaction = 0;
        int passengerCount = 0;
        int maxReservations = -1;

        this.totalFlights = flights.size();

        for (Flight flight : flights) { // 비행 예약 카운트
            int flightReservationCount = 0;

            switch (flight.getStatus()) {
                case "DELAYED": // 딜레이
                    delayedFlights++;
                    totalDelayTime += flight.getDelayMinutes();
                    break;
                case "CANCELED": // 취소
                    canceledFlights++;
                    break;
                case "DEPARTED": // 출발
                    departedFlights++;
                    break;
            }

            totalSeats += flight.getSeats().size(); // 좌석 크기

            for (Seat seat : flight.getSeats()) {
                if (seat.isBooked()) {
                    bookedSeats++;
                    totalRevenue += seat.getPrice();
                    flightReservationCount++;

                    Passenger p = seat.getBookedBy();
                    if (!p.isNoShow() && !p.isRefunded()) { // 노쇼나 환불시 승객으로 안침
                        actualPassengers++;
                        totalSatisfaction += p.getSatisfy();
                        passengerCount++;
                    }
                }
            }

            if (flightReservationCount > maxReservations) { // 노선 예약 카운트로 최대 예약 확인
                maxReservations = flightReservationCount;
                mostPopularRoute = flight;
            }

            overbookedPassengers += flight.getWaitlist().size();
        }

        this.averageDelayTime = (delayedFlights > 0) ? (totalDelayTime / (double) delayedFlights) : 0.0;
        this.cancelRate = (totalFlights > 0) ? (canceledFlights * 100.0 / totalFlights) : 0.0;
        this.delayRate = (totalFlights > 0) ? (delayedFlights * 100.0 / totalFlights) : 0.0;
        this.loadFactor = (totalSeats > 0) ? (actualPassengers * 100.0 / totalSeats) : 0.0;
        this.satisfactionRate = (passengerCount > 0) ? (totalSatisfaction * 1.0 / passengerCount) : 0.0;
    }

    @Override
    public String toString() {
        return "===== 항공편 통계 =====\n" +
                "총 항공편 수: " + totalFlights + "\n" +
                "출발한 항공편: " + departedFlights + "\n" +
                "지연된 항공편: " + delayedFlights + " (" + String.format("%.2f", delayRate) + "%)\n" +
                "취소된 항공편: " + canceledFlights + " (" + String.format("%.2f", cancelRate) + "%)\n" +
                "평균 지연 시간: " + String.format("%.2f", averageDelayTime) + "분\n" +
                "총 좌석 수: " + totalSeats + "\n" +
                "예약된 좌석 수: " + bookedSeats + "\n" +
                "실제 탑승 승객 수: " + actualPassengers + "\n" +
                "탑승률 (Load Factor): " + String.format("%.2f", loadFactor) + "%\n" +
                "총 매출: $" + String.format("%.2f", totalRevenue) + "\n" +
                "평균 만족도: " + String.format("%.2f", satisfactionRate) + "/100\n" +
                "초과 예약 승객 수: " + overbookedPassengers + "\n" +
                "가장 인기 있는 노선: " +
                (mostPopularRoute != null ?
                        mostPopularRoute.getDeparture() + " → " + mostPopularRoute.getDestination()
                        : "없음");
    }
}
