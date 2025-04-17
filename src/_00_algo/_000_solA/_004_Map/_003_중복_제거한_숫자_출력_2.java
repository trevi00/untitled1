package _00_algo._000_solA._004_Map;

import java.util.Set;
import java.util.TreeSet;

public class _003_중복_제거한_숫자_출력_2 {

    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 3, 2, 1, 4};
        Set<Integer> set = new TreeSet<>(); // 자동 오름차순 정렬
        for (int num : arr) {
            set.add(num);
        }

        for (int num : set){
            System.out.print(num + " ");
        }
    }
}
