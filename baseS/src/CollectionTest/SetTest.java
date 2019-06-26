package CollectionTest;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

class Person {

    String name;
    int age;

    public Person() {

    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "name:" + name + "、age" + age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}

public class SetTest {
    public static void main(String[] args) {
//        Set<String> mySet = Set.of("hello","world","hello");
        //Exception in thread "main" java.lang.IllegalArgumentException: duplicate element: hello

        Set<String> mySet = new HashSet<>();
        mySet.add("hello");
        mySet.add("bbbbb");
        mySet.add("nihao");
        mySet.add("ccccc");
        mySet.add("hello");
        System.out.println(mySet);

        Set<String> sortedSet = new TreeSet<>();
        sortedSet.add("hello");
        sortedSet.add("bbbbb");
        sortedSet.add("nihao");
        sortedSet.add("ccccc");
        sortedSet.add("hello");
        System.out.println(sortedSet);

        Set<Person> personSet = new HashSet<>();
        personSet.add(new Person("张三", 20));
        personSet.add(new Person("李四", 20));
        personSet.add(new Person("王五", 30));
        personSet.add(new Person("李四", 20));
        personSet.add(new Person("马六", 10));
        System.out.println(personSet);

    }
}
