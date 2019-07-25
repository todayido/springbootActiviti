package singleton;

/**
 * @Description: 饿汉式单例设计
 * 静态成员变量、私有构造方法、静态方法返回变量
 */
public class SingletonImmediate {

    private static SingletonImmediate singleton01 = new SingletonImmediate();// 初始化是立即加载，天然的线程安全

    private SingletonImmediate(){

    }

    public static SingletonImmediate getInstance(){
        return singleton01;
    }
}
