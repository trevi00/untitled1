package _04_oop_2._01_casher;

public abstract class WeaponStatistics {
    public String getWeaponName() {
        return weaponName;
    }

    public void setWeaponName(String weaponName) {
        this.weaponName = weaponName;
    }

    public int getDamageValue() {
        return damageValue;
    }

    public void setDamageValue(int damageValue) {
        this.damageValue = damageValue;
    }

    // weaponName
    String weaponName;
    // damageValue
    int damageValue;

    public int getSpeedValue() {
        return speedValue;
    }

    public void setSpeedValue(int speedValue) {
        this.speedValue = speedValue;
    }

    // speedValue
    int speedValue;

    public int getWeightValue() {
        return weightValue;
    }

    public void setWeightValue(int weightValue) {
        this.weightValue = weightValue;
    }

    // weightValue
    int weightValue;

    WeaponStatistics(String weaponName, int damageValue, int speedValue, int weightValue){
        this.weaponName = weaponName;
        this.damageValue = damageValue;
        this.speedValue = speedValue;
        this.weightValue = weightValue;
    }


}
