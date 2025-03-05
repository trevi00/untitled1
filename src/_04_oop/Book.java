package _04_oop;

public class Book {
    private String title;
    private int price;
    private String company;
    private int page;

    public Book(String title, int price, String company, int page){
        this.title = title;
        this.price = price;
        this.company = company;
        this.page = page;
    }

    public void info(){
        System.out.println(this.title);
        System.out.println(this.price);
        System.out.println(this.company);
        System.out.println(this.page);
    }
}
