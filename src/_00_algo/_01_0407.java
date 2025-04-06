package _00_algo;

public class _01_0407 {
    public static void main(String[] args) {
        System.out.println(Solution3.solution("abc", "aabcc"));
        System.out.println(Solution3.solution("abc", "defgh"));
    }
}

class Solution3 {
    public static int solution(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();

        // str2에서 str1과 길이가 같은 모든 부분 문자열을 순회하면서 비교
        for (int i = 0; i <= len2 - len1; i++) {
            String sub = str2.substring(i, i + len1);
            if (sub.equals(str1)) {
                return 1;
            }
        }
        return 0;
    }
}
