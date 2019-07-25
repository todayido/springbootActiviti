package singleton;

/**
 * @Description: 懒汉式单例模式
 */
public class SingletonLazy {
    private static SingletonLazy singletonLazy;

    private SingletonLazy(){
        if (singletonLazy!=null) {
            throw new RuntimeException();
        }
    }

    public static synchronized SingletonLazy getInstance(){ // 用的时候才会去加载，资源利用率高，但是并发效率低
        if (singletonLazy==null) {
            singletonLazy = new SingletonLazy();
        }

        return singletonLazy;
    }
}
