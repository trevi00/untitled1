package _01_base;

/*
문제: 배열에서 두 번째로 작은 값 구하기
정수형 배열이 주어졌을 때, 두 번째로 작은 값을 구하는 프로그램을 작성하세요. 배열에는
중복된 값이 존재할 수 있어요.
입력 형식
첫째 줄에는 배열의 크기 n이 주어집니다.
둘째 줄에는 n개의 정수가 공백으로 구분되어 주어집니다.
출력 형식
두 번째로 작은 값을 출력합니다.
예시
입력
6
3 2 1 5 6 4
출력
2
*/

import java.util.Scanner;

public class _09_minmax {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();

        int[] arr = new int[n];
        int min = 100;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            min = Math.min(arr[i], min);
        }

        int min2 = 100;
        for (int i = 0; i < n; i++) {
            if(arr[i] > min){
                min2 = Math.min(arr[i], min2);
            }
        }

        System.out.println(min2);
    }

}
