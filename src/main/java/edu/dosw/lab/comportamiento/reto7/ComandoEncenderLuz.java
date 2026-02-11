package edu.dosw.lab.comportamiento.reto7;

/**
 * Comando concreto: Encender luz.
 */
public class ComandoEncenderLuz implements Comando {

    private final Luz luz;
    private final String usuario;
    private boolean deshecho;

    public ComandoEncenderLuz(Luz luz, String usuario) {
        this.luz = luz;
        this.usuario = usuario;
        this.deshecho = false;
    }

    @Override
    public void ejecutar() {
        luz.encender();
        deshecho = false;
    }

    @Override
    public void deshacer() {
        luz.apagar();
        deshecho = true;
    }

    @Override
    public String getDescripcion() {
        return "Encender luz";
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
