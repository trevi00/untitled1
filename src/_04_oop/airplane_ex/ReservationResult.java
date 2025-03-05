package _04_oop.airplane_ex;

public class ReservationResult {
    private boolean success;
    private Ticket ticket;
    private String message;

    public ReservationResult(boolean success, Ticket ticket, String message) {
        this.success = success;
        this.ticket = ticket;
        this.message = message;
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

}
