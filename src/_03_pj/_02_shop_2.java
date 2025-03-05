package _03_pj;

import java.util.*;
import java.util.stream.IntStream;

public class _02_shop_2 {

    public static void main(String[] args) {
        // 배열로 데이터 관리
        String[] coffeeTypes = initializeCoffeeTypes();
        int[] coffeePrices = initializeCoffeePrices();
        int[] coffeeStock = initializeCoffeeStock();
        int[] totalSales = {0};
        int[] totalSatisfiedCustomers = {0};
        int[] totalCustomers = {0};
        int[] operatingTime = {0};
        int[] eventTime = {0};
        List<int[]> customerPreferences = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("1. 커피 재고 설정");
            System.out.println("2. 무료 이벤트 설정");
            System.out.println("3. 다음날로 이동");
            System.out.println("4. 종료");
            System.out.print("선택: ");

            int choice = sc.nextInt();

            if (choice == 1) {
                setCoffeeStock(sc, coffeeStock, coffeeTypes);
            } else if (choice == 2) {
                eventTime[0] = setEvent(sc, operatingTime[0], coffeeStock, coffeeTypes);
            } else if (choice == 3) {
                nextDay(coffeeTypes, coffeePrices, coffeeStock, totalSales, totalSatisfiedCustomers, totalCustomers, operatingTime, eventTime, customerPreferences);
            } else if (choice == 4) {
                System.out.println("프로그램을 종료합니다.");
                break;
            } else {
                System.out.println("다시 선택하세요.");
            }
        }
    }

    // 커피 종류 초기화
    public static String[] initializeCoffeeTypes() {
        String[] coffeeTypes = new String[20];
        IntStream.range(0, 20).forEach(i -> coffeeTypes[i] = "커피종류" + (i + 1));
        return coffeeTypes;
    }

    // 커피 가격 초기화
    public static int[] initializeCoffeePrices() {
        Random random = new Random();
        int[] coffeePrices = new int[20];
        IntStream.range(0, 20).forEach(i -> coffeePrices[i] = random.nextInt(10001) + 10000);
        return coffeePrices;
    }

    // 커피 재고 초기화
    public static int[] initializeCoffeeStock() {
        int[] coffeeStock = new int[20];
        IntStream.range(0, 20).forEach(i -> coffeeStock[i] = 10 + i % 10);
        return coffeeStock;
    }

    // 커피 재고 설정
    public static void setCoffeeStock(Scanner scanner, int[] coffeeStock, String[] coffeeTypes) {
        System.out.println("\n===== 커피 재고 설정 =====");
        IntStream.range(0, coffeeTypes.length).forEach(i -> {
            System.out.print(coffeeTypes[i] + " 재고 설정 (현재: " + coffeeStock[i] + "개): ");
            coffeeStock[i] = scanner.nextInt();
        });
        System.out.println("재고 설정이 완료되었습니다.");
    }

    // 무료 이벤트 설정
    public static int setEvent(Scanner scanner, int operatingTime, int[] coffeeStock, String[] coffeeTypes) {
        Random random = new Random();
        System.out.println("\n===== 무료 이벤트 설정 =====");
        System.out.print("무료 이벤트 시간 (최대 " + (operatingTime * 60) + "분): ");
        int eventTime = Math.min(scanner.nextInt(), operatingTime * 60);

        System.out.println("컴퓨터 추천 무료 제공 음료 개수를 계산합니다...");
        int[] recommended = calculateRecommendedCoffees(eventTime, coffeeStock);

        System.out.println("컴퓨터 추천 결과: ");
        IntStream.range(0, coffeeTypes.length).forEach(i -> {
            if (recommended[i] > 0) {
                System.out.println(coffeeTypes[i] + ": " + recommended[i] + "잔");
            }
        });

        System.out.println("무료 이벤트 설정이 완료되었습니다: " + eventTime + "분.");
        return eventTime;
    }

    // 추천 커피 계산
    public static int[] calculateRecommendedCoffees(int eventTime, int[] coffeeStock) {
        int[] recommended = new int[coffeeStock.length];
        int totalEventTime = eventTime;
        Random random = new Random();

        for (int i = 0; i < coffeeStock.length; i++) {
            if (coffeeStock[i] > 0) {
                int coffeeTime = random.nextInt(5) + 1; // 1~5분
                int maxPossible = totalEventTime / coffeeTime;
                recommended[i] = Math.min(maxPossible, coffeeStock[i]);
                totalEventTime -= recommended[i] * coffeeTime;
            }
        }
        return recommended;
    }

    // 다음날로 이동
    public static void nextDay(String[] coffeeTypes, int[] coffeePrices, int[] coffeeStock, int[] totalSales, int[] totalSatisfiedCustomers, int[] totalCustomers, int[] operatingTime, int[] eventTime, List<int[]> customerPreferences) {
        Random random = new Random();

        operatingTime[0] = random.nextInt(12) + 1; // 1~12시간
        System.out.println("\n===== 다음날 =====");
        System.out.println("운영 시간: " + operatingTime[0] + " 시간");

        totalCustomers[0] = random.nextInt(20) + 1; // 1~20명
        customerPreferences.clear();
        IntStream.range(0, totalCustomers[0]).forEach(i -> {
            int preferredCoffee = random.nextInt(coffeeTypes.length);
            int maxSatisfaction = random.nextInt(100) + 1;
            customerPreferences.add(new int[]{preferredCoffee, maxSatisfaction});
        });

        System.out.println("손님 수: " + totalCustomers[0]);

        simulateDay(coffeeTypes, coffeePrices, coffeeStock, totalSales, totalSatisfiedCustomers, totalCustomers, operatingTime, eventTime, customerPreferences);
    }

    // 하루 시뮬레이션
    public static void simulateDay(String[] coffeeTypes, int[] coffeePrices, int[] coffeeStock, int[] totalSales, int[] totalSatisfiedCustomers, int[] totalCustomers, int[] operatingTime, int[] eventTime, List<int[]> customerPreferences) {
        int totalEventCoffees = 0;
        int highPriceCount = 0;

        for (int[] preference : customerPreferences) {
            int preferredCoffee = preference[0];
            int maxSatisfaction = preference[1];
            int actualSatisfaction = 0;

            if (coffeeStock[preferredCoffee] > 0) {
                coffeeStock[preferredCoffee]--;
                totalSales[0] += coffeePrices[preferredCoffee];
                actualSatisfaction = (int) (maxSatisfaction * 0.7);
                totalEventCoffees++;
                if (coffeePrices[preferredCoffee] >= 15000) {
                    highPriceCount++;
                }
            } else {
                int alternativeCoffee = findAlternativeCoffee(coffeeStock);
                if (alternativeCoffee != -1) {
                    coffeeStock[alternativeCoffee]--;
                    totalSales[0] += coffeePrices[alternativeCoffee];
                    actualSatisfaction = (int) (maxSatisfaction * 0.5);
                } else {
                    actualSatisfaction = 0;
                }
            }

            if (actualSatisfaction >= maxSatisfaction * 0.5) {
                totalSatisfiedCustomers[0]++;
            }
        }

        System.out.println("총 매출: " + totalSales[0] + "원");
        System.out.println("만족한 손님: " + totalSatisfiedCustomers[0] + "/" + totalCustomers[0]);
        System.out.println("무료로 제공된 음료: " + totalEventCoffees);
        System.out.println("15,000원 이상의 고가 음료 제공 횟수: " + highPriceCount);
        System.out.println("남은 재고: ");
        IntStream.range(0, coffeeTypes.length).forEach(i -> System.out.println(coffeeTypes[i] + ": " + coffeeStock[i] + "개"));

        int averageServiceTime = operatingTime[0] * 60 / totalCustomers[0];
        if (averageServiceTime < 5) {
            totalCustomers[0] += 5;
        } else if (averageServiceTime > 10) {
            totalCustomers[0] -= 3;
        }

        System.out.println("예상 손님 수 (다음날): " + totalCustomers[0]);
    }

    // 대체 커피 찾기
    public static int findAlternativeCoffee(int[] coffeeStock) {
        for (int i = 0; i < coffeeStock.length; i++) {
            if (coffeeStock[i] > 0) {
                return i;
            }
        }
        return -1; // 모든 음료가 품절일 경우
    }
}