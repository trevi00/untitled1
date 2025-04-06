package _04_oop._02_ariplane;

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
            scanner.nextLine();
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
                    management.departureCheck();
                    break;
                case 5:
                    showFlightStatistics();
                    break;
                case 6:
                    running = false;
                    break;
                default:
                    System.out.println("잘못된 선택입니다. 다시 입력하세요.");
            }
        }
        System.out.println("프로그램 종료.");
    }

    private void showMainMenu() {
        System.out.println("\n===== 항공편 관리 시스템 =====");
        System.out.println("1. 항공편 생성");
        System.out.println("2. 좌석 예약");
        System.out.println("3. 좌석 취소");
        System.out.println("4. 출발 시점 관리 (No-show, Overbooking 자동 처리)");
        System.out.println("5. 비행편 통계 보기");
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
        scanner.nextLine();

        Flight flight = new Flight(flightNumber, departure, destination, departureTime, arrivalTime, basePrice,
                economySeats, businessSeats, firstClassSeats);
        management.addFlight(flight);
        System.out.println("항공편이 생성되었습니다.");
    }

    private void bookSeat() {
        System.out.print("예약할 항공편 번호: ");
        String flightNumber = scanner.nextLine();
        Flight flight = management.findFlight(flightNumber);
        if (flight == null) {
            System.out.println("해당 항공편을 찾을 수 없습니다.");
            return;
        }

        System.out.print("예약할 승객 이름: ");
        String name = scanner.nextLine();
        System.out.print("여권 번호: ");
        String passport = scanner.nextLine();
        System.out.print("회원 등급 (nomal/silver/gold): ");
        String grade = scanner.nextLine().toLowerCase();

        Passenger passenger = new Passenger(name, passport, grade);
        System.out.print("예약할 좌석 등급 (ECONOMY/BUSINESS/FIRST): ");
        String seatClass = scanner.nextLine().toUpperCase();

        ReservationResult result = flight.bookSeat(passenger, SeatClass.valueOf(seatClass));
        System.out.println(result.getMessage());

        if (result.isSuccess() && result.getTicket() != null) {
            System.out.println("티켓 가격: " + result.getTicket().getPrice());
        }
    }

    private void cancelSeat() {
        System.out.print("예약 취소할 항공편 번호: ");
        String flightNumber = scanner.nextLine();
        Flight flight = management.findFlight(flightNumber);
        if (flight == null) {
            System.out.println("해당 항공편을 찾을 수 없습니다.");
            return;
        }

        System.out.print("취소할 승객 이름: ");
        String name = scanner.nextLine();
        System.out.print("여권 번호: ");
        String passport = scanner.nextLine();

        Passenger passenger = new Passenger(name, passport);
        System.out.print("취소 유형을 선택하세요 (1: 승객 자발적 취소, 2: 항공사 강제 취소): ");
        int choice = scanner.nextInt();
        boolean isVoluntary = choice == 1;
        scanner.nextLine();

        flight.cancelSeat(passenger, isVoluntary);
    }

    private void showFlightStatistics() {
        FlightStatistics stats = management.getFlightStatistics();
        System.out.println(stats.toString());
    }

    public static void main(String[] args) {
        AirlineUI ui = new AirlineUI();
        ui.start();
    }
}
