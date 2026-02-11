package edu.dosw.lab.creacionales.reto3;

/**
 * Interfaz base para todos los vehículos.
 * Define el contrato que deben cumplir todos los vehículos.
 */
public interface Vehiculo {
    String getTipo();

    String getModelo();

    Categoria getCategoria();

    int getVelocidadMaxima();

    double getPrecio();

    String getEquipamiento();

    /**
     * Muestra la información completa del vehículo.
     */
    default String mostrarInfo() {
        return String.format(
                "Tipo: %s\n" +
                        "Categoría: %s\n" +
                        "Velocidad máxima: %d km/h\n" +
                        "Precio: $%,.0f\n" +
                        "Equipamiento: %s",
                getModelo(),
                getCategoria().getNombre(),
                getVelocidadMaxima(),
                getPrecio(),
                getEquipamiento());
    }
}
