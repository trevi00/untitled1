package _05_A;

import java.util.Scanner;

public class _250320_bubbleSort3 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // N M
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int[] arr2 = new int[M];
        for (int i = 0; i < M; i++) {
            arr2[i] = sc.nextInt();
        }

        bubbleSort(arr);
        bubbleSort(arr2);

        int[] ans = mergeSort(arr, arr2);

        printResult(ans);
    }

    public static void bubbleSort(int[] arr) {

        if(arr.length == 0){
//            System.out.println("배열의 길이가 0이므로 bubbleSort메서드를 수행할 필요가 없습니다.");
            return;
        }

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

    // [1,2,3,8,9], [4,6,7]
    public static int[] mergeSort(int[] arr, int[] arr2){

        int len = arr.length + arr2.length; // N+M
        int[] merge = new int[len];

        if(len == 0){
//            System.out.println("배열 길이의 합이 0이므로 mergeSort메서드가 수행하지 않습니다.");
            return merge;
        }

        int left = 0;
        int right = 0;

        int idx = 0;

        while(left < arr.length && right < arr2.length){
            if(arr[left] <= arr2[right]){
                merge[idx] = arr[left];
                left++;
                idx++;
            } else {
                merge[idx] = arr2[right];
                right++;
                idx++;
            }
        }

        while(left < arr.length){
            merge[idx] = arr[left];
            left++;
            idx++;
        }
        while(right < arr2.length){
            merge[idx] = arr2[right];
            right++;
            idx++;
        }


        return merge;
    }

    public static void printResult(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}