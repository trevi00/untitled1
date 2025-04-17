package _04_oop_2._01_casher;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    List<Weapon> weapons;

    public Inventory(){
        weapons = new ArrayList<>();
    }

    public List<Weapon> getWeapons() {
        return weapons;
    }

    public void setWeapons(List<Weapon> weapons) {
        this.weapons = weapons;
    }

    public void addWeapon(Weapon weapon){
        weapons.add(weapon);
    }
}
