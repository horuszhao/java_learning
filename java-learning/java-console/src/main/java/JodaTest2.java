import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * @author:zhaoyunxiang
 * @date:2019/11/29 5:52 下午
 */
public class JodaTest2 {
    public static void main(String[] args) {
        DateTime dt = new DateTime(2019,3,30,0,0);
        DateTime dateTime = dt.plusDays(-7);
        System.out.println(dt.toDate());
        System.out.println(dateTime.toDate());

        DateTime dt2 = DateTime.now().withTimeAtStartOfDay().withDayOfYear(1);
        System.out.println(dt2.toDate());

        DateTime dt3 = new DateTime(2019,1,1,0,0);
        System.out.println(dt3.toDate());

        DateTime dt4 = new DateTime(2019,2,28,0,0);
        System.out.println(dt4.plusMonths(1).toString("yyyy-MM-dd"));

        DateTime now = DateTime.parse("2020-04-02 09:23:43", DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println(now.toDate());
    }
}
