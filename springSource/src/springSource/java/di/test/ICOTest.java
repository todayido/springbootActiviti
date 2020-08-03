package di.test;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ICOTest {

    @Test
    public void test001(){
        // 创建IOC容器ASDX
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(BeanLifeCycle.class);
        System.out.println("容器创建完成...");
        ColorRed bean = annotationConfigApplicationContext.getBean(ColorRed.class);
        System.out.println(bean);
        annotationConfigApplicationContext.close();

        ColorRed colorRed = new ColorRed.Builder()
                .colorName("red001")
                .colorHex("FFFF00")
                .build();

        ColorRed colorRed2 = new ColorRed.Builder()
                .build();

        System.out.println("==========="+colorRed);
        System.out.println("==========="+colorRed2);
    }
}
