package _04_oop_2._01_casher;

import java.time.LocalDateTime;

public class PriceStatistics {
    private LocalDateTime td = LocalDateTime.now();

    public double getPrice(int d, int s, int w,
                           double price){
        double m1 = getDamageMul(d).getDamageMultiplier();
        double m2 = getSpeedMul(s).getSpeedMultiplier();
        double m3 = getWeightMul(w).getWieghtMultiplier();

        return price*(m1+m2+m3)/3;
    }

    public DamageClass getDamageMul(int damage){
        if(damage < 5){
            return DamageClass.L;
        } if(damage <8){
            return DamageClass.M;
        }
        return DamageClass.H;
    }

    public SpeedClass getSpeedMul(int speed){
        if(speed < 5){
            return SpeedClass.L;
        } if(speed <8){
            return SpeedClass.M;
        }
        return SpeedClass.H;
    }

    public WeightClass getWeightMul(int weight){
        if(weight < 5){
            return WeightClass.L;
        } if(weight <8){
            return WeightClass.M;
        }
        return WeightClass.H;
    }
}
