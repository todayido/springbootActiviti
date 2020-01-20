package di.test3;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Test {

    @org.junit.Test
    public void test(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DataSourceConfig.class);
        String[] names = context.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
    }

    @org.junit.Test
    public List test2(String a){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.getEnvironment().setActiveProfiles("dev");
        context.register(DataSourceConfig.class);
        context.refresh();
        String[] names = context.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }

        return null;
    }
}
