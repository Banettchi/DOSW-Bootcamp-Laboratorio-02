package edu.dosw.lab.comportamiento.reto7;

import java.util.ArrayList;
import java.util.List;

/**
 * Invocador: Control remoto que ejecuta y registra comandos.
 * Permite deshacer acciones individuales y muestra historial completo.
 */
public class ControlRemoto {

    private final List<Comando> historial;

    public ControlRemoto() {
        this.historial = new ArrayList<>();
    }

    /**
     * Ejecuta un comando y lo registra en el historial.
     */
    public void ejecutarComando(Comando comando) {
        comando.ejecutar();
        historial.add(comando);
    }

    /**
     * Deshace una acción individual por su índice en el historial.
     */
    public boolean deshacerAccion(int indice) {
        if (indice >= 0 && indice < historial.size()) {
            Comando comando = historial.get(indice);
            if (!comando.isDeshecho()) {
                comando.deshacer();
                return true;
            }
        }
        return false;
    }

    /**
     * Retorna el historial completo de comandos.
     */
    public List<Comando> getHistorial() {
        return historial;
    }
}
