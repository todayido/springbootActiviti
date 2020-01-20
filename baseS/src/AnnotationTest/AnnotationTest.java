package AnnotationTest;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

@FunctionalInterface
interface IMessage {
    public void send(String msg);
}

class MyMessage implements IMessage {

    @MyAnnotation(title = "www")
    @Override
    public void send(String msg) {
        System.out.println("发送消息......" + msg);
    }
}

@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation {
    public String title();

    public String url() default "www.xxx.cn";
}


public class AnnotationTest {
    public static void main(String[] args) throws Exception {
        Annotation annotations[] = IMessage.class.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }

        Method method = MyMessage.class.getMethod("send", String.class);
        MyAnnotation myAnnotation = method.getAnnotation(MyAnnotation.class);
        System.out.println(myAnnotation.title());
        // 利用反射和注解调用方法
        method.invoke(MyMessage.class.getDeclaredConstructor().newInstance(), myAnnotation.title() + ":" + myAnnotation.url());
    }
}
