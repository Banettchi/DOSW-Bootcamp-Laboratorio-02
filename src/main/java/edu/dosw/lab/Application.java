package edu.dosw.lab;

import edu.dosw.lab.solid.reto1.TiendaDonPepe;
import edu.dosw.lab.creacionales.reto2.Reto2;
import edu.dosw.lab.creacionales.reto3.Reto3Main;
import edu.dosw.lab.estructurales.reto4.Reto4Main;
import edu.dosw.lab.estructurales.reto5.Reto5Main;
import edu.dosw.lab.comportamiento.reto6.Reto6;
import edu.dosw.lab.comportamiento.reto7.Reto7;

/**
 * Aplicación principal del Laboratorio 02 - Patrones de Diseño.
 * Ejecuta todos los retos.
 */
public class Application {

	public static void main(String[] args) {
		System.out.println("╔══════════════════════════════════════════════════════════════════╗");
		System.out.println("║           DOSW BOOTCAMP - LABORATORIO 02                         ║");
		System.out.println("║           SOLID y Patrones de Diseño                             ║");
		System.out.println("╚══════════════════════════════════════════════════════════════════╝");
		System.out.println();

		// ==================== SOLID ====================
		System.out.println("▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓");
		System.out.println("                         PRINCIPIOS SOLID                           ");
		System.out.println("▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓");
		System.out.println();

		TiendaDonPepe.ejecutar(); // Reto 1: SOLID

		// ==================== PATRONES CREACIONALES ====================
		System.out.println("▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓");
		System.out.println("                    PATRONES CREACIONALES                           ");
		System.out.println("▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓");
		System.out.println();

		Reto2.ejecutar(); // Builder
		Reto3Main.ejecutar(); // Abstract Factory

		// ==================== PATRONES ESTRUCTURALES ====================
		System.out.println("▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓");
		System.out.println("                    PATRONES ESTRUCTURALES                          ");
		System.out.println("▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓");
		System.out.println();

		Reto4Main.ejecutar(); // Adapter
		Reto5Main.ejecutar(); // Decorator

		// ==================== PATRONES DE COMPORTAMIENTO ====================
		System.out.println("▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓");
		System.out.println("                   PATRONES DE COMPORTAMIENTO                       ");
		System.out.println("▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓");
		System.out.println();

		Reto6.ejecutar(); // Chain of Responsibility
		Reto7.ejecutar(); // Command

		// ==================== FIN ====================
		System.out.println("╔══════════════════════════════════════════════════════════════════╗");
		System.out.println("║              FIN DEL LABORATORIO 02                              ║");
		System.out.println("║              Todos los retos ejecutados exitosamente             ║");
		System.out.println("╚══════════════════════════════════════════════════════════════════╝");
	}
}
