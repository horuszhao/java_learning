import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public final class Number {
    private static final Integer DEFAULT_SCALE = 2;
    private static final Integer DIVIDE_MAX_SCALE = 15;
    private static final Integer DEFAULT_ROUND_MODE = 4;
    private static final String BLANK = "";
    private static final String DOT = ",";
    private static final String PERCENT = "%";
    private static final BigDecimal ONE_HUNDRED = BigDecimal.valueOf(100L);
    private static final DecimalFormat AMOUNT_WITH_DOT = new DecimalFormat("#,##0.00");
    private static final Comparator<Number> COMPARATOR = Comparator.comparing((number) -> {
        return number.value;
    });
    private BigDecimal value;
    private Integer scale;
    private Integer roundMode;

    private BigDecimal convert(Object o) {
        if (Objects.isNull(o)) {
            return BigDecimal.ZERO;
        } else if (o instanceof Long) {
            return BigDecimal.valueOf((Long)o);
        } else if (o instanceof Double) {
            return BigDecimal.valueOf((Double)o);
        } else if (o instanceof Integer) {
            return new BigDecimal((Integer)o);
        } else if (o instanceof String) {
            String str = (String)o;
            str = str.replace(",", "");
            if (str.endsWith("%")) {
                str = str.replace("%", "");
                return (new BigDecimal(str)).divide(ONE_HUNDRED, DIVIDE_MAX_SCALE, DEFAULT_ROUND_MODE);
            } else {
                return new BigDecimal(str);
            }
        } else if (o instanceof BigDecimal) {
            return (BigDecimal)o;
        } else if (o instanceof Float) {
            return new BigDecimal(o.toString());
        } else {
            throw new IllegalArgumentException("value type of Number illegal");
        }
    }

    private Number(Object obj) {
        this.value = this.convert(obj);
    }

    public static Number of(Object val) {
        return val instanceof Number ? (Number)val : new Number(val);
    }

    public Boolean equalValue(Object other) {
        return this.value.compareTo(of(other).value) == 0;
    }

    public Boolean bigThen(Object other) {
        return this.value.compareTo(of(other).value) > 0;
    }

    public Boolean lessThen(Object other) {
        return this.value.compareTo(of(other).value) < 0;
    }

    public Boolean equalsZero() {
        return this.value.compareTo(BigDecimal.ZERO) == 0;
    }

    public Boolean bigToZero() {
        return this.value.compareTo(BigDecimal.ZERO) > 0;
    }

    public Boolean lessToZero() {
        return this.value.compareTo(BigDecimal.ZERO) < 0;
    }

    public Number add(Object other) {
        return of(this.value.add(of(other).value));
    }

    public Number sub(Object other) {
        return of(this.value.subtract(of(other).value));
    }

    public Number times(Object other) {
        return of(this.value.multiply(of(other).value));
    }

    public Number div(Object other) {
        Number otherNum = of(other);
        return otherNum.equalsZero() ? of(BigDecimal.ZERO) : of(this.value.divide(of(other).value, DIVIDE_MAX_SCALE, DEFAULT_ROUND_MODE));
    }

    public Number scale(Integer scale) {
        this.scale = scale;
        return this;
    }

    public Number roundMode(Integer roundMode) {
        this.roundMode = roundMode;
        return this;
    }

    public BigDecimal value() {
        return this.value.setScale((Integer) Optional.ofNullable(this.scale).orElse(DEFAULT_SCALE), (Integer)Optional.ofNullable(this.roundMode).orElse(DEFAULT_ROUND_MODE));
    }

    public Integer toInt() {
        return this.value.intValue();
    }

    public Long toLong() {
        return this.value.longValue();
    }

    public String toStr() {
        return this.value.setScale((Integer)Optional.ofNullable(this.scale).orElse(DEFAULT_SCALE), (Integer)Optional.ofNullable(this.roundMode).orElse(DEFAULT_ROUND_MODE)).toString();
    }

    public String toStrWithDot() {
        return AMOUNT_WITH_DOT.format(this.value);
    }

    public String toPercent() {
        return this.times(100).scale((Integer)Optional.ofNullable(this.scale).orElse(DEFAULT_SCALE)).roundMode((Integer)Optional.ofNullable(this.roundMode).orElse(DEFAULT_ROUND_MODE)).toStr().concat("%");
    }

    public static Number max(List originList) {
        return !Objects.isNull(originList) && !originList.isEmpty() ? (Number)convert(originList).stream().max(COMPARATOR).get() : of(BigDecimal.ZERO);
    }

    public static Number min(List originList) {
        return !Objects.isNull(originList) && !originList.isEmpty() ? (Number)convert(originList).stream().min(COMPARATOR).get() : of(BigDecimal.ZERO);
    }

    public static Number sum(List originList) {
        return !Objects.isNull(originList) && !originList.isEmpty() ? (Number)convert(originList).stream().reduce(Number::add).get() : of(BigDecimal.ZERO);
    }

    public static Number avg(List originList) {
        return !Objects.isNull(originList) && !originList.isEmpty() ? sum(originList).div(originList.size()) : of(BigDecimal.ZERO);
    }

    public static List<Number> sort(List originList) {
        return (List)convert(originList).stream().sorted(COMPARATOR).collect(Collectors.toList());
    }

    private static List<Number> convert(List originList) {
        List<Number> targetList = new ArrayList();
        originList.forEach((t) -> {
            targetList.add(of(t));
        });
        return targetList;
    }

    public static void main(String[] args) {
        Integer integer = Number.of(30).times(0.81).toInt();
        System.out.println(integer);
    }
}