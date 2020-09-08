import lombok.Data;
import lombok.ToString;
/**
 * @author:zhaoyunxiang
 * @date:2020/9/7 2:17 下午
 */
public class OverrideTest {
    public static void main(String[] args) {
        Porsche p = new Porsche();
        p.setModel("aaa");
        p.setName("little p");
        p.setYear(2020);
        p.setOwner("zzz");
        Car c = (Car)p;
        c.setModel("bbb");
        System.out.println(p);
        System.out.println(c);
    }

    @Data
    public static class Car{
        private String name;
        private String model;
    }

    @Data
    @ToString(callSuper = true)
    public static class Porsche extends Car{
        private Integer year;
        private String name;
        private String model;
        private String owner;
    }
}
