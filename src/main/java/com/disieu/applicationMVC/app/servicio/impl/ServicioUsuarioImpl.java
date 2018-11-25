package com.disieu.applicationMVC.app.servicio.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.disieu.applicationMVC.app.compartida.respuesta.RespuestaUsuario;
import com.disieu.applicationMVC.app.modelo.dao.UsuarioDAO;
import com.disieu.applicationMVC.app.modelo.entidad.Usuario;
import com.disieu.applicationMVC.app.servicio.ServicioUsuario;

/**
 * 
 *
 *
 * @author Camilo Rivera
 * @date 24 nov. 2018
 */
@Service
public class ServicioUsuarioImpl implements ServicioUsuario {

	@Autowired
	private UsuarioDAO usuarioDAO;
	
	@Autowired
	private JpaUserDetailsService jpaUserDetailsService;

	@Override
	public RespuestaUsuario autenticarUsuario(String usuario, String clave) {
		Usuario usuarioEncontrado = usuarioDAO.findByUsuarioAndClave(usuario, clave);
		if (usuarioEncontrado != null) {
			jpaUserDetailsService.loadUserByUsername(usuario);
			return new RespuestaUsuario(usuarioEncontrado);
		}
		return null;
	}
}
