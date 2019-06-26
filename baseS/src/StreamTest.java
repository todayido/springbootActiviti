import javax.swing.plaf.TableHeaderUI;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Order {
    private String name;
    private double price;
    private int amount;

    public Order(String name, double price, int amount) {
        this.name = name;
        this.price = price;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}

class Demo {
    private String a;
    Order order;

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Demo(String a, Order order) {
        this.a = a;
        this.order = order;
    }
}

public class StreamTest {
    public static void main(String[] args) throws InterruptedException {
//        List<String> list = new ArrayList<String>();
//        Collections.addAll(list, "hello", "world","java","javascript","name");
//
//        Stream stream = list.stream();
////        System.out.println(stream.count());/// 获取元素个数
//
//        System.out.println(stream.filter((ele) -> ele.toString().toLowerCase().contains("j")).count());
//
//        List<Order> orders = new ArrayList<Order>();
//        orders.add(new Order("123",20,2));
//        orders.add(new Order("123",20,2));
//        orders.add(new Order("123",20,2));
//        orders.add(new Order("123",20,2));
//
//        orders.stream().filter((order -> order.getName().contains("2")));
//
//            System.out.println(false & false);
//
//
//        List<Demo> demoList = new ArrayList<>();
//        demoList.add(new Demo("1", new Order("123", 20, 2)));
//        demoList.add(new Demo("1", new Order("123", 220, 2)));
//        demoList.add(new Demo("1", new Order("123", 59, 2)));
//        demoList.add(new Demo("1", new Order("123", 15, 2)));
//        demoList.add(new Demo("1", new Order("123", 888, 2)));
//        System.out.println(demoList.stream().max(Comparator.comparingDouble(d -> d.getOrder().getPrice())).get().getOrder().getPrice());


//        System.out.println("start");
//        Thread t1 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("1");
//            }
//        });
//
//        Thread t2 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    t1.join();
//                    System.out.println("2");
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//
//            }
//        });
//
//        Thread t3 =  new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    t2.join();
//                    System.out.println("3");
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//
//        t1.start();
//        t2.start();
//        t3.start();
//        System.out.println("end");

        ret();


        Person b = (c) -> {
            System.out.println(c);
        };
    }

    interface Person {
        public void c(int b);
    }

    public static int ret() {
        int flag = 0;
        try {
            flag = 1;
            System.out.println("ret");
            return flag;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("f");
        }
        return flag;
    }

    public int getLastOne(LinkedHashMap<String, String> map, int cont, int steps) {
        Iterator iterator = map.entrySet().iterator();
        int temp = 0;
        while (iterator.hasNext()) {
            if (temp == steps) {
                map.remove(iterator.next());
                cont--;
            } else {
                temp++;
            }

        }
        return 0;
    }

    public static String getKey(LinkedHashMap<String, String> map, int cont, int steps) {
        Iterator iterator = map.entrySet().iterator();
        int temp = 0;
        while (iterator.hasNext()) {
            if (temp == steps) {
                System.out.println(iterator.next());
                map.remove(iterator.next());
                cont--;
            } else {
                if ((temp + 1) == cont) {
                    getKey(map, cont, steps);
                }
                temp++;
            }
        }

        new Thread(() -> {
            System.out.println("123");
        });


        return "";


    }


}
