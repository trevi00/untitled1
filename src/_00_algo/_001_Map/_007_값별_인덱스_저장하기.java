package _00_algo._001_Map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _007_값별_인덱스_저장하기 {
    public static void main(String[] args) {
        //정수 배열 arr이 주어졌을 때,
        //각 숫자가 어느 인덱스에 나왔는지 저장해서 출력하세요.
        //(한 숫자가 여러 번 나올 수도 있음)

        int[] arr = {3, 1, 2, 3, 2, 3};

        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int i = 0; i < arr.length; i++){
            int num = arr[i];

            if(!map.containsKey(num)){
                map.put(num, new ArrayList<>());;
            }

            map.get(num).add(i);
        }

        for(Map.Entry<Integer, List<Integer>> entry : map.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

    }
}
