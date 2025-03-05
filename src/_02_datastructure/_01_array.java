package _02_datastructure;

public class _01_array {
    public static void main(String[] args) {

        int[] arr = {5000,
                10000,
                20000,
                30000,
                40000,
                50000,
                60000,
                70000,
                80000,
                90000};

        System.out.println("1");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        System.out.println("2");
        for (int k : arr){
            System.out.println(k);
        }
    }
}
