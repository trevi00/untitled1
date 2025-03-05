package _01_base;

import java.util.Scanner;

public class _06_ps {
    static int recentAttempt1 = 0;
    static int recentAttempt2 = 0;
    static int recentAttempt3 = 0;
    static int recentAttempt4 = 0;
    static int recentAttempt5 = 0;
    static int answer; // 정답
    static int turn = 0; // 현재 턴
    static boolean hintUsed = false; // 힌트 사용 여부
    static int penaltyTurns = 0; // 패널티 턴
    static boolean specialRuleFailed = false; // 규칙 1로 정답을 아깝게 못 맞췄을 때

    public static void main(String[] args) {
        play();
    }

    public static void play() {
        Scanner sc = new Scanner(System.in);

        System.out.println("첫번째 번호 입력 : ");
        int num1 = sc.nextInt();

        System.out.println("두번째 번호 입력 : ");
        int num2 = sc.nextInt();

        System.out.println("세번째 번호 입력 : ");
        int num3 = sc.nextInt();

        System.out.println("네번째 번호 입력 : ");
        int num4 = sc.nextInt();

        answer = num1 + num2 + num3 + num4;

        System.out.println("번호 저장 완료.");
        System.out.println("숫자가 모두 더해졌습니다. 정답을 맞춰보세요. 최대한 빠른 사람이 승리합니다.");

        System.out.println("1번 플레이어의 이름을 입력하여 주십시오.");
        String p1 = sc.next();

        System.out.println("이번엔 2번 플레이어의 이름을 입력하여 주십시오.");
        String p2 = sc.next();

        System.out.println(p1 + "님, " + p2 + "님 반갑습니다.");

        System.out.println("지금부터 게임을 진행하겠습니다. 정답은 플레이어가 제시한 숫자보다 크거나 작을 시 컴퓨터가 알려줍니다.");
        System.out.println(p1 + "님부터 시작합니다.");

        while (true) {
            if (turn > 0) {
                rule1(); // 규칙 1 적용
            }

            if (penaltyTurns > 0) {
                penaltyTurns--;
                System.out.println("패널티 턴으로 인해 힌트를 받을 수 없습니다.");
            } else if (turn > 0 && specialRuleFailed) { // 규칙 1로 아깝게 틀린 경우에만 힌트 제공
                check();
                specialRuleFailed = false; // 힌트 제공 후 상태 리셋
            }

            // 1번 플레이어 차례
            turn++;
            if (playerTurn(sc, p1)) break;

            if (turn > 0) {
                rule1(); // 규칙 1 적용
            }

            if (penaltyTurns > 0) {
                penaltyTurns--;
                System.out.println("패널티 턴으로 인해 힌트를 받을 수 없습니다.");
            } else if (turn > 0 && specialRuleFailed) { // 규칙 1로 아깝게 틀린 경우에만 힌트 제공
                check();
                specialRuleFailed = false; // 힌트 제공 후 상태 리셋
            }

            // 2번 플레이어 차례
            turn++;
            if (playerTurn(sc, p2)) break;

            if (turn > 0) {
                hint2(); // 8, 10번째 턴에 대한 추가 힌트
            }
        }
    }

    // 각 플레이어 차례
    public static boolean playerTurn(Scanner sc, String player) {
        System.out.println(player + "님이 입력할 번호 : ");
        int num = sc.nextInt();
        addAttempt(num);

        if (num == answer) {
            System.out.println("정답입니다!! " + player + "님 승리!!");
            return true;
        } else {
            System.out.println("정답이 " + (num < answer ? "더 큽니다." : "더 작습니다."));
        }
        return false;
    }

    // 최근 시도들을 저장하는 함수
    public static void addAttempt(int num) {
        recentAttempt5 = recentAttempt4;
        recentAttempt4 = recentAttempt3;
        recentAttempt3 = recentAttempt2;
        recentAttempt2 = recentAttempt1;
        recentAttempt1 = num;
    }

    // 규칙 1 적용: 5의 배수 또는 7의 배수일 때 정답 수정
    public static void rule1() {
        if (turn % 5 == 0) {
            System.out.println("5의 배수 턴이므로 정답에 +1200이 추가됩니다.");
            answer += 1200;
            specialRuleFailed = true; // 규칙 1로 인해 정답을 못 맞춘 경우
        }
        if (turn % 7 == 0) {
            System.out.println("7의 배수 턴이므로 정답에 -560이 추가됩니다.");
            answer -= 560;
            specialRuleFailed = true; // 규칙 1로 인해 정답을 못 맞춘 경우
        }
    }

    // 힌트 제공 함수 (규칙 2 적용)
    public static void check() {
        if (!hintUsed) {
            hint1(); // 힌트 1 제공: 정답의 약수 제공
            penaltie2(); // 힌트를 받고 맞추지 못하면 패널티 적용
        } else {
            System.out.println("힌트를 이미 사용했습니다.");
        }
    }

    public static void hint1() {
        System.out.println("힌트 1: 정답의 약수를 제공합니다.");
        int divisorCount = 0;
        int divisor = 20; // 20 이상의 약수를 찾기 시작

        while (divisor <= answer && divisorCount < 5) { // 최대 5개의 약수만 출력
            if (answer % divisor == 0) {
                System.out.println("정답이 " + divisor + "의 배수입니다.");
                divisorCount++;
            }
            divisor++;
        }

        if (divisorCount == 0) {
            System.out.println("20 이상의 배수가 없습니다.");
        }


        penaltie(divisorCount);
        hintUsed = true; // 힌트 사용 처리
    }


    // 페널티 적용 함수
    public static void penaltie(int divisorCount) {
        if (divisorCount == 1) {
            answer += 100;
        } else if (divisorCount == 3) {
            answer += 360;
        } else if (divisorCount == 5) {
            answer += 1700;
        }
    }

    public static void penaltie2() {
        if (turn % 5 == 0 && recentAttempt1 == answer) {
            penaltyTurns += 3; // 정답을 못 맞춘 경우 패널티 추가
            System.out.println("패널티가 적용되었습니다: 3턴 동안 힌트를 받을 수 없습니다.");
        }
    }

    // 8의 배수와 10의 배수 턴
    public static void hint2() {
        if (turn % 8 == 0) {
            System.out.println("힌트: 정답의 각 자리수 합은 " + sumDigits(answer) + "입니다.");
        }
        if (turn % 10 == 0) {
            System.out.println("힌트: 정답은 " + String.valueOf(answer).length() + "자리 숫자입니다.");
        }
    }

    // 자리수 합 계산
    public static int sumDigits(int number) {
        int sum = 0;
        while (number != 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }
}
