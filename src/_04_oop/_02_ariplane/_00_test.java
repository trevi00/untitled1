package _04_oop._02_ariplane;

import java.time.LocalDateTime;

public class _00_test {
    public static void main(String[] args) {
        System.out.println("===== 항공사 운영 시스템 테스트 시작 =====");

        // 항공편 생성 테스트
        Management management = new Management();
        Flight flight = new Flight("KE123", "Seoul", "New York",
                LocalDateTime.now().plusHours(5), LocalDateTime.now().plusHours(15),
                500.0, 2, 2, 1); // 작은 테스트 케이스를 위해 좌석 수 제한
        management.addFlight(flight);
        System.out.println("[TEST] 항공편 생성 완료. 총 항공편 수: " + management.getFlights().size());

        // 좌석 예약 테스트
        Passenger passenger1 = new Passenger("Alice", "P12345", "gold");
        Passenger passenger2 = new Passenger("Bob", "P67890", "silver");
        Passenger passenger3 = new Passenger("Charlie", "P99999", "nomal");

        ReservationResult result1 = flight.bookSeat(passenger1, SeatClass.ECONOMY);
        ReservationResult result2 = flight.bookSeat(passenger2, SeatClass.ECONOMY);
        ReservationResult result3 = flight.bookSeat(passenger3, SeatClass.ECONOMY); // 좌석 부족 예상

        System.out.println("[TEST] 예약 결과 1: " + result1.getMessage());
        System.out.println("[TEST] 예약 결과 2: " + result2.getMessage());
        System.out.println("[TEST] 예약 결과 3: " + result3.getMessage());

        // 예약 취소 테스트 (대기 명단 승객 자동 배정 확인)
        flight.cancelSeat(passenger1, true);
        System.out.println("[TEST] 승객1 좌석 취소 완료. 대기 명단 승객 자동 예약됨.");

        // Overbooking 테스트
        Passenger passenger4 = new Passenger("David", "P77777", "gold");
        Passenger passenger5 = new Passenger("Eve", "P66666", "silver");

        flight.bookSeat(passenger4, SeatClass.ECONOMY);
        flight.bookSeat(passenger5, SeatClass.ECONOMY);
        System.out.println("[TEST] Overbooking 발생 확인. 대기 명단 크기: " + flight.getWaitlist().size());

        // 출발(No-show 포함) 테스트
        flight.processNoShow();
        flight.setStatus("DEPARTED");
        System.out.println("[TEST] 항공편 출발 완료. 상태: " + flight.getStatus());
        System.out.println("[TEST] No-show 발생 후 예약된 좌석 수: " +
                flight.getSeats().stream().filter(Seat::isBooked).count());

        // 항공편 지연 테스트
        flight.setStatus("DELAYED");
        System.out.println("[TEST] 항공편 지연 처리 완료. 지연 시간: " + flight.getDelayMinutes() + "분");

        // 항공편 취소 테스트
        flight.setStatus("CANCELED");
        System.out.println("[TEST] 항공편 취소 완료. 상태: " + flight.getStatus());
        System.out.println("[TEST] 모든 승객 환불 여부 확인: " + passenger1.getCanceledGain());

        // 매출 계산 테스트
        double totalRevenue = management.calculateTotalRevenue();
        System.out.println("[TEST] 총 매출: $" + totalRevenue);
    }
}