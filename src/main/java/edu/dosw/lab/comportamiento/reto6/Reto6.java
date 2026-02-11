package edu.dosw.lab.comportamiento.reto6;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * RETO 6: Sistema de Soporte Técnico con Chain of Responsibility.
 *
 * El usuario ingresa X tickets con nivel y prioridad.
 * La cadena de técnicos procesa cada ticket y muestra quién lo resolvió.
 * Se usan streams para generar estadísticas al final.
 */
public class Reto6 {

        public static void ejecutar() {
                Scanner scanner = new Scanner(System.in);

                System.out.println("╔══════════════════════════════════════════════════════════╗");
                System.out.println("║       RETO 6: CADENA DE RESPONSABILIDAD                  ║");
                System.out.println("║       Sistema de Soporte Técnico                         ║");
                System.out.println("╚══════════════════════════════════════════════════════════╝\n");

                // Construir la cadena de responsabilidad
                ManejadorSoporte basico = new SoporteNivel1();
                ManejadorSoporte intermedio = new SoporteNivel2();
                ManejadorSoporte avanzado = new SoporteNivel3();
                basico.setSiguiente(intermedio).setSiguiente(avanzado);

                // Pedir número de tickets
                System.out.print("Número de tickets: ");
                int numTickets = Integer.parseInt(scanner.nextLine().trim());

                List<Ticket> tickets = new ArrayList<>();

                for (int i = 1; i <= numTickets; i++) {
                        System.out.println("\nTicket " + i + ":");

                        System.out.print("  Nivel (basico/intermedio/avanzado): ");
                        String nivelStr = scanner.nextLine().trim().toLowerCase();
                        Ticket.Nivel nivel = parseNivel(nivelStr);

                        System.out.print("  Prioridad (baja/media/alta): ");
                        String prioridadStr = scanner.nextLine().trim().toLowerCase();
                        Ticket.Prioridad prioridad = parsePrioridad(prioridadStr);

                        System.out.print("  Descripción: ");
                        String descripcion = scanner.nextLine().trim();

                        tickets.add(new Ticket(i, nivel, prioridad, descripcion));
                }

                // Procesar tickets a través de la cadena
                System.out.println("\n--- Procesando tickets ---\n");
                for (Ticket ticket : tickets) {
                        basico.manejar(ticket);
                }

                // Estadísticas usando Streams
                System.out.println("\n--- Estadísticas ---\n");

                // Tickets resueltos por nivel
                Map<String, Long> resueltoPorTecnico = tickets.stream()
                                .filter(Ticket::isResuelto)
                                .collect(Collectors.groupingBy(Ticket::getResueltoPor, Collectors.counting()));

                long basicos = resueltoPorTecnico.getOrDefault("Técnico Básico", 0L);
                long intermedios = resueltoPorTecnico.getOrDefault("Técnico Intermedio", 0L);
                long avanzados = resueltoPorTecnico.getOrDefault("Técnico Avanzado", 0L);

                System.out.println("Tickets resueltos:");
                System.out.println("  Básico: " + basicos);
                System.out.println("  Intermedio: " + intermedios);
                System.out.println("  Avanzado: " + avanzados);

                // Tickets pendientes
                long pendientes = tickets.stream()
                                .filter(t -> !t.isResuelto())
                                .count();
                System.out.println("\nTickets pendientes: " + pendientes);

                // Promedio de prioridad de tickets resueltos
                double promedio = tickets.stream()
                                .filter(Ticket::isResuelto)
                                .mapToInt(t -> t.getPrioridad().getValor())
                                .average()
                                .orElse(0.0);
                System.out.printf("\nPromedio de prioridad de tickets resueltos: %.1f%n", promedio);

                System.out.println("\n╔══════════════════════════════════════════════════════════╗");
                System.out.println("║                     FIN RETO 6                           ║");
                System.out.println("╚══════════════════════════════════════════════════════════╝\n");
        }

        private static Ticket.Nivel parseNivel(String input) {
                switch (input) {
                        case "basico":
                                return Ticket.Nivel.BASICO;
                        case "intermedio":
                                return Ticket.Nivel.INTERMEDIO;
                        case "avanzado":
                                return Ticket.Nivel.AVANZADO;
                        default:
                                System.out.println("  Nivel no reconocido, se asigna BASICO.");
                                return Ticket.Nivel.BASICO;
                }
        }

        private static Ticket.Prioridad parsePrioridad(String input) {
                switch (input) {
                        case "baja":
                                return Ticket.Prioridad.BAJA;
                        case "media":
                                return Ticket.Prioridad.MEDIA;
                        case "alta":
                                return Ticket.Prioridad.ALTA;
                        default:
                                System.out.println("  Prioridad no reconocida, se asigna BAJA.");
                                return Ticket.Prioridad.BAJA;
                }
        }
}
