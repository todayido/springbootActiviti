package di.test2;

import lombok.Data;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Data
@Component
public class Boss implements ApplicationContextAware {

    ApplicationContext context;

    @Autowired
    private Car car;

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
        Car bean = context.getBean(Car.class);
        System.out.println(bean);
        System.out.println("===================" + context);
    }
}
