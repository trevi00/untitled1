package _01_base._00_sBase;

public class _00_sBase1 {
    public static void main(String[] args) {
        int books = 534;

        int divi = books/30;
        int lBooks = books%30;

        System.out.println("학생 한명이 받는 책 : " + divi);
        System.out.println("남은 책 : " + lBooks);

        System.out.println("*************************************");

        int a = 5; // 배 하루
        int b = 7; // 사과 하루
        int c = 5; // 오랜지

        int sum = a+b+c;

        float average = sum/3f;
        System.out.println(average + "개");

    }
}
