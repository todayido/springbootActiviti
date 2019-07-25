package builder;

public interface AirShipBuilder {
    OrbitalModule buildOrbitalModule();
    Engine buildEngine();
    EscapeTower buildEscapeTower();
}
