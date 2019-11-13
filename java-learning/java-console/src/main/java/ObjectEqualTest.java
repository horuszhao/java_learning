import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author:zhaoyunxiang
 * @date:2019/10/22 1:56 下午
 */
public class ObjectEqualTest {
    public static void main(String[] args) {

        List<A> aList = new ArrayList<>();
        A a1 = new A("a", 12);
        A a2 = new A("a", 12);
        aList.add(a1);
        aList.add(a2);
        Boolean b = a1.equals(a2);
        aList = aList.stream().distinct().collect(Collectors.toList());
        System.out.println("done");
    }

    @Data
    @AllArgsConstructor
    public static class A {
        private String name;
        private Integer age;
    }
}
