package edu.dosw.lab.creacionales.reto3;

/**
 * Fábrica concreta para vehículos acuáticos.
 * Crea: Lancha, Velero, Jet Ski
 */
public class AcuaticoFactory implements VehiculoFactory {

    private static final String[] MODELOS = { "Lancha", "Velero", "Jet Ski" };

    @Override
    public Vehiculo crearVehiculo(int modelo, Categoria categoria) {
        switch (modelo) {
            case 1:
                return new Lancha(categoria);
            case 2:
                return new Velero(categoria);
            case 3:
                return new JetSki(categoria);
            default:
                throw new IllegalArgumentException("Modelo no válido: " + modelo);
        }
    }

    @Override
    public String[] getModelosDisponibles() {
        return MODELOS;
    }
}
