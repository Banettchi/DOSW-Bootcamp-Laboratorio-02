package edu.dosw.lab.comportamiento.reto6;

/**
 * Técnico Avanzado: maneja tickets de nivel AVANZADO con cualquier prioridad.
 */
public class SoporteNivel3 extends ManejadorSoporte {

    public SoporteNivel3() {
        super("Técnico Avanzado", Ticket.Nivel.AVANZADO, Ticket.Prioridad.ALTA);
    }
}