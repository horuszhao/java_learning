import lombok.AllArgsConstructor;
import lombok.Data;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author:zhaoyunxiang
 * @date:2019/9/19 5:21 下午
 */
public class MapTest {
    public static void main(String[] args) {
        List<KeyName> datas = new ArrayList<>();
        datas.add(new KeyName("a","a"));
        datas.add(new KeyName("a1","a1"));
        datas.add(new KeyName("a","a2"));
        datas.add(new KeyName("a3","a3"));

//        datas.add(new KeyName("","null"));
//        datas.add(new KeyName(null,"null"));
//        Map<String, String> collect = datas.stream().collect(Collectors.toMap(c -> c.getKey(), c -> c.getName(), (a, b) -> b));
        Map<String, List<KeyName>> collect = datas.stream().collect(Collectors.groupingBy(c -> c.getKey()));
        System.out.println(collect);
        Object obj = null;
        KeyName kn = (KeyName)obj;
        System.out.println(kn);
//        Array<Map.Entry<String, List<KeyName>>> entries = collect.entrySet().toArray();
//        collect.entrySet().stream().sorted(Comparator.comparing(c->c.getKey()));
        System.out.println("done.");
    }

    @Data
    @AllArgsConstructor
    public static class KeyName {
        private String key;
        private String name;
    }
}
