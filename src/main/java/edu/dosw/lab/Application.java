package edu.dosw.lab;

import edu.dosw.lab.creacionales.reto1.Reto1Main;
import edu.dosw.lab.creacionales.reto2.Reto2Main;
import edu.dosw.lab.creacionales.reto3.Reto3Main;

public class Application {

	public static void main(String[] args) {
		System.out.println("Proyecto Maven configurado y corriendo correctamente\n");

		// Ejecutar Reto 1
		Reto1Main.ejecutar();

		// Ejecutar Reto 2
		Reto2Main.ejecutar();

		// Ejecutar Reto 3
		Reto3Main.ejecutar();
	}
}