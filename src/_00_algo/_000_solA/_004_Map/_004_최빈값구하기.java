package _00_algo._000_solA._004_Map;

import java.util.HashMap;
import java.util.Map;

public class _004_최빈값구하기 {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 3, 3, 4};

        Map<Integer, Integer> freeMap = new HashMap<>();
        for(int num : array){
            freeMap.put(num, freeMap.getOrDefault(num, 0)+1);
        }

        int maxCnt = 0;
        boolean isDuplicate = false;
        int mode = -1;

        for(Map.Entry<Integer, Integer> entry : freeMap.entrySet()){
            if(maxCnt < entry.getValue()){
                mode = entry.getKey();
            }
            else if(maxCnt == entry.getValue()){
                isDuplicate = true;
            };
        }

        int result = isDuplicate ? -1 : mode;

        System.out.println(result);
    }
}
