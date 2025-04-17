package _00_algo._000_solA._001_배열._02_base;

public class _03_minMax {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};

        int min = arr[5];
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }
    }
}
