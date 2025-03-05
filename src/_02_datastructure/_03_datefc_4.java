package _02_datastructure;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class _03_datefc_4 {
    public static void main(String[] args) {
        /*// 현재 날짜와 시간
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
        */

        int y, m, d;
        Scanner sc = new Scanner(System.in);

        System.out.println("년도를 입력하세요 : ");
        y = sc.nextInt();

        System.out.println("해당 달을 입력하세요 : ");
        m = sc.nextInt();

        System.out.println("해당 일을 입력하세요 : ");
        d = sc.nextInt();

        ZonedDateTime now = ZonedDateTime.of(y, m, d, 9, 0,0,0, ZoneId.of("Asia/Seoul"));

        DateTimeFormatter fm = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String fmd = now.minusDays(1).format(fm);
        System.out.println(fmd);

        DateTimeFormatter fm2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String fmd2 = now.plusDays(1).format(fm);
        System.out.println(fmd2);

        DateTimeFormatter fm3 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String fmd3 = now.format(fm);
        System.out.println(fmd3);


    }
}
