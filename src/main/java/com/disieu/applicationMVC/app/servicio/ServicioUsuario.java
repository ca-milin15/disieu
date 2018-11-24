package com.disieu.applicationMVC.app.servicio;

import com.disieu.applicationMVC.app.compartida.respuesta.RespuestaUsuario;

/**
 * 
 *
 *
 * @author Camilo Rivera
 * @date 24 nov. 2018
 */
public interface ServicioUsuario {

	/**
	 * 
	 *
	 *
	 * @param usuario
	 * @param clave
	 * @return
	 * @author Camilo Rivera
	 * @date 24 nov. 2018
	 */
	RespuestaUsuario autenticarUsuario(String usuario, String clave);
}
