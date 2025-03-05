package _01_base;/*

        int a; // >= 5000 && <= 10000
        int b; // >= 4000
        int c;
        // b > a
        // c = a + b
        // b < a
        // c = a + b -300

        int d; // a + b + c
        int e; // e < 3*d
        int f; // a + b + c + d + e + 5000
        int g; // g = f*2

        Scanner sc = new Scanner(System.in);

        System.out.println("a(>= 5000 && <= 10000) : ");
        a = sc.nextInt();
        System.out.println("b(>= 4000) : ");
        b = sc.nextInt();
        System.out.println("c(b>a이면 c = a+b/ b<a이면 c=a+b-300) : ");
        c = sc.nextInt();

        int sum1 = a+b+c;

        System.out.println("d(a+b+C=d) : ");
        d = sc.nextInt();
        System.out.println("e(<(a+b+c)*3) : ");
        e = sc.nextInt();
        System.out.println("f(f = 5000 + a+b+c+d+e) :");
        f = sc.nextInt();
        System.out.println("g(f*2 = g) :");
        g = sc.nextInt();

        boolean ab = true;
        boolean bb = true;
        boolean cb = false;
        boolean db = false;
        boolean eb = true;
        boolean fb = true;
        boolean gb = true;


        if(!(a >= 5000 && a <= 10000)){
            ab = false;
        }

        if(b < 4000){
            bb = false;
        }

        if(a < b){
            if(c == a+b){
                cb = true;
            }
        }
        else{
            if(c == a+b-300){
                cb = true;
            }
        }

        if(d == sum1){
            db = true;
        }

        if(e >= (d*3)){
            eb = false;
        }

        if(f != 5000 + a+b+c+d+e){
            fb = false;
        }

        if(g != f*2){
            gb = false;
        }

        if(!ab && !bb && !cb && !db && !eb && !fb && !gb){
            System.out.println("모두 잘못되었습니다.");
        } else if (ab && bb && cb && db && eb && fb && gb) {

        } else{
            if(!ab){
                System.out.print("a가 ");
            }
            if(!bb){
                System.out.print("b가 ");
            }
            if(!cb){
                System.out.print("c가 ");
            }
            if(!db){
                System.out.print("d가 ");
            }
            if(!eb){
                System.out.print("e가 ");
            }
            if(!fb){
                System.out.print("f가 ");
            }
            if(!gb){
                System.out.print("e가 ");
            }
            System.out.println("잘못되었습니다.");
        }

//5000 6000 11000 22000 33000 82000 164000



 */
import java.util.Scanner;

public class _02_if_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("감자의 첫번째 가격은?");
        int acost1 = sc.nextInt();
        System.out.println("감자의 두번째 가격은?");
        int acost2 = sc.nextInt();
        System.out.println("감자의 세번째 가격은?");
        int acost3 = sc.nextInt();
        System.out.println("옥수수의 첫번째 가격은?");
        int bcost1 = sc.nextInt();
        System.out.println("옥수수의 두번째 가격은?");
        int bcost2 = sc.nextInt();
        System.out.println("옥수수의 세번째 가격은?");
        int bcost3 = sc.nextInt();
        System.out.println("수박의 첫번째 가격은?");
        int ccost1 = sc.nextInt();
        System.out.println("수박의 두번째 가격은?");
        int ccost2 = sc.nextInt();
        System.out.println("수박의 세번째 가격은?");
        int ccost3 = sc.nextInt();

        System.out.println("다음 세가지 중 고르시오");
        System.out.println("1. 감자 2. 옥수수 3. 수박");
        int ch = sc.nextInt();

        String myCh = "";

        int cost1 = 0;
        int cost2 = 0;
        int cost3 = 0;

        if(ch == 1){
            myCh = "감자";
            cost1 = acost1;
            cost2 = acost2;
            cost3 = acost3;
        } else if (ch == 2) {
            myCh = "옥수수";
            cost1 = bcost1;
            cost2 = bcost2;
            cost3 = bcost3;
        } else if (ch == 3) {
            myCh = "수박";
            cost1 = ccost1;
            cost2 = ccost2;
            cost3 = ccost3;
        }


        System.out.println(myCh + " 1. " + cost1 + " 2. " + cost2 + " 3. " + cost3 + " 고를 가격의 번호를 누르시오.");
        int myCost = sc.nextInt();

        System.out.println("몇개를 사시겠습니까");
        int x = sc.nextInt();

        if (myCost == 1){
            System.out.println(myCh + " " + cost1*x + "어치를 선택하셨습니다.");
        } else if (myCost == 2) {
            System.out.println(myCh + " " + cost2*x + "어치를 선택하셨습니다.");
        } else if (myCost == 3) {
            System.out.println(myCh + " " + cost3*x + "어치를 선택하셨습니다.");
        }

    }
}





























