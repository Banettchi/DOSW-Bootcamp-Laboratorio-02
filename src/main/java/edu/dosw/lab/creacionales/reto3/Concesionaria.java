package edu.dosw.lab.creacionales.reto3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Clase Concesionaria - Lógica principal del Reino de los Vehículos.
 * Implementa el menú y la interacción con el usuario utilizando el patrón
 * Abstract Factory.
 */
public class Concesionaria {

    private static final VehiculoFactory[] FABRICAS = {
            new TierraFactory(),
            new AcuaticoFactory(),
            new AereoFactory()
    };

    private static final String[] TIPOS_VEHICULO = { "Tierra", "Acuático", "Aéreo" };

    public static void ejecutar() {
        Scanner scanner = new Scanner(System.in);
        List<Vehiculo> carrito = new ArrayList<>();
        boolean continuar = true;

        System.out.println("\n========== RETO #3: EL REINO DE LOS VEHÍCULOS ==========\n");

        System.out.println("¡Bienvenido al Reino de los Vehículos!");

        while (continuar) {
            // 1. Seleccionar tipo de vehículo
            System.out.println("\nSeleccione el tipo de vehículo:");
            for (int i = 0; i < TIPOS_VEHICULO.length; i++) {
                System.out.println((i + 1) + ". " + TIPOS_VEHICULO[i]);
            }
            System.out.print("Ingrese opción: ");
            int tipoSeleccionado = leerOpcion(scanner, 1, 3);

            VehiculoFactory factory = FABRICAS[tipoSeleccionado - 1];

            // 2. Seleccionar categoría
            System.out.println("\nSeleccione la categoría del vehículo:");
            System.out.println("1. Económico");
            System.out.println("2. Lujo");
            System.out.println("3. Usado");
            System.out.print("Ingrese opción: ");
            int categoriaSeleccionada = leerOpcion(scanner, 1, 3);

            Categoria categoria = Categoria.values()[categoriaSeleccionada - 1];

            // 3. Seleccionar modelo
            String[] modelos = factory.getModelosDisponibles();
            System.out.println("\nSeleccione el modelo de vehículo:");
            for (int i = 0; i < modelos.length; i++) {
                System.out.println((i + 1) + ". " + modelos[i]);
            }
            System.out.print("Ingrese opción: ");
            int modeloSeleccionado = leerOpcion(scanner, 1, modelos.length);

            // 4. Crear el vehículo usando la fábrica
            Vehiculo vehiculo = factory.crearVehiculo(modeloSeleccionado, categoria);
            carrito.add(vehiculo);

            System.out.println("\nVehículo agregado al carrito!");

            // 5. ¿Agregar otro vehículo?
            System.out.print("\n¿Desea agregar otro vehículo? (si/no): ");
            String respuesta = scanner.nextLine().trim().toLowerCase();
            continuar = respuesta.equals("si") || respuesta.equals("s");
        }

        // Mostrar resumen de compra
        mostrarResumen(carrito);

        System.out.println("\n=====================================================");
    }

    private static int leerOpcion(Scanner scanner, int min, int max) {
        while (true) {
            try {
                int opcion = Integer.parseInt(scanner.nextLine().trim());
                if (opcion >= min && opcion <= max) {
                    return opcion;
                }
                System.out.print("Opción inválida. Ingrese entre " + min + " y " + max + ": ");
            } catch (NumberFormatException e) {
                System.out.print("Ingrese un número válido: ");
            }
        }
    }

    private static void mostrarResumen(List<Vehiculo> carrito) {
        System.out.println("\n--- RESUMEN DE COMPRA ---");

        for (int i = 0; i < carrito.size(); i++) {
            Vehiculo v = carrito.get(i);
            System.out.println("Vehículo " + (i + 1) + ":");
            System.out.println(v.mostrarInfo());
            System.out.println();
        }

        // Calcular subtotal usando Streams
        double total = carrito.stream()
                .mapToDouble(Vehiculo::getPrecio)
                .sum();

        System.out.printf("Total a pagar: $%,.0f%n", total);
        System.out.println("-------------------------");
        System.out.println("¡Gracias por su compra en el Reino de los Vehículos!");
    }
}