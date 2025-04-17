package _01_base._00_sBase;

import java.util.Scanner;

public class _00_sBase5 {
    public static void main(String[] args) {
        int age;
        int charge = 0;

        Scanner sc = new Scanner(System.in);
        age = sc.nextInt();

        System.out.println(age<7?charge=1000:(age<13?charge=3500:(charge=5000)));
    }
}
