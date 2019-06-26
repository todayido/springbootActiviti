package FanSheTest;

class FactoryT {
    private FactoryT() {
    }

    public static <T> T getInstance(String className, Class<T> clazz) {
        T instance = null;
        try {
            instance = (T) Class.forName(className).getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return instance;
    }
}

class Single {
    //1、私有化构造方法
    private Single() {
    }

    //2、在本类中创建唯一的实例对象，使用私有静态成员变量
    private static Single single = new Single();

    //3、对外提供公开的静态方法
    public static Single getInstance() {
        return single;
    }
}


class Singleton {
    private static volatile Singleton instance = null;

    private Singleton() {
        System.out.println("执行...");
    }

    public static Singleton getInstatance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}

public class Fanshe4 {
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            int f = i;
            new Thread(() -> {
                Singleton.getInstatance();
                System.out.println(f);
            }).start();

        }
    }
}
