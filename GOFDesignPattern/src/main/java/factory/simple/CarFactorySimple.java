package factory.simple;

/**
 * @Description: 简单工厂模式，也称之为静态工厂模式，但是对于新增加子类需要需改业务代码，对于扩展不友好
 */
public class CarFactorySimple {

    private Car car;

    public Car buildCar(String carType){
        switch (carType) {
            case "buik":
                car =  new Buik();
                break;
            case "audi":
                car = new Audi();
            default:
                car = new Audi();
        }

        return car;
    }

}
