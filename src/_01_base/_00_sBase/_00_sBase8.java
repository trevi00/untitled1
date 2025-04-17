package _01_base._00_sBase;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class _00_sBase8 {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        Scanner sc = new Scanner(System.in);

        for(int i = 0; i < 3; i++){
//            map.put(i+1, (int) (Math.random()*8)+1);
            map.put(i+1, i+1);
        }

        int cnt = 0;
        while(true){
            int[] arr = new int[3];

            for(int i = 0; i < 3; i++){
                arr[i] = sc.nextInt();
            }

            int idx = 0;
            if(map.get(1) == arr[0]) idx++;
            if(map.get(2) == arr[1]) idx++;
            if(map.get(3) == arr[2]) idx++;

            if(idx == 3) {
                System.out.println(cnt + "번 만에 정답");
                break;
            } else{
                System.out.println(idx + " strike " + (3-idx) + " ball");
            }
            cnt++;
        }

    }
}
