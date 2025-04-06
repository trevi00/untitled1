package _05_A;

import java.util.Scanner;

public class _02_bubbleSort3  {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int passes = bubbleSort(arr);
        printResult(arr, passes);
        sc.close();
    }

    public static int bubbleSort(int[] arr) {
        int passCount = 0;
        boolean swapped;

        for (int i = 0; i < arr.length - 1; i++) {
            swapped = false;
            passCount++;

            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    swapped = true;
                }
            }

            if (!swapped) break;
        }

        return passCount;
    }

    public static void printResult(int[] arr, int passes) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
        System.out.println("Passes: " + passes);
    }
}
