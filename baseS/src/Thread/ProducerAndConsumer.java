package Thread;

class Computer {
    private String name;
    private double price;

    public Computer(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "name: " + this.name + " price:" + this.price;
    }
}

class Resource {
    private Computer computer;

    public synchronized void make() throws Exception {
        if (computer != null) {
            this.wait();
        }
        Thread.sleep(500);
        computer = new Computer("笔记本", 2.5);// 生产商品
        System.out.println("生产笔记本" + computer.toString());
        this.notifyAll();
    }

    public synchronized void get() throws Exception {
        if (computer == null) {
            this.wait();
        }
        Thread.sleep(50);
        System.out.println("消费笔记本" + computer.toString());// 取走商品
        computer = null;
        this.notifyAll();
    }
}

class Producer implements Runnable {

    private Resource resource;

    public Producer(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            try {
                resource.make();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer implements Runnable {

    private Resource resource;

    public Consumer(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 50; i++) {
                try {
                    resource.get();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

public class ProducerAndConsumer {
    public static void main(String[] args) {
        Resource resource = new Resource();
        new Thread(new Producer(resource)).start();
        new Thread(new Consumer(resource)).start();
    }
}
