package _02_datastructure;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class _03_datefc_3 {
    public static void main(String[] args) {
        // 현재 날짜와 시간
        LocalDateTime now = LocalDateTime.now();
        System.out.println("현재 날짜와 시간: " + now);
        // 어제 날짜 구하기
        LocalDate yesterday = LocalDate.now().minusDays(1);
        System.out.println("어제 날짜: " + yesterday);
        // 내일 날짜 구하기
        LocalDate tomorrow = LocalDate.now().plusDays(1);
        System.out.println("내일 날짜: " + tomorrow);
        // 이번 주 첫째 날 (월요일) 구하기
        LocalDate firstDayOfWeek = LocalDate.now().with(java.time.DayOfWeek.MONDAY);
        System.out.println("이번 주 첫째 날 (월요일): " + firstDayOfWeek);
        // 이번 달 첫째 날 구하기
        LocalDate firstDayOfMonth = LocalDate.now().withDayOfMonth(1);
        System.out.println("이번 달 첫째 날: " + firstDayOfMonth);
        // 날짜 포맷팅
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDate = now.format(formatter);
        System.out.println("포맷팅된 날짜와 시간: " + formattedDate);
        // 다른 형식으로 포맷팅
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy");
        String formattedDate2 = now.format(formatter2);
        System.out.println("다른 형식으로 포맷팅된 날짜: " + formattedDate2);
    }
}
