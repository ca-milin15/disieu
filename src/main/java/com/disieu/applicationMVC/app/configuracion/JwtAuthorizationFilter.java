package com.disieu.applicationMVC.app.configuracion;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.disieu.applicationMVC.app.servicio.ServicioJwt;

/**
 * 
 *
 *
 * @author Camilo Rivera
 * @date 27 nov. 2018
 */
public class JwtAuthorizationFilter extends BasicAuthenticationFilter {

	private ServicioJwt servicioJwt;

	/**
	 * 
	 * Se construye el objeto a partir de
	 *
	 * @param authenticationManager
	 * @author Camilo Rivera
	 * @date 27 nov. 2018
	 */
	public JwtAuthorizationFilter(AuthenticationManager authenticationManager, ServicioJwt servicioJwt) {
		super(authenticationManager);
		this.servicioJwt = servicioJwt;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.security.web.authentication.www.BasicAuthenticationFilter
	 * #doFilterInternal(javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse, javax.servlet.FilterChain)
	 */
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		String header = request.getHeader("Authorization");

		if (!requiresAuthentication(header)) {
			chain.doFilter(request, response);
			return;
		}

		UsernamePasswordAuthenticationToken authenticationToken = null;

		if (servicioJwt.validarToken(header)) {
			authenticationToken = new UsernamePasswordAuthenticationToken(servicioJwt.obtenerUsername(header), null,
					servicioJwt.getRoles(header));

		}
		SecurityContextHolder.getContext().setAuthentication(authenticationToken);
		chain.doFilter(request, response);
	}

	/**
	 * Valida si ya esta autenticado.
	 *
	 *
	 * @param header
	 * @return
	 * @author Camilo Rivera
	 * @date 27 nov. 2018
	 */
	private Boolean requiresAuthentication(String header) {
		if (header == null || !header.startsWith("Bearer ")) {
			return false;
		}
		return true;
	}
}
