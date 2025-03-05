package _02_datastructure;

import java.util.Scanner;

public class _01_array_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("몇개까지 있다고 할까요 : "); //11
        int len = sc.nextInt();

        int[] array = new int[len];

        System.out.print("입력 ");
        for (int i = len-1; i >=0 ; i--) {
            System.out.print(" ");
            int idx = sc.nextInt();

            array[i] = idx;
        }

        System.out.print("[거꾸로] ");
        for (int num : array){
            System.out.print(num + " ");
        }

        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += array[i];
        }
        System.out.println("총 합은 " + sum + "입니다.");

        int cnt = 0;
        int[] seven = new int[len];
        for (int i = 0; i < len; i++) {
            if(array[i] == 7){
                cnt++;
                seven[i] = 1;
            }
        }

        int sevenSum = 7*cnt;
        // 0 0 1 0 0 1 0 0 1 0 0
        //     1     3     2
        int left = 0;
        int right = len-1;
        while(left < right){
            if(seven[left] == 0) left++;
            else if (seven[right] == 0) right--;

            System.out.println(left);
            System.out.println(right);
            System.out.println();
            if(seven[right] == 1) left++;
            else if (seven[left] == 1) {
                right--;
            }
        }
        System.out.println("7이 들어있는 index 중에서 중간에 위치한 index는" + (left+1) + "번 입니다.");
        System.out.println("7이 나온 값만큼 더한 숫자는 " + sevenSum + "입니다");


    }
}
