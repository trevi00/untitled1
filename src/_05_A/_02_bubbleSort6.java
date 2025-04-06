package _05_A;

import java.util.Scanner;

public class _02_bubbleSort6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        bubbleSort(arr, K);

        printResult(arr);
        sc.close();
    }

    public static void bubbleSort(int[] arr, int K) {
        int passCount = 0;
        boolean swapped;

        for (int i = 0; i < arr.length - 1; i++) {
            swapped = false;
            if(passCount == K){
                break;
            }
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
    }

    public static void printResult(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}