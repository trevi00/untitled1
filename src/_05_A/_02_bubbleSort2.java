package _05_A;

import java.util.Scanner;

public class _02_bubbleSort2 {
    public static void main(String[] args) {
        ps();
    }

    static Scanner sc = new Scanner(System.in);

    public static void ps(){
        int N = sc.nextInt();

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        bs(arr);

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static int[] bs(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            boolean swapped = false;

            for (int j = 0; j < arr.length-1 - i; j++) {
                if(arr[j] > arr[j+1]){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                    swapped = true;
                }
            }

            if(!swapped){
                break;
            }
        }

        return arr;
    }
}
