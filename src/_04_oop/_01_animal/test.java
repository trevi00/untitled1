package _04_oop._01_animal;

public class test {
    public static void main(String[] args) {
        Person person = new Person("김이름", 1981, "인간",
                170, 60, "서울", "학생");

        introduceP ip = new introduceP(person, "프로그래밍", "행복");
        ip.introduceMyself();

        actP ap = new actP(person);
        ap.walk();
        ap.breathe();
        ap.work();
        ap.act();
        ap.rest();
    }
}
