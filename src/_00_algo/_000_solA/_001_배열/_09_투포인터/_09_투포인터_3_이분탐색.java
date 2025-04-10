package _00_algo._000_solA._001_배열._09_투포인터;

import java.util.Arrays;
import java.util.Scanner;

public class _09_투포인터_3_이분탐색 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int x = sc.nextInt();

        Arrays.sort(arr);

        int left = 0;
        int right = n-1;
        int cnt = 0;
        while(left<right){
            int sum = arr[left] + arr[right];
            if(sum > x){
                right--;
            } else if(sum < x){
                left++;
            } else {
                cnt++;
                left++;
                right--;
            }
        }

        System.out.println(cnt);
    }
}
