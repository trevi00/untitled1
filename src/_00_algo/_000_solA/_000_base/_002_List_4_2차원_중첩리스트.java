package _00_algo._000_solA._000_base;

import java.util.ArrayList;
import java.util.List;

public class _002_List_4_2차원_중첩리스트 {
    public static void main(String[] args) {
        List<List<Integer>> matrix = new ArrayList<>();

        int n = 10;

        for (int i = 0; i < n; i++) {
            matrix.add(new ArrayList<>());
        }
        matrix.get(0).add(10);  // 0행에 값 10 추가
        matrix.get(2).add(1);

        int x = matrix.get(2).get(0);  // 2행 1열 값
        System.out.println(x);



        /*
        코테에서 자주 쓰이는 List 사용 패턴
        패턴	설명
        동적 배열로 수집	정답 후보, 조건 만족 요소 수집
        정렬 후 처리	그리디, 투 포인터 사전 작업
        중복 제거 (Set과 병행)	고유 값 추출
        contains() 탐색	빠른 포함 확인 (작은 리스트일 때)
        removeIf()	조건에 따라 필터링
        정렬 후 binarySearch()	이분 탐색 (주의: Collections 사용)
        */
    }
}
