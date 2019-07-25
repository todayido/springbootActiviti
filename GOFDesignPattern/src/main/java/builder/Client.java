package builder;

public class Client {

    public static void main(String[] args) {
        AirShipBuilder airShipBuilder = new MyAirShip();
        AirShipDerector airShipDerector = new MyAirShipDerector(airShipBuilder);
        airShipDerector.derectAirShip();
    }
}
