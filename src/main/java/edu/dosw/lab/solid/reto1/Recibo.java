package edu.dosw.lab.solid.reto1;

/**
 * Genera el recibo de compra.
 * Recibe el CarritoCompras y el Cliente para mostrar la información.
 */
public class Recibo {

    public void generar(Cliente cliente, CarritoCompras carrito) {
        double subtotal = carrito.calcularSubtotal();
        double descuento = subtotal * cliente.getDescuento();
        double total = subtotal - descuento;

        System.out.println("\n--- RECIBO DE COMPRA ---");
        System.out.println("Cliente: " + cliente.getTipo());
        System.out.println("Productos:");

        carrito.getProductos().forEach((producto, cantidad) -> {
            double precioTotal = producto.getPrecio() * cantidad;
            System.out.println("  - " + producto.getNombre() + " - $" + String.format("%,.0f", precioTotal));
        });

        System.out.println("Subtotal: $" + String.format("%,.0f", subtotal));
        System.out.println("Descuento aplicado: $" + String.format("%,.0f", descuento));
        System.out.println("Total a pagar: $" + String.format("%,.0f", total));
        System.out.println("------------------------");
        System.out.println("¡Gracias por su compra!");
    }
}
