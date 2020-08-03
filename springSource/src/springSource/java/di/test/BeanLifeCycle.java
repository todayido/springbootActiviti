package di.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanLifeCycle {

    @Bean(initMethod = "init", destroyMethod = "destroy")
    public ColorRed colorRed(){
        return new ColorRed();
    }

}
