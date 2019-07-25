package singleton;

/**
 * @Description: 静态内部类单例实现，延时加载
 */
public class SingletonInnerClass {

    private static class SineltonInstance{
       private static SingletonInnerClass innerClass = new SingletonInnerClass();
    }

    private SingletonInnerClass(){

    }

    public SingletonInnerClass getInstance(){
        return SineltonInstance.innerClass;
    }
}
