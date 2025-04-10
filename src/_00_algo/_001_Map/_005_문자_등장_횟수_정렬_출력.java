package _00_algo._001_Map;

import java.util.*;

public class _005_문자_등장_횟수_정렬_출력 {
    public static void main(String[] args) {
        String s = "aaabbc";

        Map<Character, Integer> map = new HashMap<>();

        for(char ch : s.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }

        ArrayList<Map.Entry<Character, Integer>> entryList = new ArrayList<>(map.entrySet());

        Collections.sort(entryList,
                (e1, e2) ->
                        e2.getValue() - e1.getValue());

        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue() + "회");
        }
    }
}
