package edu.dosw.lab;

import edu.dosw.lab.creacionales.reto1.Reto1Main;
import edu.dosw.lab.creacionales.reto2.Reto2Main;
import edu.dosw.lab.creacionales.reto3.Reto3Main;
import edu.dosw.lab.estructurales.reto4.Reto4Main;
import edu.dosw.lab.estructurales.reto5.Reto5Main;
import edu.dosw.lab.comportamiento.reto6.Reto6Main;
import edu.dosw.lab.comportamiento.reto7.Reto7Main;


public class Application {
	public static void main(String[] args) {
		System.out.println("DOSW - Bootcamp Laboratorio 02");
		System.out.println("================================\n");

		// Ejecutar Reto 1
		Reto1Main.ejecutar();

		// Ejecutar Reto 2
		Reto2Main.ejecutar();

		// Ejecutar Reto 3
		Reto3Main.ejecutar();

		// Ejecutar Reto 4
		Reto4Main.ejecutar();

		// Ejecutar Reto 5
		Reto5Main.ejecutar();

		// Ejecutar Reto 6
		Reto6Main.ejecutar();

		// Ejecutar Reto 7
		Reto7Main.ejecutar();
	}
}