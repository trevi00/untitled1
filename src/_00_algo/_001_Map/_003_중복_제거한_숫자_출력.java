package _00_algo._001_Map;

import java.util.*;

public class _003_중복_제거한_숫자_출력 {
    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 3, 2, 1, 4};

        Map<Integer, Integer> map = new HashMap<>();
        for(int num : arr){
            map.put(num, 0);
        }
        System.out.println(map);

        List<Integer> nums = new ArrayList<>(map.keySet());
        Collections.sort(nums); //리스트를 오름차순으로 정렬

        int[] arr2 = new int[nums.size()];

        for(int i = 0; i < nums.size(); i++){
            arr2[i] = nums.get(i);
        }

        for(int num : arr2){
            System.out.println(num);
        }

    }
}
