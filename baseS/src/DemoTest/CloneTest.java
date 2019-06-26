package DemoTest;

class Person implements Cloneable, Comparable<Person> {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return super.toString() + " name:" + this.name + " age：" + this.age;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public int compareTo(Person o) {
        return this.age - o.age;
    }
}

public class CloneTest {
    public static void main(String[] args) throws Exception {
        Person person = new Person("zhangsan", 20);
        System.out.println(person);
//        BTree.DemoTest.Person person1 = person.clone(); // 注意该方法是protect的方法，不能直接调用。需要覆写clone方法

        Person person2 = (Person) person.clone();
        System.out.println(person2);
    }
}
