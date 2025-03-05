package _03_pj;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;

/*
다음날로 -> 누르면
[아래 기능은 하루에 1개만 선택이가능하다]
청소(다음날 보너스), 더 고급 커피로 바꾸는 기능 -> 더 저급으로도 바꿀 수 있어야 함(예산)
-> 청소같은 경우에는 너무 안 해주면 당연히 손님들의 만족도가 떨어져야겠죠. 10일정도까지 안하면 최저.
>> 청소 커피만족도 구현

부가소품 바꿀 수 있어야 하고, 그 기능으로 인해 더 맛좋은 커피 등을 낼 수 있음(업그레이드 등)
[저급][중급][고급]으로 원가가 다르고, 손님이 받는 만족도 역시 다를 것.
커피 가격도 우리가 바꿀 수 있는데, -> 고급으로 갈 수록 당연히 만족도가 높기 때문에, 가격을 좀 올릴 수 있을 것.
>> 원가는 아직 구현 안함 이것은 이미 정해진 등급이 3개가 있는데 올라가면 1000원 올리고 내려가면 1000원 내리는 식으로 하면 됨
만족도는 구현함

커피기기 -> 커피를 만드는 속도가 더 빨라진다던가. 원가대비 더 많이 나온다던가.
그런 효율적인 부분의 업그레이드가 가능해야할거고.
>> 커피가 더 품질이 좋아지기에 만족도가 올라가는 것으로 구현함.

물론 위에 작성한 것뿐만이 아니라, 더 다양하게 스스로 생각해서 한 3가지정도는 보너스 될 만한 업그레이드를 만들어주셔야 함.
>> 커피의 등급에 따라서 만족도가 올라가는 것, 머신의 등급에 따라서 만족도가 올라가는 것, 전날 노동시간이 8시간이 넘어갈 경우 그날은 청소를 못하고 다음날 커피 퀄리티가 내려감(가상으로 등급이 내려가도록 할 예정).

하지만 노동적인 일을 너무 많이 하면 당연히 패널티도 있어야 하는 법이다.
하루 적정 노동치(근무시간 포함)를 넘을 경우(이것은 컴퓨터가 환산) -> 다음날 일 가능 시간대가 12시간이 나왔다고 가정할 때, -2시간이 된다거나 하는 기준이 필요.
>만족도로 대체

참고로 커피는 원가가 있으니 신중히 구매해서 팔아야 함.

하루에 오는 손님 수가 있고,
영업 시간이 있다.
만약에 영업시간을 넘겼는데도 손님이 있다면
나머지는 구매가 불가할 것.

영업시간이 되려 남았았다.
그러면 영업 마감하고 하나만 선택이 가능했던 걸, 2, 3번 선택도 가능하게.
-> 1시간 기준으로 1개의 선택이 더 가능하게 하면 되겠죠.
 */

public class _02_shop_4 {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // 배열로 데이터 관리
        String[] coffeeTypes = initializeCoffeeTypes();
        int[] coffeePrices = initializeCoffeePrices();
        int[] coffeeStock = initializeCoffeeStock();
        int[] coffeeRatio = initializeCoffeeRatio();
        int[] makingTime = initializeMakingTime(); // 추후 마감시간 이후에 대한 내용과 섞을 예정
        int[] machineRatio = {2}; // 1~3
        int[] totalSales = {0};
        int[] totalSatisfiedCustomers = {0};
        int[] totalCustomers = {0};
        int[] operatingTime = {0};
        int[] pastWorkingTime = {0};
        int[] cleaningCnt = {7};
        int[] eventTime = {0};
        List<int[]> customerPreferences = new ArrayList<>();

