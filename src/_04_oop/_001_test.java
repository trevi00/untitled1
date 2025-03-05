package _04_oop;

public class _001_test {
    public static void main(String[] args) {
        int x = 10;
        int y = 20;

        int result = add(x, y);
        System.out.println(result);

        Book book = new Book("책", 10000, "oop", 100);
        book.info();

        Person p = new Person("김이름", 10, 100, 30);
        p.info();

        MovingPerson mp = new MovingPerson(p);
        mp.move();
    }

    public static int add(int x, int y){
        return x+y;
    }
}
