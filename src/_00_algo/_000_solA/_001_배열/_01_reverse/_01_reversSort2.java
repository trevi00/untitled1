package _00_algo._000_solA._001_배열._01_reverse;

import java.util.Arrays;
import java.util.Collections;

public class _01_reversSort2 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        Integer[] arr2 = new Integer[arr.length];

        for(int i = 0; i < arr.length; i++){
            arr2[i] = arr[i];
        }

        Arrays.sort(arr2, Collections.reverseOrder());

        for (int num : arr2){
            System.out.println(num);
        }
    }
}
