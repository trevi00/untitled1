package _00_algo._000_solA._001_배열._09_투포인터;

import java.util.Scanner;

public class _09_투포인터_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int s = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int left = 0;
        int right = 0;

        int sum = 0;
        int len = n;

        while(true){
            if(right == n) break;
            else if (sum >= s){
                len = Math.min(len, right-left);
                sum -= arr[left++];
            } else {
                sum += arr[right++];
            }

        }

        System.out.println(len == n + 1 ? 0 : len);
    }
}
