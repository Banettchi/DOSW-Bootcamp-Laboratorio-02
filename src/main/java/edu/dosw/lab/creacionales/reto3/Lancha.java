package edu.dosw.lab.creacionales.reto3;

/**
 * Vehículo acuático: Lancha
 */
public class Lancha extends VehiculoAcuatico {

    public Lancha(Categoria categoria) {
        this.modelo = "Lancha";
        this.categoria = categoria;

        switch (categoria) {
            case ECONOMICO:
                this.velocidadMaxima = 40;
                this.precio = 30000000;
                this.equipamiento = "Motor básico + chalecos";
                break;
            case LUJO:
                this.velocidadMaxima = 80;
                this.precio = 150000000;
                this.equipamiento = "Motor potente + GPS marino + sonido";
                break;
            case USADO:
                this.velocidadMaxima = 30;
                this.precio = 18000000;
                this.equipamiento = "Motor estándar";
                break;
        }
    }
}
