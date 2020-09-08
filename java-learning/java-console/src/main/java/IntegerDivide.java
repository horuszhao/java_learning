import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;

/**
 * @author:zhaoyunxiang
 * @date:2019/10/9 2:52 下午
 */
public class IntegerDivide {
    public static void main(String[] args) {
        Integer a = 100;
        Integer b = 30;
        BigDecimal divide = BigDecimal.valueOf(a).divide(BigDecimal.valueOf(b), 0, RoundingMode.UP);
        System.out.println(divide.intValue());

        String s = bigDecimalToPercentString(BigDecimal.valueOf(0.322345));
        System.out.println(s);

        System.out.println(Integer.valueOf("0500"));
    }

    public static String bigDecimalToPercentString(BigDecimal b){
        NumberFormat percent = NumberFormat.getPercentInstance();
        percent.setMaximumFractionDigits(2);
        return percent.format(b);

    }
}
