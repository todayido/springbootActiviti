package prototype;

import java.awt.font.TextHitInfo;
import java.util.Date;

public class Client {
    public static void main(String[] args) throws CloneNotSupportedException {

        Date birthDay = new Date();
        Sheep sheep = new Sheep("123",12, birthDay);
        Sheep cloneSheep = (Sheep) sheep.clone(); // 工厂模式可以使用clone模式创建对象，象spring中的单例和原型来创建对象


        birthDay.setTime(123123L); // 如下输出结果相同，两只羊引用的是同一个对象，对象属性更改，所有引用都会变化。
        System.out.println(sheep);
        System.out.println(cloneSheep);


        long start = new Date().getTime();
        for (int i = 0; i < 1000000; i++) {
            /**
             * 此处的date应该是new出来，不然这个代码的耗时，就不计算new Date()的时间，突然发现new Date()和new Sheep()一样耗时。如果对象中没有其他对象属性，new 要比克隆快。
             */
            Sheep s = new Sheep("123", 12, new Date());
        }
        System.out.println("new 耗时：" + (new Date().getTime() - start));


        start = new Date().getTime();
        for (int i = 0; i < 1000000; i++) {
            Sheep s2 = (Sheep) sheep.clone();
        }
        System.out.println("clone 耗时" + (new Date().getTime() - start));
    }
}
