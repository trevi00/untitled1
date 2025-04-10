package _00_algo._000_solA._001_배열._08_소수;

public class _08_에라토스테네스의체_3 {
    // 골드바흐
    // "2보다 큰 모든 짝수는 두 개의 소수의 합으로 나타낼 수 있다."

    public static void main(String[] args) {
        goldBach(90);
    }

    static void goldBach(int n){
        boolean[] isPrime = getIsPrime(n);

        for(int i = 2; i <= n/2; i++){
            if(isPrime[i] && isPrime[n-i]) {
                System.out.println(i + " + " + (n - i) + " = " + n);
                return;
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
