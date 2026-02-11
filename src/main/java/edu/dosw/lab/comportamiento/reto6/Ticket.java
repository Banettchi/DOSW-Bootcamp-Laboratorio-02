package edu.dosw.lab.comportamiento.reto6;

/**
 * Clase que representa un ticket de soporte técnico.
 * Cada ticket tiene un nivel de dificultad y una prioridad.
 */
public class Ticket {

    public enum Nivel {
        BASICO, INTERMEDIO, AVANZADO
    }

    public enum Prioridad {
        BAJA(1), MEDIA(2), ALTA(3);

        private final int valor;

        Prioridad(int valor) {
            this.valor = valor;
        }

        public int getValor() {
            return valor;
        }
    }

    private final int numero;
    private final Nivel nivel;
    private final Prioridad prioridad;
    private final String descripcion;
    private boolean resuelto;
    private String resueltoPor;

    public Ticket(int numero, Nivel nivel, Prioridad prioridad, String descripcion) {
        this.numero = numero;
        this.nivel = nivel;
        this.prioridad = prioridad;
        this.descripcion = descripcion;
        this.resuelto = false;
        this.resueltoPor = null;
    }

    public int getNumero() {
        return numero;
    }

    public Nivel getNivel() {
        return nivel;
    }

    public Prioridad getPrioridad() {
        return prioridad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public boolean isResuelto() {
        return resuelto;
    }

    public String getResueltoPor() {
        return resueltoPor;
    }

    public void marcarResuelto(String tecnico) {
        this.resuelto = true;
        this.resueltoPor = tecnico;
    }

    @Override
    public String toString() {
        return String.format("Ticket %d | Nivel: %s | Prioridad: %s | %s",
                numero, nivel, prioridad, descripcion);
    }
}
