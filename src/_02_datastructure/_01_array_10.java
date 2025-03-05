package _02_datastructure;

import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class _01_array_10 {

    static Scanner sc = new Scanner(System.in);
    static int[][] arr = new int[100][100];
    static int[][] idx = new int[100][100];
    static boolean[][] visited = new boolean[100][100];
    static int sum = 0;

    public static void main(String[] args) {
        ps();
    }

    public static void ps(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                idx[i][j] = 0;
                visited[i][j] = false;

                input(i, j);
            }
        }

        System.out.println("숫자가 저장되었습니다. 답변자는 지금부터 문제에 대한 답변을 해주세요.");

        int cnt = 0;
        int score = 0;

        while(true){
            output();
            System.out.println();

            System.out.println("답변을 맞추고 싶으시다면 열과 행을 입력해주세요.\n");

            System.out.println("(예시 : 1열 1행을 선택하고 싶을 경우 >>1 1) \n");

            System.out.println("입력할 열과 행 >>");
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();

            System.out.println(n1 + "행과 " + n2 + "열을 입력하셨습니다. 정답은 무엇입니까?" );
            int ans = sc.nextInt();

            if(arr[n1][n2] == ans){
                idx[n1][n2] = 1;
                sum += arr[n1][n2];
                score++;
            }
            else {
                if(!visited[n1][n2]) {
                    visited[n1][n2] = true;
                } else {
                    sum += arr[n1][n2];
                }
                System.out.println(cnt + "번째 기회입니다. 10회가 넘어갈 경우 답변자님 패배입니다.");
                cnt++;
            }

            if(score == 3){
                output();
                System.out.println("정답을 모두 맞추셨기때문에 우승하셨습니다.");
                ps2();
                break;
            }
            if(cnt >= 10){
                System.out.println("solution : ");
                answer();
            }

        }

    }

    public static void ps2(){

        int cnt = 0;

        while(true) {
            output();
            System.out.println("2차원 배열 중에 맞춘 것, 그리고 두 번 이상 틀린 것에 대한 숫자의 합이 얼마인지 맞추시오.");
            int ans = sc.nextInt();

            if(sum == ans){
                System.out.println("정답입니다.");
                break;
            }
            else {
                System.out.println(cnt + "번째 기회입니다. 10회가 넘어갈 경우 답변자님 패배입니다.");
                cnt++;
            }
        }
    }

    public static void input(int i, int j){
        System.out.print("[" + i + "][" + j + "]에 숫자를 입력해주세요 : ");
        arr[i][j] = sc.nextInt();
    }

    public static void answer(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print("      ");
                System.out.print("[" + i + "][" + j + "] : " + arr[i][j]);
                System.out.print("      ");
            }
            System.out.println();
        }
    }

    public static void output(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print("      ");
                System.out.print("[" + i + "][" + j + "] : ");
                if(idx[i][j] == 1){
                    System.out.print(arr[i][j]);
                } else {
                    System.out.print("?");
                }
                System.out.print("      ");
            }
            System.out.println();
        }
    }

}
