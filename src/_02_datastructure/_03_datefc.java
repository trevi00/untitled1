package _02_datastructure;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

public class _03_datefc {
    static LocalDateTime spcDateTime = LocalDateTime.of(2025, 5, 22, 14, 30);

    static Date now = new Date();

    static Calendar calendar = Calendar.getInstance();
    static Date now2 = calendar.getTime();

    public static void main(String[] args) {
        System.out.println("특정날짜와 시간 : " + spcDateTime);
        System.out.println("현재 날짜와 시간 : " + now);

        System.out.println("현재 날짜와 시간 " + now2);

        calendar.add(Calendar.DAY_OF_MONTH, -1);
        Date yesterday = calendar.getTime();
        System.out.println("어제 날짜 : " + yesterday);

        calendar.add(Calendar.DAY_OF_MONTH, 2);
        Date tomorrow = calendar.getTime();
        System.out.println("내일 날짜 : " + yesterday);

        // 이번 주 첫째 날 (월요일) 구하기
        calendar = Calendar.getInstance(); // 현재 날짜로 초기화
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        Date firstDayOfWeek = calendar.getTime();
        System.out.println("이번 주 첫째 날 (월요일): " + firstDayOfWeek);

        // 이번 달 첫째 날 구하기
        calendar = Calendar.getInstance(); // 현재 날짜로 초기화
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        Date firstDayOfMonth = calendar.getTime();
        System.out.println("이번 달 첫째 날: " + firstDayOfMonth);
    }
}
