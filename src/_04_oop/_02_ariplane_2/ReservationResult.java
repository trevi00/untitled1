package _04_oop._02_ariplane_2;

public class ReservationResult {
    private boolean success;
    private Ticket ticket;
    private String message;
    private double compensation;

    public ReservationResult(boolean success, Ticket ticket) {
        this.success = success;
        this.ticket = ticket;
        this.compensation = 0;

        if (success && ticket != null) {
            this.message = "예약 성공 | 좌석: " + ticket.getSeat().getSerialNum() + ticket.getSeat().getSeatId();
        } else {
            this.message = "예약 실패 | 좌석이 없거나 예약이 불가능합니다.";
        }
    }

    public ReservationResult(boolean success, Ticket ticket, String reason) {
        this.success = success;
        this.ticket = ticket;
        this.compensation = 0;

        if (success && ticket != null) {
            this.message = "예약 성공 | 좌석: " + ticket.getSeat().getSerialNum() + ticket.getSeat().getSeatId();
        } else {
            this.message = "예약 실패 | 이유: " + reason;
        }
    }

    public void setCompensation(double amount) {
        this.compensation = amount;
        this.message += " | 보상금 지급: $" + String.format("%.2f", amount);
    }

    public boolean isSuccess() {
        return success;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public String getMessage() {
        return message;
    }

    public double getCompensation() {
        return compensation;
    }
}
