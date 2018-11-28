package com.disieu.applicationMVC.app.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.disieu.applicationMVC.app.compartida.peticion.PeticionUsuario;
import com.disieu.applicationMVC.app.compartida.respuesta.RespuestaUsuario;
import com.disieu.applicationMVC.app.servicio.ServicioUsuario;

/**
 * 
 *
 *
 * @author Camilo Rivera
 * @date 24 nov. 2018
 */
@RestController
@RequestMapping("/disibackend/servicio/usuario")
public class UsuarioControlador {

	@Autowired
	private ServicioUsuario servicioUsuario;

	/**
	 * 
	 *
	 *
	 * @param peticionUsuario
	 * @return
	 * @author Camilo Rivera
	 * @date 24 nov. 2018
	 */
	@PostMapping("/autenticacion")
	public ResponseEntity<RespuestaUsuario> autenticarUsuario(@RequestBody PeticionUsuario peticionUsuario) {
		RespuestaUsuario respuestaUsuario = servicioUsuario.autenticarUsuario(peticionUsuario.getUsuario(),
				peticionUsuario.getClave());
		if (respuestaUsuario != null) {
			return new ResponseEntity<RespuestaUsuario>(respuestaUsuario, HttpStatus.OK);
		}
		return new ResponseEntity<RespuestaUsuario>(respuestaUsuario, HttpStatus.NOT_FOUND);
	}

	/**
	 * 
	 *
	 *
	 * @return
	 * @author Camilo Rivera
	 * @date 27 nov. 2018
	 */
	@GetMapping
	public ResponseEntity<List<RespuestaUsuario>> listarUsuario() {
		return new ResponseEntity<List<RespuestaUsuario>>(servicioUsuario.listarUsuario(), HttpStatus.OK);

	}

}
