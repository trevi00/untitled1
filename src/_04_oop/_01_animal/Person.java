package _04_oop._01_animal;

import java.util.Objects;
import java.util.Scanner;

public class Person extends Animal implements affiliation{
    //성별, 소속, 직업, 고향, 주소, 학번, 사번
    private String homtown;
    private String occupation;
    private String school;
    private String job;

    public Person(String name, int year, String species, int height, int weight, String hometown, String occupation) {
        super(name, year, species, height, weight);
        this.homtown = hometown;
        this.occupation = occupation;
    }

    protected String getHomtown(){
        return this.homtown;
    }

    protected String getOccupation(){
        return this.occupation;
    }

    @Override
    public void setSchool() {
        Scanner sc= new Scanner(System.in);
        System.out.println("대학을 졸업하거나 다니고 있으시다면 1을 입력해 주십시오. 아니면 2를 입력해 주십시오.");
        int selc = sc.nextInt();

        if(selc == 1) {
            System.out.println("교명을 입력해주십시오 : ");
            this.school = sc.next();
        } else if (selc == 2) {
            this.school = "X";
        }
    }

    @Override
    public void setJob() {
        Scanner sc= new Scanner(System.in);
        System.out.println("회사를 다니고 있으시다면 1을 입력해 주십시오. 아니면 2를 입력해 주십시오.");
        int selc = sc.nextInt();

        if(selc == 1) {
            System.out.println("회사명을 입력해주십시오 : ");
            this.job = sc.next();
        } else if (selc == 2) {
            this.job = "X";
        }
    }

    @Override
    public void introduceAffiliation() {
        if(!Objects.equals(getSchool(), "X") || getSchool() != null)
        {
            System.out.println("대학교 : " + getSchool());
        }
        if(!Objects.equals(getJob(), "X") || getJob() != null) {
            System.out.println("직장 : " + getJob());
        }
    }

    protected String getSchool(){
        return this.school;
    }

    protected String getJob(){
        return this.job;
    }
}

class actP extends Person implements Act {

    public actP(Person person) {
        super(person.getName(), person.getYear(), person.getSpecies(), person.getWeight(), person.getHeight(), person.getHomtown(), person.getOccupation());
    }

    @Override
    public void act() { //사람의 고유 행동
        if(getHp() < 2){
            System.out.println("휴식을 취해야 합니다.");
        } else{
            System.out.println(getName() + "이 공부를 합니다.");
            setHp(getHp()-2);
        }
    }

    @Override
    public void breathe() {
        System.out.println(getName() + "이 숨을 쉽니다.");
    }

    @Override
    public void walk() {
        if(getHp() == 0){
            System.out.println("휴식을 취해야 합니다.");
        } else{
            System.out.println(getName() + "이 걷습니다.");
            setHp(getHp()-1);
        }
    }

    @Override
    public void work() {
        if(getHp() < 2){
            System.out.println("휴식을 취해야 합니다.");
        } else{
            System.out.println(getName() + "이 일을 합니다.");
            setHp(getHp()-2);
        }
    }

    @Override
    public void rest() {
        System.out.println(getName() + "이 쉽니다.");
        setHp(getHp()+3);
    }
}



class introduceP extends Person{
    private String hobby;
    private String feeling;

    private String want;

    public introduceP(Person person, String hobby, String feeling) {
        super(person.getName(), person.getYear(), person.getSpecies(), person.getWeight(), person.getHeight(), person.getHomtown(), person.getOccupation());
        this.hobby = hobby;
        this.feeling = feeling;

        setSchool();
        setJob();
        setWant();
    }

    public void introduceMyself(){
        System.out.println("이름 : " + getName());
        System.out.println("출생년도 : " + getYear());
        System.out.println("고향 : " + getHomtown());

        introduceAffiliation();

        System.out.println("취미 : " + getHobby());
        System.out.println("상태 : " + getFeeling());

        System.out.println("원하는 것은 " + getWant() + "입니다.");
    }

    private void setWant(){
        Scanner sc = new Scanner(System.in);
        System.out.println("자신이 현재 원하는 것은?");
        this.want = sc.nextLine();
    }

    private String getWant() {
        return this.want;
    }

    private String getHobby() {
        return this.hobby;
    }

    protected String getFeeling(){
        return this.feeling;
    }
}