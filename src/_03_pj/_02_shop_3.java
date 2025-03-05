package _03_pj;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class _02_shop_3 {

    static Scanner sc = new Scanner(System.in);
    static InventoryManager inventoryManager = new InventoryManager();
    static EventManager eventManager = new EventManager();
    static SimulationManager simulationManager = new SimulationManager(inventoryManager, eventManager);

    static int totalSales = 0;
    static int totalSatisfiedCustomers = 0;
    static int dayCount = 0;

    public static void main(String[] args) {
        inventoryManager.initializeCoffeeList();

        while (true) {
            printMainMenu();
            int choice = inputInt(sc);

            if (choice == 1) {
                inventoryManager.setCoffeeStock(sc);
            } else if (choice == 2) {
                eventManager.setEvent(sc, inventoryManager.getOperatingTime());
            } else if (choice == 3) {
                dayCount++;
                simulationManager.nextDaySetup();
                int daySales = simulationManager.runDailySimulation(sc);
                int daySatisfied = simulationManager.getDaySatisfiedCustomers();

                totalSales += daySales;
                totalSatisfiedCustomers += daySatisfied;

                System.out.println("\n=== " + dayCount + "번째 날 결과 ===");
                System.out.println("당일 매출: " + daySales + "원");
                System.out.println("당일 만족한 손님: " + daySatisfied + "/" + simulationManager.getCustomerCount());
                System.out.println("누적 매출: " + totalSales + "원");
                System.out.println("누적 만족한 손님: " + totalSatisfiedCustomers);

            } else if (choice == 4) {
                System.out.println("프로그램을 종료합니다.");
                break;
            } else {
                System.out.println("다시 선택하세요.");
            }
        }
    }

    public static void printMainMenu() {
        System.out.println("\n===== 커피숍 관리 시스템 =====");
        System.out.println("1. 커피 재고 설정");
        System.out.println("2. 무료 이벤트 설정");
        System.out.println("3. 다음날로 이동 (시뮬레이션)");
        System.out.println("4. 종료");
        System.out.print("선택: ");
    }

    public static int inputInt(Scanner sc) {
        while (!sc.hasNextInt()) {
            sc.next();
            System.out.println("숫자를 입력하세요:");
        }
        return sc.nextInt();
    }
}

class Coffee {
    String name;
    int price;
    int stock;
    int brewTime;

    public Coffee(String name, int price, int stock, int brewTime) {
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.brewTime = brewTime;
    }
}

class Customer {
    int preferredCoffeeIndex; //선호
    int maxSatisfaction; //만족
    int actualSatisfaction; //실제만족

    public Customer(int preferredCoffeeIndex, int maxSatisfaction) {
        this.preferredCoffeeIndex = preferredCoffeeIndex;
        this.maxSatisfaction = maxSatisfaction;
        this.actualSatisfaction = 0;
    }

    public void updateSatisfaction(boolean gotPreferred, boolean isFree, int coffeePrice) {
        double base = 0.0;
        if (gotPreferred && isFree) { // 선호 공짜
            base = 1.0;
        } else if (gotPreferred && !isFree) { // 선호 공짜아님
            base = 0.7;
        } else if (!gotPreferred && isFree) { //선호x 공짜
            base = 0.5;
        } else {
            base = 0.3;
        }

        int extra = coffeePrice / 20000;
        this.actualSatisfaction = (int) (maxSatisfaction * base) + extra;
    }
}

class InventoryManager {
    private List<Coffee> coffeeList = new ArrayList<>();
    private int operatingTime;

