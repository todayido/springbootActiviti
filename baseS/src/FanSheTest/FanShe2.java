package FanSheTest;

public class FanShe2 {
    public static void main(String[] args) throws Exception {
        Class<?> cls = Class.forName("FanSheTest.Person");
        // 通过反射实例化的对象，依然要调用类中的无参构造方法
        // 其本质等价于new Person
        Object obj = cls.newInstance();
        Object obj2 = cls.getDeclaredConstructor().newInstance();
        System.out.println(obj.toString());
        System.out.println(obj2.toString());
    }
}
