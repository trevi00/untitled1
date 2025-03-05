package _04_oop._02_ariplane;

import java.time.LocalDateTime;

public class _00_test {
    public static void main(String[] args) {
        SeatClass seatClassInstance = new SeatClass();

        Passenger passenger1 = new Passenger("가가", "A123456");
        Passenger passenger2 = new Passenger("나나", "B987654");
        Passenger passenger3 = new Passenger("다다", "C135468");

        Management M = new Management();

        Flight flight = new Flight("KR123", "Seoul", "New York",
                LocalDateTime.of(2025, 3, 1, 12, 0),
                LocalDateTime.of(2025, 3, 1, 13, 0),
                50, 150, 20, 5); // 좌석: 이코노미 10석, 비즈니스 5석, 퍼스트 2석

//        flight.setStatus("DELAYED");
        M.addFlight(flight);

        Ticket ticket1 = flight.bookSeat(passenger1, seatClassInstance.getBUSINESS());
        Ticket ticket2 = flight.bookSeat(passenger2, seatClassInstance.getEconomy());
        Ticket ticket3 = flight.bookSeatTarget(1, 'B', passenger3, seatClassInstance.getEconomy());


        passenger1.printBookingStatus();
        System.out.println(passenger1.getName() + "의 마일리지 : " + passenger2.getMileage());
        passenger2.printBookingStatus();
        System.out.println(passenger2.getName() + "의 마일리지 : " + passenger2.getMileage());
        passenger3.printBookingStatus();
        System.out.println(passenger3.getName() + "의 마일리지 : " + passenger2.getMileage());



        System.out.println("항공편 상태 : " + flight.getStatus());
        System.out.println("총 수익: " + M.calculateTotalRevenue() + "만");
        M.getFlightStatistics();
    }
}
