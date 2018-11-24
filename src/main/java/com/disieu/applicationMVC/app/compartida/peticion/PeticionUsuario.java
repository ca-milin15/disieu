package com.disieu.applicationMVC.app.compartida.peticion;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 *
 *
 * @author Camilo Rivera
 * @date 24 nov. 2018
 */
public class PeticionUsuario implements Serializable {

	private static final long serialVersionUID = 3761066671622175642L;

	@JsonProperty("user")
	private String usuario;

	@JsonProperty("password")
	private String clave;

	/**
	 * Se construye el objeto a partir de
	 *
	 * @author Camilo Rivera
	 * @date 24 nov. 2018
	 */
	public PeticionUsuario() {
		super();
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
	 * @return the clave
	 */
	public String getClave() {
		return clave;
	}

	/**
	 * @param clave the clave to set
	 */
	public void setClave(String clave) {
		this.clave = clave;
	}

}
