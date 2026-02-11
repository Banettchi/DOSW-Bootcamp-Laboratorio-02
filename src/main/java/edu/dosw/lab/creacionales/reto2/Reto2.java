package edu.dosw.lab.creacionales.reto2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * RETO 2: EL CHEF DE 5 ESTRELLAS - PATRÓN BUILDER
 * 
 * Este reto demuestra la implementación del patrón Builder
 * aplicado a la creación de hamburguesas personalizadas.
 * 
 * Categoría del patrón: CREACIONAL
 * Patrón utilizado: BUILDER
 * 
 * Justificación:
 * El patrón Builder es ideal para este escenario porque:
 * - Permite construir hamburguesas complejas paso a paso
 * - El cliente puede personalizar agregando ingredientes opcionales
 * - Separa la lógica de construcción de la representación final
 * - Produce objetos inmutables (la hamburguesa final no se modifica)
 * 
 * ¿Cómo se aplicó?
 * - Ingrediente: Componente básico con nombre y precio
 * - Hamburguesa: Producto inmutable resultante
 * - HamburguesaBuilder: Construye la hamburguesa agregando ingredientes
 * - El menú interactivo permite al usuario elegir ingredientes
 * - Se usan Streams para calcular el precio total
 */
public class Reto2 {

    // Lista de ingredientes disponibles en el menú
    private static List<Ingrediente> menuIngredientes = new ArrayList<>();

    static {
        // Inicializar ingredientes predeterminados
        menuIngredientes.add(new Ingrediente("Pan", 3000));
        menuIngredientes.add(new Ingrediente("Carne", 10000));
        menuIngredientes.add(new Ingrediente("Queso", 5000));
        menuIngredientes.add(new Ingrediente("Lechuga", 2000));
        menuIngredientes.add(new Ingrediente("Tomate", 2000));
        menuIngredientes.add(new Ingrediente("Salsa especial", 3000));
    }

    public static void ejecutar() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("╔══════════════════════════════════════════════════════════╗");
        System.out.println("║         RETO 2: EL CHEF DE 5 ESTRELLAS                   ║");
        System.out.println("║              Hamburguesas Personalizadas                 ║");
        System.out.println("║                  (Patrón Builder)                        ║");
        System.out.println("╚══════════════════════════════════════════════════════════╝\n");

        // Mostrar menú de ingredientes
        mostrarMenu();

        // Leer selección del usuario
        System.out.print("Ingrese los números separados por coma: ");
        String seleccion = scanner.nextLine().trim();

        // Crear el builder
        HamburguesaBuilder builder = new HamburguesaBuilder();

        // Procesar selección
        String[] numeros = seleccion.split(",");
        for (String num : numeros) {
            try {
                int opcion = Integer.parseInt(num.trim());

                if (opcion >= 1 && opcion <= menuIngredientes.size()) {
                    // Agregar ingrediente del menú
                    Ingrediente ingrediente = menuIngredientes.get(opcion - 1);
                    builder.agregarIngrediente(ingrediente);
                } else if (opcion == menuIngredientes.size() + 1) {
                    // Agregar nuevo ingrediente personalizado
                    System.out.print("\nIngrese el nombre del nuevo ingrediente: ");
                    String nombre = scanner.nextLine().trim();

                    System.out.print("Ingrese el precio del ingrediente: ");
                    String precioStr = scanner.nextLine().trim();
                    // Remover puntos de miles (ej: 4.000 -> 4000)
                    precioStr = precioStr.replace(".", "");
                    double precio = Double.parseDouble(precioStr);

                    Ingrediente nuevoIngrediente = new Ingrediente(nombre, precio);
                    menuIngredientes.add(nuevoIngrediente); // Agregar al menú
                    builder.agregarIngrediente(nuevoIngrediente);

                    System.out.println("✓ Ingrediente '" + nombre + "' agregado!");
                }
            } catch (NumberFormatException e) {
                System.out.println("⚠ Opción inválida: " + num);
            }
        }

        // Construir y mostrar la hamburguesa
        try {
            Hamburguesa hamburguesa = builder.build();
            System.out.println(hamburguesa);
        } catch (IllegalStateException e) {
            System.out.println("\n⚠ Error: " + e.getMessage());
        }

        System.out.println("\n╔══════════════════════════════════════════════════════════╗");
        System.out.println("║                     FIN RETO 2                           ║");
        System.out.println("╚══════════════════════════════════════════════════════════╝\n");
    }

    /**
     * Muestra el menú de ingredientes disponibles.
     */
    private static void mostrarMenu() {
        System.out.println("Seleccione ingredientes para su hamburguesa:");

        for (int i = 0; i < menuIngredientes.size(); i++) {
            Ingrediente ing = menuIngredientes.get(i);
            System.out.printf("%d. %s ($%,.0f)%n", i + 1, ing.getNombre(), ing.getPrecio());
        }

        System.out.println((menuIngredientes.size() + 1) + ". Agregar un nuevo ingrediente");
        System.out.println();
    }
}
