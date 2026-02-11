package edu.dosw.lab.comportamiento.reto6;

/**
 * Técnico Básico: maneja tickets de nivel BASICO solo con prioridad BAJA.
 */
public class SoporteNivel1 extends ManejadorSoporte {

    public SoporteNivel1() {
        super("Técnico Básico", Ticket.Nivel.BASICO, Ticket.Prioridad.BAJA);
    }
}