package com.disieu.applicationMVC.app.configuracion;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * En esta clase se personaliza el filtro de logueo.
 *
 *
 * @author Camilo Rivera
 * @date 25 nov. 2018
 */
public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	private AuthenticationManager authenticationManager;

	/**
	 * Se construye el objeto a partir de del campo anteriormente creado
	 *
	 * @param authenticationManager
	 * @author Camilo Rivera
	 * @date 25 nov. 2018
	 */
	public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
		super();
		this.authenticationManager = authenticationManager;
	}

	/*
	 * Click derecho -> generar. Este mètodo es indispensable para realizar el
	 * intento de logueo
	 * 
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.security.web.authentication.
	 * UsernamePasswordAuthenticationFilter#attemptAuthentication(javax.servlet.http
	 * .HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		//Se personaliza ruta para logueo
		setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher("/disibackend/servicio/usuario/autenticacion", "POST"));
		// Este còdigo de reutilizado de la clase que extiende
		// 'UsernamePasswordAuthenticationFilter'
		String username = obtainUsername(request);
		String password = obtainPassword(request);

		if (username == null) {
			username = "";
		}

		if (password == null) {
			password = "";
		}
		
		username = username.trim();

		UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(username, password);

		setDetails(request, authRequest);

		return authenticationManager.authenticate(authRequest);
	}

}
