package _00_algo;

public class _01_0406 {
    public static void main(String[] args) {
        int[][] arr1 = {{1,2}, {2,3}};
        int[][] arr2 = {{3,4}, {5,6}};

        Solution solution = new Solution();
        int[][] answer = solution.solution(arr1, arr2);

        for (int i = 0; i < answer.length; i++) {
            for (int num : answer[i]) {
                System.out.println(num);
            }
        }
    }
}


class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = {};
        int length = arr1.length;
        int length2 = arr1[0].length;
        answer = new int[length][length2];

        for(int i = 0; i < length; i++){
            for(int j = 0; j < length2; j++){
                answer[i][j] = arr1[i][j] + arr2[i][j];
            }
        }

        return answer;
    }
}