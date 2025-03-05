package _04_oop._02_ariplane;

public class SeatClass {
    private String ECONOMY = "ECONOMY";
    private String BUSINESS = "BUSINESS";
    private String FIRST = "FIRST";

    public String getEconomy(){
        return ECONOMY;
    }

    public String getBUSINESS(){
        return BUSINESS;
    }

    public String getFIRST() {
        return FIRST;
    }

    public double getFIRSTmul() {
        return 1.0;
    }

    public double getEconomymul(){
        return 1.5;
    }

    public double getBUSINESSmul(){
        return 2.0;
    }


}
