package edu.dosw.lab.solid.reto1;

/**
 * Clase principal del Reto 1: Tienda de Don Pepe.
 */
public class TiendaDonPepe {

    public static void ejecutar() {
        System.out.println("╔══════════════════════════════════════════════════════════╗");
        System.out.println("║          RETO 1: TIENDA DE DON PEPE                      ║");
        System.out.println("║          Aplicación de Principios SOLID                  ║");
        System.out.println("╚══════════════════════════════════════════════════════════╝\n");

        // Crear productos (inmutables)
        Producto camiseta = new Producto("Camiseta", 20000);
        Producto pantalon = new Producto("Pantalón", 50000);
        Producto galletas = new Producto("Galletas", 500);
        Producto jugo = new Producto("Jugo Natural", 3000);

        // Mostrar productos disponibles
        System.out.println("Bienvenido a la tienda Don Pepe!");
        System.out.println("Productos disponibles:");
        System.out.println("  - " + camiseta);
        System.out.println("  - " + pantalon);
        System.out.println("  - " + galletas);
        System.out.println("  - " + jugo);
        System.out.println();

        // Crear cliente (puede ser ClienteNuevo o ClienteFrecuente)
        Cliente cliente = new ClienteFrecuente();
        System.out.println("Cliente: " + cliente.getTipo());
        System.out.println();

        // Crear carrito y agregar productos
        CarritoCompras carrito = new CarritoCompras();
        System.out.println("Ingrese su compra:");
        carrito.agregarProducto(camiseta, 2);
        carrito.agregarProducto(galletas, 3);
        carrito.agregarProducto(jugo, 5);

        // Generar recibo
        Recibo recibo = new Recibo();
        recibo.generar(cliente, carrito);

        System.out.println("\n╔══════════════════════════════════════════════════════════╗");
        System.out.println("║                     FIN RETO 1                           ║");
        System.out.println("╚══════════════════════════════════════════════════════════╝\n");
    }
}