        while (true) {
            System.out.println("1. 커피 재고 설정");
            System.out.println("2. 무료 이벤트 설정");
            System.out.println("3. 다음날로 이동");
            System.out.println("4. 종료");
//            System.out.println("5. 커피 등급 설정");
            System.out.print("선택: ");

            int choice = sc.nextInt();

            if (choice == 1) {
                setCoffeeStock(sc, coffeeStock, coffeeTypes);
            } else if (choice == 2) {
                eventTime[0] = setEvent(sc, operatingTime[0], coffeeStock, coffeeTypes);
            } else if (choice == 3) {
                nextDay(coffeeTypes, coffeePrices, coffeeStock, totalSales, totalSatisfiedCustomers, totalCustomers, operatingTime, eventTime, customerPreferences,
                        cleaningCnt, machineRatio, coffeeRatio, pastWorkingTime);
            } else if (choice == 4) {
                System.out.println("프로그램을 종료합니다.");
                break;
            } else {
                System.out.println("다시 선택하세요.");
            }
        }
    }

    private static int[] initializeMakingTime() {
        Random random = new Random();
        int[] coffeeRatio = new int[20];
        IntStream.range(0, 20).forEach(i -> coffeeRatio[i] = random.nextInt(5)+5);
        return coffeeRatio;
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

    // 커피 등급 초기화

    public static int[] initializeCoffeeRatio() {
        Random random = new Random();
        int[] coffeeRatio = new int[20];
        IntStream.range(0, 20).forEach(i -> coffeeRatio[i] = random.nextInt(3)+1);
        return coffeeRatio;
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


    // 청소

    private static void toDayCleaning(int[] totalCustomers, int[] totalSatisfiedCustomers, int[] cleaningCnt) {

        System.out.println("청소를 하시겠습니까?");
        System.out.println("1. 예 \n2. 아니오");

        int cSelect = sc.nextInt();

        if (cSelect == 1) {
            if (cleaningCnt[0] == 10) {
                System.out.println("이미 매우 청결합니다.");
            } else if (cleaningCnt[0] < 5) {
                System.out.println("청소 상태가 미흡합니다. 열심히 해야합니다.");
                cleaningCnt[0]++;
            } else if (cleaningCnt[0] < 10) {
                System.out.println("청소 상태가 양호합니다.");
                cleaningCnt[0]++;
            }
        } else if (cSelect == 2) {
            if (cleaningCnt[0] > 0) {
                cleaningCnt[0]--;
            }
        }
    }


    // 다음날로 이동

    public static void nextDay(String[] coffeeTypes, int[] coffeePrices, int[] coffeeStock, int[] totalSales, int[] totalSatisfiedCustomers, int[] totalCustomers, int[] operatingTime, int[] eventTime, List<int[]> customerPreferences,
                               int[] cleaningCnt, int[] machineRatio, int[] coffeeRatio, int[] pastWorkingTime) {
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

        simulateDay(coffeeTypes, coffeePrices, coffeeStock, totalSales, totalSatisfiedCustomers, totalCustomers, operatingTime, eventTime, customerPreferences,
                cleaningCnt, machineRatio, coffeeRatio, pastWorkingTime);
    }

    // 하루 시뮬레이션

    public static void simulateDay(String[] coffeeTypes, int[] coffeePrices, int[] coffeeStock, int[] totalSales, int[] totalSatisfiedCustomers, int[] totalCustomers, int[] operatingTime, int[] eventTime, List<int[]> customerPreferences,
                                   int[] cleaningCnt, int[] machineRatio, int[] coffeeRatio, int[] pastWorkingTime) {
        int totalEventCoffees = 0;
        int highPriceCount = 0;

        toDayCleaning(totalCustomers, totalSatisfiedCustomers, cleaningCnt);
        double cIdx = 0;
        if( cleaningCnt[0] < 5 ){
            cIdx = 0.1;
            if(cleaningCnt[0] == 0){
                cIdx = 0.2;
            }
        } else if (cleaningCnt[0] > 7) {
            cIdx = -0.1;
        }

        double mIdx = 0;
        if(machineRatio[0] == 1){
            mIdx = 0.1;
        } else if (machineRatio[0] == 3) {
            mIdx = -0.1;
        }



        double idx = cIdx + mIdx;


        for (int[] preference : customerPreferences) {
            int preferredCoffee = preference[0];
            int maxSatisfaction = preference[1];

            int actualSatisfaction = 0;



            if (coffeeStock[preferredCoffee] > 0) {
                double fIdx = 0;
                if(coffeeRatio[preferredCoffee] == 1){
                    fIdx = 0.1;
                } else if (coffeeRatio[preferredCoffee] == 3) {
                    fIdx = -0.1;
                }

                idx += fIdx;

                coffeeStock[preferredCoffee]--;
                totalSales[0] += coffeePrices[preferredCoffee];
                actualSatisfaction = (int) (maxSatisfaction * (0.7 - idx));
                totalEventCoffees++;
                if (coffeePrices[preferredCoffee] >= 15000) {
                    highPriceCount++;
                }
            } else {

                int alternativeCoffee = findAlternativeCoffee(coffeeStock);

                if (alternativeCoffee != -1) {
                    double fIdx = 0;
                    if(coffeeRatio[alternativeCoffee] == 1){
                        fIdx = 0.1;
                    } else if (coffeeRatio[alternativeCoffee] == 3) {
                        fIdx = -0.1;
                    }

                    idx += fIdx;

                    coffeeStock[alternativeCoffee]--;
                    totalSales[0] += coffeePrices[alternativeCoffee];
                    actualSatisfaction = (int) (maxSatisfaction * (0.5 - idx));
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
        System.out.println("청결도 : " + cleaningCnt[0]);

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