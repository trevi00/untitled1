package _04_oop_2._01_casher;

public enum DamageClass {
    H(1.5),
    M(1.0),
    L(0.5);

    private final double damageMultiplier;

    DamageClass(double damageMultiplier) {
        this.damageMultiplier = damageMultiplier;
    }

    public double getDamageMultiplier(){
        return damageMultiplier;
    }
}
