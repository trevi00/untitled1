package _04_oop.airplane_ex;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Flight {
    private String flightNumber;
    private String departure;
    private String destination;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private List<Seat> seats;
    private List<Passenger> waitlist;
    private String status;
    private double basePrice;
    private SeatClass seatClassConfig;

    public Flight(String flightNumber, String departure, String destination,
                  LocalDateTime departureTime, LocalDateTime arrivalTime, double basePrice,
                  int economySeats, int businessSeats, int firstClassSeats) {
        this.flightNumber = flightNumber;
        this.departure = departure;
        this.destination = destination;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.status = "ONTIME";
        this.basePrice = basePrice;
        this.seatClassConfig = new SeatClass();
        this.seats = new ArrayList<>();
        this.waitlist = new ArrayList<>();
        generateSeats(economySeats, businessSeats, firstClassSeats);
    }

    private void generateSeats(int economySeats, int businessSeats, int firstClassSeats) {
        char baseRow = 'A';
        // 이코노미: 한 행에 2석 (예시)
        for (int i = 1; i <= economySeats / 2; i++) {
            seats.add(new Seat(i, baseRow, seatClassConfig.getEconomy()));
            seats.add(new Seat(i, (char) (baseRow + 1), seatClassConfig.getEconomy()));
        }
        // 비즈니스: 다음 2행
        for (int i = 1; i <= businessSeats / 2; i++) {
            seats.add(new Seat(i, (char) (baseRow + 2), seatClassConfig.getBUSINESS()));
            seats.add(new Seat(i, (char) (baseRow + 3), seatClassConfig.getBUSINESS()));
        }
        // 퍼스트 클래스: 예시로 한 행당 1석, 행번호와 상관없이 'F' 사용
        for (int i = 1; i <= firstClassSeats; i++) {
            seats.add(new Seat(i, 'F', seatClassConfig.getFIRST()));
        }
    }

    public boolean isSeatBooked(int serialNum, char seatId) {
        for (Seat seat : seats) {
            if (seat.getSeatId() == seatId && seat.getSerialNum() == serialNum) {
                return seat.isBooked();
            }
        }
        return false;
    }

    public ReservationResult reserveSeat(Passenger passenger, String seatClass) {
        for (Seat seat : seats) {
            if (!seat.isBooked() && seat.getSeatClass().equals(seatClass)) {
                if (seat.reserve(passenger)) {
                    double price = basePrice * getPriceMultiplier(seatClass);
                    Ticket ticket = new Ticket(this, seat, passenger, price);
                    return new ReservationResult(true, ticket, "예약 성공");
                }
            }
        }
        waitlist.add(passenger);
        return new ReservationResult(false, null, "예약 가능한 좌석이 없어 대기자 명단에 추가되었습니다.");
    }

    public ReservationResult reserveSpecificSeat(int serialNum, char seatId, Passenger passenger, String seatClass) {
        for (Seat seat : seats) {
            if (seat.getSeatId() == seatId && seat.getSerialNum() == serialNum) {
                if (!seat.isBooked()) {
                    if (seat.reserve(passenger)) {
                        double price = basePrice * getPriceMultiplier(seatClass);
                        Ticket ticket = new Ticket(this, seat, passenger, price);
                        return new ReservationResult(true, ticket, "특정 좌석 예약 성공");
                    } else {
                        return new ReservationResult(false, null, "해당 좌석은 이미 예약되었습니다.");
                    }
                } else {
                    return new ReservationResult(false, null, "해당 좌석은 이미 예약되었습니다.");
                }
            }
        }
        return new ReservationResult(false, null, "잘못된 좌석 선택입니다.");
    }

    public void cancelSeat(Seat seat) {
        seat.cancelReservation();
        if (!waitlist.isEmpty()) {
            Passenger nextPassenger = waitlist.remove(0);
            // 취소된 좌석에 대해 다음 승객에게 예약 시도
            seat.reserve(nextPassenger);
            double price = basePrice * getPriceMultiplier(seat.getSeatClass());
            new Ticket(this, seat, nextPassenger, price);
        }
    }

    private double getPriceMultiplier(String seatClass) {
        if (seatClass.equals(seatClassConfig.getEconomy())) return seatClassConfig.getEconomyMultiplier();
        if (seatClass.equals(seatClassConfig.getBUSINESS())) return seatClassConfig.getBUSINESSMultiplier();
        if (seatClass.equals(seatClassConfig.getFIRST())) return seatClassConfig.getFIRSTMultiplier();
        return seatClassConfig.getEconomyMultiplier();
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String newStatus) {
        this.status = newStatus;
    }

    public double getBasePrice() {
        return basePrice;
    }

}
