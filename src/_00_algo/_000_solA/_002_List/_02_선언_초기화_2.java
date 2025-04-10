package _00_algo._000_solA._002_List;

import java.util.ArrayList;
import java.util.List;

public class _02_선언_초기화_2 {
    public static void main(String[] args) {
        List<List<Integer>> graph = new ArrayList<>();

        int n = graph.size();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        graph.get(0).add(1);  // 0번 노드 → 1번 연결

    }

    /*  코테에서 자주 쓰이는 List 사용 패턴
        패턴	설명
        동적 배열로 수집	정답 후보, 조건 만족 요소 수집
        정렬 후 처리	그리디, 투 포인터 사전 작업
        중복 제거 (Set과 병행)	고유 값 추출
        contains() 탐색	빠른 포함 확인 (작은 리스트일 때)
        removeIf()	조건에 따라 필터링
        정렬 후 binarySearch()	이분 탐색 (주의: Collections 사용)
     */
}
