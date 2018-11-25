package com.disieu.applicationMVC.app.modelo.entidad;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 
 *
 *
 * @author Camilo Rivera
 * @date 24 nov. 2018
 */
@Entity
@Table(name = "rol")
public class Rol extends EntidadGenerica {

	private static final long serialVersionUID = 4646146230972442367L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_rol")
	private Integer id_rolPrimaria;

	@ManyToOne(fetch = FetchType.LAZY, cascade= CascadeType.ALL)
	@JoinColumn(name = "M_usuario_idM_usuario")
	private Usuario usuario;

	@Column(name = "rol")
	private String rol;

	/**
	 * Se construye el objeto a partir de
	 *
	 * @author Camilo Rivera
	 * @date 24 nov. 2018
	 */
	public Rol() {
		super();
	}

	/**
	 * @return the id_rolPrimaria
	 */
	public Integer getId_rolPrimaria() {
		return id_rolPrimaria;
	}

	/**
	 * @param id_rolPrimaria the id_rolPrimaria to set
	 */
	public void setId_rolPrimaria(Integer id_rolPrimaria) {
		this.id_rolPrimaria = id_rolPrimaria;
	}

	/**
	 * @return the usuario
	 */
	public Usuario getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the rol
	 */
	public String getRol() {
		return rol;
	}

	/**
	 * @param rol the rol to set
	 */
	public void setRol(String rol) {
		this.rol = rol;
	}

}
