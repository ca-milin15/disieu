package com.disieu.applicationMVC.app.utilidades;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * Almacena mètodos que puedne ser útiles en toda la aplicación
 *
 *
 * @author Camilo Rivera
 * @date 28 nov. 2018
 */
public class UtilidadesGenerales {

	/**
	 * Este método transforma de tipo Date a LocalDateTime
	 *
	 *
	 * @param date
	 * @return
	 * @author Camilo Rivera
	 * @date 28 nov. 2018
	 */
	public static LocalDateTime convertDateToLocalDateTime(Date date) {
		return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
	}
}
