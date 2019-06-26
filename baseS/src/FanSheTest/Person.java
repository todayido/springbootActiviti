package FanSheTest;

public class Person {

    private String name;
    private int age;

    // 任何情况下要实例化对象必须调用类中的构造方法
    // 为什么调用构造方法，是因为要为类中的属性初始化。
    public Person() {
        System.out.println("Person构造方法");
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        System.out.println("12312312");
        return name;
    }

    @Override
    public String toString() {
        return "name:" + name + "、age" + age;
    }
}
