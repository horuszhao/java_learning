import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:zhaoyunxiang
 * @date:2020/1/2 5:48 下午
 */
public class JsonDataGenerator {
    public static void main(String[] args) {

        List<Student> list = new ArrayList<>();

        for (int i=97;i<=122;i++)
        {
            for (int j=1;j<=20;j++)
            {
                list.add(new Student(String.valueOf((char)i),j));
            }
        }

        String s = JSON.toJSONString(list);

        System.out.println(s);
    }

    @Data
    @AllArgsConstructor
    static class Student{
        private String name;
        private Integer age;
    }
}
