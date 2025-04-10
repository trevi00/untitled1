package _00_algo._000_solA._001_배열._08_소수;

import java.util.ArrayList;
import java.util.List;

public class _08_에라토스테네스의체_5 {
    public static void main(String[] args) {
        goldBach(41);
    }

    static void goldBach(int n){
        boolean[] isPrime = getIsPrime(n);

        List<Integer> list = new ArrayList();

        for(int i = 2; i <= n; i++){
            if(isPrime[i]) list.add(i);
        }

        int left = 0;
        int right = 0;
        int cnt = 0;
        int sum = 0;
        while(true){
            if(sum >= n){
                sum -= list.get(left++);
            } else if(right == list.size()){
                break;
            } else {
                sum += list.get(right++);
            }


            if(sum == n){
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    static boolean[] getIsPrime(int n){
        boolean[] isPrime = new boolean[n+1];

        for (int i = 2; i <= n; i++){
            isPrime[i] = true;
        }

        int sqrt = (int) Math.sqrt(n);

        for (int i = 2; i <= sqrt; i++) {
            if(!isPrime[i]) continue;

            for (int j = i*i; j <= n; j+=i) {
                isPrime[j] = false;
            }

        }
        return isPrime;
    }
}
