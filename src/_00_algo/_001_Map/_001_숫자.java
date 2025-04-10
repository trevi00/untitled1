package _00_algo._001_Map;

import java.util.HashMap;
import java.util.Map;

public class _001_숫자 {
    public static void main(String[] args) {
        Map<Integer, Integer> freeMap = new HashMap<>();

        int[] arr = {1, 2, 2, 3, 3, 3};

        for(int num : arr){
            freeMap.put(num, freeMap.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : freeMap.entrySet()){
            System.out.println(entry.getKey() + ": " + entry.getValue() + "회");
        }
    }
}
