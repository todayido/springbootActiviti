package di.test1;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class TestIocLifeCircle {

    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PropertyValue.class);

    @Test
    public void test001(){
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }

        Person person = context.getBean(Person.class);
        System.out.println(person);
    }
}
