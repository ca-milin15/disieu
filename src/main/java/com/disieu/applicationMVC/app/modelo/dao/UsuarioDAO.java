package com.disieu.applicationMVC.app.modelo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.disieu.applicationMVC.app.modelo.entidad.Usuario;

/**
 * 
 *
 *
 * @author Camilo Rivera
 * @date 24 nov. 2018
 */
public interface UsuarioDAO extends JpaRepository<Usuario, Integer> {

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
	Usuario findByUsuarioAndClave(String usuario, String clave);

	/**
	 * 
	 *
	 *
	 * @param usuario
	 * @return
	 * @author Camilo Rivera
	 * @date 24 nov. 2018
	 */
	Usuario findByUsuario(String usuario);
}