    public void initializeCoffeeList() {
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            String name = "커피종류" + (i + 1);
            int price = random.nextInt(10001) + 10000;
            int stock = 10 + (i % 10);
            coffeeList.add(new Coffee(name, price, stock, 1));
        }
        this.operatingTime = 0;
    }

    public void setCoffeeStock(Scanner scanner) {
        System.out.println("\n===== 커피 재고 설정 =====");
        for (int i = 0; i < coffeeList.size(); i++) {
            Coffee c = coffeeList.get(i);
            System.out.print(c.name + " 재고 설정 (현재: " + c.stock + "개): ");
            int newStock = scanner.nextInt();
            while (newStock < 0) {
                System.out.println("음수로 설정할 수 없습니다. 다시 입력하세요.");
                newStock = scanner.nextInt();
            }
            c.stock = newStock;
        }
        System.out.println("재고 설정이 완료되었습니다.");
    }

    public void setupOperatingTime() {
        Random random = new Random();
        this.operatingTime = random.nextInt(13);
    }

    public void updateBrewTimes() {
        Random random = new Random();
        for (Coffee c : coffeeList) {
            c.brewTime = random.nextInt(5) + 1;
        }
    }

    public int getOperatingTime() {
        return operatingTime;
    }

    public List<Coffee> getCoffeeList() {
        return coffeeList;
    }
}

class EventManager {
    private int eventTime;
    private int[] freePlan;

    public EventManager() {
        this.eventTime = 0;
        this.freePlan = null;
    }

    public void setEvent(Scanner scanner, int operatingTimeHours) {
        int maxPossible = operatingTimeHours * 60;
        if (maxPossible == 0) {
            System.out.println("오늘은 운영 시간이 0시간입니다. 이벤트를 진행할 수 없습니다.");
            this.eventTime = 0;
            return;
        }
        System.out.println("\n===== 무료 이벤트 설정 =====");
        System.out.print("무료 이벤트 시간 (최대 " + maxPossible + "분): ");
        int inputTime = scanner.nextInt();

        while (inputTime < 0 || inputTime > maxPossible) {
            System.out.println("잘못된 범위입니다. 0 ~ " + maxPossible + " 사이로 입력하세요.");
            inputTime = scanner.nextInt();
        }
        this.eventTime = inputTime;

        System.out.println("이벤트 시간: " + eventTime + "분 설정 완료.");
    }

    public int[] computeFreePlan(List<Coffee> coffeeList, int eventTime) {
        int[] plan = new int[coffeeList.size()];
        int remainingTime = eventTime;
        for (int i = 0; i < coffeeList.size(); i++) {
            Coffee c = coffeeList.get(i);
            if (c.brewTime <= remainingTime && c.stock > 0) {
                int maxPossible = remainingTime / c.brewTime;
                plan[i] = Math.min(maxPossible, c.stock);
                remainingTime -= plan[i] * c.brewTime;
            }
        }
        return plan;
    }

    public int getEventTime() {
        return eventTime;
    }

    public int[] getFreePlan() {
        return freePlan;
    }

    public void setFreePlan(int[] plan) {
        this.freePlan = plan;
    }
}

class SimulationManager {
    private InventoryManager inventoryManager;
    private EventManager eventManager;

    private int customerCount;
    private List<Customer> customers;
    private int daySales;
    private int daySatisfiedCustomers;
    private int usedFreeTime;

    public SimulationManager(InventoryManager im, EventManager em) {
        this.inventoryManager = im;
        this.eventManager = em;
        this.customers = new ArrayList<>();
    }

    public void nextDaySetup() {
        inventoryManager.setupOperatingTime();
        int op = inventoryManager.getOperatingTime();
        System.out.println("\n===== 다음날 =====");
        System.out.println("운영 시간: " + op + " 시간");

        inventoryManager.updateBrewTimes();

        Random random = new Random();
        this.customerCount = random.nextInt(20) + 1;
        customers.clear();
        for (int i = 0; i < customerCount; i++) {
            int pcIndex = random.nextInt(inventoryManager.getCoffeeList().size());
            int maxSat = random.nextInt(100) + 1;
            customers.add(new Customer(pcIndex, maxSat));
        }
        System.out.println("손님 수: " + customerCount);

        this.daySales = 0;
        this.daySatisfiedCustomers = 0;
        this.usedFreeTime = 0;
    }

