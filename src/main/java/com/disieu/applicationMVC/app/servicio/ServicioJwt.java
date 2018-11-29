package com.disieu.applicationMVC.app.servicio;

import java.io.IOException;
import java.util.Collection;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import io.jsonwebtoken.Claims;

/**
 * Esta clase cualquier utilidad de JwtToken
 *
 *
 * @author Camilo Rivera
 * @date 28 nov. 2018
 */
public interface ServicioJwt {

	/**
	 * A partir del objecto Authenticated del mètodo "successfulAuthentication" (que
	 * forma parte de los métodos del ciclo de vida de SpringBoot) se crea el token
	 * 
	 *
	 *
	 * @param authentication
	 * @return
	 * @author Camilo Rivera
	 * @throws JsonProcessingException
	 * @date 28 nov. 2018
	 */
	public String crearToken(Authentication authentication) throws JsonProcessingException;

	/**
	 * Este método valida si el token requiere autenticción de nuevo.
	 *
	 *
	 * @param token
	 * @return
	 * @author Camilo Rivera
	 * @date 28 nov. 2018
	 */
	public Boolean validarToken(String token);

	/**
	 * A partir del token, el obtiene los claims(información del token). Esto se
	 * hace para centralizar la obtención de las diferenters parte del token, por
	 * ejmplo: los roles, fecha expiración...
	 *
	 *
	 * @param token
	 * @return
	 * @author Camilo Rivera
	 * @date 28 nov. 2018
	 */
	public Claims obtenerClaims(String token);

	/**
	 * A partir del método anteriormente declarado "obtenerClaims" se obtiene el
	 * nombre del usuario que esta dentro del Token
	 *
	 *
	 * @param token
	 * @return
	 * @author Camilo Rivera
	 * @date 28 nov. 2018
	 */
	public String obtenerUsername(String token);

	/**
	 * A partir del método anteriormente declarado "obtenerClaims" se obtiene los
	 * roles que estan dentro del token. Este método tiene una lógica especial, en
	 * este se combinan dos clases por medio del addMixIn. Esto es para complementar
	 * el SimpleGrantedAuthority porque carece de un constructor por defecto,
	 * entonces, con la clase SimpleGrantedAuthorityMix se le añade aquel
	 * constructor, es decir, se complementa
	 *
	 * @param token
	 * @return
	 * @author Camilo Rivera
	 * @throws IOException
	 * @throws JsonMappingException
	 * @throws JsonParseException
	 * @date 28 nov. 2018
	 */
	public Collection<? extends GrantedAuthority> getRoles(String token)
			throws JsonParseException, JsonMappingException, IOException;

	public String resolve(String token);
}
