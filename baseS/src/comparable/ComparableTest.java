package comparable;

import java.util.Arrays;
import java.util.Comparator;

class Person implements Comparable<Person> {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return " name:" + this.name + " age：" + this.age;
    }

    @Override
    public int compareTo(Person o) {
        return this.age - o.age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

public class ComparableTest {
    public static void main(String[] args) {
        Person[] ps = {new Person("zhangsan", 20),
                new Person("zhangsan2", 30),
                new Person("zhangsan3", 10)};

        //Arrays.sort(ps);
        //System.out.println(Arrays.toString(ps));

        // 或者

        Comparator comparator = new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge() - o2.getAge();
            }
        };

        Arrays.sort(ps, comparator);

        System.out.println(Arrays.toString(ps));
    }
}
