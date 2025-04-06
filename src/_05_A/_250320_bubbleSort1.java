package _05_A;

import java.util.Scanner;

public class _250320_bubbleSort1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int T = sc.nextInt();



        bubbleSort(arr);
        twoPointerSum(arr, T);
    }

    public static void bubbleSort(int[] arr) {

        boolean swapped;

        for (int i = 0; i < arr.length - 1; i++) {
            swapped = false;

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

    //[2, 3, 4, 7, 11, 15]
    public static void twoPointerSum(int[] arr, int T){
        int left = 0;
        int right = arr.length-1;
        boolean isAns = false;

        while (left<right){
            if(arr[left]+arr[right] == T){
                isAns = true;
                break;
            }

            if(arr[left]+arr[right] > T){
                right--;
            } else if (arr[left]+arr[right] < T) {
                left++;
            }
        }

        if(isAns){
            System.out.println(arr[left] + " " + arr[right]);
        } else {
            System.out.println("NO PAIR");
        }

    }

    public static void printResult(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}