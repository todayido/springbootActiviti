package di.test1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@PropertySource(value = {"classpath:/person.properties"})
@Configuration
public class PropertyValue {

    @Bean
    public Person Person(){
        return new Person();
    }
}
