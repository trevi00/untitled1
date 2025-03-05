package _02_datastructure;

public class _01_array_2 {
    public static void main(String[] args) {
        int[] myarray = {1, 2, 3, 4, 5};
        int[] testarray = { 6, 7, 8, 9};
        int[] mybang = {10, 20, 30, 40, 50, 60, 70};

        for (int i = 0; i < 5; i++) {
            System.out.println(myarray[i]);
        }

        for (int i = 0; i < 4; i++) {
            System.out.println(testarray[i]);
        }

        for (int i = 0; i < 7; i++) {
            System.out.println(mybang[i]);
        }
    }
}
