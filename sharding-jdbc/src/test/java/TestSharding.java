import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import spring.skitdatatable.dao.UserMapper;
import spring.skitdatatable.entity.User;

@RunWith(SpringRunner.class)
@SpringBootTest
@SuppressWarnings("all")
@ContextConfiguration
public class TestSharding {
    @Autowired
    UserMapper userMapper;

    @org.junit.Test
    public void contextLoads() {
        for (int i = 1; i < 10; i++) {
            User u = new User();
            u.setUserId(i);
            u.setAge(25);
            u.setName("github");
            userMapper.insert(u);
        }
    }
}