package _02_datastructure;

import java.util.Scanner;

public class _01_array_5 {

    public static void main(String[] args) {
        pb();
    }

    static int person = 0;
    static int[] p;
    static Scanner sc = new Scanner(System.in);
    static int np;

    public static void pb(){

        System.out.println("손님 수 : ");
        person = sc.nextInt();

        p = new int[person+1];
        np = person;

        val();

        while (true){
            System.out.println("1. 손님 고르기");
            System.out.println("2. 종료");
            int selc =  sc.nextInt();

            if(selc == 1){
                System.out.println("몇번째 손님 : ");
                int s = sc.nextInt();

                System.out.println(s + "번째 손님이 가진 금액 : " + p[s]);
                System.out.println("얼마를 빼시겠습니까?");
                int pri = sc.nextInt();

                p[s] -= pri;
                if(p[s] == 0){
                    sort(s);
                }

                for(int i = 1;  i <= np;  i++){
                    System.out.println(i + "번째 손님이 가진 금액 : " + p[i]);
                }

            } else if(selc == 3){
                int sum = 0;
                for(int i = 1; i <= np; i++){
                    sum+= p[i];
                }
                System.out.println("손님들의 총액 : " + sum);
                System.out.println("손님 수 : " + np);
                break;
            }
        }

    }

    public static void val(){

        for(int i = 1;  i <= person;  i++){
            System.out.println(i + "번째 손님 추가할 금액 : ");
            p[i] = sc.nextInt();
        }
        for(int i = 1;  i <= person;  i++){
            System.out.println(i + "번째 손님이 가진 금액 : " + p[i]);
        }

    }

    public static void sort(int s){

        if(s == np){
            np-=1;
            return;
        }

        for(int i = s; i < np; i++){
            p[i] = p[i+1];
        }

        np-=1;
    }

}
