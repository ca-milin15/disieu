package com.disieu.applicationMVC.app.configuracion;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Se construye esta clase para crear un método constructor vacío a la clase
 * SimpleGrantedAuthority, ya que èsta no lo tiene y tampoco se puede modificar.
 * Es un complemento a la clase original.
 * La combinación de esta clase y la original 'SimpleGrantedAuthority' se hace
 * en el AuthorizationFilter
 *
 *
 * @author Camilo Rivera
 * @date 27 nov. 2018
 */
public abstract class SimpleGrantedAuthorityMixin {

	/**
	 * Se ubica @JsonProperty("authority") como parámetro porque es un mapeo a esa
	 * propiedad, propiedad que esta definida en el Token que se obtiene en el
	 * Logueo
	 *
	 * @author Camilo Rivera
	 * @date 27 nov. 2018
	 */
	@JsonCreator
	public SimpleGrantedAuthorityMixin(@JsonProperty("authority") String role) {
		super();
	}

}
