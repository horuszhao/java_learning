import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

/**
 * @author:zhaoyunxiang
 * @date:2019/12/2 11:24 上午
 */
public class DateTest {
    public static void main(String[] args) {
        DateTimeFormatter weekDateFormatter = DateTimeFormatter.ofPattern("EEEE", Locale.CHINA);
        Date date = new Date(2019,12,2);
        Instant instant = date.toInstant();
        LocalDateTime ldt = LocalDateTime.ofInstant(instant, ZoneId.of("Asia/Shanghai"));
        String format = weekDateFormatter.format(ldt);
        System.out.println(format);

        LocalDate ld = LocalDate.of(2019,2,28);
        System.out.println(ld);
        ld = ld.plusMonths(1);
        System.out.println(ld);
    }
}
