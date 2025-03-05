package _04_oop._01_animal;

public class Animal {
    private String name;
    private int year;
    private String species;
    private int height;
    private int weight;
    private int hp = 10;

    public Animal(String name, int age, String species, int height, int weight){
        this.name = name;
        this.year = age;
        this.species = species;
        this.height = height;
        this.weight = weight;
    }

    protected String getName(){
        return this.name;
    }

    protected String getSpecies(){
        return this.species;
    }

    protected int getHeight(){
        return this.height;
    }

    protected int getWeight(){
        return this.weight;
    }

    protected int getYear(){
        return this.year;
    }

    protected int getHp(){
        return this.hp;
    }

    protected void setHp(int hp){
        this.hp = hp;
    }
}
