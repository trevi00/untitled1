package _02_datastructure;

import java.util.Scanner;

public class _01_array_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("몇개까지 있다고 할까요 : ");
        int len = sc.nextInt();

        int[] arr = new int[len];
        arr[0] = 0;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                System.out.println( (j+1) + "번째 값 : " + arr[j]);
                System.out.println();
            }

            System.out.println("[다음 값 기준]");
            System.out.println("1.더하기");
            System.out.println("2.빼기");
            System.out.println("3.특정 값 불러오기");

            int selc = sc.nextInt();

            if(selc == 1){
                System.out.println("숫자 입력 : ");
                int idx = sc.nextInt();
                arr[i] = arr[i-1] + idx;
            } else if (selc == 2) {
                System.out.println("숫자 입력 : ");
                int idx = sc.nextInt();
                arr[i] = arr[i-1] - idx;
            } else if (selc == 3) {
                System.out.println("선택 : ");
                int idx = sc.nextInt();
                arr[i] = arr[idx-1];
            }

        }
    }
}
