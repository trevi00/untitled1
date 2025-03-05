package _04_oop.airplane_ex;

public class SeatClass {
    private final String ECONOMY = "ECONOMY";
    private final String BUSINESS = "BUSINESS";
    private final String FIRST = "FIRST";

    public String getEconomy() {
        return ECONOMY;
    }

    public String getBUSINESS() {
        return BUSINESS;
    }

    public String getFIRST() {
        return FIRST;
    }

    public double getEconomyMultiplier() {
        return 1.5;
    }

    public double getBUSINESSMultiplier() {
        return 2.0;
    }

    public double getFIRSTMultiplier() {
        return 1.0;
    }

}
