package edu.dosw.lab.creacionales.reto1;

import java.util.HashMap;
import java.util.Map;

public class TiendaDonPepe {
    private Map<String, Producto> catalogo;

    public TiendaDonPepe() {
        this.catalogo = new HashMap<>();
        inicializarCatalogo();
    }

    private void inicializarCatalogo() {
        catalogo.put("camiseta", new Producto("Camiseta", 20000));
        catalogo.put("pantalon", new Producto("Pantalón", 50000));
        catalogo.put("galletas", new Producto("Galletas", 500));
        catalogo.put("jugo", new Producto("Jugo Natural", 3000));
    }

    public void mostrarBienvenida() {
        System.out.println("¡Bienvenido a la tienda Don Pepe!");
    }

    public void mostrarCatalogo() {
        System.out.println("\nProductos disponibles:");
        catalogo.values().forEach(p ->
                System.out.println("  - " + p.getNombre() + " - $" + String.format("%.0f", p.getPrecio()))
        );
    }

    public Producto obtenerProducto(String nombreKey) {
        return catalogo.get(nombreKey.toLowerCase());
    }

    public Recibo procesarCompra(Cliente cliente, CarritoCompras carrito) {
        Recibo recibo = new Recibo(cliente, carrito);
        recibo.imprimir();
        return recibo;
    }

    // Método estático que ejecuta el ejemplo completo del reto
    public static void ejecutar() {
        System.out.println("\n========== RETO #1: LA TIENDA DE DON PEPE ==========\n");

        TiendaDonPepe tienda = new TiendaDonPepe();

        tienda.mostrarBienvenida();
        tienda.mostrarCatalogo();

        Cliente cliente = new ClienteFrecuente();
        CarritoCompras carrito = new CarritoCompras();

        System.out.println("\nCliente: " + cliente.getTipo());
        System.out.println("\nIngrese su compra:");

        carrito.agregarProducto(tienda.obtenerProducto("camiseta"), 2);
        carrito.agregarProducto(tienda.obtenerProducto("galletas"), 3);
        carrito.agregarProducto(tienda.obtenerProducto("jugo"), 5);

        System.out.println();

        tienda.procesarCompra(cliente, carrito);

        System.out.println("\n=====================================================");
    }
}