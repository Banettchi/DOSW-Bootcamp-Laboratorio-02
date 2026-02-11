package edu.dosw.lab.comportamiento.reto6;

/**
 * Clase abstracta que define el manejador base de la cadena de responsabilidad.
 * Cada técnico tiene una especialidad (nivel) y una prioridad máxima que puede
 * resolver.
 */
public abstract class ManejadorSoporte {

    protected ManejadorSoporte siguiente;
    protected final String nombre;
    protected final Ticket.Nivel especialidad;
    protected final Ticket.Prioridad prioridadMaxima;

    public ManejadorSoporte(String nombre, Ticket.Nivel especialidad, Ticket.Prioridad prioridadMaxima) {
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.prioridadMaxima = prioridadMaxima;
    }

    /**
     * Establece el siguiente manejador en la cadena.
     * Retorna el siguiente para permitir encadenamiento fluido.
     */
    public ManejadorSoporte setSiguiente(ManejadorSoporte siguiente) {
        this.siguiente = siguiente;
        return siguiente;
    }

    /**
     * Procesa el ticket si el nivel coincide con la especialidad del técnico
     * y la prioridad del ticket no excede la prioridad máxima del técnico.
     * Si no puede resolverlo, lo pasa al siguiente en la cadena.
     */
    public void manejar(Ticket ticket) {
        if (puedeManejar(ticket)) {
            ticket.marcarResuelto(nombre);
            System.out.println("  Ticket " + ticket.getNumero() + ": " + nombre + " resolvió el problema.");
        } else {
            System.out.println("  Ticket " + ticket.getNumero() + ": " + nombre + " no pudo resolver.");
            if (siguiente != null) {
                siguiente.manejar(ticket);
            } else {
                System.out.println("  Ticket " + ticket.getNumero()
                        + ": Ningún técnico disponible. Ticket pendiente de escalamiento.");
            }
        }
    }

    /**
     * Verifica si este técnico puede manejar el ticket.
     */
    protected boolean puedeManejar(Ticket ticket) {
        return ticket.getNivel() == especialidad
                && ticket.getPrioridad().getValor() <= prioridadMaxima.getValor();
    }

    public String getNombre() {
        return nombre;
    }
}
