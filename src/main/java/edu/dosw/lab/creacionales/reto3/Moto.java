package edu.dosw.lab.creacionales.reto3;

/**
 * Vehículo terrestre: Moto
 */
public class Moto extends VehiculoTierra {

    public Moto(Categoria categoria) {
        this.modelo = "Moto";
        this.categoria = categoria;

        switch (categoria) {
            case ECONOMICO:
                this.velocidadMaxima = 80;
                this.precio = 8000000;
                this.equipamiento = "Casco básico incluido";
                break;
            case LUJO:
                this.velocidadMaxima = 200;
                this.precio = 45000000;
                this.equipamiento = "ABS + Control de tracción + Maletas";
                break;
            case USADO:
                this.velocidadMaxima = 60;
                this.precio = 4000000;
                this.equipamiento = "Sin accesorios";
                break;
        }
    }
}
