package prototype;

import com.sun.xml.internal.ws.message.saaj.SAAJHeader;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Sheep implements Cloneable{
    private String name;
    private int age;
    private Date birthDate;

    public Sheep(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Sheep(String name, int age, Date birthDate) {
        this.name = name;
        this.age = age;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
//        Sheep sheep = new Sheep(this.name, this.age, (Date) this.birthDate.clone());
        return super.clone();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Sheep{");
        sb.append("name='").append(name).append('\'');
        sb.append(", age=").append(age);
        sb.append(", birthDate=").append(birthDate);
        sb.append('}');
        return sb.toString();
    }
}
