import com.example.weblogin.domain.User;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;

public class BeanUtilsTest {
    @Test
    public void test1() {
        User user = new User();
        try {
            BeanUtils.setProperty(user, "gender", "male");
            System.out.println(user);//User{id=0, username='null', password='null', gender='null'}
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void test2() {
        User user = new User();
        try {
            BeanUtils.setProperty(user, "hehe", "male");
            System.out.println(user);//User{id=0, username='null', password='null', gender='male'}
            String gender = BeanUtils.getProperty(user, "hehe");
            System.out.println(gender);//male
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
