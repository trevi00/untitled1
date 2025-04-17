package _04_oop_2._01_casher;

public class Weapon extends WeaponStatistics {
    private double price;
    private int stock;

    DamageClass damageClass;
    SpeedClass speedClass;
    WeightClass weightClass;

    PriceStatistics priceStatistics;

    Weapon(String weaponName, int damageValue, int speedValue, int weightValue,
           double basePirce) {
        super(weaponName, damageValue, speedValue, weightValue);
        this.price = priceStatistics.getPrice(damageValue, speedValue, weightValue, basePirce);


    }


}
