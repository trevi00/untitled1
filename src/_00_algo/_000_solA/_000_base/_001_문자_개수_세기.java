package _00_algo._000_solA._000_base;

public class _001_문자_개수_세기 {
    public static void main(String[] args) {
        String str = "baekjoon";

        char[] chArr = str.toCharArray();

        int[] cnt = new int[26];

        for (int i = 0; i < chArr.length; i++) {
            cnt[chArr[i] - 'a']++;
        }

        for(int num : cnt){
            System.out.print(num + " ");
        }
    }
}
