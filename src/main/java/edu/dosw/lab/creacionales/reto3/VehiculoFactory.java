package edu.dosw.lab.creacionales.reto3;

/**
 * ABSTRACT FACTORY - Interfaz para crear familias de vehículos.
 * 
 * Categoría del patrón: CREACIONAL
 * Patrón utilizado: ABSTRACT FACTORY
 * 
 * Justificación:
 * - Permite crear familias de objetos relacionados (vehículos por tipo)
 * - Cada fábrica concreta crea vehículos de un tipo específico (Tierra, Agua,
 * Aire)
 * - El cliente trabaja con la interfaz abstracta sin conocer las clases
 * concretas
 * - Facilita agregar nuevos tipos de vehículos sin modificar código existente
 */
public interface VehiculoFactory {

    /**
     * Crea un vehículo según el modelo y categoría especificados.
     * 
     * @param modelo    Número del modelo (1, 2, 3 según el tipo)
     * @param categoria Categoría del vehículo (Económico, Lujo, Usado)
     * @return El vehículo creado
     */
    Vehiculo crearVehiculo(int modelo, Categoria categoria);

    /**
     * Obtiene los modelos disponibles para este tipo de vehículo.
     */
    String[] getModelosDisponibles();
}
