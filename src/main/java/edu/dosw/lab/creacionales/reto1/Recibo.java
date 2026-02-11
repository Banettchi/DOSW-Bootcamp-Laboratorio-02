package edu.dosw.lab.creacionales.reto1;

public class Recibo {
    private Cliente cliente;
    private CarritoCompras carrito;
    private double subtotal;
    private double descuento;
    private double total;

    public Recibo(Cliente cliente, CarritoCompras carrito) {
        this.cliente = cliente;
        this.carrito = carrito;
        this.subtotal = carrito.calcularSubtotal();
        this.descuento = cliente.calcularDescuento(subtotal);
        this.total = subtotal - descuento;
    }

    public void imprimir() {
        System.out.println("--- RECIBO DE COMPRA ---");
        System.out.println("Cliente: " + cliente.getTipo());
        System.out.println("Productos:");
        
        carrito.getProductos().forEach((producto, cantidad) -> {
            double precioTotal = producto.getPrecio() * cantidad;
            System.out.println("  - " + producto.getNombre() + " - $" + String.format("%.0f", precioTotal));
        });
        
        System.out.println("Subtotal: $" + String.format("%.0f", subtotal));
        System.out.println("Descuento aplicado: $" + String.format("%.0f", descuento));
        System.out.println("Total a pagar: $" + String.format("%.0f", total));
        System.out.println("------------------------");
        System.out.println("¡Gracias por su compra!");
    }

    public double getTotal() {
        return total;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public double getDescuento() {
        return descuento;
    }
}
