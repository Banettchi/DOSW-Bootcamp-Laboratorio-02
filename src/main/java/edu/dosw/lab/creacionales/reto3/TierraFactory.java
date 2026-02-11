package edu.dosw.lab.creacionales.reto3;

/**
 * Fábrica concreta para vehículos terrestres.
 * Crea: Auto, Bicicleta, Moto
 */
public class TierraFactory implements VehiculoFactory {

    private static final String[] MODELOS = { "Auto", "Bicicleta", "Moto" };

    @Override
    public Vehiculo crearVehiculo(int modelo, Categoria categoria) {
        switch (modelo) {
            case 1:
                return new Auto(categoria);
            case 2:
                return new Bicicleta(categoria);
            case 3:
                return new Moto(categoria);
            default:
                throw new IllegalArgumentException("Modelo no válido: " + modelo);
        }
    }

    @Override
    public String[] getModelosDisponibles() {
        return MODELOS;
    }
}
