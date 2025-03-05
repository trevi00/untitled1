package _02_datastructure;

import java.util.Scanner;

public class _01_array_6 {
    static Scanner sc = new Scanner(System.in);
    static int[] ar1;
    static int[] ar2;
    static int length;

    public static void main(String[] args) {
        System.out.println("배열 길이 : ");
        length = sc.nextInt();

        ar1 = new int[length];

        for(int i = 0; i < length; i++){
            System.out.println(i+1 + "번째 숫자 : ");
            ar1[i] = sc.nextInt();
        }

        prearr();
        preSum();
        System.out.println(sum);
        System.out.print("[");
        for(int i = left; i < right; i++){
            System.out.print(ar2[i]);
            if(i != right-1){
                System.out.print(", ");
            } else{
                System.out.print("]");
            }
        }

    }

    public static void prearr(){
        ar2 = new int[length*2];
        for(int i = 0; i < length; i++){
            ar2[i] = ar1[i];
            ar2[i+length] = ar1[i];
        }
    }

    static int left;
    static int right;
    static int sum;

    public static void preSum(){
        int inLen = 2;
        sum = 0;
        while (inLen < length){
            int temp = 0;
            for(int i = 0; i < length; i++){

                for(int j = i; j < i+inLen; j++){
                    temp += ar2[j];
                }

                if(sum < temp){
                    sum = temp;
                    left = i;
                    right = i+inLen;
                }

                temp = 0;
            }

            inLen += 1;
        }
    }

}
