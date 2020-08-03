package aop.test;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AopTest {

    @Test
    public void test(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfigAop.class);
        MathCalculator mathCalculator = context.getBean(MathCalculator.class);
        System.out.println(mathCalculator.div(80, 16));
    }

    @Test
    public void test2(){
        Integer a = 1;
        Integer b = 1;
        System.out.println(a == b);
        System.out.println(a.equals(b));

        String str1 = "hello";
        String str2 = "hello";

        System.out.println(str1 == str2);
        System.out.println(str1.equals(str2));
    }

}
