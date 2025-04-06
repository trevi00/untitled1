package _04_oop._02_ariplane_2;

public enum SeatClass {
    ECONOMY(1.0),
    BUSINESS(1.5),
    FIRST(2.0);

    private final double priceMultiplier;

    SeatClass(double priceMultiplier) {
        this.priceMultiplier = priceMultiplier;
    }

    public double getPriceMultiplier() {
        return priceMultiplier;
    }
}
