package _01_base;

public class _05_while {
    public static void main(String[] args) {
        ans();
    }

    public static void ans(){
        //int f = 0;
        // f += 10
        // f <= 1000

        // f == 1000
        // f -= 10

        int idx = 0;
        int f = 0;

        while(true){
            System.out.println(f);
            idx += fwhile(f);
            if(idx == 0){
                f+=10;
            } else {
                f-=10;
            }
            if(idx == 1 && f < 500){
                break;
            }
        }
    }

    public static int fwhile(int f){
        if(f == 1000){
            return 1;
        }
        return 0;
    }
}
