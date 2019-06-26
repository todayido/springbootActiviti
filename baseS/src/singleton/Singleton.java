package singleton;

public class Singleton {

    // private 构造方法
    private Singleton() {
    }

    // private 静态内部类
    private static class InnerClass {
        private static Singleton instance = new Singleton();
    }

    // 返回静态内部类的实例
    public Singleton getInstance() {
        return InnerClass.instance;
    }
}
