package _03_pj;

import java.util.*;

public class _02_shop {

    // 전역 변수 선언
    static String[] coffeeTypes = new String[20];
    static int[] coffeePrices = new int[20];
    static int[] coffeeTimes = new int[20];
    static int[] coffeeStock = new int[20];
    static int totalSales = 0;
    static int totalCustomers;
    static int totalSatisfiedCustomers = 0;
    static int[][] customerPreferences;
    static int operatingTime;
    static int eventTime;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        initializeCoffeeTypes();

        while (true) {
            System.out.println("1. 커피 재고 설정");
            System.out.println("2. 무료 이벤트 설정");
            System.out.println("3. 다음날로 이동");
            System.out.println("4. 종료");
            System.out.print("선택: ");

            int choice = sc.nextInt();

            if (choice == 1) {
                setCoffeeStock(sc);
            } else if (choice == 2) {
                setEvent(sc);
            } else if (choice == 3) {
                nextDay();
            } else if (choice == 4) {
                System.out.println("프로그램을 종료합니다.");
                break;
            } else {
                System.out.println("다시 선택하세요.");
            }
        }
    }

    public static void initializeCoffeeTypes() {
        Random random = new Random();
        for (int i = 0; i < coffeeTypes.length; i++) {
            coffeeTypes[i] = "커피종류" + (i + 1);
            coffeePrices[i] = random.nextInt(10001) + 10000; // 가격을 10000~20000원으로 설정
            coffeeStock[i] = 10 + i % 10; // 재고를 10~19로 순환
        }
    }

    public static void setCoffeeStock(Scanner scanner) {
        System.out.println("\n===== 커피 재고 설정 =====");
        for (int i = 0; i < coffeeTypes.length; i++) {
            System.out.print(coffeeTypes[i] + " 재고 설정 (현재: " + coffeeStock[i] + "개): ");
            coffeeStock[i] = scanner.nextInt();
        }
        System.out.println("재고 설정이 완료되었습니다.");
    }

    public static void setEvent(Scanner scanner) {
        Random random = new Random();
        System.out.println("\n===== 무료 이벤트 설정 =====");
        System.out.print("무료 이벤트 시간 (최대 " + (operatingTime * 60) + "분): ");
        eventTime = Math.min(scanner.nextInt(), operatingTime * 60);

        System.out.println("컴퓨터 추천 무료 제공 음료 개수를 계산합니다...");
        int[] recommended = calculateRecommendedCoffees();

        System.out.println("컴퓨터 추천 결과: ");
        for (int i = 0; i < coffeeTypes.length; i++) {
            if (recommended[i] > 0) {
                System.out.println(coffeeTypes[i] + ": " + recommended[i] + "잔");
            }
        }

        System.out.println("무료 이벤트 설정이 완료되었습니다: " + eventTime + "분.");
    }

    public static int[] calculateRecommendedCoffees() {
        int[] recommended = new int[coffeeTypes.length];
        int totalEventTime = eventTime;

        for (int i = 0; i < coffeeTypes.length; i++) {
            if (coffeeStock[i] > 0 && coffeeTimes[i] <= totalEventTime) {
                int maxPossible = totalEventTime / coffeeTimes[i];
                recommended[i] = Math.min(maxPossible, coffeeStock[i]);
                totalEventTime -= recommended[i] * coffeeTimes[i];
            }
        }
        return recommended;
    }

    public static void nextDay() {
        Random random = new Random();

        // 하루 운영 시간 랜덤 설정
        operatingTime = random.nextInt(12) + 1; // 1~12 시간
        System.out.println("\n===== 다음날 =====");
        System.out.println("운영 시간: " + operatingTime + " 시간");

        // 커피 제조 시간 랜덤 설정
        for (int i = 0; i < coffeeTypes.length; i++) {
            coffeeTimes[i] = random.nextInt(5) + 1; // 1~5분
        }

        // 손님 설정
        totalCustomers = random.nextInt(20) + 1; // 1~20명
        customerPreferences = new int[totalCustomers][2];
        for (int i = 0; i < totalCustomers; i++) {
            customerPreferences[i][0] = random.nextInt(coffeeTypes.length); // 선호 커피
            customerPreferences[i][1] = random.nextInt(100) + 1; // 선호 만족도 크기
        }

        System.out.println("손님 수: " + totalCustomers);

        // 시뮬레이션 실행
        simulateDay();
    }

    public static void simulateDay() {
        int totalEventCoffees = 0;
        int highPriceCount = 0;

        for (int i = 0; i < totalCustomers; i++) {
            int preferredCoffee = customerPreferences[i][0];
            int maxSatisfaction = customerPreferences[i][1];
            int actualSatisfaction = 0;

            // 손님이 원하는 음료 제공 여부 확인
            if (coffeeStock[preferredCoffee] > 0) {
                coffeeStock[preferredCoffee]--;
                totalSales += coffeePrices[preferredCoffee];
                actualSatisfaction = (int) (maxSatisfaction * 0.7); // 원하는 음료 제공
                totalEventCoffees++;
                if (coffeePrices[preferredCoffee] >= 15000) {
                    highPriceCount++;
                }
            } else {
                // 재고 부족 시 다른 음료 제공
                int alternativeCoffee = findAlternativeCoffee();
                if (alternativeCoffee != -1) {
                    coffeeStock[alternativeCoffee]--;
                    totalSales += coffeePrices[alternativeCoffee];
                    actualSatisfaction = (int) (maxSatisfaction * 0.5); // 다른 음료 제공
                } else {
                    actualSatisfaction = 0; // 만족도 없음
                }
            }

            if (actualSatisfaction >= maxSatisfaction * 0.5) {
                totalSatisfiedCustomers++;
            }
        }

        // 결과 출력
        System.out.println("총 매출: " + totalSales + "원");
        System.out.println("만족한 손님: " + totalSatisfiedCustomers + "/" + totalCustomers);
        System.out.println("무료로 제공된 음료: " + totalEventCoffees);
        System.out.println("15,000원 이상의 고가 음료 제공 횟수: " + highPriceCount);
        System.out.println("남은 재고: ");
        for (int i = 0; i < coffeeTypes.length; i++) {
            System.out.println(coffeeTypes[i] + ": " + coffeeStock[i] + "개");
        }

        // 다음날 손님 수 계산 (운영 효율 기반)
        int averageServiceTime = operatingTime * 60 / totalCustomers;
        if (averageServiceTime < 5) {
            totalCustomers += 5; // 빠른 서비스로 손님 증가
        } else if (averageServiceTime > 10) {
            totalCustomers -= 3; // 느린 서비스로 손님 감소
        }

        System.out.println("예상 손님 수 (다음날): " + totalCustomers);
    }

    public static int findAlternativeCoffee() {
        for (int i = 0; i < coffeeStock.length; i++) {
            if (coffeeStock[i] > 0) {
                return i;
            }
        }
        return -1; // 모든 음료가 품절일 경우
    }
}

