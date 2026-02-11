package edu.dosw.lab.creacionales.reto3;

/**
 * Fábrica concreta para vehículos aéreos.
 * Crea: Avión, Avioneta, Helicóptero
 */
public class AereoFactory implements VehiculoFactory {

    private static final String[] MODELOS = { "Avión", "Avioneta", "Helicóptero" };

    @Override
    public Vehiculo crearVehiculo(int modelo, Categoria categoria) {
        switch (modelo) {
            case 1:
                return new Avion(categoria);
            case 2:
                return new Avioneta(categoria);
            case 3:
                return new Helicoptero(categoria);
            default:
                throw new IllegalArgumentException("Modelo no válido: " + modelo);
        }
    }

    @Override
    public String[] getModelosDisponibles() {
        return MODELOS;
    }
}
