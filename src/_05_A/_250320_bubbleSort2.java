package _05_A;

import java.util.Scanner;

public class _250320_bubbleSort2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int X = sc.nextInt();


        bubbleSort(arr);
        int ans = binarySearchIdx(arr, X);

        System.out.println(ans);
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
    public static int binarySearchIdx(int[] arr, int X){

        int left = 0;
        int right = arr.length-1;
        while(left <= right){
            int mid = left + (right-left)/2;
            if(arr[mid] == X){
                return mid;
            }

            if(arr[mid] > X){
                right = mid-1;
            }
            else{
                left = mid+1;
            }
        }

        return -1;
    }

    public static void printResult(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}