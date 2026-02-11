package edu.dosw.lab.comportamiento.reto7;

/**
 * Comando concreto: Ajustar volumen (parámetro 0-100).
 * Permite deshacer restaurando el valor anterior.
 */
public class ComandoAjustarVolumen implements Comando {

    private final Persiana persiana;
    private final String usuario;
    private final int nuevoValor;
    private int valorAnterior;
    private boolean deshecho;

    public ComandoAjustarVolumen(Persiana persiana, String usuario, int nuevoValor) {
        this.persiana = persiana;
        this.usuario = usuario;
        this.nuevoValor = nuevoValor;
        this.deshecho = false;
    }

    @Override
    public void ejecutar() {
        valorAnterior = persiana.getValor();
        persiana.ajustar(nuevoValor);
        deshecho = false;
    }

    @Override
    public void deshacer() {
        persiana.ajustar(valorAnterior);
        deshecho = true;
    }

    @Override
    public String getDescripcion() {
        return "Ajustar volumen a " + nuevoValor + "%";
    }

    @Override
    public String getUsuario() {
        return usuario;
    }

    @Override
    public boolean isDeshecho() {
        return deshecho;
    }
}
