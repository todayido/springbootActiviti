package di.test3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class DataSourceConfig {

    @Bean
    @Profile("test")
    Yellow yellow(){
        System.out.println("test......");
        return new Yellow();
    }

    @Bean
    @Profile("dev")
    Yellow yellow2(){
        System.out.println("dev......");
        return new Yellow();
    }
}
