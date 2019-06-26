package FanSheTest;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ReflectTest {
    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("FanSheTest.Person");
//        Constructor constructor = clazz.getConstructor(String.class, int.class);
//        Object obj = constructor.newInstance("xiaoming", 25);
//        System.out.println(obj.toString());

//        Method method[] = clazz.getMethods();
//        for (int i = 0; i < method.length; i++) {
//            System.out.println(method[i].getName());
//        }

        //反射来实现调用方法
        Method m = clazz.getMethod("getName");
        System.out.println(m.invoke(clazz));
    }
}
