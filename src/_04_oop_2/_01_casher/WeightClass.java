package _04_oop_2._01_casher;

public enum WeightClass {
    H(1.5),
    M(1.0),
    L(0.5);

    private final double wieghtMultiplier;

    WeightClass(double wieghtMultiplier) {
        this.wieghtMultiplier = wieghtMultiplier;
    }

    public double getWieghtMultiplier(){
        return wieghtMultiplier;
    }
}
