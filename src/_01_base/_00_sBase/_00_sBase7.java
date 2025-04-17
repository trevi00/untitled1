package _01_base._00_sBase;

import java.util.Random;
import java.util.Scanner;

public class _00_sBase7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Random rand = new Random();

        //1~100
        //숫자 맞추기

        //if >
        //   <
        //   ==
        int ans = rand.nextInt(100)+1;

        int cnt = 0;
        while(true){
            System.out.println("input : ");
            int input = sc.nextInt();

            if(input > ans){
                System.out.println("down");
            } else if(input < ans) {
                System.out.println("up");
            } else{
                System.out.println(++cnt + "번 만에 정답");
                break;
            }
            cnt++;
        }
    }
}
