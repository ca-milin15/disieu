package com.disieu.applicationMVC.app.servicio;

import java.util.List;

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

	/**
	 * 
	 *
	 *
	 * @return
	 * @author Camilo Rivera
	 * @date 27 nov. 2018
	 */
	List<RespuestaUsuario> listarUsuario();
}
