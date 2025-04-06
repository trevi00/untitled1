package _04_oop._02_ariplane_2;

import java.util.ArrayList;
import java.util.List;

public class Passenger {
    private String name;
    private String passportNumber;
    private List<Ticket> myBookings;

    public int getSatisfy() {
        return satisfy;
    }

    public void setSatisfy(int satisfy) {
        this.satisfy = satisfy;
    }

    private int satisfy;
    private boolean noShow;
    private int canceledGain;
    private int mileage;
    private String grade;

    public Passenger(String name, String passportNumber, String grade) {
        this.name = name;
        this.passportNumber = passportNumber;
        this.myBookings = new ArrayList<>();
        this.grade = grade;
        this.satisfy = 50;
    }

    public Passenger(String name, String passportNumber) {
        this.name = name;
        this.passportNumber = passportNumber;
        this.myBookings = new ArrayList<>();
        this.grade = "nomal"; // 기본 등급 설정
        this.satisfy = 50;
    }

    public void setCanceledGain(int amount) {
        this.canceledGain = amount;
        this.satisfy += 5; // 환불을 받으면 만족도 증가
        if (satisfy > 100) satisfy = 100; // 최대 만족도 100 유지
    }

    public int getCanceledGain() {
        return canceledGain;
    }

    public void addBooking(Ticket ticket) {
        myBookings.add(ticket);
    }

    public String getName() {
        return name;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public List<Ticket> getMyBookings() {
        return myBookings;
    }

    public boolean isNoShow() {
        return noShow;
    }

    public void setNoShow(boolean noShow) {
        this.noShow = noShow;
    }

    public boolean isRefunded() {
        for (Ticket ticket : myBookings) {
            if (ticket.isRefunded()) {
                return true; // 하나라도 환불된 티켓이 있으면 true 반환
            }
        }
        return false;
    }
}
