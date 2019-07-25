package factory.simple;

public class Client02 {
    public static void main(String[] args) {
        // 简单工厂模式创建Car
        CarFactorySimple factory = new CarFactorySimple();
        Car car = factory.buildCar("buik");
        car.run();
    }
}
