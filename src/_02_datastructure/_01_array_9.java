package _02_datastructure;

import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class _01_array_9 {

    //카드뭉치가 존재합니다. 그리고 각 카드에 대해 1에서 10000 사이의 숫자를 입력하라는 메시지가 표시됩니다.
    //입력할 카드의 수는 50에서 100 사이여야 합니다
    //모든 카드를 입력하면 카드의 2/3가 무작위로 제거되어 일정 수의 카드가 남습니다.
    //나머지 카드 중 하나를 선택할 수 있습니다.
    //그러나 선택한 카드의 숫자는 숨겨져 있으므로 알아내려면 다음 힌트를 사용해야 합니다

    //카드는 4~6으로 나눴을 때 0으로 떨어집니다
    //숫자는 100~8000 사이입니다
    //숫자는 ?의 배수입니다.(이 힌트는 기회가 3번 남았을 때 나타납니다) -> 이는 남는 방식이 아닌 힌트입니다.
    //숫자는 정확히 ?자리입니다. ( 이 힌트는 기회가 2번 남았을 때 나타납니다.)
    //숫자는 3의 배수이지만 ?가 들어가지 않습니다.(이 힌트는 기회가 1번 남았을 때 나타납니다

    static Scanner sc = new Scanner(System.in);

    static int[][] cards = new int[200][100];
    static int[] clear;
    static int len;

    public static void main(String[] args) {
        ps();
    }

    public static void ps(){
        System.out.println("카드의 개수는? (50~100)");
        len = sc.nextInt();

        clear = new int[len];
        cards = new int[len][100];

        for (int i = 0; i < len; i++) {
            System.out.println((i+1) + "번째 카드의 숫자는? (1~10000)");
             cards[i][0] = sc.nextInt();
        }

        p1();
        p2();

        int was = 0;
        for (int i = 0; i < len; i++) {
            int idx = 1;
            if(cards[i][1] == 0 || cards[i][2] == 0){
                idx = 0;
                was++;
            }
            // clear가 0이면 카드 버리는 것
            clear[i] = idx;
        }
        System.out.println("조건에 맞는 카드들을 추립니다.");

        int ans;
        int rand = len/2+len/10;
        while(true){
            if(clear[rand] == 1 && cards[rand][0] % 3 == 0){
                ans = rand;
                System.out.println("카드가 정해졌습니다.");
                break;
            }
            rand++;
            if(rand >= len) rand = 0;
        }

        if(was > (len/3)*2){
            int more = was - (len/3)*2;
            int inidx = len/2;
            while(more > 0){
                if(clear[inidx] == 0){
                    more--;
                    clear[inidx] = 1;
                    inidx++;
                }
            }
        } else if (was < (len/3)*2) {
            int more = (len/3)*2 - was;
            int inidx = len/2;
            while(more > 0){
                if(clear[inidx] == 1 && inidx != ans){
                    more--;
                    clear[inidx] = 0;
                }
                inidx++;
            }
        }

        int cnt = 8;

        int h3 = p3(cards[ans][0]); //3
        int h4 = p4(cards[ans][0]); //2

        for (int i = 0; i < len; i++) {
            if(clear[i] == 1){
                System.out.println((i+1) + "번째 카드의 숫자는 " + cards[i][0] +"입니다.");
            }
        }

        while(cnt > 0){
            System.out.println("고르고싶은 카드를 고르세요. 만약 없는 카드일 경우에는 다시 기회가 주어집니다.");
            int input = sc.nextInt();

            if(input != ans && clear[input] == 1){

                if(input > ans){
                    System.out.println("카드번호가 정답 카드보다 높습니다.");
                } else {
                    System.out.println("카드번호가 정답 카드보다 낮습니다.");
                }

                cnt--;

                if(cnt == 3){
                    System.out.println("숫자는 " + h3 + "의 배수입니다.");
                }
                if(cnt == 2){
                    System.out.println("숫자는 정확히 " + h4 + "자리입니다.");
                }
                int h5 = p5(ans, input);
                if(cnt == 1){
                    System.out.println("숫자는 3의 배수이지만 " + h5 + "를 포함하고 있지 않습니다.");
                }

            } else if (input-1 == ans && clear[input-1] == 1) {
                System.out.println("정답입니다.");
                break;
            } else {
                System.out.println("다른 카드를 고르세요.");
            }
        }


    }

    public static void p1(){
        for (int i = 0; i < len; i++) {
            int idx = 0;
            if(cards[i][0] % 4 == 0 || cards[i][0] % 5 == 0 || cards[i][0] % 6 == 0){
                idx = 1;
            }
            cards[i][1] = idx;
        }
    }

    public static void p2(){
        for (int i = 0; i < len; i++) {
            int idx = 0;
            if(cards[i][0] >= 100 && cards[i][0] < 8000){
                idx = 1;
            }
            cards[i][2] = idx;
        }
    }

    public static int p3(int ans) {

        int idx = 0;
        int var = ans;

        for (int j = 2; j < var / 2; j++) {
            if (var % j == 0) {
                idx = j;
            }
        }

        return idx;
    }


    public static int p4(int ans){

        int idx = 0;
        int var = ans;
        while(var > 0){
            var/=10;
            idx+=1;
        }

        return idx;
    }

    public static int p5(int ans, int input){
        int idx = 0;
        int n1 = cards[ans][0];
        int n2 = cards[input][0];

        boolean noMatch = false;
        while(!noMatch){
            if(n1%10 == n2%10){
                n1/=10;
                n2/=10;
            } else{
                noMatch = true;
                idx = n2%10;
            }
        }
        return idx;
    }

}
