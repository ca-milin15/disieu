package com.disieu.applicationMVC.app.servicio.impl;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import com.disieu.applicationMVC.app.configuracion.SimpleGrantedAuthorityMixin;
import com.disieu.applicationMVC.app.servicio.ServicioJwt;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * Esta clase implementa la interface que declara los mètodos Jwt
 *
 *
 * @author Camilo Rivera
 * @date 28 nov. 2018
 */
@Component
public class ServicioJwtImpl implements ServicioJwt {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.disieu.applicationMVC.app.servicio.ServicioJwt#crearToken(org.
	 * springframework.security.core.Authentication)
	 */
	@Override
	public String crearToken(Authentication authentication) throws JsonProcessingException {

		Claims claims = Jwts.claims();
		claims.put("roles", new ObjectMapper().writeValueAsString(authentication.getAuthorities()));

		String token = Jwts.builder().setClaims(claims).setSubject(authentication.getName())
				.signWith(SignatureAlgorithm.HS512, "Alguna.clave.secreta".getBytes()).setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + 3600000L)).compact();

		return token;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.disieu.applicationMVC.app.servicio.ServicioJwt#validarToken(java.lang.
	 * String)
	 */
	@Override
	public Boolean validarToken(String token) {
		try {
			obtenerClaims(token);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Claims obtenerClaims(String token) {
		return Jwts.parser().setSigningKey("Alguna.clave.secreta".getBytes())
				.parseClaimsJws(token.replace("Bearer ", "")).getBody();
	}

	@Override
	public String obtenerUsername(String token) {
		return obtenerClaims(token).getSubject();
	}

	@Override
	public Collection<? extends GrantedAuthority> getRoles(String token)
			throws JsonParseException, JsonMappingException, IOException {
		
		Object roles = obtenerClaims(token).get("roles");
		
		Collection<? extends GrantedAuthority> authorities = Arrays.asList(new ObjectMapper()
				// Esta linea es para combinar la clase impleGrantedAuthorityMixin.class con la
				// original
				// asi se le setea el constructor por defecto
				.addMixIn(SimpleGrantedAuthority.class, SimpleGrantedAuthorityMixin.class)
				.readValue(roles.toString().getBytes(), SimpleGrantedAuthority[].class));
		return authorities;
	}

	@Override
	public String resolve(String token) {
		// TODO Auto-generated method stub
		return null;
	}

}
