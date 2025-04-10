package _00_algo._000_solA._002_List;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class _01_선언_초기화 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        list.add(5);           // 끝에 추가
        list.add(1, 10);       // 인덱스 1에 삽입

        list.remove(2);        // 인덱스 2의 값 삭제
        list.remove(Integer.valueOf(10)); // 값 10을 삭제

        int val = list.get(0);     // 0번째 값
        list.set(1, 99);           // 1번째 값 수정

        list.size();               // 요소 개수
        list.isEmpty();            // 비었는지 확인

        Collections.sort(list);

        list.sort(Collections.reverseOrder());

        // 특정 리스트의 생소한 조건대로 정렬
        // list.sort((a, b) -> Integer.compare(a.length(), b.length()));

        list.contains(10);        // 값 포함 여부
        list.indexOf(5);          // 처음 등장 위치
        list.lastIndexOf(5);      // 마지막 등장 위치

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        for (int x : list) {
            System.out.println(x);
        }

        // 리스트 >> 배열
        List<Integer> list2 = new ArrayList<>(Arrays.asList(1, 2, 3));
        Integer[] arr = list2.toArray(new Integer[0]);


    }
}
