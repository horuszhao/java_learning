import org.joda.time.DateTime;

/**
 * @author:zhaoyunxiang
 * @date:2019/11/29 5:52 下午
 */
public class JodaTest {
    public static void main(String[] args) {
        DateTime dt = new DateTime(2019,3,30,0,0);
        DateTime dateTime = dt.plusDays(-7);
        System.out.println(dt.toDate());
        System.out.println(dateTime.toDate());
    }
}
