package edu.dosw.lab.comportamiento.reto7;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * RETO 7: Control Remoto Mágico con patrón Command.
 *
 * El usuario registra X acciones sobre dispositivos del hogar.
 * Cada acción se puede deshacer. Al final se muestra un resumen
 * y se investiga quién desconfiguró cada aparato.
 */
public class Reto7 {

    public static void ejecutar() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("========== RETO #7: CONTROL REMOTO MÁGICO ==========");

        // Dispositivos del hogar
        Luz luz = new Luz();
        Puerta puerta = new Puerta();
        Musica musica = new Musica();
        Persiana persiana = new Persiana();

        ControlRemoto control = new ControlRemoto();

        System.out.print("Número de acciones a registrar: ");
        int numAcciones = Integer.parseInt(scanner.nextLine().trim());

        for (int i = 1; i <= numAcciones; i++) {
            System.out.println("\nAcción " + i + ":");

            System.out.print("  Usuario: ");
            String usuario = scanner.nextLine().trim();

            System.out.println(
                    "  Selecciones: 1. Encender luz  2. Abrir puerta  3. Reproducir música  4. Ajustar volumen");
            System.out.print("  Seleccione: ");
            int seleccion = Integer.parseInt(scanner.nextLine().trim());

            Comando comando = null;

            switch (seleccion) {
                case 1:
                    comando = new ComandoEncenderLuz(luz, usuario);
                    break;
                case 2:
                    comando = new ComandoAbrirPuerta(puerta, usuario);
                    break;
                case 3:
                    comando = new ComandoReproducirMusica(musica, usuario);
                    break;
                case 4:
                    System.out.print("  Ingrese valor (0-100): ");
                    int valor = Integer.parseInt(scanner.nextLine().trim());
                    comando = new ComandoAjustarVolumen(persiana, usuario, valor);
                    break;
                default:
                    System.out.println("  Opción no válida, se omite.");
                    continue;
            }

            control.ejecutarComando(comando);

            System.out.print("  Deshacer acción? (si/no): ");
            String deshacer = scanner.nextLine().trim().toLowerCase();
            if (deshacer.equals("si")) {
                control.deshacerAccion(control.getHistorial().size() - 1);
            }
        }

        // Mostrar resultados
        List<Comando> historial = control.getHistorial();
        System.out.println("\n--- Resultados ---\n");

        for (int i = 0; i < historial.size(); i++) {
            Comando cmd = historial.get(i);
            if (cmd.isDeshecho()) {
                System.out.println("Acción " + (i + 1) + " ejecutada por " + cmd.getUsuario()
                        + ": " + cmd.getDescripcion() + " (deshecha)");
            } else {
                System.out.println("Acción " + (i + 1) + " ejecutada por " + cmd.getUsuario()
                        + ": " + cmd.getDescripcion());
            }
        }

        // Historial completo
        System.out.println("\n--- Historial completo ---");
        for (int i = 0; i < historial.size(); i++) {
            Comando cmd = historial.get(i);
            String estado = cmd.isDeshecho() ? " (deshecha)" : "";
            System.out.println((i + 1) + ": " + cmd.getDescripcion()
                    + " - Usuario: " + cmd.getUsuario() + estado);
        }

        // Investigar quién desconfiguró cada aparato
        System.out.println("\n--- Investigando quién desconfiguró los electrodomésticos ---");

        // Conteo de acciones ejecutadas (no deshechas) por usuario
        Map<String, Long> accionesPorUsuario = historial.stream()
                .filter(c -> !c.isDeshecho())
                .collect(Collectors.groupingBy(Comando::getUsuario, Collectors.counting()));

        // Identificar usuarios con más acciones (posibles "desconfiguradores")
        long maxAcciones = accionesPorUsuario.values().stream()
                .mapToLong(Long::longValue)
                .max()
                .orElse(0);

        if (maxAcciones > 1) {
            accionesPorUsuario.entrySet().stream()
                    .filter(e -> e.getValue() == maxAcciones)
                    .forEach(e -> System.out.println("Se detecta que " + e.getKey()
                            + " realizó " + e.getValue() + " acciones que alteraron la configuración."));
        }

        accionesPorUsuario.forEach((usuario, cantidad) -> {
            if (cantidad < maxAcciones || maxAcciones <= 1) {
                System.out.println(usuario + " realizó " + cantidad + " acción" + (cantidad > 1 ? "es." : "."));
            }
        });

        System.out.println("=====================================================");
    }
}