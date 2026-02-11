package edu.dosw.lab.creacionales.reto3;

/**
 * Vehículo acuático: Jet Ski
 */
public class JetSki extends VehiculoAcuatico {

    public JetSki(Categoria categoria) {
        this.modelo = "Jet Ski";
        this.categoria = categoria;

        switch (categoria) {
            case ECONOMICO:
                this.velocidadMaxima = 50;
                this.precio = 20000000;
                this.equipamiento = "Motor estándar";
                break;
            case LUJO:
                this.velocidadMaxima = 100;
                this.precio = 60000000;
                this.equipamiento = "Motor turbo + GPS + asientos premium";
                break;
            case USADO:
                this.velocidadMaxima = 40;
                this.precio = 12000000;
                this.equipamiento = "Motor básico";
                break;
        }
    }
}
