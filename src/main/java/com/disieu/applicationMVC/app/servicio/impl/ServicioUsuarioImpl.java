package com.disieu.applicationMVC.app.servicio.impl;

import java.util.List;
import java.util.stream.Collectors;

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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.disieu.applicationMVC.app.servicio.ServicioUsuario#autenticarUsuario(java
	 * .lang.String, java.lang.String)
	 */
	@Override
	public RespuestaUsuario autenticarUsuario(String usuario, String clave) {
		Usuario usuarioEncontrado = usuarioDAO.findByUsuarioAndClave(usuario, clave);
		if (usuarioEncontrado != null) {
			jpaUserDetailsService.loadUserByUsername(usuario);
			return new RespuestaUsuario(usuarioEncontrado);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.disieu.applicationMVC.app.servicio.ServicioUsuario#listarUsuario()
	 */
	@Override
	public List<RespuestaUsuario> listarUsuario() {
		return usuarioDAO.findAll().stream().map(usuario -> {
			return new RespuestaUsuario(usuario);
		}).collect(Collectors.toList());
	}
}
