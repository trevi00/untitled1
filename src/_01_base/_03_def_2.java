package _01_base;

import java.util.Scanner;

/**

 public static void main(String[] args) {
 ans();
 }

 public static void ans(){
 Scanner sc = new Scanner(System.in);
 System.out.println("점수를 입력하시오");
 int score = sc.nextInt();
 System.out.println("학점을 입력하세요");
 String grade = sc.next();

 String realG = grade(score);
 boolean sp = mes(grade, realG);
 if(sp){
 System.out.println("올바른 학점입니다.");
 } else {
 System.out.println("올바르지 않은 학점입니다.");
 }
 }

 public static String grade(int score){
 if(score >= 100){
 return "A";
 } else if (score >= 90) {
 return "B";
 } else if (score >= 80) {
 return "C";
 } else if (score >= 70) {
 return "D";
 } else if (score >= 60) {
 return "E";
 } else if (score >= 50) {
 return "F";
 }
 return "";
 }

 public static boolean mes(String inputGrade, String grade){
 if(Objects.equals(inputGrade, grade)){
 return true;
 }
 return false;
 }


 */

//누가 보더라도 이해하기 쉽게 코드를 작성하시오.
//누가 보더라도 프로그램을 사용할 수 있게 제대로 정의해주시오
//아래 문제의 경우 음식이 세 가지로 분류되어 있는데, 본인이 두 가지를 더 추가해서 만든다.
//참고로 이 문제는 풀 수 있는 방식이 워낙 많고, 도움이 될 수 있는 문제기 때문에, 본인이 풀었을 경우, 다른 방식으로 또 풀어보겠다. 이후 피드백을 드림.
public class _03_def_2 {
    public static void main(String[] args) {
        // 1. 용돈 지급 함수
        // 2. 기본금 10000원 부족할시 용돈 지급 함수 (boolean 용돈 추가 받음 << 필요)
        // 3. 떡볶이, 우동, 과자 + @ 차례대로 몇개를 주문하겠냐는 함수
        // 4. if 돈이 부족할때마다 용돈 지급 함수
        // 5. else 구매한 메뉴는 얼마였고, 현재 얼마가 남았다.
        // 6. 용돈 추가 받음 상태면 쫒겨남.
        ans();
    }

    public static void ans(){
        String menu1 = "떡볶이";
        String menu2 = "우동";
        String menu3 = "과자";
        String menu4 = "만두";
        String menu5 = "커피";

        int price1 = pricefix(menu1);
        int price2 = pricefix(menu2);
        int price3 = pricefix(menu3);
        int price4 = pricefix(menu4);
        int price5 = pricefix(menu5);

        int m = 10000;
        m = m+money();

        boolean alr = false;

        System.out.println("현재 용돈의 금액은 " + m + "입니다.");

        int idxP = 0;

        idxP = order(menu1, price1);
        if(m < idxP){
            if(!alr) {
                m += money(m, idxP);
                alr = true;
            } else {
                System.out.println("쫒겨납니다.");
                return;
            }
        }
        m -= idxP;
        System.out.println("지불 후 금액 : " + m);


        idxP = order(menu2, price2);
        if(m < idxP){
            if(!alr) {
                m += money(m, idxP);
                alr = true;
            } else {
                System.out.println("쫒겨납니다.");
                return;
            }
        }
        m -= idxP;
        System.out.println("지불 후 금액 : " + m);

        idxP = order(menu3, price3);
        if(m < idxP){
            if(!alr) {
                m += money(m, idxP);
                alr = true;
            } else {
                System.out.println("쫒겨납니다.");
                return;
            }
        }
        m -= idxP;
        System.out.println("지불 후 금액 : " + m);

        idxP = order(menu4, price4);
        if(m < idxP){
            if(!alr) {
                m += money(m, idxP);
                alr = true;
            } else {
                System.out.println("쫒겨납니다.");
                return;
            }
        }
        m -= idxP;
        System.out.println("지불 후 금액 : " + m);

        idxP = order(menu5, price5);
        if(m < idxP){
            if(!alr) {
                m += money(m, idxP);
                alr = true;
            } else {
                System.out.println("쫒겨납니다.");
                return;
            }
        }
        m -= idxP;
        System.out.println("지불 후 금액 : " + m);

    }

    public static int money(){
        Scanner sc = new Scanner(System.in);
        System.out.println("첫 용돈을 입력하시오. (기본금을 제외한 용돈입니다.)");
        return sc.nextInt();
    }

    public static int money(int m, int price){
        Scanner sc = new Scanner(System.in);
        System.out.println("추가 용돈을 입력하시오. 현재 " + (price - m) + "만큼 모자랍니다.");
        return sc.nextInt();
    }

    public static int order(String menu, int price){
        Scanner sc = new Scanner(System.in);
        System.out.println(menu + "를 몇개 주문하시겠습니까? 1인분 가격은 " + price + "입니다.");
        int index = sc.nextInt();
        return price*index;
    }

    public static int pricefix(String menu){
        Scanner sc = new Scanner(System.in);
        System.out.println(menu + "의 가격은?");
        return sc.nextInt();
    }
}

















