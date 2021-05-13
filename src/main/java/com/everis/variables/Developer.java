package com.everis.variables;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * FP-DUAL:: Javier Esmerado Vela
 * 
 * @author esmer
 *
 */

public class Developer {

	private static Logger LOGGER = LoggerFactory.getLogger(Developer.class);
	private Integer ID;
	private static Integer contID = 0;
	private String name;
	private static final String COMPANY = "Everis";
	private Integer vacationDays = 21;

	public Developer(String name) {
		LOGGER.info("Accedemos al constructor.");
		if (contID >= 127) {
			System.err.println("[ERROR]: La empresa no puede tener más de 127 empleados.");
		} else {
			this.name = name;
			this.ID = contID + 1;
			contID++;
		}
	}

	public Integer getID() {
		return ID;
	}
	
	public static Integer getcontID() {
		return contID;
	}

	public String getName() {
		return ID + " " + name + "\n";
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVacationDays() {
		return ID + " " + vacationDays + "\n";
	}

	public void setVacationDays(Integer vacationDays) {
		this.vacationDays = vacationDays;
	}

	public static String getCompany() {
		return COMPANY;
	}

	/**
	 * Método para restar días de vacaciones.
	 */
	public void subtractVacationDays(int x) {
		LOGGER.info("Accedemos al método subtractVacationDays");
		if (x > vacationDays) {
			System.err.println("No puede restarse más de los días de los que dispone.");
		} else {
			vacationDays -= x;
		}
	}

	@Override
	public String toString() {
		return "Developer, ID=" + ID + ", name=" + name + ", vacationDays=" + vacationDays + ", company=" + COMPANY + "\n";
	}

}
