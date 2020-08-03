package di.test2;

import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@ToString
public class UserService {

    @Autowired(required = false)
    private UserDao userDao;
}
