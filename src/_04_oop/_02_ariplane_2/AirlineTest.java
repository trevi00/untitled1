package _04_oop._02_ariplane_2;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AirlineTest {
    public static void main(String[] args) {
        // 1. 관리 클래스 생성
        Management management = new Management();

        // 2. 항공편 2개 생성 (국내선/국제선)
        Airplane airplane1 = new Airplane("Boeing 737", 15, "A등급", 3000, false, 0.05);
        Maintenance maintenance1 = new Maintenance(500, 300, 200);
        Flight flight1 = new Flight("FL001", "서울", "부산",
                LocalDateTime.now().plusHours(1),
                LocalDateTime.now().plusHours(2),
                150000, 10, 3, 2,
                airplane1, maintenance1);

        Airplane airplane2 = new Airplane("Boeing 777", 15, "S등급", 10000, true, 0.1);
        Maintenance maintenance2 = new Maintenance(800, 400, 250);
        Flight flight2 = new Flight("FL002", "서울", "도쿄",
                LocalDateTime.now().plusHours(1),
                LocalDateTime.now().plusHours(3),
                200000, 10, 3, 2,
                airplane2, maintenance2);

        management.addFlight(flight1);
        management.addFlight(flight2);

        // 3. 승객 예약 (각 3명씩)
        flight1.bookSeat(new Passenger("김민수", "P1234567", "gold"), SeatClass.ECONOMY);
        flight1.bookSeat(new Passenger("이영희", "P9876543", "silver"), SeatClass.BUSINESS);
        flight1.bookSeat(new Passenger("홍길동", "P5555555", "nomal"), SeatClass.ECONOMY);

        flight2.bookSeat(new Passenger("장보고", "P8888888", "gold"), SeatClass.ECONOMY);
        flight2.bookSeat(new Passenger("신사임당", "P7777777", "silver"), SeatClass.BUSINESS);
        flight2.bookSeat(new Passenger("유관순", "P3333333", "gold"), SeatClass.FIRST);

        System.out.println("[예약 완료] FL001 예약 수: " + flight1.getSeats().stream().filter(Seat::isBooked).count());
        System.out.println("[예약 완료] FL002 예약 수: " + flight2.getSeats().stream().filter(Seat::isBooked).count());

        // 4. 시뮬레이션 실행 전 상태 출력
        System.out.println("\n=== 시뮬레이션 전 상태 ===");
        for (Flight f : management.getFlights()) {
            System.out.println(f.getFlightNumber() + " 상태: " + f.getStatus());
        }

        // 5. 시뮬레이션 실행 (정비 부족 발생 유도)
        Simulation sim = new Simulation(management);
        sim.simulatePeriod(7); // 운항 횟수 누적 유도

        // 6. 정비 필요 상태 수동 확인 및 정비 수행
        System.out.println("\n=== 정비 수행 ===");
        for (Flight f : management.getFlights()) {
            if (f.getMaintenance().needsMaintenance()) {
                System.out.println("정비 필요: " + f.getFlightNumber());
                f.getMaintenance().performMaintenance();
                System.out.println("정비 완료: " + f.getFlightNumber());
            }
        }

        // 7. 전략 기반 예약 테스트
        Reservation reservation = new Reservation(management);
        reservation.addPassenger(new Passenger("김초롱", "P1111111", "gold"));
        reservation.addPassenger(new Passenger("최지현", "P2222222", "silver"));

        System.out.println("\n=== 전략 예약 (이코노미 우선) ===");
        reservation.passengersBook(new EconomyOnlyStrategy());

        // 8. 인기 노선 증편 테스트
        management.addMorePopularRoute();

        // 9. 비인기 노선 폐지 테스트 (예약 수 기준 이하인 항공편만)
        management.suggestRouteChanges();

        // 10. 통계 출력
        FlightStatistics stats = management.getFlightStatistics();
        System.out.println("\n=== 최종 통계 ===");
        System.out.println(stats.toString());
    }
}
