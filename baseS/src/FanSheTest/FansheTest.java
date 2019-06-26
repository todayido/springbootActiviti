package FanSheTest;

import java.util.Date;


public class FansheTest {
    public static void main(String[] args) throws Exception {
        Person person = new Person();
        Class<? extends Person> personClass = person.getClass();
        System.out.println(personClass);
        System.out.println(personClass.getName());

        System.out.println(Person.class.getName());

        Class per = Class.forName("FanSheTest.Person");
        System.out.println(per);

    }
}
