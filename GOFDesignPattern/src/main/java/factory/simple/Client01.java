package factory.simple;

public class Client01 {
    public static void main(String[] args) {
        Car audi = new Audi();
        Car buik = new Buik();
        audi.run();
        buik.run();
    }
}
