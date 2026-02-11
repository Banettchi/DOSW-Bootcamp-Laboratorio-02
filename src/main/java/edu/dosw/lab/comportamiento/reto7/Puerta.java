package edu.dosw.lab.comportamiento.reto7;

/**
 * Receptor: dispositivo Puerta.
 */
public class Puerta {

    private boolean abierta;

    public Puerta() {
        this.abierta = false;
    }

    public void abrir() {
        abierta = true;
    }

    public void cerrar() {
        abierta = false;
    }

    public boolean isAbierta() {
        return abierta;
    }
}
