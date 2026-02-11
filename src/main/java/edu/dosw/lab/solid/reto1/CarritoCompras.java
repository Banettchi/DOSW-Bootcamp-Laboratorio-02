package edu.dosw.lab.solid.reto1;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Carrito de compras que almacena productos y sus cantidades.
 * No usa ItemCarrito, directamente asocia Producto con cantidad.
 */
public class CarritoCompras {
    private final Map<Producto, Integer> productos;

    public CarritoCompras() {
        this.productos = new LinkedHashMap<>();
    }

    public void agregarProducto(Producto producto, int cantidad) {
        productos.merge(producto, cantidad, Integer::sum);
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
