package _00_algo._000_solA._001_배열;

public class _04_prefixSum {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};

        int[] prefix = new int[arr.length+1];

        prefix[0] = 0;
        for (int i = 0; i < arr.length; i++) {
            prefix[i+1] = prefix[i] + arr[i];
        }

        // i~j의 구간 합 ex> i = 2, j = 5
        int sum = prefix[5] - prefix[2];
    }
}
