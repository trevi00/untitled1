package _01_base;

import java.util.Scanner;

public class _03_while {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = 1, b = 1, c, d;
        while(true){
            System.out.println("1. +1, 2. X");
            a = sc.nextInt();

            if( a == 1){
                b++;
                System.out.println("b : " + b);
            }
            if( a == 2){
                System.out.println("X");
                break;
            }
            System.out.println("b : " + b);
        }
    }
}
