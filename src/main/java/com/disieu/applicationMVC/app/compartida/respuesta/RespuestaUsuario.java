package com.disieu.applicationMVC.app.compartida.respuesta;

import java.io.Serializable;

import com.disieu.applicationMVC.app.modelo.entidad.Usuario;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 *
 *
 * @author Camilo Rivera
 * @date 24 nov. 2018
 */
public class RespuestaUsuario implements Serializable {

	private static final long serialVersionUID = 5937683409253201392L;

	@JsonProperty("username")
	private String usuario;

	@JsonProperty("name")
	private String nombre;

	@JsonProperty("token")
	private String token;

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
	 * 
	 * Se construye el objeto desde la clase JWTAuthentication
	 *
	 * @param name
	 * @param token2
	 * @author Camilo Rivera
	 * @date 25 nov. 2018
	 */
	public RespuestaUsuario(String name, String token2) {
		this.usuario = name;
		this.token = token2;
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

	/**
	 * @return the token
	 */
	public String getToken() {
		return token;
	}

	/**
	 * @param token the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}

}
