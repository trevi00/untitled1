package _04_oop.airplane_ex;

public class FlightStatistics {
    private int totalFlights;
    private int delayedFlights;
    private int canceledFlights;

    public FlightStatistics(int totalFlights, int delayedFlights, int canceledFlights) {
        this.totalFlights = totalFlights;
        this.delayedFlights = delayedFlights;
        this.canceledFlights = canceledFlights;
    }

    public int getTotalFlights() {
        return totalFlights;
    }

    public int getDelayedFlights() {
        return delayedFlights;
    }

    public int getCanceledFlights() {
        return canceledFlights;
    }

    @Override
    public String toString() {
        return "총 비행편 수: " + totalFlights + "\n지연된 비행편: " + delayedFlights +
                "\n취소된 비행편: " + canceledFlights;
    }
}
