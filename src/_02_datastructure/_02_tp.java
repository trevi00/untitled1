package _02_datastructure;

import java.util.Scanner;

public class _02_tp {
    public static void main(String[] args) {
        int[] arr = new int[20];

        Scanner sc = new Scanner(System.in);

        System.out.println("숫자 몇개를 입력받으시겠습니까?");
        int len = sc.nextInt();

        for (int i = 0; i < len; i++) {
            System.out.println((i+1) + "번째 숫자 : ");
            arr[i] = sc.nextInt();
        }

        int ans = 0;

        int window = 1;
        int left = 0;
        int right = 0;

        // 0 1 2 3 0 1 2 3 4
        for (int i = 1; i < len; i++) {
            if(arr[i-1] <= arr[i]){
                window++;
            } else {
                window = 1;
            }

            if(ans < window){
                ans = window;
                right = i;
                left = i-ans+1;
            }
        }

        for (int i = left; i < right; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println(ans);
    }
}
