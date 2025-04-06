package _04_oop._02_ariplane_2;

import java.util.Random;

public class Simulation {

    /*일주일 혹은 한 달치 스케줄을 반복 실행 1

누적 매출, 누적 승객 수, 취소율 등 집계. 2

이를 토대로 새로운 노선 추가 3

혹은 비인기 노선 폐지 같은 확장 요소를 4

시뮬레이션할 수 있음.*/

    private Management m;
    private int totalDays;
    private double totalRevenue;
    private int totalPassengers;
    private int totalCancelers;

    public Simulation(Management m){
        this.m = m;
    }

    public void simulatePeriod(int days){
        this.totalDays = days;
        this.totalRevenue = 0;
        this.totalPassengers = 0;
        this.totalCancelers = 0;

        for (int i = 0; i < days; i++) {
            // 하루 랜덤으로

            simulation();
        }

        System.out.println(days + "일 동안의 시뮬레이션 결과");
        System.out.println("누적 매출 : " + totalRevenue);
        System.out.println("누적 승객 : " + totalPassengers);
        System.out.println("누적 취소 항공 : " + totalCancelers);

    }

    public void simulation() {
        for (Flight flight : m.getFlights()) {
            Maintenance maintenance = flight.getMaintenance();

            // 상태 결정: 정비 부족이면 지연/취소 위험
            if (maintenance.hasDisruptionRisk()) {
                if (Math.random() < 0.5) {
                    flight.setStatus("CANCELED");
                    totalCancelers++;
                    continue; // 취소된 항공편은 더 이상 처리 X
                } else {
                    flight.setStatus("DELAYED");
                }
            } else {
                flight.setStatus("DEPARTED");
            }

            // 운항 성공 시 정비 기록
            if (flight.getStatus().equals("DEPARTED")) {
                maintenance.recordFlight();
            }

            // No-show 처리
            flight.processNoShow();

            // 수익과 승객 수 누적
            for (Seat seat : flight.getSeats()) {
                if (seat.isBooked()) {
                    Passenger p = seat.getBookedBy();
                    if (!p.isNoShow() && !p.isRefunded()) {
                        totalPassengers++;
                        totalRevenue += seat.getPrice();
                    }
                }
            }
        }
    }

}
