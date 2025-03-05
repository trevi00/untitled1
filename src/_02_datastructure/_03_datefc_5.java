package _02_datastructure;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class _03_datefc_5 {
    /*하루 동안의 분 단위를 나타내는 값들을 원소로 갖는 배열 arr이 있습니다.
    이 배열의 각 원소는 해당 원소의 값을 분 단위로 나타냅니다.
    현재 시간을 기준으로, arr 배열에 있는 각 원소의 분 단위 값과 비교하여 현재 시간 이후의 시간들만 출력하는 프로그램을 작성하세요.

    입력: 현재 시간을 입력받습니다. 형식은 ISO 8601을 따릅니다. (예: "2023-02-23T12:30:00+09:00")

    출력: arr 배열에서 현재 시간 이후의 시간들을 출력합니다. 출력 형식은 "hh:mm"입니다.

    제한사항:

    arr 배열은 하루 동안의 모든 분을 나타내는 1분부터 1440분까지의 값을 순차적으로 갖습니다.
    예시:

    입력: "2023-02-23T12:00:00+09:00"
    출력: 12:01, 12:02, 12:03, ..., 23:58, 23:59

    입력: "2023-02-23T16:59:00+09:00"
    출력: 17:00, 17:01, 17:02, ..., 23:58, 23:59

    입력: "2023-02-23T23:59:00+09:00"
    출력: (출력 없음)*/

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("현재 시간 : ");
        String input = sc.nextLine();

        ZonedDateTime zd = ZonedDateTime.parse(input);

        String[] arr = new String[2000];

        DateTimeFormatter fm = DateTimeFormatter.ofPattern("HH:mm");
        String fmd = fm.format(zd);

        System.out.println(fmd);

        int idx = 0;
        while(!fmd.equals("23:59")){

            fmd = fm.format(zd.plusMinutes(idx));
            arr[idx] = fmd;
            idx++;

        }
        arr[idx] = fm.format(zd.plusMinutes(idx));

        for (int i = 0; i < idx; i++) {
            System.out.println(arr[i]);
        }

    }
}
