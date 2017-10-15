import com.javalearning.lombokstudy.BuilderPattern;
import com.javalearning.lombokstudy.DoubleCheckedLockingSingleton;
import com.javalearning.lombokstudy.EnumSingleton;
import com.javalearning.lombokstudy.Student;

import java.util.Date;


public class LombokTest {
    public static void main(String[] args) {

        /**
         * 1）通过Lombok注解方式创建一个实体
         */
        Student student = new Student();
        student.setAge(12);
        System.out.println(student.toString());

        /**
         * 2）通过枚举创建一个单例类
         */
        Student student1 = EnumSingleton.INSTANCE.getInstance();
        student1.setAge(13);
        System.out.println(student1.toString());

        /**
         * 3）通过Double check locking 创建一个单例对象
         */
        DoubleCheckedLockingSingleton.getInstance().Print();
        DoubleCheckedLockingSingleton.getInstance().Print();
        DoubleCheckedLockingSingleton.getInstance().Print();

        /**
         *  4）创建一个构建器(Builder)模式实例
         */
        BuilderPattern.Builder builder = new BuilderPattern.Builder("yunxiang", "123456");
        BuilderPattern builderPattern = builder.setAge(15).setBirthday(new Date()).Builder();
        System.out.println(builderPattern.toString());
    }
}
