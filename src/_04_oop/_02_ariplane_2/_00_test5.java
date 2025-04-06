package _04_oop._02_ariplane_2;

public class _00_test5 {
    public static void main(String[] args) {

//        Management management = new Management();
//
//        // 1. 항공편 생성
//        Flight flight1 = new Flight("KE101", "서울", "도쿄",
//                LocalDateTime.now().minusHours(2), LocalDateTime.now().plusHours(1),
//                100.0, 5, 2, 1);
//        Flight flight2 = new Flight("OZ202", "부산", "제주",
//                LocalDateTime.now().minusHours(1), LocalDateTime.now().plusHours(2),
//                80.0, 4, 1, 1);
//        management.addFlight(flight1);
//        management.addFlight(flight2);
//
//        // 2. 승객 예약
//        Passenger p1 = new Passenger("홍", "P123", "silver");
//        Passenger p2 = new Passenger("김", "P124", "gold");
//        Passenger p3 = new Passenger("이", "P125", "nomal");
//
//        flight1.bookSeat(p1, SeatClass.ECONOMY);
//        flight1.bookSeat(p2, SeatClass.BUSINESS);
//        flight1.bookSeat(p3, SeatClass.FIRST);
//
//        flight2.bookSeat(p1, SeatClass.ECONOMY);
//        flight2.bookSeat(p2, SeatClass.ECONOMY);
//
//        Simulation s = new Simulation(management);
//        s.simulatePeriod(30);

//        // 3. 강제 No-show 설정
//        p2.setNoShow(true);
//
//        // 4. 강제 취소 테스트
//        flight2.cancelSeat(p1, true); // 자발적 취소
//
//        // 5. 출발 처리
//        management.departureCheck();
//
//        // 6. 통계 출력
//        FlightStatistics stats = management.getFlightStatistics();
//        System.out.println(stats.toString());
//
//        // 7. 인기 노선 증편 테스트
//        management.addMorePopularRoute();
//
//        // 8. 비인기 노선 제거 테스트
//        management.suggestRouteChanges();
    }
}