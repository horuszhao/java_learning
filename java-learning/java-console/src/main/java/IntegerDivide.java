import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author:zhaoyunxiang
 * @date:2019/10/9 2:52 下午
 */
public class IntegerDivide {
    public static void main(String[] args) {
        Integer a = 100;
        Integer b = 30;
        BigDecimal divide = BigDecimal.valueOf(a).divide(BigDecimal.valueOf(b), 0, RoundingMode.UP);
        System.out.println(divide);
    }
}
