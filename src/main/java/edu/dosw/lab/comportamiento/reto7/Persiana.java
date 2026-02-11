package edu.dosw.lab.comportamiento.reto7;

/**
 * Receptor: dispositivo Persiana (Volumen).
 * Permite ajustar un valor de 0 a 100.
 */
public class Persiana {

    private int valor;

    public Persiana() {
        this.valor = 0;
    }

    public void ajustar(int nuevoValor) {
        this.valor = Math.max(0, Math.min(100, nuevoValor));
    }

    public int getValor() {
        return valor;
    }
}
