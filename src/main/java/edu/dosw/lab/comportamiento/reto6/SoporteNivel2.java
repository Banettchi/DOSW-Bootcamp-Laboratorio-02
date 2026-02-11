package edu.dosw.lab.comportamiento.reto6;

/**
 * Técnico Intermedio: maneja tickets de nivel INTERMEDIO con prioridad hasta
 * MEDIA.
 */
public class SoporteNivel2 extends ManejadorSoporte {

    public SoporteNivel2() {
        super("Técnico Intermedio", Ticket.Nivel.INTERMEDIO, Ticket.Prioridad.MEDIA);
    }
}
