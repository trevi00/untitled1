package _00_algo._000_solA._000_base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class _002_List_3 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3));

        list.add(5);
        list.add(1,10);

        list.remove(2);
        list.remove(Integer.valueOf(10));

        int val = list.get(0);
        list.set(1, 99);

        System.out.println(list.size());
        System.out.println(list.isEmpty());

        // 오름차순 정렬
        Collections.sort(list);
        // 내림차순 정렬
        list.sort(Collections.reverseOrder());

        System.out.println(list.contains(10));
        System.out.println(list.indexOf(5));
        System.out.println(list.lastIndexOf(5));

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        for (int x : list) {
            System.out.println(x);
        }

        Integer[] arr = list.toArray(new Integer[0]);


    }
}
