package _04_oop_2._01_casher;

public enum SpeedClass {
    H(1.5),
    M(1.0),
    L(0.5);

    private final double speedMultiplier;

    SpeedClass(double speedMultiplier) {
        this.speedMultiplier = speedMultiplier;
    }

    public double getSpeedMultiplier(){
        return speedMultiplier;
    }
}
