package builder;

public class MyAirShip implements AirShipBuilder{
    @Override
    public OrbitalModule buildOrbitalModule() {
        System.out.println("myOritablModule");
        return new OrbitalModule("myOritablModule");
    }

    @Override
    public Engine buildEngine() {
        System.out.println("myEngine");
        return new Engine("myEngine");
    }

    @Override
    public EscapeTower buildEscapeTower() {
        System.out.println("myEscapeTower");
        return new EscapeTower("myEscapeTower");
    }
}
