package _01_base;

import java.util.Scanner;

public class _05_test {
    // 구구단 2단 이상 모두 변수로
    // 볶음밥 자장면 탕수육 각각 가격 제시하고 끝까지 금액 +=
    // 4. 종료 > 합산 금액 산출
    // 모든 선택형에 없는 번호 누를 시 다시 되돌아가도록 조건문
    // 탕수육은 소 중 대 각기 다른 금액으로 표시
    //

    public static void main(String[] args) {
        ans();
    }

    public static void ans(){
        Scanner sc = new Scanner(System.in);
        int prv = -1;

        int menu1 = 0;
        int menu2 = 0;
        int menu3_1 = 0;
        int menu3_2 = 0;
        int menu3_3 = 0;
        int p3MS = 0;
        int p2Sum = 0;

        while(true){
            System.out.println("1. 구구단");
            System.out.println("2. 음식점");
            System.out.println("3. 계산기");
            System.out.println("4. 종료");
            int select = sc.nextInt();
            if(select == 1){
                p1();
            } else if (select == 2) {
                if(p3MS == 0){
                    System.out.println("가격 설정");
                    System.out.println("1. 볶음밥");
                    menu1 = sc.nextInt();
                    System.out.println("2. 자장면");
                    menu2 = sc.nextInt();
                    System.out.println("3-1. 탕수육 소");
                    menu3_1 = sc.nextInt();
                    System.out.println("3-2. 탕수육 중");
                    menu3_2 = sc.nextInt();
                    System.out.println("3-3. 탕수육 대");
                    menu3_3 = sc.nextInt();
                    p3MS++;
                }

                p2Sum += p2(sc, menu1, menu2, menu3_1, menu3_2, menu3_3);
                System.out.println("현재 누적금액은 : " + p2Sum);

            } else if (select == 3) {
                int tmp = p3(sc, prv);
                if(prv == -1){
                    prv=0;
                }
                prv = tmp;
            } else if (select == 4) {
                if(prv == -1){
                    prv = 0;
                }
                int ans = p2Sum + prv;
                System.out.println(ans);
                break;
            }
        }
    }

    public static void p1() {
        int idx = 1;
        while(idx <= 9){
            System.out.println("2 * " + idx + " = " + 2*idx);
            idx++;
        }
    }

    public static int p2(Scanner sc,
                         int menu1, int menu2, int menu3_1, int menu3_2, int menu3_3) {
        int idx = 0;

        while(true) {

            System.out.println("1. 볶음밥 : " + menu1);
            System.out.println("2. 자장면 : " + menu2);
            System.out.println("3. 탕수육[소'중'대 따로] : " + menu3_1 + " " + menu3_2 + " " + menu3_3);
            System.out.println("4. 종료");
            int selc = sc.nextInt();

            if(selc == 1){
                idx += menu1;
                System.out.print("볶음밥이 "+ idx + "원이 추가되어");
                break;
            } else if (selc == 2) {
                idx += menu2;
                System.out.print("자장면이 "+ idx + "원이 추가되어");
                break;
            } else if(selc == 4) {
                break;
            } else if(selc == 3){
                int innerIdx = 100;
                while(!(innerIdx < 5 && innerIdx > 0)){
                    System.out.println("1. 소 : " + menu3_1);
                    System.out.println("2. 중 : " + menu3_2);
                    System.out.println("3. 대 : " + menu3_3);
                    System.out.println("4. 이전 메뉴로");
                    innerIdx = sc.nextInt();
                    if(innerIdx == 1){
                        idx+=menu3_1;
                        System.out.print("탕수육(소)이 "+ idx + "원이 추가되어");
                    } else if (innerIdx == 2) {
                        idx+=menu3_2;
                        System.out.print("탕수육(중)이 "+ idx + "원이 추가되어");
                    } else if (innerIdx == 3) {
                        idx+=menu3_3;
                        System.out.print("탕수육(대)이 "+ idx + "원이 추가되어");
                    }
                }
                break;
            }
        }
        return idx;
    }

    public static int p3(Scanner sc, int prv){
        boolean sf = false;
        int selc = 0;
        while(!sf) {
            System.out.println("1. 덧셈");
            System.out.println("2. 뺄셈");
            selc = sc.nextInt();
            if(selc == 1 || selc == 2){
                sf = true;
            }
        }

        int num1 = 0;
        int num2 = 10000;

        if(prv == -1) {
            System.out.println("첫번째 숫자 : ");
            num1 = sc.nextInt();
        } else {
            num1 = prv;
        }

        while(true) {
            System.out.println("두번째 숫자 : ");
            num2 = sc.nextInt();
            if(num1 >= num2 || selc == 1){
                break;
            }
            System.out.println("두번째 숫자가 더 클 수 없습니다.");
        }

        int ans;

        if(selc == 1){
            ans = num1 + num2;
            System.out.println(num1 + " + " + num2 + " = " + ans);
        } else {
            ans = num1 - num2;
            System.out.println(num1 + " - " + num2 + " = " + ans);
        }
        return ans;
    }

}
