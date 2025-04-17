package _00_algo._000_solA._001_배열._01_reverse;

public class _01_revers {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};

        for(int i = 0; i < arr.length/2; i++){
            int tmp = arr[i];
            arr[i] = arr[arr.length-i-1];
            arr[arr.length-i-1] = tmp;
        }

        for (int num : arr){
            System.out.println(num);
        }
    }
}
