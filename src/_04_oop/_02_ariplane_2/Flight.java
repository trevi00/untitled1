package _04_oop._02_ariplane_2;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Flight {

    private String flightNumber;
    private String departure;
    private String destination;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private double basePrice;
    private List<Seat> seats;
    private List<Passenger> waitlist;
    private String status;
    private int delayMinutes;
    private Airplane airplane;
    private Maintenance maintenance;

    public Flight(String flightNumber, String departure, String destination,
                  LocalDateTime departureTime, LocalDateTime arrivalTime, double basePrice,
                  int economySeats, int businessSeats, int firstClassSeats, Airplane airplane, Maintenance maintenance) {
        this.flightNumber = flightNumber;
        this.departure = departure;
        this.destination = destination;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.basePrice = basePrice;
        this.status = "ONTIME";
        this.delayMinutes = 0;
        this.seats = new ArrayList<>();
        this.waitlist = new ArrayList<>();
        this.airplane = airplane;
        this.maintenance = maintenance;

        generateSeats(economySeats, businessSeats, firstClassSeats);
    }

    private void generateSeats(int economySeats, int businessSeats, int firstClassSeats) {
        for (int i = 1; i <= economySeats; i++) {
            seats.add(new Seat(i, i + "A", SeatClass.ECONOMY, basePrice));
        }
        for (int i = 1; i <= businessSeats; i++) {
            seats.add(new Seat(i, i + "B", SeatClass.BUSINESS, basePrice));
        }
        for (int i = 1; i <= firstClassSeats; i++) {
            seats.add(new Seat(i, i + "C", SeatClass.FIRST, basePrice));
        }
    }

    public ReservationResult bookSeat(Passenger passenger, SeatClass seatClass) {
        for (Seat seat : seats) {
            if (!seat.isBooked() && seat.getSeatClass() == seatClass) {
                if (seat.reserve(passenger)) {
                    Ticket ticket = new Ticket(this, seat, passenger);
                    passenger.addBooking(ticket);
                    return new ReservationResult(true, ticket);
                }
            }
        }
        // 좌석 부족 시 대기 명단 추가
        waitlist.add(passenger);
        return new ReservationResult(false, null, "좌석이 없어 대기명단에 추가되었습니다.");
    }

    public void cancelSeat(Passenger passenger, boolean isVoluntary) {
        for (Seat seat : seats) {
            if (seat.isBooked() && seat.getBookedBy().equals(passenger)) {
                seat.cancelReservation();
                if (isVoluntary) {
                    passenger.setCanceledGain((int) seat.getPrice());
                }
                if (!waitlist.isEmpty()) {
                    Passenger nextPassenger = waitlist.remove(0);
                    bookSeat(nextPassenger, seat.getSeatClass());
                }
                return;
            }
        }
    }

    public void processNoShow() {
        Random random = new Random();
        int noShowCount = random.nextInt(3); // 랜덤 No-show 발생

        for (int i = 0; i < noShowCount && i < seats.size(); i++) {
            Seat seat = seats.get(i);
            if (seat.isBooked()) {
                Passenger passenger = seat.getBookedBy();
                passenger.setNoShow(true);
                seat.cancelReservation(); // 좌석 예약 해제

                if (!waitlist.isEmpty()) {
                    Passenger nextPassenger = waitlist.remove(0);
                    bookSeat(nextPassenger, seat.getSeatClass()); // 대기자 배정
                }
            }
        }
    }


    public void setStatus(String newStatus) {
        this.status = newStatus;
        if (newStatus.equals("DELAYED")) {
            delayMinutes = (new Random().nextInt(2) + 1) * 60;
        }
        if (newStatus.equals("CANCELED")) {
            for (Seat seat : seats) {
                if (seat.isBooked()) {
                    seat.getBookedBy().setCanceledGain((int) seat.getPrice());
                    seat.cancelReservation();
                }
            }
        }
    }

    public List<Passenger> getWaitlist() {
        return waitlist;
    }

    public String getStatus() {
        return status;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public int getDelayMinutes() {
        return delayMinutes;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public String getDeparture() {
        return departure;
    }

    public Airplane getAirplane() {
        return airplane;
    }

    public Maintenance getMaintenance() {
        return maintenance;
    }


    public String getDestination() {
        return destination;
    }
}
