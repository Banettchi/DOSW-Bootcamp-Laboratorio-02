package edu.dosw.lab.creacionales.reto1;

import java.util.HashMap;
import java.util.Map;

public class CarritoCompras {
    private Map<Producto, Integer> productos;

    public CarritoCompras() {
        this.productos = new HashMap<>();
    }

    public void agregarProducto(Producto producto, int cantidad) {
        productos.put(producto, productos.getOrDefault(producto, 0) + cantidad);
        System.out.println(producto.getNombre() + " " + cantidad + " unidades agregado al carrito.");
    }

    public Map<Producto, Integer> getProductos() {
        return productos;
    }

    public double calcularSubtotal() {
        return productos.entrySet().stream()
                .mapToDouble(entry -> entry.getKey().getPrecio() * entry.getValue())
                .sum();
    }
}
