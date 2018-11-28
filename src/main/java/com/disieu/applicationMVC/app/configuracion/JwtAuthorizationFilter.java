package com.disieu.applicationMVC.app.configuracion;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.disieu.applicationMVC.app.modelo.entidad.Usuario;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;

/**
 * 
 *
 *
 * @author Camilo Rivera
 * @date 27 nov. 2018
 */
public class JwtAuthorizationFilter extends BasicAuthenticationFilter {

	/**
	 * 
	 * Se construye el objeto a partir de
	 *
	 * @param authenticationManager
	 * @author Camilo Rivera
	 * @date 27 nov. 2018
	 */
	public JwtAuthorizationFilter(AuthenticationManager authenticationManager) {
		super(authenticationManager);
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

		Boolean validoToken;
		Claims token = null;
		try {
			token = Jwts.parser().setSigningKey("Alguna.clave.secreta".getBytes())
					.parseClaimsJws(header.replace("Bearer ", "")).getBody();
			validoToken = true;
		} catch (JwtException | IllegalArgumentException e) {
			validoToken = false;
		}

		UsernamePasswordAuthenticationToken authenticationToken = null;

		if (validoToken) {
			String username = token.getSubject();
			Object roles = token.get("roles");

			Collection<? extends GrantedAuthority> authorities = Arrays
					.asList(new ObjectMapper().readValue(roles.toString().getBytes(), SimpleGrantedAuthority[].class));

			authenticationToken = new UsernamePasswordAuthenticationToken(username, authorities);

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
