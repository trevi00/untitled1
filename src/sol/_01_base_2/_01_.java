package sol._01_base_2;

import java.util.Scanner;

public class _01_ {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();

        int[] arr = new int[n];
        int min = 100;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            min = Math.min(arr[i], min);
        }

        int min2 = 100;
        for (int i = 0; i < n; i++) {
            if(arr[i] > min){
                min2 = Math.min(arr[i], min2);
            }
        }

        System.out.println(min2);
    }

}
