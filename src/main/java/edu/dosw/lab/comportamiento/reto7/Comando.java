package edu.dosw.lab.comportamiento.reto7;

/**
 * Interfaz Command que define el contrato para todos los comandos.
 * Cada comando registra qué usuario lo ejecutó.
 */
public interface Comando {
    void ejecutar();

    void deshacer();

    String getDescripcion();

    String getUsuario();

    boolean isDeshecho();
}
