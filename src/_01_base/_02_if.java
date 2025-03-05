package _01_base;

import java.util.Scanner;

public class _02_if {
    public static void main(String[] args) {
        String name1;
        String name2;
        String name3;

        int km;

        int ans;

        Scanner sc = new Scanner(System.in);

        System.out.println("첫번째 사람의 이름은?");
        name1 = sc.next();
        System.out.println("두번째 사람의 이름은?");
        name2 = sc.next();
        System.out.println("세번째 사람의 이름은?");
        name3 = sc.next();

        System.out.println("집 마다의 km수는?");
        km = sc.nextInt();


        System.out.println("셋의 집은 각각 " + km + "마다 떨어져 있는 거리에 존재한다. 세명의 집을 차례대로 방문하려면 몇 km를 걸어가야 하는가?");
        ans = sc.nextInt();

        int a = km*3;

        if(ans == a){
            System.out.println("정답입니다.");
        }
        else{
            System.out.println("오답입니다.\n"
            + "답은 " + a + "입니다.");
        }
    }
}
