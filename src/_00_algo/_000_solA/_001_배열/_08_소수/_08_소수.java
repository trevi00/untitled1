package _00_algo._000_solA._001_배열._08_소수;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 연속된 소수의 합으로 n 만들기

public class _08_소수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<Integer> primes = PrimeUtils.getPrimesUpTo(n);

        int left = 0, right = 0, sum = 0, count = 0;

        while (right < primes.size()) {
            sum += primes.get(right);

            while (sum > n) {
                sum -= primes.get(left++);
            }

            if (sum == n) count++;

            right++;
        }

        System.out.println(count);
    }
}

class PrimeUtils {

    /**
     * 에라토스테네스의 체를 이용하여 n 이하의 모든 소수를 반환
     * @param n 소수를 구할 최대 숫자
     * @return 소수 리스트
     */
    public static List<Integer> getPrimesUpTo(int n) {
        boolean[] isPrime = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }

        int sqrt = (int) Math.sqrt(n);
        for (int i = 2; i <= sqrt; i++) {
            if (!isPrime[i]) continue;
            for (int j = i * i; j <= n; j += i) {
                isPrime[j] = false;
            }
        }

        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) primes.add(i);
        }

        return primes;
    }
}
