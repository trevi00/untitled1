package _00_algo._000_solA._001_배열._02_base;

import java.util.Arrays;

public class _07_sortAndSol {
    public static void main(String[] args) {
        int[] arr = {3, 2, 6, 7, 7, 2, 1};

        // 정렬 후 처리
        //정렬 후 양 끝에서 포인터 이동 (Two Sum 계열)

        //정렬 후 그룹핑, 중복 제거 등

        Arrays.sort(arr);
        int target = 7;
        int left = 0;
        int right = arr.length-1;
        int cnt = 0;

        while(left < right){
            int sum = arr[left] + arr[right];
            if(sum < target) left++;
            else if(sum > target) right--;
            else {
                cnt++;
                left++;
                right--;
            }
        }

        System.out.println(cnt);
    }
}
