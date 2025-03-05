package _03_pj;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;

public class _02_shop_4_1 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // 기본 데이터 초기화
        String[] coffeeTypes = initializeCoffeeTypes();
        int[] coffeePrices = initializeCoffeePrices();
        int[] coffeeStock = initializeCoffeeStock();
        int[] coffeeRatio = initializeCoffeeRatio();
        int[] makingTime = initializeMakingTime(); // 커피별 제조 시간
        int[] machineRatio = {2}; // 기계 1:저급, 2:중급, 3:고급
        int[] accessoryQuality = {2}; // 추가 1:저급, 2:중급, 3:고급
        int[] totalSales = {0};
        int[] totalSatisfiedCustomers = {0};
        int[] totalCustomers = {0};
        int[] operatingTime = {0};
        int[] pastWorkingTime = {0}; // 전날 노동 시간
        int[] cleaningCnt = {7};   // 청결도(최대 10)
        int[] eventTime = {0};
        List<int[]> customerPreferences = new ArrayList<>();

        while (true) {
            System.out.println("\n===== 메뉴 =====");
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
                nextDay(coffeeTypes, coffeePrices, coffeeStock, totalSales, totalSatisfiedCustomers,
                        totalCustomers, operatingTime, eventTime, customerPreferences, cleaningCnt,
                        machineRatio, coffeeRatio, pastWorkingTime, makingTime, accessoryQuality);
            } else if (choice == 4) {
                System.out.println("프로그램을 종료합니다.");
                break;
            } else {
                System.out.println("다시 선택하세요.");
            }
        }
    }

    // 다음날
    public static void nextDay(String[] coffeeTypes, int[] coffeePrices, int[] coffeeStock, int[] totalSales,
                               int[] totalSatisfiedCustomers, int[] totalCustomers, int[] operatingTime,
                               int[] eventTime, List<int[]> customerPreferences, int[] cleaningCnt,
                               int[] machineRatio, int[] coffeeRatio, int[] pastWorkingTime, int[] makingTime,
                               int[] accessoryQuality) {
        Random random = new Random();

        // 운영시간 및 손님 수
        operatingTime[0] = random.nextInt(12) + 1; // 1~12시간
        System.out.println("\n===== 다음날 =====");
        System.out.println("운영 시간: " + operatingTime[0] + "시간");

        totalCustomers[0] = random.nextInt(20) + 1; // 1~20명
        customerPreferences.clear();
        IntStream.range(0, totalCustomers[0]).forEach(i -> {
            int preferredCoffee = random.nextInt(coffeeTypes.length);
            int maxSatisfaction = random.nextInt(100) + 1;
            customerPreferences.add(new int[]{preferredCoffee, maxSatisfaction});
        });
        System.out.println("손님 수: " + totalCustomers[0]);

        // 전날 노동 시간 설정
        pastWorkingTime[0] = random.nextInt(5) + 6;
        System.out.println("전날 노동시간: " + pastWorkingTime[0] + "시간");

        // 하루 시뮬레이션 실행
        simulateDay(coffeeTypes, coffeePrices, coffeeStock, totalSales, totalSatisfiedCustomers,
                totalCustomers, operatingTime, eventTime, customerPreferences, cleaningCnt,
                machineRatio, coffeeRatio, pastWorkingTime, makingTime, accessoryQuality);

        // 추가 일거리
        int addWork = operatingTime[0];
        addWorkSelection(addWork, cleaningCnt, machineRatio, coffeeRatio, coffeePrices,
                coffeeTypes, makingTime, pastWorkingTime, accessoryQuality);
    }

    // ──────────────────────────────────────
    // 하루 시뮬레이션
    public static void simulateDay(String[] coffeeTypes, int[] coffeePrices, int[] coffeeStock, int[] totalSales,
                                   int[] totalSatisfiedCustomers, int[] totalCustomers, int[] operatingTime,
                                   int[] eventTime, List<int[]> customerPreferences, int[] cleaningCnt,
                                   int[] machineRatio, int[] coffeeRatio, int[] pastWorkingTime, int[] makingTime,
                                   int[] accessoryQuality) {
        totalSatisfiedCustomers[0] = 0;
        int totalEventCoffees = 0;
        int highPriceCount = 0;
        int idxEventTime = eventTime[0];

        double idx = 0;
        idx = addSatisfiedRatio(idx, cleaningCnt, machineRatio, accessoryQuality);

        // 전날 노동시간이 많으면 제조 시간이 20% 증가
        makingTimeSetter(pastWorkingTime, makingTime);

        int remainingTime = operatingTime[0] * 60;
        System.out.println("남은 영업시간(분): " + remainingTime);

        for (int[] preference : customerPreferences) {
            int preferredCoffee = preference[0];
            int maxSatisfaction = preference[1];

            int requiredTime = makingTime[preferredCoffee];
            if (remainingTime < requiredTime) {
                System.out.println("영업시간이 종료되어 더 이상 주문을 처리할 수 없습니다.");
                break;
            }
            remainingTime -= requiredTime;

            int actualSatisfaction = 0;
            if (coffeeStock[preferredCoffee] > 0) {
                double fIdx = (coffeeRatio[preferredCoffee] == 1) ? 0.1
                        : (coffeeRatio[preferredCoffee] == 3 ? -0.1 : 0);
                idx += fIdx;
                coffeeStock[preferredCoffee]--;
                totalSales[0] += coffeePrices[preferredCoffee];
                actualSatisfaction = (int) (maxSatisfaction * (0.7 - idx));
                if(idxEventTime>0) {
                    totalEventCoffees++;

                    actualSatisfaction = maxSatisfaction;

                    totalSales[0] -= coffeePrices[preferredCoffee];

                    idxEventTime -= makingTime[preferredCoffee];
                    if(machineRatio[0] == 3) {
                        idxEventTime += 1;
                    } else {
                        idxEventTime -= 1;
                    }
                }
                if (coffeePrices[preferredCoffee] >= 15000) {
                    highPriceCount++;
                }
            } else {
                int alternativeCoffee = findAlternativeCoffee(coffeeStock);
                if (alternativeCoffee != -1) {
                    double fIdx = (coffeeRatio[alternativeCoffee] == 1) ? 0.1
                            : (coffeeRatio[alternativeCoffee] == 3 ? -0.1 : 0);
                    idx += fIdx;
                    coffeeStock[alternativeCoffee]--;
                    totalSales[0] += coffeePrices[alternativeCoffee];
                    actualSatisfaction = (int) (maxSatisfaction * (0.5 - idx));

                    if(idxEventTime>0) {
                        totalEventCoffees++;

                        actualSatisfaction = (int) (maxSatisfaction * (0.7 - idx));

                        totalSales[0] -= coffeePrices[preferredCoffee];

                        idxEventTime -= makingTime[preferredCoffee];
                        if(machineRatio[0] == 3) {
                            idxEventTime += 1;
                        } else {
                            idxEventTime -= 1;
                        }
                    }

                } else {
                    actualSatisfaction = 0;
                }
            }

            if (actualSatisfaction >= maxSatisfaction * 0.5) {
                totalSatisfiedCustomers[0]++;
            }
        }

        simulatePrint(totalSales, totalSatisfiedCustomers, totalCustomers, totalEventCoffees, highPriceCount, coffeeTypes, coffeeStock, cleaningCnt);
        /*System.out.println("총 매출: " + totalSales[0] + "원");
        System.out.println("만족한 손님: " + totalSatisfiedCustomers[0] + "/" + totalCustomers[0]);
        System.out.println("무료로 제공된 음료: " + totalEventCoffees);
        System.out.println("15,000원 이상의 고가 음료 제공 횟수: " + highPriceCount);
        System.out.println("남은 재고: ");
        IntStream.range(0, coffeeTypes.length)
                .forEach(i -> System.out.println(coffeeTypes[i] + ": " + coffeeStock[i] + "개"));
        System.out.println("청결도 : " + cleaningCnt[0]);*/

        int averageServiceTime = operatingTime[0] * 60 / totalCustomers[0];
        if (averageServiceTime < 5) {
            totalCustomers[0] += 5;
        } else if (averageServiceTime > 10) {
            totalCustomers[0] -= 3;
        }
        System.out.println("예상 손님 수 (다음날): " + totalCustomers[0]);
    }

    private static void simulatePrint(int[] totalSales, int[] totalSatisfiedCustomers, int[] totalCustomers, int totalEventCoffees, int highPriceCount, String[] coffeeTypes, int[] coffeeStock, int[] cleaningCnt) {
        System.out.println("총 매출: " + totalSales[0] + "원");
        System.out.println("만족한 손님: " + totalSatisfiedCustomers[0] + "/" + totalCustomers[0]);
        System.out.println("무료로 제공된 음료: " + totalEventCoffees);
        System.out.println("15,000원 이상의 고가 음료 제공 횟수: " + highPriceCount);
        System.out.println("남은 재고: ");
        IntStream.range(0, coffeeTypes.length)
                .forEach(i -> System.out.println(coffeeTypes[i] + ": " + coffeeStock[i] + "개"));
        System.out.println("청결도 : " + cleaningCnt[0]);
    }

    private static double addSatisfiedRatio(double idx, int[] cleaningCnt, int[] machineRatio, int[] accessoryQuality) {
        // 청결도에 따른 보정
        if (cleaningCnt[0] < 5) {
            idx += (cleaningCnt[0] == 0 ? 0.2 : 0.1);
        } else if (cleaningCnt[0] > 7) {
            idx -= 0.1;
        }
        // 커피기기 등급에 따른 보정
        if (machineRatio[0] == 1) {
            idx += 0.1;
        } else if (machineRatio[0] == 3) {
            idx -= 0.1;
        }
        // 부가소품 등급에 따른 보정
        if (accessoryQuality[0] == 1) {
            idx += 0.1;
        } else if (accessoryQuality[0] == 3) {
            idx -= 0.1;
        }
        return idx;
    }

    private static void makingTimeSetter(int[] pastWorkingTime, int[] makingTime) {
        if (pastWorkingTime[0] > 8) {
            System.out.println("전날 노동시간이 8시간을 초과하여, 오늘의 커피 제조 시간이 늘어납니다.");
            for (int i = 0; i < makingTime.length; i++) {
                makingTime[i] = (int)(makingTime[i] * 1.2);
            }
        }
    }


    // 추가 일거리
    private static void addWorkSelection(int bonus, int[] cleaningCnt, int[] machineRatio,
                                         int[] coffeeRatio, int[] coffeePrices, String[] coffeeTypes,
                                         int[] makingTime, int[] pastWorkingTime, int[] accessoryQuality) {
        Scanner sc = new Scanner(System.in);

        boolean[] bonusUsed = new boolean[5];
        while (bonus > 0) {
            System.out.println("\n추가 일거리 선택 (" + bonus + "회 선택 가능):");
            System.out.println("1. 청소 (청결도 증가)");
            System.out.println("2. 커피 등급 변경 (품질 업/다운 및 가격 조정)");
            System.out.println("3. 커피기기 업그레이드/다운그레이드 (제조 시간 조정)");
            System.out.println("4. 부가소품 변경 (매장 분위기 개선)");
            System.out.println("5. 직원 휴식 (전날 노동시간 감소)");
            System.out.println("0. 추가 일거리 종료");
            System.out.print("선택: ");
            int bonusChoice = sc.nextInt();
            if (bonusChoice == 0) break;
            if (bonusChoice < 1 || bonusChoice > 5) {
                System.out.println("잘못된 선택입니다.");
                continue;
            }
            if (bonusUsed[bonusChoice - 1]) {
                System.out.println("추가 일거리를 이미 끝냈습니다.");
                continue;
            }
            switch (bonusChoice) {
                case 1:
                    // 청소: cleaningCnt 최대 10까지 증가
                    if (cleaningCnt[0] < 10) {
                        cleaningCnt[0]++;
                        System.out.println("청결도가 " + cleaningCnt[0] + "로 증가했습니다.");
                    } else {
                        System.out.println("이미 최고 청결 상태입니다.");
                    }
                    break;
                case 2:
                    // 커피 등급
                    System.out.println("변경할 커피 번호 선택 (1 ~ " + coffeeTypes.length + "): ");
                    int coffeeIndex = sc.nextInt() - 1;
                    if (coffeeIndex < 0 || coffeeIndex >= coffeeTypes.length) {
                        System.out.println("잘못된 번호입니다.");
                        break;
                    }
                    System.out.println("현재 " + coffeeTypes[coffeeIndex] + "의 등급: " + coffeeRatio[coffeeIndex]);
                    System.out.println("1. 업그레이드");
                    System.out.println("2. 다운그레이드");
                    int qualityChoice = sc.nextInt();
                    if (qualityChoice == 1) {
                        if (coffeeRatio[coffeeIndex] < 3) {
                            coffeeRatio[coffeeIndex]++;
                            coffeePrices[coffeeIndex] += 1000;
                            System.out.println(coffeeTypes[coffeeIndex] + " 업그레이드 / 등급: "
                                    + coffeeRatio[coffeeIndex] + ", 가격: " + coffeePrices[coffeeIndex] + "원");
                        } else {
                            System.out.println("이미 최고 등급입니다.");
                        }
                    } else if (qualityChoice == 2) {
                        if (coffeeRatio[coffeeIndex] > 1) {
                            coffeeRatio[coffeeIndex]--;
                            coffeePrices[coffeeIndex] -= 1000;
                            System.out.println(coffeeTypes[coffeeIndex] + " 다운그레이드 / 등급: "
                                    + coffeeRatio[coffeeIndex] + ", 가격: " + coffeePrices[coffeeIndex] + "원");
                        } else {
                            System.out.println("이미 최저 등급입니다.");
                        }
                    } else {
                        System.out.println("잘못된 선택입니다.");
                    }
                    break;
                case 3:
                    // 커피기기 등급
                    System.out.println("현재 커피기기 등급: " + machineRatio[0]);
                    System.out.println("1. 업그레이드");
                    System.out.println("2. 다운그레이드");
                    int machineChoice = sc.nextInt();
                    if (machineChoice == 1) {
                        if (machineRatio[0] < 3) {
                            machineRatio[0]++;
                            for (int i = 0; i < makingTime.length; i++) {
                                makingTime[i] = Math.max(1, (int)(makingTime[i] * 0.9));
                            }
                            System.out.println("커피기기 업그레이드 / 새로운 등급: " + machineRatio[0]);
                        } else {
                            System.out.println("이미 최고 등급입니다.");
                        }
                    } else if (machineChoice == 2) {
                        if (machineRatio[0] > 1) {
                            machineRatio[0]--;
                            for (int i = 0; i < makingTime.length; i++) {
                                makingTime[i] = (int)(makingTime[i] * 1.1);
                            }
                            System.out.println("커피기기 다운그레이드 / 새로운 등급: " + machineRatio[0]);
                        } else {
                            System.out.println("이미 최저 등급입니다.");
                        }
                    } else {
                        System.out.println("잘못된 선택입니다.");
                    }
                    break;
                case 4:
                    // 부가소품 등급
                    System.out.println("현재 부가소품 등급: " + accessoryQuality[0]);
                    System.out.println("1. 업그레이드");
                    System.out.println("2. 다운그레이드");
                    int accessoryChoice = sc.nextInt();
                    if (accessoryChoice == 1) {
                        if (accessoryQuality[0] < 3) {
                            accessoryQuality[0]++;
                            System.out.println("부가소품 업그레이드 / 새로운 등급: " + accessoryQuality[0]);
                        } else {
                            System.out.println("이미 최고 등급입니다.");
                        }
                    } else if (accessoryChoice == 2) {
                        if (accessoryQuality[0] > 1) {
                            accessoryQuality[0]--;
                            System.out.println("부가소품 다운그레이드 / 새로운 등급: " + accessoryQuality[0]);
                        } else {
                            System.out.println("이미 최저 등급입니다.");
                        }
                    } else {
                        System.out.println("잘못된 선택입니다.");
                    }
                    break;
                case 5:
                    // 직원 휴식: 전날 노동시간 50% 감소
                    System.out.println("전날 노동시간이 50% 감소합니다.");
                    pastWorkingTime[0] = (int)(pastWorkingTime[0] * 0.5);
                    System.out.println("새로운 전날 노동시간: " + pastWorkingTime[0] + "시간");
                    break;
            }
            bonusUsed[bonusChoice - 1] = true;
            bonus--;
        }
    }

    public static String[] initializeCoffeeTypes() {
        String[] coffeeTypes = new String[20];
        IntStream.range(0, 20).forEach(i -> coffeeTypes[i] = "커피종류" + (i + 1));
        return coffeeTypes;
    }

    public static int[] initializeCoffeePrices() {
        Random random = new Random();
        int[] coffeePrices = new int[20];
        IntStream.range(0, 20).forEach(i -> coffeePrices[i] = random.nextInt(10001) + 10000);
        return coffeePrices;
    }

    public static int[] initializeCoffeeStock() {
        int[] coffeeStock = new int[20];
        IntStream.range(0, 20).forEach(i -> coffeeStock[i] = 10 + i % 10);
        return coffeeStock;
    }

    public static int[] initializeCoffeeRatio() {
        Random random = new Random();
        int[] coffeeRatio = new int[20];
        IntStream.range(0, 20).forEach(i -> coffeeRatio[i] = random.nextInt(3) + 1);
        return coffeeRatio;
    }

    public static int[] initializeMakingTime() {
        Random random = new Random();
        int[] makingTime = new int[20];
        IntStream.range(0, 20).forEach(i -> makingTime[i] = random.nextInt(5) + 5); // 5~9분
        return makingTime;
    }

    public static void setCoffeeStock(Scanner scanner, int[] coffeeStock, String[] coffeeTypes) {
        System.out.println("\n===== 커피 재고 설정 =====");
        IntStream.range(0, coffeeTypes.length).forEach(i -> {
            System.out.print(coffeeTypes[i] + " 재고 설정 (현재: " + coffeeStock[i] + "개): ");
            coffeeStock[i] = scanner.nextInt();
        });
        System.out.println("재고 설정이 완료되었습니다.");
    }

    public static int setEvent(Scanner scanner, int operatingTime, int[] coffeeStock, String[] coffeeTypes) {
        Random random = new Random();
        System.out.println("\n===== 무료 이벤트 설정 =====");
        System.out.print("무료 이벤트 시간 (최대 " + (operatingTime * 60) + "분): ");
        int eventTime = Math.min(scanner.nextInt(), operatingTime * 60);

        System.out.println("컴퓨터 추천 무료 제공 음료 개수");
        int[] recommended = calculateRecommendedCoffees(eventTime, coffeeStock);

        System.out.println("컴퓨터 추천 결과 : ");
        IntStream.range(0, coffeeTypes.length).forEach(i -> {
            if (recommended[i] > 0) {
                System.out.println(coffeeTypes[i] + ": " + recommended[i] + "잔");
            }
        });
        System.out.println("무료 이벤트 설정이 완료 : " + eventTime + "분.");
        return eventTime;
    }

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

    public static int findAlternativeCoffee(int[] coffeeStock) {
        for (int i = 0; i < coffeeStock.length; i++) {
            if (coffeeStock[i] > 0) {
                return i;
            }
        }
        return -1; // 모두 품절인 경우
    }
}
