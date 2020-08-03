package di.test2;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestAutowired {

    @Test
    public void test01(){
        AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext(MainConfigOfAutowired.class);
        String[] names = configApplicationContext.getBeanDefinitionNames();
        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i]);
        }

        UserService bean = configApplicationContext.getBean(UserService.class);
        System.out.println(bean);

        Boss boss = configApplicationContext.getBean(Boss.class);
        System.out.println(boss);

        Car car = configApplicationContext.getBean(Car.class);
        System.out.println(car);


        System.out.println(configApplicationContext);

        configApplicationContext.close();

        System.out.println(this.getClass().getClassLoader());
    }
}
