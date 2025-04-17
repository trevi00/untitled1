package _01_base._00_sBase;

import java.util.Scanner;

public class _00_sBase6 {
    /*사용자로부터 월을 입력받아, 해당 월의 계절을 출력하는 프로그램을 작성하세요.
     * 봄:3-5월, 여름:6-8월, 가을:9-11월, 겨울: 12-2월*/
    /*
     * 사용자로부터 요일을 입력받아(1~7) 해당 요일에 어떤 음식을 먹을지 출력하는 프로그램을 작성하세요.
     * (월요일:떡볶이,화요일:스파게티,------,일요일:초밥)-->여러분이 먹고싶은거 아무거나
     */
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {


    }

    static void sol1(){
        System.out.print("계절 계산기 : ");
        int m = scan.nextInt();

        if(m>=3 && m<= 5){
            System.out.println("봄");
        } else if(m > 6 && m < 9) System.out.println("여름");
        else if(m > 9 && m < 12) System.out.println("가을");
        else if(m == 12 || m > 0 && m < 3) System.out.println("겨울");
    }

    static void sol2(){
        System.out.println("요일 : ");
        int d = scan.nextInt();

        String[] str = {
                "", "짜", "라", "스파", "초밥", "ㅇㄹㅇㄹ"
        };

        System.out.println(str[d]);
    }
}
