package _00_algo._000_solA._001_배열._09_투포인터;

import java.util.Scanner;

public class _09_투포인터 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int left = 1;
        int right = 1;
        int sum = 1;
        int cnt = 0;

        while(true){
            if(right == n) break;
            else if (sum < n) {
                sum += right++;
            }
            else {
                sum -= left++;
            }

            if(sum == n) cnt++;
        }

        System.out.println(cnt);
    }
}
