import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class Test {
    private static final String CHINA_ZONE_ID = "Asia/Shanghai";

    public static void main(String[] args) throws IOException {
//        Set<String> strList = new HashSet<>();
//        strList.add("");
//        strList.add(null);
//        strList.add("1");
//        strList.add("1");
//        System.out.println("aaaggg");
//
//
//        LocalDateTime localDate = LocalDateTime.now(ZoneId.of(CHINA_ZONE_ID));
//
//        System.out.println(localDate);
//
//        System.out.println(localDate.plusDays(-27));
//
//        DateTimeFormatter weekDateFormatter = DateTimeFormatter.ofPattern("EEEE",Locale.CHINA);
//        Instant instant = new Date().toInstant();
//        LocalDateTime ldt = LocalDateTime.ofInstant(instant, ZoneId.of("Asia/Shanghai"));
//        System.out.println(ldt);
//        System.out.println(weekDateFormatter.format(ldt));
//        System.in.read();


//        List<Pair<String, BigDecimal>> weekRoomRateList = new ArrayList<>();
//        weekRoomRateList.add( new Pair<>("aaa",BigDecimal.valueOf(5)));
//        weekRoomRateList.add( new Pair<>("bbb",BigDecimal.valueOf(6)));
//        weekRoomRateList.add( new Pair<>("ccc",BigDecimal.valueOf(3)));
//
//        Collections.sort(weekRoomRateList,Comparator.comparing(c->c.getValue(),Comparator.reverseOrder()));
//
//        Function<String,Integer> weekSort = w -> {
//            if (w.contains("一")) {
//                return 1;
//            } else if (w.contains("二")) {
//                return 2;
//            } else if (w.contains("三")) {
//                return 3;
//            } else if (w.contains("四")) {
//                return 4;
//            } else if (w.contains("五")) {
//                return 5;
//            }else if(w.contains("六")){
//                return 6;
//            }
//            return 7;
//        };

//        List<String> weekList = new ArrayList<>();
//        weekList.add("星期二");
//        weekList.add("星期一");
//        weekList.add("星期日");
//        weekList.add("星期三");
//        Collections.sort(weekList,Comparator.comparing(c->weekSort.apply(c)));
//
//        NumberFormat percent = NumberFormat.getPercentInstance();
//        percent.setMaximumFractionDigits(2);
//        BigDecimal  b = BigDecimal.valueOf(52342345.235234);
//
//        System.out.println(String.format("%18.2f",b.doubleValue())) ;
//        System.out.println(percent.format(b));

//        Integer i = null;
//        boolean e = i.intValue()==0;
//        boolean e1 = i.equals(0);
//
//        Calendar now = Calendar.getInstance();
//        now.setTime(new Date());
//        System.out.println(String.format("the first day is:%s", now.getFirstDayOfWeek()));
//        System.out.println(String.format("today is:%s", now.get(Calendar.DAY_OF_WEEK)));
//        now.setFirstDayOfWeek(Calendar.MONDAY);
//        System.out.println(String.format("the first day is:%s", now.getFirstDayOfWeek()));
//        System.out.println(String.format("today is:%s", now.get(Calendar.DAY_OF_WEEK)));


//        List<BigDecimal> bdList = new ArrayList<>();
//        bdList.add(BigDecimal.valueOf(1.375));
//        bdList.add(BigDecimal.valueOf(1.5));
//        bdList.add(BigDecimal.valueOf(1));
//        bdList.add(BigDecimal.valueOf(1.125));
//        bdList.add(BigDecimal.valueOf(1.0625));
//
//        BigDecimal reduce = bdList.stream().reduce(BigDecimal.ZERO, BigDecimal::add);
//        BigDecimal divide = reduce.divide(BigDecimal.valueOf(bdList.size()), 4);
//
//        OptionalDouble average = bdList.stream().mapToDouble(c -> c.doubleValue()).average();

//        List<AAA>dList = new ArrayList<>();
//        dList.add(new AAA("A",BigDecimal.valueOf(12))) ;
//        dList.add(new AAA("A",BigDecimal.valueOf(12))) ;
//        dList.add(new AAA("A",null)) ;
//        dList.add(new AAA("A",BigDecimal.valueOf(12))) ;
//        dList.add(new AAA("A",BigDecimal.valueOf(12))) ;
//
//        BigDecimal r = dList.stream().map(c->c.getAmount()).reduce(BigDecimal::add).orElse(BigDecimal.ZERO);
//
//        test1("aaa","bbb","ccc");

//        Date d1 = new Date();
//        d1.setDate(26);
//        Date d2 = new Date();
//        long days = (d1.getTime() - d2.getTime()) / (24 * 3600 * 1000);
//Long a = -12L;

//        Scanner scanner = new Scanner(System.in);
//        String next = scanner.next();
//        int next = System.in.read();
//        System.out.println(next);
//        LocalDate now = LocalDate.now();
//        LocalDate startDate = now.plusDays(-1);
//        LocalDate endDate = now.plusDays(-7);
//
//        Integer i = 0;
//        System.out.println(i.equals(0));
//        System.out.println(i==0);

        LocalDate ld1 = LocalDate.parse("2019-09-12");
        LocalDate ld2 = LocalDate.parse("2019-09-13");
        Date d1 = Date.from(ld1.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
        Date d2 = Date.from(ld2.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
        d1.setHours(6);
        long days1 = dateSubDays1(d1, d2);
        long days2 = dateSubDays(d2, d1);


        System.out.println("aaa");


    }

    private static long dateSubDays(Date d1, Date d2) {
        LocalDate ld1 = LocalDateTime.ofInstant(d1.toInstant(), ZoneId.systemDefault()).toLocalDate();
        LocalDate ld2 = LocalDateTime.ofInstant(d2.toInstant(), ZoneId.systemDefault()).toLocalDate();
        long days = ld1.until(ld2, ChronoUnit.DAYS);
        return days;
    }

    private static long dateSubDays1(Date d1, Date d2) {
        return (d1.getTime() - d2.getTime()) / (24 * 3600 * 1000);
    }

    private static void test1(String... list) {
        Object[] objs = new Object[]{list};
        System.out.println(objs);
    }

    @Data
    @AllArgsConstructor
    static class AAA {
        private String name;
        private BigDecimal amount;
    }
}
