package _00_algo._000_solA._001_배열._08_소수;

import java.util.Scanner;

public class _08_에라토스테네스의체_4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        int[] arr = new int[T];

        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
            max = Math.max(max, arr[i]);
        }

        boolean[] isPrime = getIsPrime(max);


        for (int i = 0; i < T; i++) {
            for(int j = arr[i]/2; j >= 2; j--){
                if(isPrime[j]&&isPrime[arr[i]-j]){
                    System.out.println(j + " " + (arr[i]-j));
                    break;
                }
            }
        }

    }

    static boolean[] getIsPrime(int n){
        boolean[] isPrime = new boolean[n+1];

        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }

        int sqrt = (int) Math.sqrt(n);

        for (int i = 2; i <= sqrt; i++) {
            if(!isPrime[i]) continue;
            for(int j = i*i; j <= n; j+=i){
                isPrime[j] = false;
            }
        }

        return isPrime;
    }
}
