package com.disieu.applicationMVC.app.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.disieu.applicationMVC.app.modelo.dao.UsuarioDAO;
import com.disieu.applicationMVC.app.modelo.entidad.Usuario;

@Service
public class JpaUserDetailsService implements UserDetailsService{

	@Autowired
	private UsuarioDAO usuarioDAO;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioDAO.findByUsuario(username);
		List<GrantedAuthority> listGrantedAuthority = new ArrayList<>();
		usuario.getListRol().stream().forEach(rol -> {
			listGrantedAuthority.add(new SimpleGrantedAuthority(rol.getRol()));
		});
		return new User(username, usuario.getClave(), listGrantedAuthority);
	}

}
