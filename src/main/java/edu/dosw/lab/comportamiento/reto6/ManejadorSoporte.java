package edu.dosw.lab.comportamiento.reto6;

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

    public ManejadorSoporte setSiguiente(ManejadorSoporte siguiente) {
        this.siguiente = siguiente;
        return siguiente;
    }

    public String manejar(Ticket ticket) {
        // Si coincide la especialidad (nivel)
        if (ticket.getNivel() == especialidad) {
            // Verificar si puede resolver por prioridad
            if (ticket.getPrioridad().getValor() <= prioridadMaxima.getValor()) {
                ticket.marcarResuelto(nombre);
                return nombre + " resolvió el problema.";
            } else {
                // Misma especialidad pero prioridad muy alta
                if (siguiente != null) {
                    return nombre + " no pudo resolver. " + siguiente.manejar(ticket);
                } else {
                    return "Ningún técnico disponible. Ticket pendiente de escalamiento.";
                }
            }
        } else {
            // No es su especialidad, pasar al siguiente sin mensaje
            if (siguiente != null) {
                return siguiente.manejar(ticket);
            } else {
                return "Ningún técnico disponible. Ticket pendiente de escalamiento.";
            }
        }
    }

    public String getNombre() {
        return nombre;
    }
}