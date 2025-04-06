package _05_A;

import java.util.Scanner;

public class _250320_bubbleSort4 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // N M
        int N = sc.nextInt();

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }


        bubbleSort(arr);

        zigzag(arr);

        printResult(arr);
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

    //[1, 2, 3, 4, 5]
    // 0  1  2  3  4
    //[1, 3, 2, 5, 4]
    //1 < 3 > 2 < 5 > 4
    public static void zigzag(int[] arr){

        for (int i = 2; i < arr.length; i+=2) {
            int tmp = arr[i];
            arr[i] = arr[i-1];
            arr[i-1] = tmp;
        }

    }


    public static void printResult(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}