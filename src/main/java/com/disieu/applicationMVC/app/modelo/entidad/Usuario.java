package com.disieu.applicationMVC.app.modelo.entidad;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 
 *
 *
 * @author Camilo Rivera Fecha: @date
 */
@Entity
@Table(name = "m_usuario")
public class Usuario extends EntidadGenerica {

	private static final long serialVersionUID = -6848298470832380006L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idM_usuario")
	private Integer idM_usuario;

	@Column(name = "usuario")
	private String usuario;

	@Column(name = "clave")
	private String clave;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "apellido")
	private String apellido;

	@Column(name = "menu")
	private Boolean menu;

	@Column(name = "activo")
	private Boolean activo;

	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
	private List<Rol> rol;

	/**
	 * Se construye el objeto a partir de
	 *
	 * @author Camilo Rivera
	 * @date 24 nov. 2018
	 */
	public Usuario() {
		super();
	}

	/**
	 * @return the idM_usuario
	 */
	public Integer getIdM_usuario() {
		return idM_usuario;
	}

	/**
	 * @param idM_usuario the idM_usuario to set
	 */
	public void setIdM_usuario(Integer idM_usuario) {
		this.idM_usuario = idM_usuario;
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
	 * @return the apellido
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 * @param apellido the apellido to set
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	/**
	 * @return the menu
	 */
	public Boolean getMenu() {
		return menu;
	}

	/**
	 * @param menu the menu to set
	 */
	public void setMenu(Boolean menu) {
		this.menu = menu;
	}

	/**
	 * @return the activo
	 */
	public Boolean getActivo() {
		return activo;
	}

	/**
	 * @param activo the activo to set
	 */
	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	/**
	 * @return the rol
	 */
	public List<Rol> getRol() {
		return rol;
	}

	/**
	 * @param rol the rol to set
	 */
	public void setRol(List<Rol> rol) {
		this.rol = rol;
	}

}
