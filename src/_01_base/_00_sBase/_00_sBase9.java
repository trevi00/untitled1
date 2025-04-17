package _01_base._00_sBase;

import java.util.Scanner;

public class _00_sBase9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = 0;
        int[] score = new int[0];

        while(true){
            System.out.println("***");
            System.out.println("1. 학생수 | 2. 점수입력 | 3. 점수리스트 | 4.분석 | 5.종료");
            System.out.println("***");
            System.out.println("선택> ");
            int slec = sc.nextInt();

            if(slec == 1){
                N = sc.nextInt();
                score = new int[N];
            } else if (slec == 2) {
                for(int j = 0; j < N; j++){
                    if(score.length == 0){
                        System.out.println("학생수 설정");
                        continue;
                    }
                    System.out.println((j+1) + "번째 점수 입력");
                    score[j] = sc.nextInt();
                }
            } else if (slec == 3) {
                for(int n : score){
                    System.out.print(n + " ");
                }
                System.out.println();
            } else if (slec == 4) {
                int sum = 0;
                int max = Integer.MIN_VALUE;
                for(int n : score){
                    sum += n;
                    max = Math.max(max, n);
                }
                System.out.println("총점 : " + sum);
                System.out.println("평균 : " + ((double) sum)/N);
                System.out.println("최댓값 : " + max);
            } else if (slec == 5) {
                break;
            } else {
                System.out.println("잘봇 입력");
            }
        }
    }
}
