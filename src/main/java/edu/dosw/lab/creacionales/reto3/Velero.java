package edu.dosw.lab.creacionales.reto3;

/**
 * Vehículo acuático: Velero
 */
public class Velero extends VehiculoAcuatico {

    public Velero(Categoria categoria) {
        this.modelo = "Velero";
        this.categoria = categoria;

        switch (categoria) {
            case ECONOMICO:
                this.velocidadMaxima = 15;
                this.precio = 25000000;
                this.equipamiento = "Velas básicas + cabina simple";
                break;
            case LUJO:
                this.velocidadMaxima = 25;
                this.precio = 200000000;
                this.equipamiento = "Velas premium + cabina completa + cocina";
                break;
            case USADO:
                this.velocidadMaxima = 12;
                this.precio = 12000000;
                this.equipamiento = "Velas estándar";
                break;
        }
    }
}
