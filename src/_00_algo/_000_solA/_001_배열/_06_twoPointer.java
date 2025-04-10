package _00_algo._000_solA._001_배열;

public class _06_twoPointer {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};

        //투 포인터
        //정렬된 배열에서 조건 만족하는 쌍 or 구간 찾을 때 사용

        //left, right 포인터를 움직이며 범위 조절

        int n = arr.length;
        int target = 11;
        int left = 0, right = 0, sum = 0, count = 0;
        while (right < n) {
            sum += arr[right++];

            while (sum > target) {
                sum -= arr[left++];
            }

            if (sum == target) count++;
        }

        System.out.println(count);

    }
}
