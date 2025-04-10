package _00_algo._000_solA._001_배열._08_소수;

import java.util.ArrayList;
import java.util.List;

public class _08_소수_에라토스테네스의체 {
    static List<Integer> getPrimeNums(int n){
        boolean[] isPrime = new boolean[n + 1];
        for(int i = 2; i <= n; i++){
            isPrime[i] = true;
        }

        int sqrt = (int) Math.sqrt(n);

        for(int i = 2; i <= sqrt; i++){
            if(!isPrime[i]) continue;
            for (int j = i*i; j < n; j += i) {
                isPrime[j] = false;
            }
        }

        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if(isPrime[i]) primes.add(i);
        }

        return primes;
    }
}
