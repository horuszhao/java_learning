import java.math.BigDecimal;

/**
 * @author:zhaoyunxiang
 * @date:2019/11/13 3:22 下午
 */
public class DecimalTest {
    public static void main(String[] args) {
//        BigDecimal decimal1 = BigDecimal.valueOf(0.00);
//        BigDecimal decimal2 = BigDecimal.valueOf(0);
//        System.out.println(decimal1.equals(BigDecimal.ZERO));
//        System.out.println(decimal2.equals(BigDecimal.ZERO));
//
//        System.out.println(decimal1.compareTo(BigDecimal.ZERO));
//        System.out.println(decimal2.compareTo(BigDecimal.ZERO));

        Integer a = 80,b=75;
        System.out.println(String.valueOf(BigDecimal.valueOf(a).divide(BigDecimal.TEN))) ;
        System.out.println(String.valueOf(BigDecimal.valueOf(b).divide(BigDecimal.TEN)));

        System.out.println(Integer.valueOf("000"));
    }
}
