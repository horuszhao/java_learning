import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
        Map<String, String> collect = datas.stream().collect(Collectors.toMap(c -> c.getKey(), c -> c.getName(), (a, b) -> b));

        System.out.println(collect);
        Object obj = null;
        KeyName kn = (KeyName)obj;
        System.out.println(kn);
    }

    @Data
    @AllArgsConstructor
    public static class KeyName {
        private String key;
        private String name;
    }
}
