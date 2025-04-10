package _00_algo._000_solA._000_base;

import java.util.ArrayList;
import java.util.List;

public class _002_List {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        list.add("apple");
        list.add("banana");

        System.out.println(list.get(0));
        System.out.println(list.size());

        /*
        기능	        ArrayList	    LinkedList
        접근 속도	빠름 (O(1))	    느림 (O(n))
        삽입/삭제	느림 (O(n))	    빠름 (O(1), 앞/뒤에서)
        메모리 사용	효율적	        포인터 필요 → 더 큼
        사용 예시	조회 많은 경우	삽입/삭제 많은 경우

        add(E e)	리스트 끝에 추가
        add(int index, E e)	특정 위치에 삽입
        get(int index)	특정 위치 값 읽기
        set(int index, E e)	특정 위치 값 수정

        remove(int index)	특정 위치 값 제거
        remove(Object o)	특정 값 제거 (처음 만나는 값 1개)

        contains(Object o)	특정 값 포함 여부

        size()	리스트 크기

        isEmpty()	리스트 비어 있는지

        clear()	전체 삭제

        indexOf(Object o)	첫 번째 위치 반환 (없으면 -1)
        lastIndexOf(Object o)	마지막 위치 반환

        toArray()	배열로 변환

        sort(Comparator)	정렬
        */
    }
}
