package edu.dosw.lab.estructurales.reto4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Clase CasaCambio - Lógica principal del Reto 4.
 * Utiliza el patrón Adapter para convertir monedas con tasas reales.
 */
public class CasaCambio {

    private static final ConversorMoneda conversor = new AdaptadorCasaCambio();

    public static void ejecutar() {
        Scanner scanner = new Scanner(System.in);
        List<TransaccionGrupo> transacciones = new ArrayList<>();

        System.out.println("\n========== RETO #4: LA CASA DE CAMBIO ==========\n");

        System.out.print("Ingrese número de transacciones: ");
        int numTransacciones = Integer.parseInt(scanner.nextLine().trim());

        for (int i = 1; i <= numTransacciones; i++) {
            System.out.println("\n--- Transacción " + i + " ---");

            // Leer monto
            System.out.print("Ingrese monto: ");
            String montoStr = scanner.nextLine().trim().replace(".", "");
            double monto = Double.parseDouble(montoStr);

            // Leer moneda origen
            System.out.print("Ingrese moneda de origen (USD, EUR, JPY, COP, CNY): ");
            Moneda origen = Moneda.valueOf(scanner.nextLine().trim().toUpperCase());

            // Leer monedas destino
            System.out.print("Ingrese monedas destino (separadas por coma, ej: USD,JPY): ");
            String[] destinosStr = scanner.nextLine().trim().toUpperCase().split(",");

            List<Conversion> conversiones = new ArrayList<>();
            for (String destinoStr : destinosStr) {
                Moneda destino = Moneda.valueOf(destinoStr.trim());
                double convertido = conversor.convertir(monto, origen, destino);
                conversiones.add(new Conversion(destino, convertido));
            }

            transacciones.add(new TransaccionGrupo(i, monto, origen, conversiones));
        }

        // Mostrar resultados
        mostrarResultados(transacciones);

        System.out.println("\n=====================================================");
    }

    private static void mostrarResultados(List<TransaccionGrupo> transacciones) {
        System.out.println();

        // Mostrar cada transacción con sus conversiones
        for (TransaccionGrupo t : transacciones) {
            System.out.printf("Transacción %d: %.0f %s%n",
                    t.numero, t.montoOriginal, t.origen.name());

            for (Conversion c : t.conversiones) {
                System.out.printf("    Convertido a %s: %,.2f %s%n",
                        c.moneda.name(), c.monto, c.moneda.name());
            }
            System.out.println();
        }

        // Calcular totales por moneda usando Streams
        System.out.println("--- Totales por moneda ---");

        Map<Moneda, Double> totales = new HashMap<>();
        transacciones.stream()
                .flatMap(t -> t.conversiones.stream())
                .forEach(c -> totales.merge(c.moneda, c.monto, Double::sum));

        totales.forEach((moneda, total) ->
                System.out.printf("%s: %,.2f %s%n", moneda.name(), total, moneda.name()));
    }

    // Clases auxiliares internas
    private static class TransaccionGrupo {
        int numero;
        double montoOriginal;
        Moneda origen;
        List<Conversion> conversiones;

        TransaccionGrupo(int numero, double montoOriginal, Moneda origen, List<Conversion> conversiones) {
            this.numero = numero;
            this.montoOriginal = montoOriginal;
            this.origen = origen;
            this.conversiones = conversiones;
        }
    }

    private static class Conversion {
        Moneda moneda;
        double monto;

        Conversion(Moneda moneda, double monto) {
            this.moneda = moneda;
            this.monto = monto;
        }
    }
}