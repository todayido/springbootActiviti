package singleton;

/**
 * @Description: 枚举类实现单例
 */
public enum SingletonEnum {

    INSTANCE;

    // 添加自己需要的操作
    public void showMeTheCode(){
        System.out.println("123");
    }

    public static void main(String[] args) {
        SingletonEnum singletonEnum =  SingletonEnum.INSTANCE;
        singletonEnum.showMeTheCode();
    }
}
