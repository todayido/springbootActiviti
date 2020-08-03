package di.test1;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

@Data
public class Person {

    @Value("张三")
    private String name;

    @Value("${person.age}")
    private int age;
}
