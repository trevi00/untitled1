package _04_oop._02_ariplane_2;

public class Airplane {
    private String modelName;         // 항공기 기종명
    private int totalSeats;           // 총 좌석 수
    private String engineGrade;       // 엔진 등급
    private int range;                // 항속 거리 (km)
    private boolean international;    // 국제선 여부
    private double taxRate;           // 세금/수수료 비율 (예: 0.1 → 10%)

    public Airplane(String modelName, int totalSeats, String engineGrade, int range, boolean international, double taxRate) {
        this.modelName = modelName;
        this.totalSeats = totalSeats;
        this.engineGrade = engineGrade;
        this.range = range;
        this.international = international;
        this.taxRate = taxRate;
    }

    public String getModelName() {
        return modelName;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public String getEngineGrade() {
        return engineGrade;
    }

    public int getRange() {
        return range;
    }

    public boolean isInternational() {
        return international;
    }

    public double getTaxRate() {
        return taxRate;
    }

    @Override
    public String toString() {
        return modelName + " | 총좌석: " + totalSeats +
                ", 엔진등급: " + engineGrade +
                ", 항속거리: " + range + "km" +
                ", " + (international ? "국제선" : "국내선") +
                ", 세금율: " + (taxRate * 100) + "%";
    }
}
