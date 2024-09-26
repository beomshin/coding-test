package effectivejava;

import java.sql.Timestamp;
import java.util.Date;

public class TimeStampEqualsTestMain {

    public static void main(String[] args) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Date date = new Date(timestamp.getTime());

        System.out.println(timestamp.equals(date));
        System.out.println(date.equals(timestamp));

        /**
         * TimeStamp는 Date를 상속받아 equals를 재정의 하였는데 같은 class 이외는 false
         * Date를 기준으로 timestamp를 비교할 경우는 getTime으로 동일성 처리
         *
         *
         * 하여 변경하여 equals를 비교하면 대칭성이 어긎남
         *
         */
    }
}
