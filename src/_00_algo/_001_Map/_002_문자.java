package _00_algo._001_Map;

import java.util.HashMap;
import java.util.Map;

public class _002_문자 {
    public static void main(String[] args) {
        String s = "banna";

        Map<String, Integer> map = new HashMap<>();
        for(char ch : s.toCharArray()){
            map.put(String.valueOf(ch), map.getOrDefault(String.valueOf(ch), 0) + 1);
        }

        for(Map.Entry<String, Integer> entry : map.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
