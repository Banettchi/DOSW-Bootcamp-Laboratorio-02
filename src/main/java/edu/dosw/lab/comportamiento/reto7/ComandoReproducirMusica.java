package edu.dosw.lab.comportamiento.reto7;

/**
 * Comando concreto: Reproducir música.
 */
public class ComandoReproducirMusica implements Comando {

    private final Musica musica;
    private final String usuario;
    private boolean deshecho;

    public ComandoReproducirMusica(Musica musica, String usuario) {
        this.musica = musica;
        this.usuario = usuario;
        this.deshecho = false;
    }

    @Override
    public void ejecutar() {
        musica.reproducir();
        deshecho = false;
    }

    @Override
    public void deshacer() {
        musica.detener();
        deshecho = true;
    }

    @Override
    public String getDescripcion() {
        return "Reproducir música";
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
