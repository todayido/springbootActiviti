import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.IntStream;

public class StaticTest {
    public static void main(String[] args) {
//        Student s1 = new Student();
//        Student s2 = new Student();
//        s1.username = "123";
//
//        System.out.println(s2.username);

//        System.out.println(IntStream.range(1, 2).sum());
//        IntStream.range(1,10).forEach(i->{
//            System.out.println(i);
//        });

        /**
         * true
         * true
         * false
         * true
         */
//        String a = "a";
//        String b = "a";
//        System.out.println(a == b);
//        System.out.println(a.equals(b));
//
//        String c = new String("a");
//        String d = new String("a");
//
//        System.out.println(c == d);
//        System.out.println(c.equals(d));

        Map<Student, Student> map = new HashMap<Student, Student>();
        map.put(new Student("123", 20),new Student("123", 20));
        map.put(new Student("123", 21),new Student("123", 22));
//        System.out.println(map);
        System.out.println(map.size());
//        System.out.println(map.get(new Student("123", 20)));

    }
}

class Student{
    static String username; // 静态方法区，存放所有的静态从成员变量，并且共享。
    String no;

    public Student(String no, int age) {
        this.no = no;
        this.age = age;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    int age;



    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        Student.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        System.out.println("equals======");
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age &&
                Objects.equals(no, student.no);
    }

    @Override
    public int hashCode() {
        System.out.println("hashCode------");
        return Objects.hash(no);
    }
}
