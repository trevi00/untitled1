package _01_base;

public class _05_for_2 {
    public static void main(String[] args) {
        int i = 1;
        int b = 1;
        int c = 1;

        System.out.println("\n\n지금부터 1부터 100까지의 숫자를 나열합니다.\n\n");

        // i가 100까지 증가
        // b는 50이 더 증가
        // c는 b의 두 배까지 증가
        // c증가가 끝나고 -500까지 떨어짐
        // i, b 동시에 -500까지 떨어짐
        // i, b, c가 일치시 i가 3000까지 증가
        // i가 증가하던 중 i == 1500 일때 b가 증가하기 시작
        // b 숫자가 i보다 1000이 더 크기 시작할때 c증가
        // b는 5000에서 멈춤
        // b가 5000까지 증가했을때 i와 c가 b까지만 증가하고 프로그램 종료

        for (; i <= 100; i++) {
            System.out.println("===================================");
            System.out.println("증가하는 i의 숫자 = " + i);
            System.out.println("증가하지 않는 b의 숫자 = " + b);
            System.out.println("증가하는 c의 숫자 = " + c);
            System.out.println("===================================");
            c++;
        }

        for (; b <= i+50 ; b++) {
            System.out.println("===================================");
            System.out.println("i = " + i);
            System.out.println("b = " + b + " (i보다 50 높게 증가)");
            System.out.println("c = " + c);
            System.out.println("===================================");
            c++;
        }

        for (c = 0; c > -500 ; c--) {
            System.out.println("i = " + i);
            System.out.println("b = " + b);
            System.out.println("c = " + c);
        }

        for (; b >= -500 ; b--) {
            System.out.println("i = " + i);
            System.out.println("b = " + b);
            System.out.println("c = " + c);
            if(i > -500){
                i--;
            }
        }

        for(; i < 3000; i++){
            System.out.println("i = " + i);
            System.out.println("b = " + b);
            System.out.println("c = " + c);
            if(i >= 1500){
                b++;
            }
        }

        for (; b < 5000; b++) {
            System.out.println("i = " + i);
            System.out.println("b = " + b);
            System.out.println("c = " + c);
            if(b >= i + 1000){
                c++;
            }
        }

        for (; c <= b; c++){
            System.out.println("i = " + i);
            System.out.println("b = " + b);
            System.out.println("c = " + c);

            if(i < b) i++;
        }


    }
}

