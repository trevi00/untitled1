package _00_algo._000_solA._000_base;

import java.util.ArrayList;
import java.util.List;

public class _002_List_2 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        /*리스트에 "사과", "바나나", "체리" 추가
        두 번째 과일 출력
        "바나나"를 "망고"로 교체
        "사과" 삭제
        최종 리스트를 전부 출력*/

        list.add("사과");
        list.add("바나나");
        list.add("체리");

        list.get(1);

        list.set(1, "망고");

        list.remove(0);

        /*for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }*/

        System.out.println("초기 리스트: " + list);

        for(String fruit : list){
            System.out.println(fruit);
        }


    }
}
