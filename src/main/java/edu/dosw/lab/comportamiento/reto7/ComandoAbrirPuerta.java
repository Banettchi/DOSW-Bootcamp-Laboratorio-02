package edu.dosw.lab.comportamiento.reto7;

/**
 * Comando concreto: Abrir puerta.
 */
public class ComandoAbrirPuerta implements Comando {

    private final Puerta puerta;
    private final String usuario;
    private boolean deshecho;

    public ComandoAbrirPuerta(Puerta puerta, String usuario) {
        this.puerta = puerta;
        this.usuario = usuario;
        this.deshecho = false;
    }

    @Override
    public void ejecutar() {
        puerta.abrir();
        deshecho = false;
    }

    @Override
    public void deshacer() {
        puerta.cerrar();
        deshecho = true;
    }

    @Override
    public String getDescripcion() {
        return "Abrir puerta";
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
