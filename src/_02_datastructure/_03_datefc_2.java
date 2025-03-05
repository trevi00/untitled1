package _02_datastructure;

import java.text.SimpleDateFormat;
import java.util.Date;

public class _03_datefc_2 {
    public static void main(String[] args) {
        // 현재 날짜와 시간
        Date now = new Date();
        // 날짜 포맷팅
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDate = sdf.format(now);
        System.out.println("포맷팅된 날짜와 시간: " + formattedDate);
        // 다른 형식으로 포맷팅
        SimpleDateFormat sdf2 = new SimpleDateFormat("EEEE, MMMM, dd, yyyy");
        String formattedDate2 = sdf2.format(now);
        System.out.println("다른 형식으로 포맷팅된 날짜: " + formattedDate2);
    }
}