    public int runDailySimulation(Scanner sc) {
        int evTime = eventManager.getEventTime();
        int opTime = inventoryManager.getOperatingTime();
        int maxEventTime = Math.min(evTime, opTime * 60);

        int[] plan = eventManager.computeFreePlan(inventoryManager.getCoffeeList(), maxEventTime);
        eventManager.setFreePlan(plan);

        System.out.println("\n===== 오늘의 이벤트 추천 안: =====");
        List<Coffee> cList = inventoryManager.getCoffeeList();
        for (int i = 0; i < plan.length; i++) {
            if (plan[i] > 0) {
                System.out.println(cList.get(i).name + ": " + plan[i] + "잔");
            }
        }

        usedFreeTime = 0;

        for (Customer cust : customers) {
            int desiredIdx = cust.preferredCoffeeIndex;
            boolean isFree = false;
            int chosenIdx = -1;

            Coffee desiredCoffee = cList.get(desiredIdx);
            if (plan[desiredIdx] > 0 && desiredCoffee.stock > 0) {
                if (usedFreeTime + desiredCoffee.brewTime <= maxEventTime) {
                    plan[desiredIdx]--;
                    desiredCoffee.stock--;
                    usedFreeTime += desiredCoffee.brewTime;
                    isFree = true;
                    chosenIdx = desiredIdx;
                    cust.updateSatisfaction(true, true, desiredCoffee.price);

                } else {
                    chosenIdx = buyCoffee(desiredIdx, cust);
                }
            } else {
                chosenIdx = buyCoffee(desiredIdx, cust);
            }

            if (chosenIdx == -1) {
                cust.actualSatisfaction = 0;
            }

            if (cust.actualSatisfaction >= cust.maxSatisfaction * 0.5) {
                daySatisfiedCustomers++;
            }
        }

        System.out.println("===== 하루 시뮬레이션 결과 =====");
        System.out.println("무료 이벤트 소진 시간: " + usedFreeTime + "분 / " + maxEventTime + "분");
        System.out.println("당일 매출: " + daySales);

        System.out.println("===== 남은 재고 =====");
        for (Coffee c : cList) {
            System.out.println(c.name + ": " + c.stock + "개");
        }

        System.out.println("===== 각 손님별 결과 =====");
        for (int i = 0; i < customers.size(); i++) {
            Customer cust = customers.get(i);
            System.out.println((i + 1) + "번째 손님 - 선호커피: " + cList.get(cust.preferredCoffeeIndex).name
                    + ", 실제만족도: " + cust.actualSatisfaction + "/" + cust.maxSatisfaction);
        }

        return daySales;
    }

    private int buyCoffee(int desiredIdx, Customer cust) {
        List<Coffee> cList = inventoryManager.getCoffeeList();
        Coffee desired = cList.get(desiredIdx);
        if (desired.stock > 0) {
            desired.stock--;
            this.daySales += desired.price;
            cust.updateSatisfaction(true, false, desired.price);
            return desiredIdx;
        } else {
            int altIdx = findAlternativeCoffee();
            if (altIdx == -1) {
                return -1;
            } else {
                cList.get(altIdx).stock--;
                this.daySales += cList.get(altIdx).price;
                cust.updateSatisfaction(false, false, cList.get(altIdx).price);
                return altIdx;
            }
        }
    }

    private int findAlternativeCoffee() {
        List<Coffee> cList = inventoryManager.getCoffeeList();
        for (int i = 0; i < cList.size(); i++) {
            Coffee c = cList.get(i);
            if (c.stock > 0) {
                return i;
            }
        }
        return -1;
    }

    public int getDaySatisfiedCustomers() {
        return daySatisfiedCustomers;
    }

    public int getCustomerCount() {
        return customerCount;
    }
}
