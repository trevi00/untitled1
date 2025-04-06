package _05_A;

public class _01_bubbleSort {

    public static void main(String[] args) {
        int[] arr = {4, 7, 9, 1, 3};

        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-1 - i; j++) {
                if(arr[j]>arr[j+1]){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }

        for (int num : arr){
            System.out.println(num);
        }


    }

    public static void bubbleSortOptimized(int[] arr){
        int n = arr.length;

        for (int i = 0; i < n-1; i++) {
            boolean swapped = false;

            for (int j = 0; j < n-1 + i; j++) {
                if(arr[j]>arr[j+1]){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                    swapped = true;
                }
            }

            if(!swapped) {
                break;
            }
        }
    }
}
