package edu.dosw.lab.comportamiento.reto7;

/**
 * Receptor: dispositivo Luz.
 */
public class Luz {

    private boolean encendida;

    public Luz() {
        this.encendida = false;
    }

    public void encender() {
        encendida = true;
    }

    public void apagar() {
        encendida = false;
    }

    public boolean isEncendida() {
        return encendida;
    }
}
