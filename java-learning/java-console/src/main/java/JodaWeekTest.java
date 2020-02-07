import org.joda.time.DateTime;

/**
 * @author:zhaoyunxiang
 * @date:2020/1/13 4:22 下午
 */
public class JodaWeekTest {
    public static void main(String[] args) {

        DateTime dt = DateTime.now();
        dt = dt.plusDays(6);
        int i = dt.dayOfWeek().get();
        System.out.println(dt.toDate());
        System.out.println(i);
    }
}
