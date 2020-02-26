import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Period;

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

        Integer days = Days.daysBetween(DateTime.now(), DateTime.now()).getDays();
        System.out.println(days);

        Integer days1 = Days.daysBetween(dt,dateTime).getDays();
        System.out.println(days1);

        System.out.println("----------");
        DateTime start = DateTime.parse("2019-12-10");
        DateTime end = DateTime.parse("2019-12-16");
        int days2 = Days.daysBetween(start, end).getDays();
        for (int i=0;i<=days2;i++){
            System.out.println(start.plusDays(i).toDate());
        }
        System.out.println("----------");
        Days days3 = Days.daysBetween(start, end).dividedBy(3);
        System.out.println("end");

        System.out.println("----------");
        DateTime start1 = new DateTime(2020, 1, 1, 0, 0);
        DateTime end1 = start1.plusYears(1).plusDays(-1);
        System.out.println(start1.toDate());
        System.out.println(end1.toDate());
    }
}
