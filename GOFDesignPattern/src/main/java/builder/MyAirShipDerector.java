package builder;

public class MyAirShipDerector implements AirShipDerector {

    AirShipBuilder airShipBuilder;

    @Override
    public AirShip derectAirShip() {

        OrbitalModule orbitalModule = airShipBuilder.buildOrbitalModule();
        Engine engine = airShipBuilder.buildEngine();
        EscapeTower escapeTower = airShipBuilder.buildEscapeTower();

        AirShip airShip = new AirShip();
        airShip.setOrbitalModule(orbitalModule);
        airShip.setEngine(engine);
        airShip.setEscapeTower(escapeTower);

        return airShip;
    }

    public MyAirShipDerector(AirShipBuilder airShipBuilder) {
        this.airShipBuilder = airShipBuilder;
    }

    public AirShipBuilder getAirShipBuilder() {
        return airShipBuilder;
    }

    public void setAirShipBuilder(AirShipBuilder airShipBuilder) {
        this.airShipBuilder = airShipBuilder;
    }
}
