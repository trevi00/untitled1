package _04_oop._02_ariplane_2;

public class Maintenance {
    private double maintenanceCost;
    private double fuelCost;
    private double crewCost;

    private int flightsSinceLastMaintenance;
    private final int maintenanceThreshold = 10;

    public Maintenance(double maintenanceCost, double fuelCost, double crewCost) {
        this.maintenanceCost = maintenanceCost;
        this.fuelCost = fuelCost;
        this.crewCost = crewCost;
        this.flightsSinceLastMaintenance = 0;
    }

    public void recordFlight() {
        flightsSinceLastMaintenance++;
    }

    public void performMaintenance() {
        flightsSinceLastMaintenance = 0;
    }

    public boolean needsMaintenance() {
        return flightsSinceLastMaintenance >= maintenanceThreshold;
    }

    public double getTotalCost() {
        return maintenanceCost + fuelCost + crewCost;
    }

    public double getNetProfit(double revenue) {
        return revenue - getTotalCost();
    }

    public int getFlightsSinceLastMaintenance() {
        return flightsSinceLastMaintenance;
    }

    // 정비 부족으로 인한 지연/취소 확률 적용
    public boolean hasDisruptionRisk() {
        return needsMaintenance() && Math.random() < 0.3; // 30% 확률
    }
}

