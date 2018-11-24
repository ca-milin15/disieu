package com.disieu.applicationMVC.app.compartida.respuesta;

import java.io.Serializable;

import com.disieu.applicationMVC.app.modelo.entidad.Usuario;

/**
 * 
 *
 *
 * @author Camilo Rivera
 * @date 24 nov. 2018
 */
public class RespuestaUsuario implements Serializable {

	private static final long serialVersionUID = 5937683409253201392L;

	private String usuario;

	private String nombre;

	/**
	 * Se construye el objeto a partir de
	 *
	 * @author Camilo Rivera
	 * @date 24 nov. 2018
	 */
	public RespuestaUsuario() {
		super();
	}

	/**
	 * 
	 * Se construye el objeto a partir de la entidad encontrada en DB.
	 *
	 * @param usuarioEncontrado
	 * @author Camilo Rivera
	 * @date 24 nov. 2018
	 */
	public RespuestaUsuario(Usuario usuarioEncontrado) {
		this.usuario = usuarioEncontrado.getUsuario();
		this.nombre = usuarioEncontrado.getNombre() + usuarioEncontrado.getApellido();
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the usuario
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

}
