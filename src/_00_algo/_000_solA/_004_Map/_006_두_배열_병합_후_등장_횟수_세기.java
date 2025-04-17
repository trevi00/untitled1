package _00_algo._000_solA._004_Map;

import java.util.HashMap;
import java.util.Map;

public class _006_두_배열_병합_후_등장_횟수_세기 {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 2, 3};
        int[] arr2 = {2, 3, 4};
        // 두 배열 합치고
        // 각 숫자가 몇번 등장했는지 출력

        Map<Integer, Integer> map = new HashMap<>();

        for(int num : arr1){
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        for(int num : arr2){
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

    }
}
