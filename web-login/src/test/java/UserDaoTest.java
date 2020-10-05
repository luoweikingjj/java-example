import com.example.weblogin.dao.UserDao;
import com.example.weblogin.domain.User;
import org.junit.jupiter.api.Test;

public class UserDaoTest {
    @Test
    public void testLogin() {
        User user = new User();
        user.setUsername("xiaohei");
        user.setPassword("123");

        UserDao userDao = new UserDao();
        User loginUser = userDao.login(user);

        System.out.println(loginUser);
    }
}
