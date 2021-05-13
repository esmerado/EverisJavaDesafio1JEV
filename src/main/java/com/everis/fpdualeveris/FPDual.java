package com.everis.fpdualeveris;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.everis.variables.Developer;

/**
 * 
 * FP-DUAL:: Javier Esmerado Vela
 * 
 * @author esmer
 *
 */
public class FPDual {

	/**
	 * Método para crer empleados.
	 * 
	 */
	private static void variablesChallenge(Map<Integer, Developer> map, Scanner sc) {
		try {
			// Creamos el primer empleado.
			System.out.println("Introduce el nombre del primer empleado:");
			String name1 = sc.next();
			Developer emp1 = new Developer(name1);
			map.put(emp1.getID(), emp1);

			// Creamos el segundo empleado.
			System.out.println("Introduce el nombre del segundo empleado:");
			String name2 = sc.next();
			Developer emp2 = new Developer(name2);
			map.put(emp2.getID(), emp2);

			// Creamos el tercer empleado.
			System.out.println("Introduce el nombre del tercer empleado:");
			String name3 = sc.next();
			Developer emp3 = new Developer(name3);
			map.put(emp3.getID(), emp3);

			// Creamos el cuarto empleado.
			System.out.println("Introduce el nombre del cuarto  empleado:");
			String name4 = sc.next();
			Developer emp4 = new Developer(name4);
			map.put(emp4.getID(), emp4);

		} catch (Exception e) {
			System.err.println("[ERRO]:: Alguno de los valores introducidos es erróneo.");
		}
	}

	/**
	 * Método para mostrar todos los empleados.
	 * 
	 * @param map
	 */
	private static void showDevelopers(Map<Integer, Developer> map) {
		System.out.println("Estos son los empleados disponibles: ");
		map.values().stream().forEach(System.out::print);
	}

	/**
	 * Método para salir del programa.
	 */
	private static void exit() {
		System.out.println("HASTA PRONTO!!");
		System.exit(0);
	}

	/**
	 * Método para mostrar el número de empleados.
	 */
	public static void showNumEmple() {
		System.out.println("El número total de empleados es de: " + Developer.getcontID());

	}

	/**
	 * Método para obtener el número de cada empleado.
	 * 
	 * @param map
	 */
	public static void getNumEmple(Map<Integer, Developer> map) {
		map.values().stream().map(l -> l.getName()).forEach(System.out::print);
	}

	/**
	 * Método para restar días a un empleado.
	 * 
	 * @param map
	 * @param sc
	 */
	public static void subtractVacationDays(Map<Integer, Developer> map, Scanner sc) {
		try {
			showDevelopers(map);
			System.out.println("Introduce el ID, del empleado al que desea restar días:");
			int n = sc.nextInt();
			Developer emple = map.get(n);
			System.out.println("Cuántos días desea quitar:");
			System.out.println("[Recuerde que no puede restar más días de los que dispone.]");
			int d = sc.nextInt();
			emple.subtractVacationDays(d);
		} catch (Exception e) {
			System.err.println("[ERROR]:: Alguno de los valores introducidos son incorrectos.");
		}
	}

	/**
	 * Método para mostrar los días de vacaciones de cada empleado.
	 * 
	 * @param map
	 */
	public static void showVacationsDays(Map<Integer, Developer> map) {
		map.values().stream().map(l -> l.getVacationDays()).forEach(System.out::print);
	}

	/**
	 * Método para añadir empleados nuevos.
	 * 
	 * @param map
	 * @param sc
	 */
	public static void addDeveloper(Map<Integer, Developer> map, Scanner sc) {
		try {
			System.out.println("Introduce el nombre del nuevo empleado: ");
			String name = sc.next();
			Developer emp = new Developer(name);
			map.put(emp.getID(), emp);
		} catch (Exception e) {
			System.err.println("[ERROR]:: Alguno de los valores introducidos son incorrectos.");
		}
	}

	/**
	 * Mostramos el número de empleados en el primero y último.
	 */
	public static void showOneToFor(Map<Integer, Developer> map) {
		System.out.println("Número empleado del primer empleado: ");
		map.values().stream().filter(l -> l.getID() == 1).map(l -> l.getcontID()).forEach(System.out::print);
		System.out.println("\n");
		System.out.println("Número empleado del cuarto empleado: ");
		map.values().stream().filter(l -> l.getID() == 4).map(l -> l.getcontID()).forEach(System.out::print);
		System.out.println("\n");
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Map<Integer, Developer> developers = new HashMap();

		try {
			variablesChallenge(developers, sc);
			while (true) {
				System.out.println("Qué acción desea realizar");
				System.out.println("1.- Mostrar empleados.");
				System.out.println("2.- Mostrar número total de empleados.");
				System.out.println("3.- Mostrar número de cada empleado.");
				System.out.println("4.- Descontar días de vacaciones.");
				System.out.println("5.- Consultar días de vacaciones de cada empleado.");
				System.out.println("6.- Añadir nuevo empleado.");
				System.out.println("7.- Mostrar coincidencia de num de empleados.");
				System.out.println("8.- Salir");
				int num = sc.nextInt();
				switch (num) {
				case 1:
					showDevelopers(developers);
					break;

				case 2:
					showNumEmple();
					break;

				case 3:
					getNumEmple(developers);
					break;

				case 4:
					subtractVacationDays(developers, sc);
					break;

				case 5:
					showVacationsDays(developers);
					break;

				case 6:
					addDeveloper(developers, sc);
					break;

				case 7:
					showOneToFor(developers);
					break;

				default:
					exit();
					break;
				}

			}
		} catch (Exception e) {
			System.err.println("[ERROR]:: Alguno de los datos introducidos es erróneo.");
		}

	}

}
