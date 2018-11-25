package com.disieu.applicationMVC.app.configuracion;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.disieu.applicationMVC.app.compartida.respuesta.RespuestaUsuario;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * En esta clase se personaliza el filtro de logueo. Este logueo no requiere de
 * EndPoint, porque utiliza un filtro. Los filtros interceptan las petición de
 * acuerdo a la ruta y al verbo Http, y SpringSecurity hace toda la operación.
 * Si las credenciales estan bien retorna un Status: 200, de lo contrario,
 * retorna Unauthorized
 *
 *
 * @author Camilo Rivera
 * @date 25 nov. 2018
 */
public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	private AuthenticationManager authenticationManager;

	/**
	 * Se construye el objeto a partir del atributo anteriormente creado
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
	 * Mayus + alt + S -> generar. Este mètodo es indispensable para realizar el
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
		// Se personaliza ruta para logueo
		// Este còdigo de reutilizado de la clase que extiende
		// 'UsernamePasswordAuthenticationFilter'
		String username = obtainUsername(request);
		String password = obtainPassword(request);

		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(password);

		System.out.println(hashedPassword);
		if (username == null) {
			username = "";
		}

		if (password == null) {
			password = "";
		}

		username = username.trim();

		UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(username, password);

		return authenticationManager.authenticate(authRequest);
	}

	/*
	 * Mayus + alt + S -> generar. Este mètodo es indispensable para generar el
	 * Token
	 * 
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.security.web.authentication.
	 * AbstractAuthenticationProcessingFilter#successfulAuthentication(javax.servlet
	 * .http.HttpServletRequest, javax.servlet.http.HttpServletResponse,
	 * javax.servlet.FilterChain, org.springframework.security.core.Authentication)
	 */
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {

		String token = Jwts.builder().setSubject(authResult.getName())
				.signWith(SignatureAlgorithm.HS512, "Alguna.clave.secreta".getBytes()).compact();
		new RespuestaUsuario(authResult.getName(), token);
		response.addHeader("Authorization", "Bearer " + token);
		Map<String, Object> body = new HashMap<>();
		body.put("token", token);
		body.put("user", authResult.getAuthorities());
		body.put("mensaje", "exitoso");

		response.getWriter().write(new ObjectMapper().writeValueAsString(body));
		response.setStatus(200);
		response.setContentType("application/json");
	}

}
