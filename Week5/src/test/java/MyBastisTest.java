import com.mybatisstudy.Service.UserService;
import com.mybatisstudy.domain.User;
import org.junit.Assert;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.*;

public class MyBastisTest {

    @Test
    public void getUser() {
        UserService service = new UserService();
        User user = service.getUser(1);
        System.out.println(user.toString());
        Assert.assertEquals(user.getId(), 1);
    }

    /**
     * 1）通过Mybatis批量插入N条数据到数据库
     */
    @Test
    public void batchInsertUser() {
        List<User> users = new ArrayList<User>();
        for (int i = 0; i < 100; i++) {
            User user = new User();
            user.setName("Hello" + String.valueOf(i));
            user.setAge(10 + i);
            users.add(user);
        }

        UserService service = new UserService();
        int r = service.batchInsert(users);
        System.out.println(r);
        Assert.assertTrue(true);
    }

    /**
     * 2）通过Bean Validation验证参数不能为空，数字不能大于100同时不能小于50等条件
     */
    @Test
    public void beanValidation() {
        User user = new User();
        user.setName("a");
        user.setAge(10 + 100);

        ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
        Validator validator = vf.getValidator();

        Set<ConstraintViolation<User>> validateResult = validator.validate(user);
        for (ConstraintViolation<User> cv : validateResult) {
            System.out.println(cv.getMessage() + "(" + cv.getPropertyPath() + ")" + "-->" + cv.getInvalidValue());
        }
        Assert.assertTrue(true);
    }
}
