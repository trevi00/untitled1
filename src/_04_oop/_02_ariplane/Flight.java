package _04_oop._02_ariplane;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Flight {
    private String flightNumber;

    private String departure;
    private String destination;

    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;

    private ArrayList<Seat> seats;

    private ArrayList<Passenger> waitlist;

    private String status;

    private double basePrice;

    private SeatClass sc;

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

        this.sc = new SeatClass();

        this.seats = new ArrayList<>();

        this.waitlist = new ArrayList<>();

        generateSeats(economySeats, businessSeats, firstClassSeats);
    }

    private void generateSeats(int economySeats, int businessSeats, int firstClassSeats) {
        char idx = 'A';

        for (int i = 1; i <= economySeats/2; i++) {
            seats.add(new Seat(i, idx, sc.getEconomy()));
            seats.add(new Seat(i, (char) (idx+1), sc.getEconomy()));

        }
        for (int i = 1; i <= businessSeats/2; i++) {
            seats.add(new Seat(i, (char) (idx+2), sc.getBUSINESS()));
            seats.add(new Seat(i, (char) (idx+3), sc.getBUSINESS()));
        }
        for (int i = 1; i <= firstClassSeats; i++) {
            seats.add(new Seat(i, 'F', sc.getFIRST()));
        }
    }

    // 특정 좌석 예약 여부 조회
    public boolean isSeatBooked(int serialNum,char seatId){
        for(Seat seat : seats){
            if(!seat.getBook() && seat.getSeatId() == seatId && seat.getSerialNum() == serialNum){
                return seat.getBook();
            }
        }
        return false;
    }

    public Ticket bookSeat(Passenger passenger, String seatClass) {
        for (Seat seat : seats) {
            if (!seat.getBook() && seat.getSeatClass().equals(seatClass)) {
                if (seat.setBook(passenger)) {
                    double price = basePrice * getPriceMultiplier(seatClass);
                    return new Ticket(this, seat, passenger, price);
                }
            }
        }
        waitlist.add(passenger);
        return null;
    }

    // 특정 좌석 예약
    public Ticket bookSeatTarget(int serialNum, char seatId, Passenger passenger, String seatClass){
        for(Seat seat : seats){
            if(seat.getSeatId() == seatId && seat.getSerialNum() == serialNum){
                if(!seat.getBook()){
                    if(seat.setBook(passenger)){
                        double price = basePrice * getPriceMultiplier(seatClass);
                        return new Ticket(this, seat, passenger, price);
                    }
                    else {
                        System.out.println("이미 예약된 자리입니다.");
                    }
                }
            }
        }
        System.out.println("잘못된 좌석을 입력하셨습니다.");
        return null;
    }

    public void cancelSeat(Seat seat) {
        seat.delBook();
        if (!waitlist.isEmpty()) {
            Passenger nextPassenger = waitlist.remove(0);
            bookSeat(nextPassenger, seat.getSeatClass());
        }

        // TODO 문제 2 3번째
    }

    private double getPriceMultiplier(String seatClass) {
        if (seatClass.equals(sc.getEconomy())) return sc.getEconomymul();
        if (seatClass.equals(sc.getBUSINESS())) return sc.getBUSINESSmul();
        if (seatClass.equals(sc.getFIRST())) return sc.getFIRSTmul();
        return sc.getEconomymul();
    }

    public double getBasePrice() {
        return basePrice;
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
}
