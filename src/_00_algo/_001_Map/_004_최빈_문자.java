package _00_algo._001_Map;

import java.util.HashMap;
import java.util.Map;

public class _004_최빈_문자 {
    public static void main(String[] args) {
        String s = "aaabbc";


        Map<Character, Integer> map = new HashMap<>();


        for(char ch : s.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }

        int maxFreq = 0;
        char maxChar = ' ';

        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            if(maxFreq < entry.getValue()){
                maxFreq = entry.getValue();
                maxChar = entry.getKey();
            }
        }

        System.out.println(maxChar);
    }
}
