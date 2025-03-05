package _01_base;

public class _05_for_02 {
    public static void main(String[] args) {
        ans();
    }

    public static void ans(){
        for (int i = 2; i <= 40; i+=2) {
            int tmp = i;

            tmp = p(tmp);

            System.out.println("=======구구단 " + tmp + "단=======");
            p2(tmp, i);
        }
    }

    public static int p(int tmp){
        if(tmp == 18){
            tmp = 118;
        } else if (tmp == 20) {
            tmp = 220;
        }

        if (tmp % 10 == 0){
            return tmp+1;
        }

        return tmp;
    }

    public static void p2(int tmp, int i){
        if (i == 4 || i == 8 || i == 14) {
            System.out.println(".");
            System.out.println();
            System.out.println(".");
            System.out.println();
            System.out.println(".");
        } else if(i % 2 == 0) {
            for (int j = 1; j < 10; j++) {
                System.out.println(tmp + " * " + j + " = " + (tmp * j));
            }
        } else {
            System.out.println();
        }
    }
}
