package _00_algo._000_solA._001_배열._02_base;

import java.util.Arrays;

public class _02_copy {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};

        int[] copy = Arrays.copyOf(arr, arr.length);

        int[] partial = Arrays.copyOfRange(arr, 1, 3);

    }
}
