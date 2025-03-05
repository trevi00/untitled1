package _04_oop;

public class Person implements Act{
    private final String name;
    private final int age;
    private final float weight;
    private final float height;

    public Person(String name, int age, float weight, float height){
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.height = height;
    }

    public void info(){
        System.out.println(this.name);
        System.out.println(this.age);
        System.out.println(this.weight);
        System.out.println(this.height);
    }

    @Override
    public void study() {
        System.out.println(name + "이 공부를 시작합니다.");
    }

    @Override
    public void introduceMyself() {
        System.out.println("저는 " + name + "입니다.");
    }

    @Override
    public void speak() {
        System.out.println(name + "이 말을 합니다.");
    }

    protected String getName() {
        return this.name;
    }


    protected int getAge() {
        return this.age;
    }

    protected float getWeight(){
        return this.weight;
    }

    protected float getHeight(){
        return this.height;
    }
}

class MovingPerson extends Person implements Movable {

    public MovingPerson(Person person){
        super(person.getName(), person.getAge(), person.getWeight(), person.getHeight() );
    }

    @Override
    public void move() {
        System.out.println(getName() + "이 움직였습니다.");
    }
}