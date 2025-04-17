package _00_algo._000_solA._001_배열._02_base;

public class _05_slidingWindow {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};

        // 3. 슬라이딩 윈도우 (고정 크기 or 조건 기반)
        //일정 구간 유지하면서 이동할 때 O(n)으로 문제 해결 가능
        //자주 쓰이는 문제: 최대합, 조건 만족 구간 수

        int k = 3;
        int windowSum = 0;
        for (int i = 0; i < k; i++) windowSum += arr[i];

        int maxSum = windowSum;
        for (int i = k; i < arr.length; i++) {
            windowSum += arr[i] - arr[i - k];
            maxSum = Math.max(maxSum, windowSum);
        }

    }
}
