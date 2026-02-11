package edu.dosw.lab.estructurales.reto5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Clase Cafeteria - Lógica principal del Reto 5.
 * Utiliza el patrón Decorator para personalizar cafés con toppings.
 */
public class Cafeteria {

    private static final String[] TOPPINGS_MENU = {
            "Leche", // 1 - $1.000
            "Chocolate", // 2 - $1.500
            "Caramelo", // 3 - $1.200
            "Crema Batida", // 4 - $2.000
            "Menta" // 5 - $1.300
    };

    private static final double[] TOPPINGS_PRECIOS = {
            1000, 1500, 1200, 2000, 1300
    };

    public static void ejecutar() {
        Scanner scanner = new Scanner(System.in);
        List<Cafe> cafes = new ArrayList<>();

        System.out.println("\n========== RETO #5: EL CAFÉ PERSONALIZADO ==========\n");

        // Mostrar menú de toppings
        mostrarMenuToppings();

        System.out.print("Número de cafés a personalizar: ");
        int numCafes = Integer.parseInt(scanner.nextLine().trim());

        for (int i = 1; i <= numCafes; i++) {
            System.out.println("\n--- Café " + i + " ---");
            System.out.print("Seleccione toppings (numeros separados por coma): ");
            String seleccion = scanner.nextLine().trim();

            // Comenzar con café base
            Cafe cafe = new CafeBase();

            // Procesar cada topping seleccionado
            String[] numeros = seleccion.split(",");
            for (String num : numeros) {
                try {
                    int opcion = Integer.parseInt(num.trim());
                    cafe = aplicarTopping(cafe, opcion, scanner);
                } catch (NumberFormatException e) {
                    System.out.println("Opción inválida: " + num);
                }
            }

            cafes.add(cafe);
        }

        // Mostrar resumen
        mostrarResumen(cafes);

        System.out.println("\n=====================================================");
    }

    /**
     * Aplica un topping al café usando el decorador correspondiente.
     */
    private static Cafe aplicarTopping(Cafe cafe, int opcion, Scanner scanner) {
        switch (opcion) {
            case 1:
                return new Leche(cafe);
            case 2:
                return new Chocolate(cafe);
            case 3:
                return new Caramelo(cafe);
            case 4:
                return new CremaBatida(cafe);
            case 5:
                return new Menta(cafe);
            case 6:
                // Topping personalizado
                System.out.print("Ingrese nombre del nuevo topping: ");
                String nombre = scanner.nextLine().trim();
                System.out.print("Ingrese precio del topping: ");
                String precioStr = scanner.nextLine().trim().replace(".", "");
                double precio = Double.parseDouble(precioStr);
                return new ToppingPersonalizado(cafe, nombre, precio);
            default:
                System.out.println("Opción no válida: " + opcion);
                return cafe;
        }
    }

    private static void mostrarMenuToppings() {
        System.out.println("Lista de toppings disponibles:");
        System.out.println("----------------------------------------------");
        System.out.printf("%-10s %-20s %-10s%n", "Opción", "Topping", "Precio");
        System.out.println("----------------------------------------------");

        for (int i = 0; i < TOPPINGS_MENU.length; i++) {
            System.out.printf("%-10d %-20s $%,.0f%n", i + 1, TOPPINGS_MENU[i], TOPPINGS_PRECIOS[i]);
        }

        System.out.printf("%-10d %-20s %s%n", 6, "Agregar nuevo topping", "Precio personalizado");
        System.out.println("----------------------------------------------\n");
    }

    private static void mostrarResumen(List<Cafe> cafes) {
        System.out.println("\n--- RESUMEN DE CAFÉ PERSONALIZADO ---\n");

        for (int i = 0; i < cafes.size(); i++) {
            Cafe cafe = cafes.get(i);
            System.out.println("Café " + (i + 1) + ":");
            System.out.println("Ingredientes: " + cafe.getDescripcion());
            System.out.printf("Precio total: $%,.0f%n", cafe.getPrecio());
            System.out.println();
        }

        // Calcular total usando Streams
        double totalGeneral = cafes.stream()
                .mapToDouble(Cafe::getPrecio)
                .sum();

        System.out.println("-------------------------------");
        System.out.printf("Total a pagar por todos los cafés: $%,.0f%n", totalGeneral);
        System.out.println("¡Disfrute su café!");
    }
}