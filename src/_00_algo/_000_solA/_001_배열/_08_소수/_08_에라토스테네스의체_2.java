package _00_algo._000_solA._001_배열._08_소수;

import java.util.ArrayList;
import java.util.List;

public class _08_에라토스테네스의체_2 {
    public static void main(String[] args) {
        // 1000이하의 소수를 열거

        List<Integer> list = getPrimeNums(1000);

        for(int num : list){
            System.out.println(num);
        }

    }

    static List<Integer> getPrimeNums(int n){
        boolean[] isPrime = new boolean[n+1];

        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }

        int sqrt = (int) Math.sqrt(n);

        for(int i = 2; i < sqrt; i++){
            if(!isPrime[i]) continue;
            for(int j = i*i; j < n; j+=i){
                isPrime[j] = false;
            }
        }

        List<Integer> list = new ArrayList<>();

        for(int i = 2; i <= n; i++){
            if(isPrime[i]) list.add(i);
        }

        return list;
    }
}
