package _04_oop._02_ariplane_2;

import java.util.ArrayList;
import java.util.List;

/*Passenger 배열을 두고, 여러 승객이 각각 다른 Flight를 예약.

항공사 입장에서 예약 시스템을 통합적으로 관리.*/

public class Reservation {
    private List<Passenger> passengers;
    private Management management;

    public Reservation(Management management){
        this.management = management;
        this.passengers = new ArrayList<>();

    }

    public void addPassenger(Passenger passenger){
        passengers.add(passenger);
    }

    public void passengersBook(BookingStrategy strategy) {
        for (Passenger p : passengers) {
            boolean booked = false;

            for (Flight f : management.getFlights()) {
                if (strategy.isMatch(f, p)) {
                    ReservationResult result = f.bookSeat(p, SeatClass.ECONOMY);
                    if (result.isSuccess()) {
                        System.out.println(p.getName() + ": 예약 성공 - " + f.getFlightNumber());
                        booked = true;
                        break;
                    }
                }
            }

            if (!booked) {
                System.out.println(p.getName() + ": 예약 실패");
            }
        }
    }



}
