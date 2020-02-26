import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

/**
 * @author:zhaoyunxiang
 * @date:2019/10/10 2:13 下午
 */
public class StringTest {
    public static void main(String[] args) {
        String a = "aaa";
        boolean equals = a.equals(null);
        System.out.println(equals);

        System.out.println(String.format("%d%02d",2019,13));


        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        System.out.println(new Date());
        System.out.println(cal.get(Calendar.DAY_OF_WEEK));
        BigDecimal week_index = BigDecimal.valueOf(cal.get(Calendar.DAY_OF_WEEK) -1);
        BigDecimal add = BigDecimal.valueOf(0.8).add(week_index.divide(BigDecimal.valueOf(100)));
        System.out.println(add);
    }
}
