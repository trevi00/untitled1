package _01_base._00_sBase;

import java.util.Scanner;

public class _00_sBase4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(n%2==0?"짝":"홀");

        int n1 = sc.nextInt();
        int n2 = sc.nextInt();

        System.out.println(n1>n2?n1:n2);
    }
}
