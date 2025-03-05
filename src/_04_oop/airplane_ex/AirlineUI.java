package _04_oop.airplane_ex;

import java.time.LocalDateTime;
import java.util.Scanner;

public class AirlineUI {
    private Management management;
    private Scanner scanner;

    public AirlineUI() {
        management = new Management();
        scanner = new Scanner(System.in);
    }

    public void start() {
        boolean running = true;
        while (running) {
            showMainMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // 개행문자 제거
            switch (choice) {
                case 1:
                    createFlight();
                    break;
                case 2:
                    bookSeat();
                    break;
                case 3:
                    cancelSeat();
                    break;
                case 4:
                    showFlightStatistics();
                    break;
                case 5:
                    showTotalRevenue();
                    break;
                case 6:
                    running = false;
                    break;
                default:
                    System.out.println("잘못된 선택입니다.");
            }
        }
        System.out.println("프로그램 종료.");
    }

    private void showMainMenu() {
        System.out.println("\n===== 항공편 관리 시스템 =====");
        System.out.println("1. 항공편 생성");
        System.out.println("2. 좌석 예약");
        System.out.println("3. 좌석 취소");
        System.out.println("4. 비행편 통계 보기");
        System.out.println("5. 총 매출 보기");
        System.out.println("6. 종료");
        System.out.print("선택: ");
    }

    private void createFlight() {
        System.out.print("항공편 번호: ");
        String flightNumber = scanner.nextLine();
        System.out.print("출발지: ");
        String departure = scanner.nextLine();
        System.out.print("도착지: ");
        String destination = scanner.nextLine();
        // 예시: 출발은 현재 시간 +1시간, 도착은 +3시간으로 설정
        LocalDateTime departureTime = LocalDateTime.now().plusHours(1);
        LocalDateTime arrivalTime = LocalDateTime.now().plusHours(3);
        System.out.print("기본 요금: ");
        double basePrice = scanner.nextDouble();
        System.out.print("이코노미 좌석 수: ");
        int economySeats = scanner.nextInt();
        System.out.print("비즈니스 좌석 수: ");
        int businessSeats = scanner.nextInt();
        System.out.print("퍼스트 클래스 좌석 수: ");
        int firstClassSeats = scanner.nextInt();
        scanner.nextLine(); // 개행문자 제거

        Flight flight = new Flight(flightNumber, departure, destination, departureTime, arrivalTime, basePrice,
                economySeats, businessSeats, firstClassSeats);
        management.addFlight(flight);
        System.out.println("항공편이 생성되었습니다.");
    }

    private void bookSeat() {
        System.out.print("예약할 항공편 번호: ");
        String flightNumber = scanner.nextLine();
        Flight flight = findFlight(flightNumber);
        if (flight == null) {
            System.out.println("해당 항공편을 찾을 수 없습니다.");
            return;
        }
        System.out.print("예약할 승객 이름: ");
        String name = scanner.nextLine();
        System.out.print("여권 번호: ");
        String passport = scanner.nextLine();
        Passenger passenger = new Passenger(name, passport);
        System.out.print("예약할 좌석 등급 (ECONOMY/BUSINESS/FIRST): ");
        String seatClass = scanner.nextLine().toUpperCase();

        ReservationResult result = flight.reserveSeat(passenger, seatClass);
        System.out.println(result.getMessage());
        if (result.isSuccess()) {
            System.out.println("티켓 가격: " + result.getTicket().getPrice());
        }
    }

    private void cancelSeat() {
        System.out.print("예약 취소할 항공편 번호: ");
        String flightNumber = scanner.nextLine();
        Flight flight = findFlight(flightNumber);
        if (flight == null) {
            System.out.println("해당 항공편을 찾을 수 없습니다.");
            return;
        }
        System.out.print("취소할 좌석의 시리얼 번호: ");
        int serialNum = scanner.nextInt();
        System.out.print("취소할 좌석의 열 (문자): ");
        char seatId = scanner.next().charAt(0);
        scanner.nextLine(); // 개행문자 제거

        Seat targetSeat = null;
        for (Seat seat : flight.getSeats()) {
            if (seat.getSerialNum() == serialNum && seat.getSeatId() == seatId) {
                targetSeat = seat;
                break;
            }
        }
        if (targetSeat == null) {
            System.out.println("해당 좌석을 찾을 수 없습니다.");
            return;
        }
        flight.cancelSeat(targetSeat);
        System.out.println("예약이 취소되었습니다.");
    }

    private void showFlightStatistics() {
        FlightStatistics stats = management.getFlightStatistics();
        System.out.println(stats.toString());
    }

    private void showTotalRevenue() {
        double revenue = management.calculateTotalRevenue();
        System.out.println("총 매출: " + revenue);
    }

    private Flight findFlight(String flightNumber) {
        for (Flight flight : management.getFlights()) {
            if (flight.getFlightNumber().equals(flightNumber)) {
                return flight;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        AirlineUI ui = new AirlineUI();
        ui.start();
    }

}
