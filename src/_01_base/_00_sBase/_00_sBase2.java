package _01_base._00_sBase;

import java.util.Scanner;

public class _00_sBase2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("score1 : ");
        int score1 = sc.nextInt();

        System.out.println(score1>=60?"합격":"불합격");

        System.out.println("*************************");

        System.out.println("score2 : ");
        int score2 = sc.nextInt();

        System.out.println(score2>90?'A':(score2>80?'B':'C'));

        System.out.println("*************************");

        double pi = 3.14;
        System.out.println("반지름 : ");
        int num = sc.nextInt();
        double result = num * num *pi;

        System.out.println(result);
    }
}
