package _04_oop._02_ariplane;

public class Seat {
    public int getSerialNum() {
        return serialNum;
    }

    private int serialNum;
    private char seatId;
    private String seatClass;
    private boolean book;
    private Passenger bookBy;

    public Seat(int serialNum, char seatId, String seatClass){
        this.serialNum = serialNum;
        this.seatId = seatId;
        this.seatClass = seatClass;
        this.book = false;
        this.bookBy = null;
    }

    public boolean setBook(Passenger passenger){
        if(!book){
            this.book = true;
            this.bookBy = passenger;
            return true;
        }
        return false;
    }

    public void delBook(){
        this.book = false;
        this.bookBy = null;
    }

    public boolean getBook(){
        return this.book;
    }

    public char getSeatId(){
        return this.seatId;
    }

    public String getSeatClass() {
        return seatClass;
    }
}
